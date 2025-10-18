package rpg.itens.weapons;

import rpg.interfaces.Item;

/**
 * Classe abstrata que representa a base para todas as armas do jogo.
 * Toda arma é um Item e deve ter um nome.
 */
public abstract class Weapon implements Item{
    //Atributos
    private int dano;
    private int minNivel;
    
    //Construtor
    /**
     * Construtor para criar uma nova arma com seus status base.
     * @param dano O dano da arma.
     * @param minNivel O nível mínimo para poder usar a arma.
     */
    public Weapon(int dano, int minNivel){
        this.dano = dano;
        this.minNivel = minNivel;
    }

    //Getters
    /**
     * Retorna o nível mínimo para poder equipar a arma.
     * @return O nível mínimo.
     */
    public int getMinNivel(){
        return minNivel;
    }

    /**
     * Retorna o dano da arma.
     * @return A quantidade de dano.
     */
    public int getDano(){
        return dano;
    }

    /**
     * Aplica um multiplicador ao dano base da arma, escalando seu poder.
     * @param aumento O multiplicador de dificuldade, que será usado para calcular o bônus de dano.
     */
    public void mult_dano(double aumento){
        this.dano += (int)(this.dano * aumento/2);
    }
    
    /**
     * Método abstrato que força todas as armas a implementar um método para retornar seu nome.
     * @return O nome da arma como String.
     */
    public abstract String getName();
}
