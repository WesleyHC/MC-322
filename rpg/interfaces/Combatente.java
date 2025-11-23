package rpg.interfaces;
import rpg.itens.weapons.Weapon;

/**
 * Representa qualquer entidade que pode participar de uma batalha, com comportamentos que tanto heróis quanto monstros devem ter.
 */
public interface Combatente {
    /**
     * Retorna o nome do combatente.
     * @return o nome do combatente.
     */
    String getName();
    /**
     * Verifica se o combatente está vivo.
     * @return true se a vida for maior que 0, caso contrário, false.
     */
    boolean isAlive();
    /**
     * Retorna os pontos de vida do combatente.
     * @return os ponto de vida do combatente.
     */
    int getPontosDeVida();
    /**
     * Aplica dano ao combatente, o que reduz seus pontos de vida.
     * @param dano A quantidade de dano que será recebido.
     * @return O dano que foi recebido (que pode ser utilizado para drenar/curar).
     */
    int receberDano(int dano);
    /**
     * Aplica força ao combatente, o que aumenta seu dano.
     * @param forca A quantidade de força que será recebida.
     */
    void receberForca(int forca);
    /**
     * Aplica cura ao combatente, o que regenera seus pontos de vida.
     * @param cura A quantidade de cura que será recebida.
     */
    void receberCura(int cura);

    int getForca();

    int getNivel();

    Weapon getArma();

    float getSorte();

    int getAtributoEspecial();

    void setAtributoEspecial(int valor);
    /**
     * Lógica para a escolha da próxima ação de combate, decidindo qual ação será usada no turno.
     * @param alvo Combatente que será alvo da ação.
     * @return Uma ação que será executada.
     */
    AcaoDeCombate escolherAcao(Combatente alvo);
}
