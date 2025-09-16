package tarefa3;

import tarefa1.Hero;

public interface Fase {
    public void iniciar(Hero heroi);
    public boolean isDone();
    public String getAmbiente();
}
