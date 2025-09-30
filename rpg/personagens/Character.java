package rpg.personagens;

import java.util.ArrayList;
import java.util.List;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.itens.weapons.Weapon;

public abstract class Character implements Combatente{
    //Atributos
    private String name;
    private int pontosDeVida;
    private int forca;
    protected Weapon arma;
    protected List<AcaoDeCombate> acoes;
    
    //Construtor
    public Character(String name, int pontosDeVida, int forca, Weapon arma){
        this.name = name;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
        this.acoes = new ArrayList<>();
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
    public int receberDano(int dano){
        setPontosDeVida(-dano);
        if (pontosDeVida < 0)
            pontosDeVida = 0; 
            return dano;  
    }

    public void receberCura(int cura){
        setPontosDeVida(cura);
        System.out.println(this.name + " curou-se em " + cura + " de vida!");
    }

    public void receberForca(int forca){
        setForca(forca);
        System.out.println(this.name + " ficou mais forte em " + forca + " pontos!");
    }

    public boolean isAlive(){
        return (this.pontosDeVida>0);
    }

    public void exibirStatus(){
        System.out.println("\nStatus de " + name);
        System.out.print("Vida: " + pontosDeVida + " | ");
        System.out.println("Força: " + forca);
    }

    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    protected void adicionarAcao(AcaoDeCombate novaAcao) {
        this.acoes.add(novaAcao);
    }
}
