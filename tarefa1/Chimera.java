package tarefa1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tarefa2.Weapon;
import tarefa3.BasicAtk;
import tarefa3.Item;
import tarefa3.Rest;

public class Chimera extends Monster {
    //Atributo intimidador (dano do inimigo reduzido)
    private int intimidate;
    private boolean intimidate_msg;

    //Construtor
    public Chimera(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, int intimidate){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.intimidate = intimidate;
        this.intimidate_msg = true;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Rest());
    }

    //Getters
    public int getIntimidate(){
        return intimidate;
    }

    //Métodos
    public void receberDano(int dano){
        if (intimidate_msg) {
            System.out.println("O herói está intimidado por " + this.getName() + ", enfraquecendo seu ataque!");
            intimidate_msg = false;
        }
        int damage = dano - this.intimidate;
        if (damage < 0) {
            damage = 0; //Para não curar caso fique negativo
        }
        System.out.println(this.getName() + " resiste ao golpe e sofre apenas " + damage + " de dano.");
        super.receberDano(damage);
    }

    @Override
    public List<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        List<Item> drops = new ArrayList<>();

        int money = random.nextInt(50);
        heroi.setDracmas(money);

        drops.add(largarArma(heroi.getSorte()));

        return drops;
    }

}
