package game.personagens.monstros;

import java.util.ArrayList;
import java.util.Random;

import game.combate.*;
import game.interfaces.Item;
import game.itens.Dracmas;
import game.itens.weapons.Weapon;
import game.personagens.*;

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

    public int receberDano(int dano) {
        if ((100*Math.random()) < this.flight) {
            System.out.println(this.getName() + " voa agilmente e ESQUIVA do ataque!");
            return 0;
        } else {
            System.out.println("O ataque ACERTA " + this.getName() + "!");
            super.receberDano(dano);
            return dano;
        }
    }

    @Override
    public ArrayList<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        ArrayList<Item> drops = new ArrayList<>();

        int money = random.nextInt(10, 50);
        drops.add(new Dracmas(money));
        System.out.println(this.getName() + " deixou cair " + money + " Dracmas!");
        Weapon dropArma = largarArma(heroi.getSorte());
        
        if (dropArma != null) {
            drops.add(dropArma);
        }
        return drops;
    }
}
