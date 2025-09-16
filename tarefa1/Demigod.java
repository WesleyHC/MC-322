package tarefa1;

import tarefa2.Weapon;
import tarefa3.BasicAtk;
import tarefa3.FuriaDivina;
import tarefa3.Motivate;

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

}

