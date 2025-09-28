package rpg.itens.weapons;

public class Club extends Weapon { //clava / porrete
    private String name;
    public Club(){
        super(18, 3);
        this.name = "Porrete";
    }

    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

