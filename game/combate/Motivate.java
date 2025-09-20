package game.combate;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;
import game.personagens.herois.Demigod;

public class Motivate implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) {
        Demigod User = (Demigod)user;
        int motivation = 2;

        System.out.println(User.getName() + " se sente determinado a cumprir seu dever!");

        User.receberCura(motivation*5);
        User.receberForca(motivation);
    }
    
}
