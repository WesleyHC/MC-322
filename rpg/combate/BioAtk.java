package rpg.combate;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Ataque do Sátiro, utiliza sua Biomance (afinidade com a natureza).
 */
public class BioAtk implements AcaoDeCombate{
    @Override
    public void executar(Combatente user, Combatente alvo) throws RecursoException {
        if (user.getAtributoEspecial()<10){
           throw new RecursoException(user.getName() + " teve problemas para se associar com os espíritos naturais do ambiente!");
        }
        int dano = user.getForca() + user.getAtributoEspecial() + user.getArma().getDano();
        user.setAtributoEspecial(-1);
        System.out.println(user.getName() + " usa sua conexão com a natureza para atacar e causa " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
    
}
