package game.interfaces;

import java.util.ArrayList;

import game.cenario.TipoCenario;
import game.personagens.Hero;
import game.personagens.Monster;

public interface Fase {
    void iniciar(Hero heroi);
    boolean isDone();
    TipoCenario getTipoDeCenario();
    ArrayList<Monster> getMonstros();
    ArrayList<Evento> getEventos();
}
