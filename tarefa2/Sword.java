package tarefa2;

public class Sword extends Weapon {
    //Atributos
    private int def;

    public Sword(int dano, int minNivel, int def){
        super(dano, minNivel);
        this.def = def;
    }
}

