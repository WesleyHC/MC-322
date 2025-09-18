package tarefa3;

import java.util.ArrayList;

import tarefa1.*;

public class FaseDeCombate implements Fase {
    //Atributos
    private int nivel;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDolvl;
    
    //Construtor
    public FaseDeCombate(int nivel, ArrayList<Monster> monstrosDolvl, TipoCenario cenario){
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstrosDolvl = monstrosDolvl;
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
        return this.cenario;
    }

    public ArrayList<Monster> getMonstros() {
        return this.monstrosDolvl;
    }
    
}
