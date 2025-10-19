package com.rpglab.test.combate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import rpg.combate.FuriaDivina;
import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.itens.weapons.Sword;
import rpg.personagens.Monster;
import rpg.personagens.herois.Demigod;
import rpg.personagens.monstros.Ciclop;

public class AcaoCombateTest {

    @Test
    public void testFuriaDivinaExcecao() {
        Demigod heroiFraco = new Demigod("Herói Fraco", 100, 10, 1, 0, new Sword(), 50, 0.5f, 2);

        //Monstro alvo
        Monster alvo = new Ciclop("Alvo", 100, 10, new Sword(), 50);
        AcaoDeCombate furiaDivina = new FuriaDivina();

        RecursoException exception = assertThrows(RecursoException.class, () -> {
            furiaDivina.executar(heroiFraco, alvo);
        });

        assertTrue(exception.getMessage().contains("não teve conexão suficiente"));
    }
}