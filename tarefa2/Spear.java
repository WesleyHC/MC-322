package tarefa2;

public class Spear extends Weapon {
    private String nome;
    public Spear(){
        super(10, 1);
        this.nome = "Lança";
    }

    public String toString() {
        return this.nome; // Retorna o nome da arma
    }
}

