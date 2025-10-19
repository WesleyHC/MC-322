package com.rpglab.test.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import rpg.utils.InputManager;

/**
 * Classe de testes para a classe InputManager.
 * Simula a entrada do usuário e captura a saída, permitindo testes.
 */
public class InputManagerTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Restaura os streams de entrada e saída do sistema após cada teste.
     */
    @AfterEach
    void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalOut);
    }

    /**
     * Prepara e simula a entrada de dados do usuário.
     * @param data A String que representa os dados que seriam digitados pelo usuário.
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);

        InputManager.reabrirScanner();
    }

    /**
     * Testa o método lerInteiro com uma entrada válida.
     */
    @Test
    public void testLerInteiro_ValidInput() {
        provideInput("5\n"); //"5", Enter
        int resultado = InputManager.lerInteiro("Digite um numero", 1, 10);
        assertEquals(5, resultado);
    }

    /**
     * Testa o método lerInteiro com uma entrada inválida (texto) seguida por uma válida.
     */
    @Test
    public void testLerInteiro_InvalidInput_nao_inteiro() {
        System.setOut(new PrintStream(outContent));
        provideInput("palavras\n7\n"); //"palavras", Enter, "7", Enter

        int resultado = InputManager.lerInteiro("Digite um número", 1, 10);
        assertEquals(7, resultado);

        String saida = outContent.toString();
        assertTrue(saida.contains("Valor invalido. Digite um numero inteiro."));
    }

    /**
     * Testa o método lerString com uma entrada de texto.
     */
    @Test
    public void testLerString_ValidInput() {
        String entradaSimulada = "Nome do Herói\n";
        provideInput(entradaSimulada); //"Nome do Herói" e Enter
        String resultado = InputManager.lerString("Digite um nome: ");
        assertEquals("Nome do Herói", resultado, "O método deveria retornar o texto digitado.");
    }

    /**
     * Testa o método lerString quando o usuário primeiro digita uma entrada vazia (apenas Enter), depois o texto.
     */
    @Test
    public void testLerString_EmptyInputThenValid() {
        String entradaSimulada = "\nTexto Válido\n"; //Enter, "Texot Válido", Enter
        provideInput(entradaSimulada);
        String resultado = InputManager.lerString("Digite algo: ");
        assertEquals("Texto Válido", resultado, "O método deveria ignorar a primeira entrada vazia.");
    }

    /**
     * Testa o método lerSimNao com uma entrada válida para sim ('S').
     */
    @Test
    public void testLerSimNao_ValidInputSim() {
        provideInput("S\n"); //'S' maiúsculo
        boolean resultado = InputManager.lerSimNao("Deseja continuar? ");
        assertTrue(resultado, "A entrada 'S' deveria retornar true.");
    }

    /**
     * Testa o método lerSimNao com uma entrada inválida seguida por uma válida para não ('n').
     */
    @Test
    public void testLerSimNao_InvalidInputThenNao() {
        String entradaSimulada = "talvez\nn\n"; //"talvez", Enter, "n", Enter
        provideInput(entradaSimulada);
        boolean resultado = InputManager.lerSimNao("Deseja atacar? ");
        assertFalse(resultado, "Deveria ignorar 'talvez' e retornar false para a entrada 'n'.");
    }
}