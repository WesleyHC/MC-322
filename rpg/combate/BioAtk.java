package rpg.combate;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.herois.Satyr;

/**
 * Ataque do Sátiro, utiliza sua Biomance (afinidade com a natureza).
 */
public class BioAtk implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) throws RecursoException {
        if (!(user instanceof Satyr)) {
            throw new RecursoException("Ação exclusiva do Sátiro!");
        }
        Satyr User = (Satyr)user;
        if (User.getBiomance()<10){
           throw new RecursoException(User.getName() + " teve problemas para se associar com os espíritos naturais do ambiente!");
        }
        int dano = User.getForca() + User.getBiomance() + User.getArma().getDano();
        User.setBiomance(-1);
        System.out.println(User.getName() + " usa sua conexão com a natureza para atacar e causa " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
    
}
