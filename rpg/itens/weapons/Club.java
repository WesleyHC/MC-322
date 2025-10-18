package rpg.itens.weapons;

/**
 * Representa a arma do tipo Porrete.
 * É uma arma que requer nível 3 para ser equipada.
 */
public class Club extends Weapon { //clava / porrete
    private String name;
    /**
     * Constrói uma nova instância de um Porrete.
     */
    public Club(){
        super(18, 3);
        this.name = "Porrete";
    }

    /**
     * Retorna o nome da arma.
     * @return O nome "Porrete".
     */
    public String getName() {
        return this.name;
    }
}

