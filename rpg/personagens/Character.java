package rpg.personagens;

import java.util.ArrayList;
import java.util.List;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.itens.weapons.Weapon;

/**
 * Classe abstrata que é a base para qualquer personagem do jogo: Herói ou Monstro. Implementa a interface Combatente.
 */
public abstract class Character implements Combatente{
    //Atributos
    private String name;
    private int pontosDeVida;
    private int forca;
    protected Weapon arma;
    protected List<AcaoDeCombate> acoes;
    
    //Construtor
    /**
     * Construtor base para o personagem.
     * @param name O nome do personagem.
     * @param pontosDeVida Os pontos de vida do personagem.
     * @param forca A força base do personagem.
     * @param arma A arma inicial do personagem.
     */
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

    public List<AcaoDeCombate> getAcoes() {
        return this.acoes;
    }

    //setters
    protected void setPontosDeVida(int valor){
        pontosDeVida += valor;
    }

    protected void setForca(int valor){
        forca += valor;
    }

    //Métodos
    /** 
     * Aplica dano a este combatente, o que reduz seus pontos de vida.
     * Garante que os pontos de vida não fiquem negativos, e sim zero.
     * @param dano A quantidade de dano a ser recebido.
     * @return A quantidade de dano que foi alicado.
     */
    public int receberDano(int dano){
        setPontosDeVida(-dano);
        if (pontosDeVida < 0)
            pontosDeVida = 0; 
            return dano;  
    }

    /**
     * Aplica cura a este combatente, o que regenera seus pontos de vida.
     * @param cura A quantidade de cura a ser recebida.
     */
    public void receberCura(int cura){
        setPontosDeVida(cura);
        System.out.println(this.name + " curou-se em " + cura + " de vida!");
    }

    /**
     * Aplica força a este combatente, o que aumenta seu dano.
     * @param forca
     */
    public void receberForca(int forca){
        setForca(forca);
        System.out.println(this.name + " ficou mais forte em " + forca + " pontos!");
    }

    /**
     * Verifica se este combatente está vivo, ou seja, se seus pontos de vida são maiores que zero.
     * @return true se os pontos de vida estiverem maiores que zero, caso contrário, false.
     */
    public boolean isAlive(){
        return (this.pontosDeVida>0);
    }

    /**
     * Exibe as informações principais do combatente: Nome, vida e força.
     */
    public void exibirStatus(){
        System.out.println("\nStatus de " + name);
        System.out.print("Vida: " + pontosDeVida + " | ");
        System.out.println("Força: " + forca);
    }

    /**
     * Método abstrato que faz a escolha da ação de combate a ser utilizada no turno.
     * @param alvo Combatente que sofrerá a ação de combate.
     */
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    /**
     * Adiciona uma ação a lista de ações de combate do combatente.
     * @param novaAcao A ação que será adicionada.
     */
    protected void adicionarAcao(AcaoDeCombate novaAcao) {
        this.acoes.add(novaAcao);
    }
}
