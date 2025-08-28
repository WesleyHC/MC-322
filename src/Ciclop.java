package src;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, int xpConcedido, boolean heavystrike){
        super(name, pontosDeVida, forca, xpConcedido);
        this.heavystrike = heavystrike;
    }

    //Getters
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Métodos
}
