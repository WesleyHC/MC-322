package tarefa1;

import tarefa2.Weapon;
import tarefa3.BasicAtk;

public class Chimera extends Monster {
    //Atributo intimidador (dano do inimigo reduzido)
    private int intimidate;
    private boolean intimidate_msg;

    //Construtor
    public Chimera(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, int intimidate){
        super(name, pontosDeVida, forca, arma, xpConcedido);
        this.intimidate = intimidate;
        this.intimidate_msg = true;
        adicionarAcao(new BasicAtk());
    }

    //Getters
    public int getIntimidate(){
        return intimidate;
    }

    //Métodos
    public void receberDano(int dano){
        if (intimidate_msg) {
            System.out.println("O herói está intimidado por " + this.getName() + ", enfraquecendo seu ataque!");
            intimidate_msg = false;
        }
        int damage = dano - this.intimidate;
        if (damage < 0) {
            damage = 0; //Para não curar caso fique negativo
        }
        System.out.println(this.getName() + " resiste ao golpe e sofre apenas " + damage + " de dano.");
        super.receberDano(damage);
    }

    @Override
    public String droparLoot() {
        
    }

}
