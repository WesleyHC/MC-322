package rpgtest.personagens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.itens.weapons.*;
import rpg.personagens.Hero;
import rpg.personagens.Monster;
import rpg.personagens.herois.Demigod;
import rpg.personagens.monstros.Ciclop;
import rpg.exceptions.LvlEquiparException;
import rpg.exceptions.RecursoException;
import rpg.cenario.Difficulty;

public class HeroTEST {

    @Test
    public void testCombatente() {
        Hero heroi = new Demigod("Herói de Teste", 100, 10, 1, 0, new Sword(), 50, 0.5f, 10);
        assertTrue(heroi instanceof Combatente, "Um Herói deve ser um Combatente.");
    }

    @Test
    public void testRecebeDano() {
        Hero heroi = new Demigod("Herói de Teste", 100, 10, 1, 0, new Sword(), 50, 0.5f, 10);
        int vidaInicial = heroi.getPontosDeVida();
        int danoSofrido = 30;

        heroi.receberDano(danoSofrido);

        assertEquals(vidaInicial - danoSofrido, heroi.getPontosDeVida(), "A vida do herói deveria ter diminuído em 30.");
    }

    @Test
    public void testAtacar() throws RecursoException {
        Hero heroi = new Demigod("Herói Atacante", 100, 10, 1, 0, new Sword(), 50, 0.5f, 10);
        Monster monstro = new Ciclop("Alvo de Teste", 100, 10, new Club(), 50, Difficulty.MEDIO);
        int vidaInicialDoMonstro = monstro.getPontosDeVida();
        
        AcaoDeCombate Ataque = heroi.getAcoes().get(0);
        Ataque.executar(heroi, monstro);
        
        assertTrue(monstro.getPontosDeVida() < vidaInicialDoMonstro, "O ataque do herói deveria ter causado dano no monstro.");
    }

    @Test
    public void testExcecaoEquiparArma() {
        Hero heroi = new Demigod("Herói Fraco", 100, 10, 1, 0, new Sword(), 50, 0.5f, 10); 
        Weapon armaForte = new Club();
        LvlEquiparException exception = assertThrows(LvlEquiparException.class, () -> {
        heroi.equipar(armaForte);
        });

        assertEquals("O herói não foi forte o suficiente. Requer nível 3", exception.getMessage());
    }
}