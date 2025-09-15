package tarefa2;

public class Bow extends Weapon {
    private String nome;
    public Bow(){
        super(15, 2);
        this.nome = "Arco";
    }


    public String toString() {
        return this.nome; // Retorna o nome da arma
    }
}

