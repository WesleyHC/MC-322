package rpg.itens;

import rpg.interfaces.Item;

/**
 * Representa a moeda do jogo, as Dracmas.
 */
public class Dracmas implements Item{
    private String name = "Dracmas";
    private int quantity;

    /**
     * Constrói uma nova pilha de Dracmas.
     * @param quantity A quantidade de moedas que este item representa.
     */
    public Dracmas(int quantity){
        this.quantity = quantity;
    }

    /**
     * Retorna o nome do item.
     * @return A String "Dracmas".
     */
    public String getName() {
        return name;
    }
    
    /**
     * Retorna a quantidade de moedas neste item.
     * @return A quantidade de Dracmas.
     */
    public int getQuantity() {
        return quantity;
    }
}
