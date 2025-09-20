package game.itens.weapons;

public class Bow extends Weapon {
    private String name;
    public Bow(){
        super(12, 2);
        this.name = "Arco";
    }


    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

