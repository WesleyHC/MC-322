package rpg.personagens;

import java.util.ArrayList;
import java.util.Random;

import rpg.cenario.Difficulty;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.interfaces.Item;
import rpg.interfaces.Lootable;
import rpg.itens.Dracmas;
import rpg.itens.weapons.Weapon;
import rpg.personagens.monstros.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlSeeAlso;
/**
 * Classe abstrata que serve como base para todos os inimigos (monstros) no jogo.
 * Herda de Character e implementa a interface Lootavel, garantindo que todo monstro possa deixar recompensas.
 */
@XmlSeeAlso({Chimera.class, Ciclop.class, Harpy.class})
public abstract class Monster extends Character implements Lootable{
    //Atributos
    private int xpConcedido;
    private ArrayList<String> armasComuns;
    private ArrayList<String> armasRaras;
    private Random random = new Random();
    private Difficulty dificuldade;

    //Construtor
    /**
     * Construtor para criar um novo monstro.
     * @param name Nome do monstro.
     * @param pontosDeVida Pontos de vida inicial do monstro.
     * @param forca Força inicial do monstro.
     * @param arma Arma incial do monstro.
     * @param xpConcedido Experiencia que o monstro concede ao ser derrotado.
     */
    public Monster(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, Difficulty dificuldade) {
        super(name, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.armasComuns = new ArrayList<>();
        this.armasRaras = new ArrayList<>();
        this.dificuldade = dificuldade;
    }

    public Monster() {
        super();
        this.armasComuns = new ArrayList<>();
        this.armasRaras = new ArrayList<>();
        }

    //Getters
    @XmlElement
    public int getXpConcedido(){
        return xpConcedido;
    }

    @XmlElementWrapper(name = "armasComuns")
    @XmlElement(name = "arma")
    public ArrayList<String> getArmasComuns() {
        return armasComuns;
    }

    @XmlElementWrapper(name = "armasRaras")
    @XmlElement(name = "arma")
    public ArrayList<String> getArmasRaras() {
        return armasRaras;
    }

    @XmlElement
    public Difficulty getDificuldade(){
        return dificuldade;
    }

    //Setters
    public void setXpConcedido(int xp) {
        this.xpConcedido = xp;
    }
    public void setDificuldade(Difficulty dificuldade) {
        this.dificuldade = dificuldade;
    }
    public void setArmasComuns(ArrayList<String> nomesArmasComuns) {
        this.armasComuns = nomesArmasComuns;
    }
    public void setArmasRaras(ArrayList<String> nomesArmasRaras) {
        this.armasRaras = nomesArmasRaras;
    }

    //Métodos
    /**
     * Exibe o status completo do monstro.
     */
    public void exibirStatus(){
        super.exibirStatus();
        if (this.getPontosDeVida() == 0) {
            System.out.println("XP Concedido: " + xpConcedido);
        }
    }

    /**
     * Adiciona uma arma à lista de possíveis drops comuns deste monstro.
     * @param arma A arma comum a ser adicionada.
     * @param mult O multipliador de dificuldade a ser aplicado no dano da arma.
     */
    public void addArmaComum(String nomeArma) {
        this.armasComuns.add(nomeArma);
    }

    /**
     * Adiciona uma arma à lista de possíveis drops raros deste monstro.
     * @param arma A arma rara a ser adicionada.
     * @param mult O multipliador de dificuldade a ser aplicado no dano da arma.
     */
    public void addArmaRara(String nomeArma) {
        this.armasRaras.add(nomeArma);
    }
    
    /**
     * Método que sorteia uma arma (comum ou rara) com base na sorte do herói.
     * @param luck A sorte do herói, um valor float.
     * @return A arma (Weapon) sorteada, ou null se nenhuma arma for dropada.
     */
    protected Weapon largarArma(float luck) { //dropa uma weapon aleatoria
        if (random == null) {
            this.random = new Random();
        }
        ArrayList<String> listaArmas = new ArrayList<>();
        float rare = new Random().nextFloat();

        if (rare<=luck && !armasRaras.isEmpty()){
            System.out.println("A arma apresenta um poder maior do que o normal! Dizem que a arma corresponde a grandiosidade do guerreiro!");
            listaArmas = armasRaras;
        } else if (!armasComuns.isEmpty()) {
            System.out.println("Foi deixada pelos restos moribundos da criatura uma arma comum");
            listaArmas = armasComuns;
        }
        if (listaArmas.isEmpty()) {
            return null;
        }
        String arma = listaArmas.get(random.nextInt(listaArmas.size()));
        try {
            Class<?> classeArma = Class.forName(arma);
            Weapon armaDrop = (Weapon) classeArma.getDeclaredConstructor().newInstance();

            double multArma = this.dificuldade.getMultArma();
            armaDrop.mult_dano(multArma);

            System.out.println("Um(a) " + armaDrop.getName() + " foi encontrado(a)!");
            return armaDrop;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Implementa a "IA" do monstro, escolhendo uma ação de forma aleatória.
     * @param alvo O alvo da ação, geralmente o herói.
     * @return A ação de combate que o monstro executará neste turno.
     */
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (random == null) {
            random = new Random();
        }
        return acoes.get(random.nextInt(acoes.size()));
    }

    public ArrayList<Item> droparLoot(Hero heroi) {
        ArrayList<Item> loot = new ArrayList<>();
        if (random == null) {
            random = new Random();
        }
        loot.add(new Dracmas(random.nextInt(41) + 10)); // Dropa de 10 a 50 Dracmas
        
        Weapon arma = largarArma(heroi.getSorte());
        if (arma != null) {
            loot.add(arma);            
        }
        return loot;
    }
}
