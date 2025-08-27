package src;

public class Chimera extends Monster {
    //Atributo intimidador (dano do heroi reduzido)
    private int intimidate;

    //Construtor
    public Chimera(String name, int pontosDeVida, int forca, int xpConcedido, int intimidate){
        super(name, pontosDeVida, forca, xpConcedido);
        this.intimidate = intimidate;
    }

    //Getters
    public int getIntimidate(){
        return intimidate;
    }

    //Métodos
}
