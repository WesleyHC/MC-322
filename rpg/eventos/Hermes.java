package rpg.eventos;

import java.util.ArrayList;
import java.util.Random;

import rpg.exceptions.LvlEquiparException;
import rpg.interfaces.Evento;
import rpg.itens.weapons.*;
import rpg.personagens.Hero;

/**
 * Representa o evento aleatório onde o deus Hermes aparece como um comerciante.
 * Esta classe implementa a interface Evento, definindo a condição e a lógica para a interação da loja de armas.
 */
public class Hermes implements Evento{
    //Atributos
    private ArrayList<Weapon> stock = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();
    private boolean appearence = false;

    /**
     * Construtor do evento Hermes.
     * Inicializa o estoque de armas da loja e seus respectivos preços.
     */
    public Hermes() {
        //estoque de armas
        stock.add(new Sword());
        stock.add(new Bow());
        stock.add(new Club());

        //preços das armas (respec)
        prices.add(40);
        prices.add(90);
        prices.add(150);
    }

    /**
     * Define o gatilho para a aparição de Hermes.
     * O evento tem 25% de chance de ocorrer e só pode acontecer uma vez por fase.
     * @return true se o evento for ativado, false caso contrário.
     */
    @Override
    public boolean Trigger() {
        if(new Random().nextFloat() <= 0.25f && !appearence) { //chance do evento acontecer
            return true;
        } else{
            return false;
        }
    }

    /**
     * Executa o evento da loja, iniciando a interação com o herói.
     * Marca o evento como ocorrido para que não se repita na mesma fase.
     * @param heroi O herói que encontrou o comerciante.
     */
    @Override
    public void start(Hero heroi) {
        this.appearence = true;
        this.visit(heroi);
    }

    /**
     * Método privado que contém a lógica de interação.
     * Exibe os itens, simula a decisão de compra do herói (tentando sempre o melhor upgrade).
     * @param heroi O herói que está visitando a loja.
     */
    private void visit(Hero heroi) {
        System.out.println("\n=================|HERMES, O PATRONO DOS VIAJANTES |=================");
        System.out.println("Com um brilho fugaz, Hermes surge em seu caminho.");
        System.out.println("'Uma árdua jornada, ein? Por um preço, posso tornar seu fardo um pouquinho mais leve.'");
        System.out.println("Itens à venda:");
        
        for (int i=0; i < stock.size(); i++) {
            Weapon arma = stock.get(i);
            int price = prices.get(i);
            System.out.println("-> " + arma.getName() + ":" + " [Dano:" + arma.getDano() + ", Nível Mín: " + arma.getMinNivel() + "]" + " | Preço: " + price);
        }
        boolean compraRealizada = false;
        for (int j=stock.size()-1; j > -1; j--){
            Weapon armaForSale = stock.get(j);
            int priceAtual = prices.get(j);

            if ((heroi.getDracmas() >= priceAtual) && (heroi.getNivel() >= armaForSale.getMinNivel()) && (armaForSale.getDano() > heroi.getArma().getDano())) {
                System.out.println(heroi.getName() + " comprou " + armaForSale.getName() + " por " + priceAtual + " Dracmas.");
                heroi.setDracmas(-priceAtual);
                try{heroi.equipar(armaForSale);
                } catch (LvlEquiparException e) {
                    System.out.println("Não foi possível equipar: " + e.getMessage());
                }
                compraRealizada = true;
                break;
            } 
        }
        if (!compraRealizada) {
            System.out.println("'Talvez da próxima vez.' - diz Hermes.");
        }
        System.out.println("Hermes desaparece em um piscar de olhos.");
        System.out.println("===================================================\n");
    }
}
