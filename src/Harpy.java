package src;

public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private int flight; 

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, int xpConcedido, int flight){
        super(name, pontosDeVida, forca, xpConcedido);
        this.flight = flight;
    }

    //Getters
     public int getFlight(){
        return flight;
    }

    //Métodos
    public void atacar(Character alvo){
        super.atacar(alvo, this.getForca());
    }
    public void receberDano(int dano) {
        if (Math.random()<0.25) {
            System.out.println(this.getName() + "esquivou!");
        } else {
            super.receberDano(dano);
        }
    }
}
