package rpg.personagens.herois;

import rpg.combate.BasicAtk;
import rpg.combate.FuriaDivina;
import rpg.combate.Motivate;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;

    //Construtor
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.divineAfinity = divineAfinity;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new FuriaDivina());
        adicionarAcao(new Motivate());
    }

    //Getters
    public int getDivineAfinity(){
        return divineAfinity;
    }

    public void setDivineAfinity(int valor){
        this.divineAfinity += valor;
    }

}

