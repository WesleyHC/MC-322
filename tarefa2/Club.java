package tarefa2;

public class Club extends Weapon { //clava / porrete
    private String name;
    public Club(){
        super(25, 3);
        this.name = "Porrete";
    }

    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

