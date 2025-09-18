package tarefa2;

public class Sword extends Weapon {
    private String name;
    public Sword(){
        super(8, 1);
        this.name = "Espada";
    }

    // public String toString() {
    //     return this.name; // Retorna o nome da arma
    // }

    public String getName(){
        return this.name;
    }
}


