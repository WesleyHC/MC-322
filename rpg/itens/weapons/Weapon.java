package rpg.itens.weapons;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import rpg.interfaces.Item;

@XmlSeeAlso({Sword.class, Bow.class, Club.class, Spear.class})
public abstract class Weapon implements Item{
    //Atributos
    private int dano;
    private int minNivel;
    
    //Construtor
    public Weapon(int dano, int minNivel){
        this.dano = dano;
        this.minNivel = minNivel;
    }

    public Weapon(){

    }

    //Getters
    @XmlElement
    public int getMinNivel(){
        return minNivel;
    }
    @XmlElement
    public int getDano(){
        return dano;
    }
  
    public void mult_dano(double aumento){
        this.dano += (int)(this.dano * aumento/2);
    }

    public abstract String getName();

    //Setters
    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setMinNivel(int minNivel) {
        this.minNivel = minNivel;
    }
}


