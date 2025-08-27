package src;

public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;

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
    public void atacar(Character alvo){
        super.atacar(alvo, this.getForca());
    }

    public void usarHabilidadeEspecial(Character alvo){
        super.usarHabilidadeEspecial(alvo);
        System.out.println("God's Plan em " + alvo.getName());
    }
}

