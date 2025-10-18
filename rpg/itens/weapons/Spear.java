package rpg.itens.weapons;

/**
 * Representa a arma do tipo Lança.
 * É uma arma que requer nível 1 para ser equipada.
 */
public class Spear extends Weapon {
    private String name;
    /**
     * Constrói uma nova instância de uma Lança.
     */
    public Spear(){
        super(10, 1);
        this.name = "Lança";
    }

    /**
     * Retorna o nome da arma.
     * @return O nome "Lança".
     */
    public String getName() {
        return this.name; // Retorna o nome da arma
    }
}

