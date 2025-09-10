package tarefa2;

public class Bow extends Weapon{
    //Atributos
    private int dist;

    public Bow(int dano, int minNivel, int dist){
        super(dano, minNivel);
        this.dist = dist;
    }
}
