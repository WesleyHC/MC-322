package rpg.interfaces;

import java.util.ArrayList;

import rpg.cenario.Difficulty;

/**
 * Define o comportamento das classes responsáveis por criar a sequência de fases da campanha.
 */
public interface GeradorDeFases {
    /**
     * Gera uma lista de fases que serão jogadas.
     * @param nFases O número de fases que serão geradas.
     * @param dificuldade A dificuldade das fases que serão geradas.
     * @return Uma lista de objetos que implementam Fase.
     */
    public ArrayList<Fase> gerar(int nFases, Difficulty dificuldade);
}
