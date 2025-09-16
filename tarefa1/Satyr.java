package tarefa1;

import tarefa2.Weapon;
import tarefa3.BasicAtk;
import tarefa3.BioAtk;
import tarefa3.Rest;
import tarefa3.Sintese;

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
