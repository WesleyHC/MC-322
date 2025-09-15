package tarefa1;

import tarefa2.Weapon;

public abstract class Character {
    //Atributos
    private String name;
    private int pontosDeVida;
    private int forca;
    protected Weapon arma;
    
    //Construtor
    public Character(String name, int pontosDeVida, int forca, Weapon arma){
        this.name = name;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }
    //getters
    public String getName(){
        return name;
    }
    public int getPontosDeVida(){
        return pontosDeVida;
    }
    public int getForca(){
        return forca;
    }
    
    public Weapon getArma(){
        return arma;
    }

    //setters
    protected void setPontosDeVida(int valor){
        pontosDeVida += valor;
    }

    protected void setForca(int valor){
        forca += valor;
    }

    //Métodos
    public void receberDano(int dano){
        setPontosDeVida(-dano);

        if (pontosDeVida < 0)
            pontosDeVida = 0;   
    }

    public void receberCura(int cura){
        setPontosDeVida(cura);

        if (pontosDeVida < 0)
            pontosDeVida = 0;   
    }

    public boolean isAlive(){
        return (this.pontosDeVida>0);
    }

    public void exibirStatus(){
        System.out.println("\nStatus de " + name);
        System.out.print("Vida: " + pontosDeVida + " | ");
        System.out.println("Força: " + forca);
    }

    public abstract void atacar(Character alvo); //Lógica geral para Ataque
}
