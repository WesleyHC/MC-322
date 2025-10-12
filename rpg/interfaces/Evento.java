package rpg.interfaces;

import rpg.personagens.Hero;

/**
 * Contrato que define qualquer evento surpresa que possa acontecer durante o jogo.
 */
public interface Evento {
    /**
     * Condições necessárias para que o evento ocorra.
     * @return true se o evento deve começar, false caso contrário.
     */
    boolean Trigger();
    /**
     * Lógica do evento.
     * @param heroi O herói que acionou o evento.
     */
    void start(Hero heroi);
}
