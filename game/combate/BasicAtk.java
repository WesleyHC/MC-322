package game.combate;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;

public class BasicAtk implements AcaoDeCombate{
    @Override
    public void executar(Combatente user, Combatente alvo) {
        game.personagens.Character User = (game.personagens.Character)user;
        int dano = User.getForca() + User.getArma().getDano();
        
        System.out.println(User.getName() + " ataca, causando " + dano + " de dano em " + alvo.getName());
        alvo.receberDano(dano);
    }
}