package tarefa3;

import tarefa1.Hero;

public class Rest implements AcaoDeCombate{

    @Override
    public void executar(Combatente user, Combatente alvo) {
        Hero User = (Hero)user;
        int descanso = (User.getPontosDeVida())/5;
        
        System.out.println(User.getName() + " descansou por um breve instante! Recuperou " + descanso);
        User.receberCura(descanso);
    }
    
}
