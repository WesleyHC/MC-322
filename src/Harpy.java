package src;

public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, int xpConcedido, float flight){
        super(name, pontosDeVida, forca, xpConcedido);
        this.flight = flight;
    }

    //Getters
     public float getFlight(){
        return flight;
    }

    //Métodos
    public void atacar(Character alvo){
        super.atacar(alvo, this.getForca());
    }
    public void receberDano(int dano) {
        if ((100*Math.random())<flight) {
            System.out.println(this.getName() + " esquivou!");
        } else {
            super.receberDano(dano);
        }
    }
}
