package rpg.interfaces;

import rpg.exceptions.RecursoException;

public interface AcaoDeCombate {
    void executar(Combatente user, Combatente alvo) throws RecursoException;
}
