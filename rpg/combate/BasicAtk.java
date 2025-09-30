package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

public class BasicAtk implements AcaoDeCombate{
    @Override
    public void executar(Combatente user, Combatente alvo) {
        rpg.personagens.Character User = (rpg.personagens.Character)user;
        int dano = User.getForca() + User.getArma().getDano();
        
        System.out.println(User.getName() + " ataca, causando " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
}