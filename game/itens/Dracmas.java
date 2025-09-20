package game.itens;

import game.interfaces.Item;

public class Dracmas implements Item{
    private String name = "Dracmas";
    private int quantity;

    public Dracmas(int quantity){
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
