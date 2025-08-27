package src;

public class Harpy extends Monster {
    //Atributo voar (ataca primeiro sempre)
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
}
