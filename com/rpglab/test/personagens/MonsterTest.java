package com.rpglab.test.personagens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.interfaces.Lootable;
import rpg.itens.weapons.*;
import rpg.personagens.Hero;
import rpg.personagens.Monster;
import rpg.personagens.herois.Demigod;
import rpg.personagens.monstros.Ciclop;

public class MonsterTest {

    @Test
    //Teste interface combatnete
    public void testInterfaces() {
        Monster monstro = new Ciclop("Monstro Teste", 100, 10, new Club(), 50);
        assertTrue(monstro instanceof Combatente, "Um Monstro deve ser um Combatente.");
        assertTrue(monstro instanceof Lootable, "Um Monstro deve ser Lootavel.");
    }

    @Test
    public void testReceberDano() {
        Monster monstro = new Ciclop("Monstro Teste", 100, 10, new Club(), 50);
        int vidaInicial = monstro.getPontosDeVida();
        int danoSofrido = 45;

        monstro.receberDano(danoSofrido);

        assertEquals(vidaInicial - danoSofrido, monstro.getPontosDeVida(), "A vida do monstro deveria ter diminuído em 45.");
    }
    @Test
    public void testAtacar() throws RecursoException {
        Hero heroi = new Demigod("Alvo Teste", 100, 10, 1, 0, new Sword(), 50, 0.5f, 10);
        Monster monstro = new Ciclop("Monstro Atacante", 100, 10, new Club(), 50);
        int vidaInicialDoHeroi = heroi.getPontosDeVida();
        
        AcaoDeCombate Ataque = monstro.getAcoes().get(0);
        Ataque.executar(monstro, heroi);
        
        assertTrue(heroi.getPontosDeVida() < vidaInicialDoHeroi, "O ataque do monstro deveria ter causado dano no herói.");
    }
}