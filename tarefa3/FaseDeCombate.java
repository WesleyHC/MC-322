package tarefa3;

import java.util.ArrayList;

import tarefa1.Hero;
import tarefa1.Monster;

public class FaseDeCombate implements Fase{
    private Hero heroi;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDolvl = new ArrayList<>();
    
    public FaseDeCombate(ArrayList<Monster> monstrosDoLvl, TipoCenario cenario){
        this.cenario = cenario;
    }
    @Override
    public void iniciar(Hero heroi) {
        this.heroi = heroi;
    }

    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDone'");
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoDeCenario'");
    }
    
}
