package tarefa1;

import tarefa2.Weapon;

public abstract class Hero extends Character {
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
    private void subirdeNivel() {
        this.nivel += 1;
        super.setForca(5);
        super.setPontosDeVida(10);
        System.out.println("==============================================");
        System.out.println(this.getName() + " DE NÍVEL!");
        System.out.println("-=============================================");
        this.experiencia -= this.expProximoNivel;
        this.expProximoNivel *= 2; 
        
    }
    public void ganharExperiencia(int xp){
        this.experiencia += xp;
        while (this.experiencia >= this.expProximoNivel){
            subirdeNivel();
        }
    }

    public void exibirStatus(){
        super.exibirStatus();
        System.out.print("Nível: " + nivel + " | ");
        System.out.println("Experiência: " + experiencia);
    }

    public abstract void usarHabilidadeEspecial(Character alvo);

    public void equiparArma(Weapon novaArma){
        if (nivel >= novaArma.getMinNivel()){ 
            arma = novaArma;
        }
    }
}
