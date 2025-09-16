package tarefa3;

public interface Combatente {
    public String getName();
    public boolean isAlive();
    public void receberDano(int dano);
    public void receberCura(int cura);
    public AcaoDeCombate escolherAcao(Combatente alvo);
}
