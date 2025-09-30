package rpg.combate;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.herois.Satyr;

public class BioAtk implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) throws RecursoException {
        Satyr User = (Satyr)user;
        if (User.getBiomance()<10){
           throw new RecursoException(User.getName() + " teve problemas para se associar com os espíritos naturais do ambiente!");
        }
        User.setBiomance(-1);
        int dano = User.getForca() + User.getBiomance() + User.getArma().getDano();
        System.out.println(User.getName() + " usa sua conexão com a natureza para atacar e causa " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
    
}
