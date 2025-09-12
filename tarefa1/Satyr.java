package tarefa1;

import java.util.Random;

import tarefa2.Weapon;

public class Satyr extends Hero {
    //Atributos
    private int biomance;

    //Construtor
    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.biomance = biomance;
    }

    //Getters
    public int getBiomance(){
        return biomance;
    }

    //Métodos
    public void atacar(Character alvo){ //Ataque = Força + Biomance
        int dano = this.getForca() + biomance + this.arma.getDano();
        System.out.println(this.getName() + " usa sua conexão com a natureza para atacar!");
        System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
        alvo.receberDano(dano);

    }

    public void usarHabilidadeEspecial(Character alvo){ //Se cura
        int cura = this.biomance;
        float crit = new Random().nextFloat();
        boolean AE = false;
        if (crit <= this.getSorte()) {
            AE = true;
            System.out.println("Os espíritos da natureza favorecem " + this.getName() + "! Sua cura foi fortalecida");
        }
        System.out.println(this.getName() + " usa a habilidade especial 'Síntese'!");
        System.out.println(this.getName() + " absorve energia vital e se cura em " + cura + " pontos de vida!");
        if (AE){
            cura *= 2;
        }
        this.receberDano(-cura);
    }
}
