package tarefa2;

public class Sword extends Weapon {
    private String nome;
    public Sword(){
        super(5, 0);
        this.nome = "Espada";
    }

    public String toString() {
        return this.nome; // Retorna o nome da arma
    }
}


