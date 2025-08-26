package src;
public class Hero extends Character {
    private int nivel;
    private int experiencia;

    public Hero(String name, int pontosDeVida, int forca, int nivel, int experiencia){
        super(name, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public int getNivel(){
        return nivel;
    }
    public int getExperiencia(){
        return experiencia;
    }

    public void ganharExperiencia(int xp){
        experiencia += xp;
    }

    public void exibirStatus(){
        super.exibirStatus();
        System.out.print("Nível: " + nivel + " | ");
        System.out.println("Experiência: " + experiencia);
    }

    public void usarHabilidadeEspecial(Character alvo){
        System.out.print("Usou Habilidade Especial:");
    }
}
