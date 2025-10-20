package rpg.itens.weapons;

import jakarta.xml.bind.annotation.XmlElement;

public class Spear extends Weapon {
    private String name;
    public Spear(){
        super(10, 1);
        this.name = "Lança";
    }
    @XmlElement
    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

