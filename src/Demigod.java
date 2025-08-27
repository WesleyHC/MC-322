package src;

public class Demigod extends Hero {
    //Atributos
    int divineAfinity;

    //Construtor
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia);
        this.divineAfinity = divineAfinity;
    }

    //Getters
    public int getDivineAfinity(){
        return divineAfinity;
    }

    //Métodos
}
