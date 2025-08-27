package src;
public class Hero extends Character {
    //Atributos
    private int nivel;
    private int experiencia;

    //Construtor
    public Hero(String name, int pontosDeVida, int forca, int nivel, int experiencia){
        super(name, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }
    //Getters
    public int getNivel(){
        return nivel;
    }
    public int getExperiencia(){
        return experiencia;
    }

    //Métodos
    public void ganharExperiencia(int xp){
        experiencia += xp;
        if (experiencia>=50){
            nivel += 1;
            experiencia -= 50;
        }
    }

    public void exibirStatus(){
        super.exibirStatus();
        System.out.print("Nível: " + nivel + " | ");
        System.out.println("Experiência: " + experiencia);
    }

    public void usarHabilidadeEspecial(Character alvo){
        System.out.print("Usou Habilidade Especial: ");
    }
}
