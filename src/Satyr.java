package src;

public class Satyr extends Hero {
    int biomance;

    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia);
        this.biomance = biomance;
    }

    //Getters
    public int getBiomance(){
        return biomance;
    }

    //Métodos
    public void atacar(Character alvo){
        super.atacar(alvo, getForca());
    }

    public void usarHabilidadeEspecial(Character alvo){
        super.usarHabilidadeEspecial(alvo);
        System.out.print("Sátiro atacou" + alvo.getName());
        setPontosDeVida(20);
    }
}
