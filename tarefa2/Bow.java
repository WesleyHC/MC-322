package tarefa2;

public class Bow extends Weapon {
    private String name;
    public Bow(){
        super(15, 2);
        this.name = "Arco";
    }


    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

