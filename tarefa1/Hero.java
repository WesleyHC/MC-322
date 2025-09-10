package tarefa1;

import tarefa2.Weapon;

public class Hero extends Character {
    //Atributos
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;

    //Construtor
    public Hero(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte){
        super(name, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
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
        System.out.print(this.getName() + " usa Habilidade Especial: ");
    }
    public void atacar(Character alvo, int valor) {
        System.out.println(this.getName() + " ataca!");
        super.atacar(alvo, this.getForca());
    }

    public void equiparArma(Weapon novaArma){
        if (nivel>=novaArma.getMinNivel()){
            arma = novaArma;
        }
    }
}
