package rpg.itens.weapons;

/**
 * Representa a arma do tipo Arco.
 * É uma arma que requer nível 2 para ser equipada.
 */
public class Bow extends Weapon {
    private String name;
    /**
     * Constrói uma nova instância de um Arco.
     */
    public Bow(){
        super(12, 2);
        this.name = "Arco";
    }

    /**
     * Retorna o nome da arma.
     * @return O nome "Arco".
     */
    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

