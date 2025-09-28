package rpg.personagens.herois;

import rpg.combate.BasicAtk;
import rpg.combate.BioAtk;
import rpg.combate.Rest;
import rpg.combate.Sintese;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

public class Satyr extends Hero {
    //Atributos
    private int biomance;

    //Construtor
    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.biomance = biomance;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Sintese());
        adicionarAcao(new BioAtk());
        adicionarAcao(new Rest());
    }

    //Getters
    public int getBiomance(){
        return biomance;
    }

}
