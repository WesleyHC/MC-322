package rpg.itens.weapons;

/**
 * Representa a arma do tipo Espada.
 * É uma arma que requer nível 1 para ser equipada.
 */
public class Sword extends Weapon {
    private String name;
    /**
     * Constrói uma nova instância de uma Espada.
     */
    public Sword(){
        super(8, 1);
        this.name = "Espada";
    }

    // public String toString() {
    //     return this.name; // Retorna o nome da arma
    // }

    /**
     * Retorna o nome da arma.
     * @return O nome "Espada".
     */
    public String getName(){
        return this.name;
    }
}


