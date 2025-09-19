package tarefa3;

public interface Combatente {
    String getName();
    boolean isAlive();
    int getPontosDeVida();
    int receberDano(int dano);
    void receberForca(int forca);
    void receberCura(int cura);
    AcaoDeCombate escolherAcao(Combatente alvo);
}
