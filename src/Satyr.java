package src;

public class Satyr extends Hero {
    //Atributos
    private int biomance;

    //Construtor
    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia);
        this.biomance = biomance;
    }

    //Getters
    public int getBiomance(){
        return biomance;
    }

    //Métodos
    public void atacar(Character alvo){ //Ataque = Força + Biomance
        super.atacar(alvo, (this.getForca()+biomance));
    }

    public void usarHabilidadeEspecial(Character alvo){ //Se cura
        super.usarHabilidadeEspecial(alvo);
        System.out.println("Synthesis");
        this.receberDano(-biomance);
    }
}
