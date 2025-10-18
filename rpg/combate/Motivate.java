package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.herois.Demigod;

/**
 * Ação motivadora do Semideus (Demigod).
 * Cura, aumenta a força e a afinidade divina do usuário.
 */
public class Motivate implements AcaoDeCombate{
    /**
     * Executa a ação de motivação.
     * Verifica se o usuário é um Semideus e aplica um bônus de cura, força e Afinidade Divina.
     * @param user O Combatente (usuário) que vai ser motivado.
     * @param alvo O oponente no combate (ignorado).
     */
    public void executar(Combatente user, Combatente alvo) {
        Demigod User = (Demigod)user;
        int motivation = 2;

        System.out.println(User.getName() + " se sente determinado a cumprir seu dever!");

        User.receberCura(motivation*5);
        User.receberForca(motivation);
        User.setDivineAfinity(motivation*2);
    }
    
}
