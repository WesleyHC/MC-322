package rpg.interfaces;

import rpg.personagens.Hero;

public interface Evento {
    boolean Trigger();
    void start(Hero heroi);
}
