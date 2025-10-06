package rpgtest.cenario;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import rpg.cenario.ConstrutorDeCenarioFixo;
import rpg.cenario.Difficulty;
import rpg.interfaces.Fase;
import rpg.personagens.Monster;

public class ConstrutorDeCenarioFixoTEST {

    @Test
    public void testDificuldade() {
        
        ConstrutorDeCenarioFixo gerador = new ConstrutorDeCenarioFixo();

        ArrayList<Fase> fasesFaceis = gerador.gerar(1, Difficulty.FACIL);
        Monster monstroFacil = fasesFaceis.get(0).getMonstros().get(0);
        
        ArrayList<Fase> fasesDificeis = gerador.gerar(1, Difficulty.DIFICL);
        Monster monstroDificil = fasesDificeis.get(0).getMonstros().get(0);

        assertNotNull(monstroFacil);
        assertNotNull(monstroDificil);

        System.out.println("TESTE DE DIFICULDADE:");
        System.out.println("Vida do Monstro (Fácil): " + monstroFacil.getPontosDeVida());
        System.out.println("Vida do Monstro (Difícil): " + monstroDificil.getPontosDeVida());
        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(), 
                   "A vida do monstro no modo Difícil deveria ser maior que no Fácil.");
        
        System.out.println("Força do Monstro (Fácil): " + monstroFacil.getForca());
        System.out.println("Força do Monstro (Difícil): " + monstroDificil.getForca());
        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(), 
                   "A força do monstro no modo Difícil deveria ser maior que no Fácil.");
    }
}