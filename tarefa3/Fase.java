package tarefa3;

import tarefa1.Hero;

public interface Fase {
    void iniciar(Hero heroi);
    boolean isDone();
    TipoCenario getTipoDeCenario();
}
