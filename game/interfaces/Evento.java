package game.interfaces;

import game.personagens.Hero;

public interface Evento {
    boolean Trigger();
    void start(Hero heroi);
}
