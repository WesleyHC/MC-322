package rpg.personagens;

import java.util.Random;

import rpg.exceptions.LvlEquiparException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.interfaces.Item;
import rpg.itens.weapons.Weapon;

/**
 * Classe abstrata que serve como base para todos os heróis jogáveis.
 * Herda de Character e adiciona mecânicas de progressão como nível, experiência e gerenciamento de inventário/moedas.
 */
public abstract class Hero extends Character {
    //Atributos
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;
    private int dracmas;
    private Random random = new Random();

    //Construtor
    /**
     * Construtor para criar um herói novo.
     * @param name Nome do herói.
     * @param pontosDeVida Pontos de vida incial do herói.
     * @param forca Força inicial do herói.
     * @param nivel Nível inicial do herói.
     * @param experiencia Experiência inicial do herói.
     * @param arma Arma inicial do herói.
     * @param expProximoNivel Quantidade de experiência necessária para o herói subir de nível.
     * @param sorte Sorte incial do herói (entre 0.000 e 1.000).
     */
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
    /**
     * Processo que ocorre quando o herói sobe de nível.
     * Aumenta os status, reinicia a contagem de XP e aumenta a meta para o próximo nível.
     */
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

    /**
     * Adiciona pontos de experiência ao herói e verifica se ele subiu de nível.
     * @param xp A quantidade de experiência recebida ao derrotar um monstro.
     */
    public void ganharExperiencia(int xp){
        this.experiencia += xp;
        while (this.experiencia >= this.expProximoNivel){
            subirdeNivel();
        }
    }

    /**
     * Exibe o status completo do herói.
     */
    public void exibirStatus(){
        super.exibirStatus();
        System.out.print("Nível: " + nivel + " | ");
        System.out.println("Experiência: " + experiencia);
        
        System.out.printf("Sorte Divina: %.3f  | ", sorte);
        System.out.println("Arma Equipada: " + this.getArma().getName());
        System.out.println("Dracmas atuais: " + this.dracmas);
    }

    /**
     * Tenta equipar um novo item. Verifica se o item é uma arma e se o herói consegue/deve equipá-la.
     * @param novoItem O item a ser equipado.
     * @throws LvlEquiparException Se o herói não tiver o nível mínimo para usar a arma.
     */
    public void equipar(Item novoItem) throws LvlEquiparException{
        if (novoItem instanceof Weapon){
            Weapon novaArma = (Weapon)novoItem;
            if ((nivel < novaArma.getMinNivel())) {
                throw new LvlEquiparException("O herói não foi forte o suficiente. Requer nível " + novaArma.getMinNivel());
            }
            
            if (novaArma.getDano()>this.getArma().getDano()){ 
                this.arma = novaArma;
                System.out.println(this.getName() + " equipou " + novaArma.getName());
            } else {
            System.out.println(novaArma.getName() + " tem dano igual ou inferior a arma atual!");
            }
        }
    }

   /**
     * Simula a escolha de uma ação durante o combate.
     * A escolha é feita de forma aleatória a partir da lista de ações disponíveis.
     * @param alvo O alvo atual do combate.
     * @return A AcaoDeCombate escolhida para ser executada.
     */
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return acoes.get(random.nextInt(acoes.size()));
    }

}
