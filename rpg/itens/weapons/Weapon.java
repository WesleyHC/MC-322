package rpg.itens.weapons;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.interfaces.Item;

public abstract class Weapon implements Item{
    //Atributos
    private int dano;
    private int minNivel;
    
    //Construtor
    public Weapon(int dano, int minNivel){
        this.dano = dano;
        this.minNivel = minNivel;
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
    @XmlElement
    public void mult_dano(double aumento){
        this.dano += (int)(this.dano * aumento/2);
    }
    @XmlElement
    public abstract String getName();
}
