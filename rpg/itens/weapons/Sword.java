package rpg.itens.weapons;

import jakarta.xml.bind.annotation.XmlElement;

public class Sword extends Weapon {
    private String name;
    public Sword(){
        super(8, 1);
        this.name = "Espada";
    }

    // public String toString() {
    //     return this.name; // Retorna o nome da arma
    // }
    @XmlElement
    public String getName(){
        return this.name;
    }
}


