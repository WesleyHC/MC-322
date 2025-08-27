package src;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private int heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, int xpConcedido, int heavystrike){
        super(name, pontosDeVida, forca, xpConcedido);
        this.heavystrike = heavystrike;
    }

    //Getters
     public int getHeavystrike(){
        return heavystrike;
    }

    //Métodos
}
