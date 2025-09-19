package tarefa2;

public class Spear extends Weapon {
    private String name;
    public Spear(){
        super(10, 1);
        this.name = "Lança";
    }

    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

