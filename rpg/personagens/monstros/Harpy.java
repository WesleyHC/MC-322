package rpg.personagens.monstros;

import java.util.ArrayList;
import java.util.Random;

import rpg.combate.*;
import rpg.interfaces.Item;
import rpg.itens.Dracmas;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

/**
 * Representa o monstro Harpia, um inimigo evasivo.
 * Sua característica é a habilidade de voar, o que lhe confere uma chance de esquivar completamente dos ataques recebidos.
 */
public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    /**
     * Constrói uma nova instância de uma Harpia.
     * @param name Nome do monstro.
     * @param pontosDeVida Pontos de vida do monstro.
     * @param forca Força base do monstro.
     * @param arma Arma que o monstro utiliza.
     * @param xpConcedido Experiência concedida ao ser derrotado.
     * @param flight A chance de esquiva.
     */
    public Harpy(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, float flight){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.flight = flight;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Rest());
    }

    //Getters
    /**
     * Retorna a chance de esquiva da Harpia.
     * @return A chance de esquiva.
     */
     public float getFlight(){
        return flight;
    }

    //Métodos
    /**
     * Sobrescreve o método para aplicar a habilidade de esquiva.
     * Com base no atributo flight, há uma chance de o dano ser completamente anulado.
     * @param dano O dano original do ataque.
     * @return O dano final que foi efetivamente aplicado (0 em caso de esquiva).
     */
    public int receberDano(int dano) {
        if ((100*Math.random()) < this.flight) {
            System.out.println(this.getName() + " voa agilmente e ESQUIVA do ataque!");
            return 0;
        } else {
            System.out.println("O ataque ACERTA " + this.getName() + "!");
            super.receberDano(dano);
            return dano;
        }
    }

    /**
     * Define o loot que a Harpia deixa ao ser derrotada.
     * Herda a implementação da classe Monster.
     * @param heroi O herói que derrotou o monstro.
     * @return Uma lista de itens contendo as recompensas.
     */
    @Override
    public ArrayList<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        ArrayList<Item> drops = new ArrayList<>();

        int money = random.nextInt(10, 50);
        drops.add(new Dracmas(money));
        System.out.println(this.getName() + " deixou cair " + money + " Dracmas!");
        Weapon dropArma = largarArma(heroi.getSorte());
        
        if (dropArma != null) {
            drops.add(dropArma);
        }
        return drops;
    }
}
