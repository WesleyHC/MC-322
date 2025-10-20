package rpg.itens.weapons;

import jakarta.xml.bind.annotation.XmlElement;

public class Bow extends Weapon {
    private String name;
    public Bow(){
        super(12, 2);
        this.name = "Arco";
    }

    @XmlElement
    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

