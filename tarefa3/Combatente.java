package tarefa3;

public interface Combatente {
    String getName();
    boolean isAlive();
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoDeCombate action(Combatente alvo);
}
