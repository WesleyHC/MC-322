package rpg.personagens.monstros;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlRootElement;

import rpg.cenario.Difficulty;
import rpg.combate.Actions;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, float flight, Difficulty dificuldade){
        super(name, pontosDeVida, forca, arma, xpConcedido, dificuldade);
        this.flight = flight;
    }
    public Harpy() {
        super();
        adicionarAcao(Actions.ATAQUE_BASICO);
        adicionarAcao(Actions.DESCANSAR);
    }

    //Getters
    @XmlElement
     public float getFlight(){
        return flight;
    }
    @XmlElement
    @Override
    public int getAtributoEspecial() {
        return 0; //não têm atributo especial
    }

    
    @Override
    public void setAtributoEspecial(int valor) {
    }

    @XmlElement
    @Override
    public float getSorte() {
        return 0; //sem sorte
    }

    @XmlElement
    @Override
    public int getNivel() {
        return 1;
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
}
