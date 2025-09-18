package tarefa3;

import java.util.ArrayList;

import tarefa1.*;

public interface Fase {
    void iniciar(Hero heroi);
    boolean isDone();
    TipoCenario getTipoDeCenario();
    ArrayList<Monster> getMonstros();
}
