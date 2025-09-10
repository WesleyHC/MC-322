package tarefa1;

import tarefa2.Weapon;

public class Harpy extends Monster {
    //Atributo voar (chance de esquivar)
    private float flight; //0 a 100

    //Construtor
    public Harpy(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, float flight){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.flight = flight;
    }

    //Getters
     public float getFlight(){
        return flight;
    }

    //Métodos
    public void atacar(Character alvo, int valor){
        System.out.println(this.getName() + " ataca!");
        super.atacar(alvo, this.getForca());
    }
    public void receberDano(int dano) {
        if ((100*Math.random()) < flight) {
            System.out.println(this.getName() + " esquiva voando!");
        } else {
            super.receberDano(dano);
        }
    }
}
