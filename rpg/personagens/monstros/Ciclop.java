package rpg.personagens.monstros;

import java.util.ArrayList;
import java.util.Random;

import rpg.combate.*;
import rpg.interfaces.Item;
import rpg.itens.Dracmas;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

/**
 * Representa o monstro Ciclope, um inimigo de força bruta.
 * Sua característica é a habilidade Golpe Pesado, um ataque danoso, mas que o deixa fatigado, forçando-o a pular o próximo turno de ataque.
 */
public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    /**
     * Constrói uma nova instância de um Ciclope.
     * @param name Nome do monstro.
     * @param pontosDeVida Pontos de vida do monstro.
     * @param forca Força base do monstro.
     * @param arma Arma que o monstro utiliza.
     * @param xpConcedido Experiência concedida ao ser derrotado.
     */
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.heavystrike = true;
        adicionarAcao(new GolpePesado());
        adicionarAcao(new Rest());
    }

    //Getters
    /**
     * Verifica se o Ciclope está pronto para usar seu Golpe Pesado.
     * @return true se o golpe estiver disponível, false se estiver fatigado.
     */
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Setters
    /**
     * Define o estado de fadiga do Golpe Pesado.
     * @param heavystrike O novo estado (true para pronto, false para fatigado).
     */
    public void setHeavystrike(boolean heavystrike){
        this.heavystrike = heavystrike;
    }

    //Métodos
    /**
     * Define o loot que o Ciclope deixa ao ser derrotado.
     * Herda a implementação da classe Monster.
     * @param heroi O herói que derrotou o monstro.
     * @return Uma lista de itens contendo as recompensas.
     */
    @Override
    public ArrayList<Item> droparLoot(Hero heroi) {
        Random random = new Random();
        ArrayList<Item> drops = new ArrayList<>();

        int money = random.nextInt(15, 50);
        drops.add(new Dracmas(money));
        System.out.println(this.getName() + " deixou cair " + money + " Dracmas!");
        Weapon dropArma = largarArma(heroi.getSorte());
        
        if (dropArma != null) {
            drops.add(dropArma);
        }
        return drops;
    }
}
