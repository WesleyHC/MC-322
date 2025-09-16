package tarefa1;

import tarefa2.Weapon;
import tarefa3.AcaoDeCombate;
import tarefa3.BasicAtk;
import tarefa3.Combatente;

public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, float flight){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.flight = flight;
        adicionarAcao(new BasicAtk());
    }

    //Getters
     public float getFlight(){
        return flight;
    }

    //Métodos

    public void receberDano(int dano) {
        if ((100*Math.random()) < this.flight) {
            System.out.println(this.getName() + " voa agilmente e ESQUIVA do ataque!");
        } else {
            System.out.println("O ataque ACERTA " + this.getName() + "!");
            super.receberDano(dano);
        }
    }

}
