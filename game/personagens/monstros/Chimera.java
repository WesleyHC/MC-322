package game.personagens.monstros;

import java.util.ArrayList;
import java.util.Random;

import game.combate.*;
import game.interfaces.Item;
import game.itens.Dracmas;
import game.itens.weapons.Weapon;
import game.personagens.*;


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
    public int receberDano(int dano){
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
        return damage;
    }

    @Override
    public ArrayList<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        ArrayList<Item> drops = new ArrayList<>();

        int money = random.nextInt(12, 50);
        drops.add(new Dracmas(money));
        System.out.println(this.getName() + " deixou cair " + money + " Dracmas!");
        Weapon dropArma = largarArma(heroi.getSorte());
        
        if (dropArma != null) {
            drops.add(dropArma);
        }
        return drops;
    }
}
