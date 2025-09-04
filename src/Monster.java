package src;
public class Monster extends Character {
    //Atributos
    private int xpConcedido;

    //Construtor
    public Monster(String name, int pontosDeVida, int forca, int xpConcedido){
        super(name, pontosDeVida, forca);
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
}