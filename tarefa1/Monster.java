package tarefa1;

import tarefa2.Weapon;

public class Monster extends Character {
    //Atributos
    private int xpConcedido;
    private Weapon[] listaDeArmasParaLargar;

    //Construtor
    public Monster(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido){
        super(name, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
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

    public void largaArma(){
        //droppa uma arma aleatória da "listaDeArmasParaLargar"
    }
}