package game.personagens.herois;

import game.combate.BasicAtk;
import game.combate.BioAtk;
import game.combate.Rest;
import game.combate.Sintese;
import game.itens.weapons.Weapon;
import game.personagens.Hero;

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
