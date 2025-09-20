package game.combate;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;
import game.personagens.herois.Satyr;

public class BioAtk implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) {
        Satyr User = (Satyr)user;
        int dano = User.getForca() + User.getBiomance() + User.getArma().getDano();
        System.out.println(User.getName() + " usa sua conexão com a natureza para atacar e causa " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
    
}
