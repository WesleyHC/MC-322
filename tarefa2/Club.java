package tarefa2;

public class Club extends Weapon { //clava / porrete
    private String nome;
    public Club(){
        super(25, 3);
        this.nome = "Porrete";
    }

    public String toString() {
        return this.nome; // Retorna o nome da arma
    }
}

