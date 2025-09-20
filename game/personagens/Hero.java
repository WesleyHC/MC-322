package game.personagens;

import java.util.Random;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;
import game.interfaces.Item;
import game.itens.weapons.Weapon;

public abstract class Hero extends Character {
    //Atributos
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;
    private int dracmas;
    private Random random = new Random();

    //Construtor
    public Hero(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte){
        super(name, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
        this.dracmas = 0;
    }
    //Getters
    public int getNivel(){
        return nivel;
    }
    public int getExperiencia(){
        return experiencia;
    }

    public float getSorte() {
        return sorte;
    }
    public int getDracmas(){
        return dracmas;
    }
    //Setters 
    public void setDracmas(int valor) {
        dracmas += valor;
    }

    public void setSorte(float valor) {
        sorte += valor;
    }
    
    //Métodos
    private void subirdeNivel() {
        this.nivel += 1;
        super.setForca(8);
        super.setPontosDeVida(30);
        System.out.println("\n==============================================");
        System.out.println(this.getName() + " SUBIU DE NÍVEL!");
        System.out.println("==============================================\n");
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
        
        System.out.printf("Sorte Divina: %.3f  | ", sorte);
        System.out.println("Arma Equipada: " + this.getArma().getName());
        System.out.println("Dracmas atuais: " + this.dracmas);
    }

    public void equipar(Item novoItem){
        if (novoItem instanceof Weapon){
            Weapon novaArma = (Weapon)novoItem;
            if ((nivel >= novaArma.getMinNivel())&(novaArma.getDano()>=this.getArma().getDano())){ 
                this.arma = novaArma;
                System.out.println(this.getName() + " equipou " + novaArma.getName());
            } else {
            System.out.println(this.getName() + " não foi forte o suficiente para equipar " + novaArma.getName());
            }
        }
    }

    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return acoes.get(random.nextInt(acoes.size()));
    }

}
