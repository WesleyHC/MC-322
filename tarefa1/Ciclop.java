package tarefa1;

import tarefa2.Weapon;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.heavystrike = true;
    }

    //Getters
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Métodos
    public void atacar(Character alvo, int forca) {
        if (this.heavystrike) {
            alvo.receberDano(this.getForca()*2);
            this.heavystrike = false;
            System.out.println(this.getName() + " executa um ataque poderoso");
        } else {
            alvo.receberDano(this.getForca()*0);
            System.out.println(this.getName() + " está fatigado!");
            this.heavystrike = true;
        }
    }
}
