package tarefa2;

public class Spear extends Weapon {
     //Atributos
    private int bleed;

    public Spear(int dano, int minNivel, int bleed){
        super(dano, minNivel);
        this.bleed = bleed;
    }
}
