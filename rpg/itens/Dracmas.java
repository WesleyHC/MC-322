package rpg.itens;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.interfaces.Item;

public class Dracmas implements Item{
    private String name = "Dracmas";
    private int quantity;

    public Dracmas(int quantity){
        this.quantity = quantity;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public int getQuantity() {
        return quantity;
    }
}
