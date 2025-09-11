package tarefa1;

import java.util.ArrayList;

import tarefa2.Weapon;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, ArrayList<Weapon> armas){
        super(name, pontosDeVida, forca, arma, xpConcedido, armas);
        this.heavystrike = true;
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
}
