package rpg.cenario;

import java.util.ArrayList;

import rpg.interfaces.*;
import rpg.personagens.*;

/**
 * Implementação concreta de uma Fase do jogo, focada em uma sequência de combates.
 * Esta classe armazena todos os monstros, o cenário e os eventos de um determinado nível.
 */
public class FaseDeCombate implements Fase {
    //Atributos
    private int nivel;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDolvl;
    private ArrayList<Evento> eventos;
    
    //Construtor
    /**
     * Constrói uma nova fase de combate.
     * @param nivel O número do nível desta fase.
     * @param monstrosDolvl A lista de monstros que o herói enfrentará.
     * @param cenario O Enum TipoCenario que define o ambiente e seus efeitos.
     * @param eventos A lista de eventos que podem ocorrer nesta fase.
     */
    public FaseDeCombate(int nivel, ArrayList<Monster> monstrosDolvl, TipoCenario cenario, ArrayList<Evento> eventos){
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstrosDolvl = monstrosDolvl;
        this.eventos = eventos;
    }

     /**
     * Inicia a fase, exibindo a descrição e aplicando os efeitos do cenário sobre o herói.
     * @param heroi O herói que está adentrando na fase.
     */
    @Override
    public void iniciar(Hero heroi) {
        System.out.println(this.cenario.getDescricao());
        System.out.println("\n=================|" + this.cenario.getName() + "|===================");
        this.cenario.Effect(heroi);
    }

    /**
     * Verifica se a fase foi concluída, checando se todos os monstros foram derrotados.
     * @return true se todos os monstros da fase estão mortos, false caso contrário.
     */
    @Override
    public boolean isDone() {
        for (Monster monstro : this.monstrosDolvl) {
            if (monstro.isAlive()) {
                return false;
            }
        }
        return true;
    }

    //Getters
     /**
     * Retorna o número do nível desta fase.
     * @return O nível da fase.
     */
    public int getNivel(){
        return nivel;
    }

    /**
     * Retorna o tipo de cenário (Enum) associado a esta fase.
     * @return O TipoCenario da fase.
     */
    @Override
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }

    /**
     * Retorna a lista de monstros presentes nesta fase.
     * @return Uma lista de Monstros.
     */
    public ArrayList<Monster> getMonstros() {
        return monstrosDolvl;
    }
    
    /**
     * Retorna a lista de eventos que podem ocorrer nesta fase.
     * @return Uma lista de Eventos.
     */
    public ArrayList<Evento> getEventos(){
        return eventos;
    }
}
