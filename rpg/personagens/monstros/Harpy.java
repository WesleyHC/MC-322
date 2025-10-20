package rpg.personagens.monstros;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.cenario.Difficulty;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

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
    }

    //Getters
    @XmlElement
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
}
