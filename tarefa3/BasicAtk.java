package tarefa3;

public class BasicAtk implements AcaoDeCombate{
    @Override
    public void executar(Combatente user, Combatente alvo) {
        tarefa1.Character User = (tarefa1.Character)user;
        int dano = User.getForca() + User.getArma().getDano();
        
        System.out.println(User.getName() + " ataca!");
        alvo.receberDano(dano);
    }
}