package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Ação motivadora do Semideus (Demigod).
 * Cura, aumenta a força e a afinidade divina do usuário.
 */
public class Motivate implements AcaoDeCombate {
    @Override
    public void executar(Combatente user, Combatente alvo) {
        int motivation = 2;

        System.out.println(user.getName() + " se sente determinado a cumprir seu dever!");

        user.receberCura(motivation*5);
        user.receberForca(motivation);
        user.setAtributoEspecial(motivation*2);
    }
    
}
