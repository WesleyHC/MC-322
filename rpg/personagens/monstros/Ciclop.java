package rpg.personagens.monstros;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlRootElement;

import rpg.cenario.Difficulty;
import rpg.combate.*;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.itens.weapons.Weapon;
import rpg.personagens.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Ciclop extends Monster {
    //Atributo golpe pesado (danoso, porém lento, alternando o ataque entre os turnos)
    private boolean heavystrike;

    //Construtor
    public Ciclop(String name, int pontosDeVida, int forca, Weapon arma, int xpConcedido, Difficulty dificuldade){
        super(name, pontosDeVida, forca, arma, xpConcedido, dificuldade);
        this.heavystrike = true;
    }
    public Ciclop() {
        super();
        adicionarAcao(Actions.GOLPE_PESADO);
        adicionarAcao(Actions.DESCANSAR);
    }

    //Getters
    @XmlElement
     public boolean getHeavystrike(){
        return heavystrike;
    }
    @XmlElement
    @Override
    public int getAtributoEspecial() {
        return 0; //não têm atributo especial
    }


    @Override
    public void setAtributoEspecial(int valor) {
    }

    @XmlElement
    @Override
    public float getSorte() {
        return 0; //sem sorte
    }

    @XmlElement
    @Override
    public int getNivel() {
        return 1;
    }

    //Setters
    public void setHeavystrike(boolean heavystrike){
        this.heavystrike = heavystrike;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
    if (heavystrike) {
        heavystrike = false;
        return Actions.GOLPE_PESADO;
    } else {
        heavystrike = true;
        return Actions.DESCANSAR;
    }
}
}
