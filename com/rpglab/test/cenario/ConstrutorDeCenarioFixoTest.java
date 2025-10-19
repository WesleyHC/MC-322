package com.rpglab.test.cenario;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import rpg.cenario.ConstrutorDeCenarioFixo;
import rpg.cenario.Difficulty;
import rpg.interfaces.Fase;
import rpg.personagens.Monster;

public class ConstrutorDeCenarioFixoTest {

    @Test
    public void testDificuldade() {
        
        ConstrutorDeCenarioFixo gerador = new ConstrutorDeCenarioFixo();

        //Faceis
        ArrayList<Fase> fasesFaceis = gerador.gerar(1, Difficulty.FACIL);
        Monster monstroFacil = fasesFaceis.get(0).getMonstros().get(0);
        
        //Dificeis
        ArrayList<Fase> fasesDificeis = gerador.gerar(1, Difficulty.DIFICL);
        Monster monstroDificil = fasesDificeis.get(0).getMonstros().get(0);

        assertNotNull(monstroFacil);
        assertNotNull(monstroDificil);

        //Prints
        System.out.println("======| TESTE DE DIFICULDADE |======");
        System.out.println("Vida Monstro (Fácil): " + monstroFacil.getPontosDeVida());
        System.out.println("Vida Monstro (Difícil): " + monstroDificil.getPontosDeVida());
        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(), 
                   "O monstro difícil deveria ter mais vida que o fácil.");
        
        System.out.println("Força Monstro (Fácil): " + monstroFacil.getForca());
        System.out.println("Força Monstro (Difícil): " + monstroDificil.getForca());
        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(), 
                  "O monstro difícil deveria ter mais força que o fácil.");
    }
}