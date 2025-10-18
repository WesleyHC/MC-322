package rpg.personagens;

import java.util.ArrayList;
import java.util.Random;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.interfaces.Item;
import rpg.interfaces.Lootable;
import rpg.itens.weapons.Weapon;

/**
 * Classe abstrata que serve como base para todos os inimigos (monstros) no jogo.
 * Herda de Character e implementa a interface Lootavel, garantindo que todo monstro possa deixar recompensas.
 */
public abstract class Monster extends Character implements Lootable{
    //Atributos
    private int xpConcedido;
    private ArrayList<Weapon> armasComuns;
    private ArrayList<Weapon> armasRaras;
    private Random random = new Random();

    //Construtor
    /**
     * Construtor para criar um novo monstro.
     * @param name Nome do monstro.
     * @param pontosDeVida Pontos de vida inicial do monstro.
     * @param forca Força inicial do monstro.
     * @param arma Arma incial do monstro.
     * @param xpConcedido Experiencia que o monstro concede ao ser derrotado.
     */
    public Monster(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido) {
        super(name, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.armasComuns = new ArrayList<>();
        this.armasRaras = new ArrayList<>();
    }

    //Getters
    /**
     * Retorna a quantidade de experiência concedida após o monstro ser derrotado.
     * @return Quantidade de experiência concedida.
     */
    public int getXpConcedido(){
        return xpConcedido;
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
    public void addArmaComum(Weapon arma, int mult) {
        arma.mult_dano(mult);
        this.armasComuns.add(arma);
    }

    /**
     * Adiciona uma arma à lista de possíveis drops raros deste monstro.
     * @param arma A arma rara a ser adicionada.
     * @param mult O multipliador de dificuldade a ser aplicado no dano da arma.
     */
    public void addArmaRara(Weapon arma, int mult) {
        arma.mult_dano(mult);
        this.armasRaras.add(arma);
    }
    
    /**
     * Método que sorteia uma arma (comum ou rara) com base na sorte do herói.
     * @param luck A sorte do herói, um valor float.
     * @return A arma (Weapon) sorteada, ou null se nenhuma arma for dropada.
     */
    public Weapon largarArma(float luck) { //dropa uma weapon aleatoria
        Random random = new Random();
        float rare = new Random().nextFloat();
        if (rare<=luck && !armasRaras.isEmpty()){
            System.out.println("A arma apresenta um poder maior do que o normal! Dizem que a arma corresponde a grandiosidade do guerreiro!");
            int arma = random.nextInt(armasRaras.size());
            return armasRaras.get(arma);

        } else if (!armasComuns.isEmpty()) {
            System.out.println("Foi deixada pelos restos moribundos da criatura uma arma comum");
            int arma = random.nextInt(armasComuns.size());
            return armasComuns.get(arma);

        } else {
            return null; //não tem arma pra dropar
        }
    }

    /**
     * Implementa a "IA" do monstro, escolhendo uma ação de forma aleatória.
     * @param alvo O alvo da ação.
     * @return A ação de combate que o monstro executará neste turno.
     */
    public AcaoDeCombate escolherAcao(Combatente alvo) {
         return acoes.get(random.nextInt(acoes.size()));
    }

    /**
     * O drop de loot do monstro ao ser derrotado.
     * @param heroi O herói que derrotou o monstro, usado para obter a sorte.
     * @return Uma lista de itens contendo as recompensas.
     */
    public abstract ArrayList<Item> droparLoot(Hero heroi);
}
