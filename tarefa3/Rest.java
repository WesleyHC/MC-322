package tarefa3;

public class Rest implements AcaoDeCombate{

    @Override
    public void executar(Combatente user, Combatente alvo) {
        int descanso = (user.getPontosDeVida())/5;
        
        System.out.println(user.getName() + " descansou por um breve instante!");
        user.receberCura(descanso);
    }
    
}
