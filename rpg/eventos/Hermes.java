package rpg.eventos;

import java.util.ArrayList;
import java.util.Random;

import rpg.interfaces.Evento;
import rpg.itens.weapons.*;
import rpg.personagens.Hero;

public class Hermes implements Evento{
    //Atributos
    private ArrayList<Weapon> stock = new ArrayList<>();
    private ArrayList<Integer> prices = new ArrayList<>();
    private boolean appearence = false;

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

    @Override
    public boolean Trigger() {
        if(new Random().nextFloat() <= 0.25f && !appearence) { //chance do evento acontecer
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void start(Hero heroi) {
        this.appearence = true;
        this.visit(heroi);
    }

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
                heroi.equipar(armaForSale);
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
