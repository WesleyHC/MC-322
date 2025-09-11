package tarefa2;

public abstract class Weapon {
    //Atributos
    private int dano;
    private int minNivel;
    
    //Construtor
    public Weapon(int dano, int minNivel){
        this.dano = dano;
        this.minNivel = minNivel;
    }

    //Getters
    public int getMinNivel(){
        return minNivel;
    }

    public int getDano(){
        return dano;
    }
    
}
