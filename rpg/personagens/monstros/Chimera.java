package rpg.personagens.monstros;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.cenario.Difficulty;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;


public class Chimera extends Monster {
    //Atributo intimidador (dano do inimigo reduzido)
    private int intimidate;
    private boolean intimidate_msg;

    //Construtor
    public Chimera(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, int intimidate, Difficulty dificuldade){
        super(name, pontosDeVida, forca, arma, xpConcedido, dificuldade);
        this.intimidate = intimidate;
        this.intimidate_msg = true;
    }
    public Chimera() {
        super();
    }

    //Getters
    @XmlElement
    public int getIntimidate(){
        return intimidate;
    }

    //Métodos
    public int receberDano(int dano){
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
        return damage;
    }
}
