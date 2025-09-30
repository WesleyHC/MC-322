package rpg.interfaces;

import java.util.ArrayList;

import rpg.cenario.TipoCenario;
import rpg.personagens.Hero;
import rpg.personagens.Monster;

public interface Fase {
    void iniciar(Hero heroi);
    boolean isDone();
    TipoCenario getTipoDeCenario();
    ArrayList<Monster> getMonstros();
    ArrayList<Evento> getEventos();
}
