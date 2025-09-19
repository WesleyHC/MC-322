package tarefa3;

import java.util.ArrayList;

import tarefa1.*;

public class FaseDeCombate implements Fase {
    //Atributos
    private int nivel;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDolvl;
    private ArrayList<Evento> eventos;
    
    //Construtor
    public FaseDeCombate(int nivel, ArrayList<Monster> monstrosDolvl, TipoCenario cenario, ArrayList<Evento> eventos){
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstrosDolvl = monstrosDolvl;
        this.eventos = eventos;
    }

    @Override
    public void iniciar(Hero heroi) {
        System.out.println(this.cenario.getDescricao());
        System.out.println("\n=================|" + this.cenario.getName() + "|===================");
        this.cenario.Effect(heroi);
    }

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
    public int getNivel(){
        return nivel;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }

    public ArrayList<Monster> getMonstros() {
        return monstrosDolvl;
    }
    
    public ArrayList<Evento> getEventos(){
        return eventos;
    }
}
