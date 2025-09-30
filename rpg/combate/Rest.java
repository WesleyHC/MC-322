package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

public class Rest implements AcaoDeCombate{

    @Override
    public void executar(Combatente user, Combatente alvo) {
        int descanso = (user.getPontosDeVida())/10;
        
        System.out.println(user.getName() + " descansou por um breve instante!");
        user.receberCura(descanso);
    }
    
}
