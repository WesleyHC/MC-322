package tarefa1;

import java.util.ArrayList;
import java.util.Random;
import tarefa2.Weapon;

public abstract class Monster extends Character {
    //Atributos
    private int xpConcedido;
    private ArrayList<Weapon> armasComuns;
    private ArrayList<Weapon> armasRaras;

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

    public void addArmaComum(Weapon arma) {
        this.armasComuns.add(arma);
    }

    public void addArmaRara(Weapon arma) {
        arma.setDano(arma.getDano()*2);
        this.armasRaras.add(arma);
    }
    
    public Weapon largarArma(float luck) { //dropa uma weapon aleatoria
        Random random = new Random();
        float rare = new Random().nextFloat();
        if (rare<=luck){
            System.out.println("A arma apresenta um poder maior do que o normal! Dizem que a arma corresponde a grandiosidade do guerreiro!");
            int arma = random.nextInt(armasRaras.size());
            return armasRaras.get(arma);
        } else {
            System.out.println("Foi deixada pelos restos moribundos da criatura uma arma comum");
            int arma = random.nextInt(armasComuns.size());
            return armasComuns.get(arma);
    }
}
}