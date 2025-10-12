package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Ataque básico que pode ser usado por qualquer personagem.
 * O dano é calculado com base na força do usuário e no dano de sua arma.
 */
public class BasicAtk implements AcaoDeCombate{
    /**
     * Executa o ataque básico.
     * @param user O Combatente que está realizando o ataque.
     * @param alvo O Combatente que está recebendo o ataque.
     */
    @Override
    public void executar(Combatente user, Combatente alvo) {
        rpg.personagens.Character User = (rpg.personagens.Character)user;
        int dano = User.getForca() + User.getArma().getDano();
        
        System.out.println(User.getName() + " ataca, causando " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
}