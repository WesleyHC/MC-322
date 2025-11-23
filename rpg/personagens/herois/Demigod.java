package rpg.personagens.herois;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.combate.Actions;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;

    //Construtor
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.divineAfinity = divineAfinity;
        adicionarAcao(Actions.ATAQUE_BASICO);
        adicionarAcao(Actions.FURIA_DIVINA);
        adicionarAcao(Actions.MOTIVAR);
    }

    public Demigod(){
        adicionarAcao(Actions.ATAQUE_BASICO);
        adicionarAcao(Actions.FURIA_DIVINA);
        adicionarAcao(Actions.MOTIVAR);
    }

    //Getters
    @XmlElement
    public int getAtributoEspecial(){
        return divineAfinity;
    }

    public void setAtributoEspecial(int valor){
        this.divineAfinity += valor;
    }

}

