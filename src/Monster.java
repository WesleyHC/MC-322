package src;
public class Monster extends Character {
    private int xpConcedido;

    public Monster(String name, int pontosDeVida, int forca, int xpConcedido){
        super(name, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    public int getXpConcedido(){
        return xpConcedido;
    }

    public void exibirStatus(){
        super.exibirStatus();
        System.out.println("XP Concedido: " + xpConcedido);
    }
}
