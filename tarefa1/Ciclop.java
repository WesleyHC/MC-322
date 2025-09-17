package tarefa1;

import java.util.Random;

import tarefa2.Weapon;
import tarefa3.BasicAtk;
import tarefa3.Item;
import tarefa3.Rest;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.heavystrike = true;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Rest());
    }

    //Getters
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Métodos
    public void atacar(Character alvo) {
        int dano;
        if (this.heavystrike) {
            dano = this.getForca()*2;
            System.out.println(this.getName() +" executa um GOLPE PESADO!");
            System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
            this.heavystrike = false;
        } else {
            dano = 0;
            System.out.println(this.getName() + " está fatigado do último golpe e não consegue atacar.");
            this.heavystrike = true;
        }
        alvo.receberDano(dano);
    }

    @Override
    public Item droparLoot(Hero heroi) {
        Random random = new Random();
        Item drops = largarArma(heroi.getSorte());

        int money = random.nextInt(50);
        heroi.setDracmas(money);


        return drops;
    }
}
