package rpg.interfaces;

import java.util.ArrayList;

import rpg.cenario.Difficulty;

public interface GeradorDeFases {
    public ArrayList<Fase> gerar(int nFases, Difficulty dificuldade);
}
