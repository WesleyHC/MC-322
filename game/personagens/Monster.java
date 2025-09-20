package game.personagens;

import java.util.ArrayList;
import java.util.Random;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;
import game.interfaces.Item;
import game.interfaces.Lootable;
import game.itens.weapons.Weapon;

public abstract class Monster extends Character implements Lootable{
    //Atributos
    private int xpConcedido;
    private ArrayList<Weapon> armasComuns;
    private ArrayList<Weapon> armasRaras;
    private Random random = new Random();

    //Construtor
    public Monster(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido) {
        super(name, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.armasComuns = new ArrayList<>();
        this.armasRaras = new ArrayList<>();
    }

    //Getters
    public int getXpConcedido(){
        return xpConcedido;
    }


    //Métodos
    public void exibirStatus(){
        super.exibirStatus();
        if (this.getPontosDeVida() == 0) {
            System.out.println("XP Concedido: " + xpConcedido);
        }
    }

    public void addArmaComum(Weapon arma, int mult) {
        arma.mult_dano(mult);
        this.armasComuns.add(arma);
    }

    public void addArmaRara(Weapon arma, int mult) {
        arma.mult_dano(mult);
        this.armasRaras.add(arma);
    }
    
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
    public AcaoDeCombate escolherAcao(Combatente alvo) {
         return acoes.get(random.nextInt(acoes.size()));
    }

    public abstract ArrayList<Item> droparLoot(Hero heroi);
}
