package tarefa1;

import java.util.ArrayList;
import java.util.Random;
import tarefa2.Weapon;

public abstract class Monster extends Character {
    //Atributos
    private int xpConcedido;
    private ArrayList<Weapon> listaDeArmasParaLargar;

    //Construtor
    public Monster(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, ArrayList<Weapon> listaDeArmasParaLargar) {
        super(name, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
    }

    //Getters
    public int getXpConcedido(){
        return xpConcedido;
    }

    //Métodos
    public void exibirStatus(){
        super.exibirStatus();
        if (this.getPontosDeVida() == 0) {
            System.out.println("XP Concedido: " + xpConcedido);
        }
    }
    
    public Weapon largarArma() { //dropa uma weapon aleatoria
        Random random = new Random();
        int arma = random.nextInt(listaDeArmasParaLargar.size());
        return listaDeArmasParaLargar.get(arma);
    }
}