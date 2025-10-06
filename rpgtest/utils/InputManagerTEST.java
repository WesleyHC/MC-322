package rpgtest.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;

import rpg.utils.InputManager;

public class InputManagerTEST {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @AfterEach
    void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testLerInteiro_ValidInput() {
        provideInput("5\n");

        int resultado = InputManager.lerInteiro("Digite um numero", 1, 10);
        assertEquals(5, resultado);
    }

    @Test
     public void testLerInteiro_InvalidInput_nao_inteiro() {
        System.setOut(new PrintStream(outContent));

        provideInput("palavras\n");

    RuntimeException exception = assertThrows(RuntimeException.class, () ->
    InputManager.lerInteiro("Digite um numero", 1, 10));

    // Entrada invalida faz com que o InputManager espere nova entrada (nao existe entao da erro)
    assertEquals("Entrada nao disponivel.", exception.getMessage());

    // Verifica se a mensagem de entrada errada foi exibida
    assertEquals("Digite um numero (1 - 10): Valor invalido. Digite um numero inteiro.\n"+
    "Digite um numero (1 - 10): No line found\n", outContent.toString());

    }

    @Test
    public void testLerString_ValidInput() {
        String entradaSimulada = "Nome do Herói\n";
        provideInput(entradaSimulada); // Simula o usuário digitando "Nome do Herói" e apertando Enter

        String resultado = InputManager.lerString("Digite um nome: ");
        
        assertEquals("Nome do Herói", resultado, "O método deveria retornar o texto digitado.");
    }

    @Test
    public void testLerString_EmptyInput() {
        String entradaSimulada = "\nTexto Válido\n"; // Simula um Enter, depois um texto
        provideInput(entradaSimulada);

        String resultado = InputManager.lerString("Digite algo: ");
        
        assertEquals("Texto Válido", resultado, "O método deveria ignorar a primeira entrada vazia.");
    }

    @Test
    public void testLerSimNao_ValidInput_Sim() {
        provideInput("S\n"); // Simula o usuário digitando 'S' maiúsculo

        boolean resultado = InputManager.lerSimNao("Deseja continuar? ");
        
        assertTrue(resultado, "A entrada 'S' deveria retornar true.");
    }

   
    @Test
    public void testLerSimNao_InvalidInput() {
        String entradaSimulada = "talvez\nn\n"; // Simula "talvez", Enter, "n", Enter
        provideInput(entradaSimulada);

        boolean resultado = InputManager.lerSimNao("Deseja atacar? ");
        
        assertFalse(resultado, "Deveria ignorar 'talvez' e retornar false para a entrada 'n'.");
    }
}

