package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Representa a ação de descansar. O usuário recupera uma pequena porção de seus pontos de vida.
 */
public class Rest implements AcaoDeCombate{

    /**
     * Executa a ação de descanso, curando o usuário em 10% de sua vida atual.
     * O parâmetro 'alvo' é ignorado nesta ação.
     * @param user O Combatente que vai descansar e se curar.
     * @param alvo O oponente no combate (ignorado).
     */
    @Override
    public void executar(Combatente user, Combatente alvo) {
        int descanso = (user.getPontosDeVida())/10;
        
        System.out.println(user.getName() + " descansou por um breve instante!");
        user.receberCura(descanso);
    }
    
}
