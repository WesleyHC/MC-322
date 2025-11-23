package rpg.personagens.herois;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.combate.Actions;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

public class Satyr extends Hero {
    //Atributos
    private int biomance;

    //Construtor
    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.biomance = biomance;
        adicionarAcao(Actions.ATAQUE_BASICO);
        adicionarAcao(Actions.SINTESE);
        adicionarAcao(Actions.BIO_ATAQUE);
        adicionarAcao(Actions.DESCANSAR);
    }

    public Satyr(){
        adicionarAcao(Actions.ATAQUE_BASICO);
        adicionarAcao(Actions.SINTESE);
        adicionarAcao(Actions.BIO_ATAQUE);
        adicionarAcao(Actions.DESCANSAR);
    }

    //Getters
    @XmlElement
    public int getAtributoEspecial(){
        return biomance;
    }

    public void setAtributoEspecial(int valor){
        this.biomance += valor;
    }
}
