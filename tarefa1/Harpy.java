package tarefa1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tarefa2.Weapon;
import tarefa3.BasicAtk;
import tarefa3.Item;
import tarefa3.Rest;

public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, float flight){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.flight = flight;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Rest());
    }

    //Getters
     public float getFlight(){
        return flight;
    }

    //Métodos

    public void receberDano(int dano) {
        if ((100*Math.random()) < this.flight) {
            System.out.println(this.getName() + " voa agilmente e ESQUIVA do ataque!");
        } else {
            System.out.println("O ataque ACERTA " + this.getName() + "!");
            super.receberDano(dano);
        }
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
