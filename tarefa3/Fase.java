package tarefa3;

import java.util.ArrayList;

import tarefa1.Hero;
import tarefa1.Monster;

public interface Fase {
    void iniciar(Hero heroi);
    boolean isDone(int kills, ArrayList<Monster> TotalMonstros);
    TipoCenario getTipoDeCenario();
}
