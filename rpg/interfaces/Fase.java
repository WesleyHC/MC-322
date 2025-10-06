package rpg.interfaces;

import java.util.ArrayList;

import rpg.cenario.TipoCenario;
import rpg.personagens.Hero;
import rpg.personagens.Monster;

/**
 * Acões iniciais da fase, exibindo descrições e aplicando efeitos de cenário.
 */
public interface Fase {
    /**
     * 
     * @param heroi Herói que está adentrando a fase.
     */
    void iniciar(Hero heroi);
    /**
     * Verifica se a fase foi concluída.
     * @return true se a fase foi concluída, caso contrário, false.
     */
    boolean isDone();
    /**
     * Retorna o tipo de cenário associado a fase.
     * @return TipoCenario da fase.
     */
    TipoCenario getTipoDeCenario();
    /**
     * Retorna a lista de monstros presentes na fase.
     * @return Uma lista de monstros.
     */
    ArrayList<Monster> getMonstros();
    /**
     * Retorna a lista de eventos que possivelmente podem ocorrer na fase.
     * @return Uma lista de eventos.
     */
    ArrayList<Evento> getEventos();
}
