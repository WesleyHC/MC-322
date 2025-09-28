package rpg.itens.weapons;

import rpg.interfaces.Item;

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

    public void mult_dano(double aumento){
        this.dano += (int)(this.dano * aumento/2);
    }
    
    public abstract String getName();
}
