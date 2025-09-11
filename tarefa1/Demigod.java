package tarefa1;
import java.util.Random;

import tarefa2.Weapon;

public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;
    private String [] Gods = {"Zeus", "Poseidon", "Afrodite", "Ares", "Hades"};

    //Construtor
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.divineAfinity = divineAfinity;
    }

    //Getters
    public int getDivineAfinity(){
        return divineAfinity;
    }

    //Métodos
    public void atacar(Character alvo){
        int dano = this.getForca() + this.arma.getDano();
        System.out.println(this.getName() + " ataca!");
        System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
        alvo.receberDano(dano);
    }

    public void usarHabilidadeEspecial(Character alvo){ //Usa o poder concedido por um Deus aleatório
        System.out.println(this.getName() + " usa a habilidade especial 'Fúria Divina'!");
        Random random = new Random();
        int deus = random.nextInt(5);
        int dano;
        switch(Gods[deus]){
            case("Zeus"):
                dano = this.getForca() + this.divineAfinity * 2 + this.arma.getDano();
                System.out.println("BENÇÃO DE ZEUS!\nUm raio atinge " + alvo.getName() + " causando " + dano + " de dano!");
                alvo.receberDano(dano);
                break;
            case("Poseidon"):
                dano = this.getForca() + this.divineAfinity + this.arma.getDano();
                System.out.println("BENÇÃO DE POSEIDON!\nUma onda esmaga " + alvo.getName() + " causando " + dano + " de dano!");
                alvo.receberDano(dano);
                break;
            case("Afrodite"):
                int cura = this.getDivineAfinity() + (this.getNivel() * 2);
                System.out.println("BENÇÃO DE AFRODITE!\nUma aura pura envolve " + this.getName() + ", fechando seus ferimentos!");
                System.out.println(this.getName() + " recupera " + cura + " pontos de vida!");
                this.receberDano(-cura);
                break;
            case("Ares"): 
                dano = this.getForca() * 3 + this.arma.getDano();
                System.out.println("BENÇÃO DE ARES!\nA fúria da guerra inspira um golpe devastador de " + dano + " de dano em " + alvo.getName());
                alvo.receberDano(dano);
                break;
            case("Hades"):  
                dano = this.divineAfinity * 2 + this.arma.getDano();
                System.out.println("BENÇÃO DE HADES!\nA energia vital de " + alvo.getName() + " é drenada!");
                System.out.println(this.getName() + " causa " + dano + " de dano e se cura na mesma quantidade.");
                alvo.receberDano(dano);
                this.receberDano(-dano);
                break;
        }
    }
}

