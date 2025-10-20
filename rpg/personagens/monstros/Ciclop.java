package rpg.personagens.monstros;

import jakarta.xml.bind.annotation.XmlElement;
import rpg.cenario.Difficulty;
import rpg.combate.*;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, Difficulty dificuldade){
        super(name, pontosDeVida, forca, arma, xpConcedido, dificuldade);
        this.heavystrike = true;
        adicionarAcao(new GolpePesado());
    }
    public Ciclop() {
        super();
    }

    //Getters
    @XmlElement
     public boolean getHeavystrike(){
        return heavystrike;
    }

    //Setters
    public void setHeavystrike(boolean heavystrike){
        this.heavystrike = heavystrike;
    }
}
