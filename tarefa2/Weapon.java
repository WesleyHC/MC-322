package tarefa2;

import tarefa3.Item;

public abstract class Weapon implements Item{
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
    
    //Setters
    public void setDano(int valor){
        this.dano += dano;
    }
    
}
