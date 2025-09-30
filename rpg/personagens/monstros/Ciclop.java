package rpg.personagens.monstros;

import java.util.ArrayList;
import java.util.Random;

import rpg.combate.*;
import rpg.interfaces.Item;
import rpg.itens.Dracmas;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.heavystrike = true;
        adicionarAcao(new GolpePesado());
        adicionarAcao(new Rest());
    }

    //Getters
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Setters
    public void setHeavystrike(boolean heavystrike){
        this.heavystrike = heavystrike;
    }

    //Métodos
    @Override
    public ArrayList<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        ArrayList<Item> drops = new ArrayList<>();

        int money = random.nextInt(15, 50);
        drops.add(new Dracmas(money));
        System.out.println(this.getName() + " deixou cair " + money + " Dracmas!");
        Weapon dropArma = largarArma(heroi.getSorte());
        
        if (dropArma != null) {
            drops.add(dropArma);
        }
        return drops;
    }
}
