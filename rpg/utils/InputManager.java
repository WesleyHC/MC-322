package rpg.utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Uma classe de utilidade para gerenciar e validar a entrada de dados do usuário.
 * Fornece métodos para ler diferentes tipos de dados.
 */
public class InputManager {
    private static Scanner entrada = new Scanner(System.in);


    /**
     * Lê um número inteiro do usuário, garantindo que ele esteja dentro de um intervalo.
     * Repete a solicitação até que uma entrada válida seja fornecida.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @param min O valor mínimo aceitável.
     * @param max O valor máximo aceitável.
     * @return O número inteiro validado.
     */
    public static int lerInteiro(String mensagem, int min, int max){
        while (true) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            String input = null;
        try {
            input = entrada.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Entrada vazia. Digite um numero entre " + min + " e " + max + ".");
                continue;
            }

            int valor = Integer.parseInt(input);
            if (valor < min || valor > max) {
                System.out.println("Fora do intervalo. Digite um numero entre " + min + " e " + max + ".");
                continue;
            }

        return valor;
    } catch (NumberFormatException e) {
        System.out.println("Valor invalido. Digite um numero inteiro.");
    } catch (NoSuchElementException e) {
        throw new RuntimeException("Entrada nao disponivel.", e);
        }
    }
    
    }

    /**
     * Lê uma String não vazia do usuário.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return A String validada.
     */
    public static String lerString(String mensagem){
        while (true){
            System.out.print(mensagem);
            String input = null;
        try {
            input = entrada.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Entrada vazia. Digite uma entrada válida");
                continue;
            }

            return input;
        } catch (NoSuchElementException e) {
        throw new RuntimeException("Entrada nao disponivel.", e);
        }

        }

    }

    /**
     * Lê uma resposta de "sim" ou "não" (s/n) do usuário.
     * @param mensagem A pergunta a ser feita ao usuário.
     * @return true se o usuário digitar 's', false se digitar 'n'.
     */
    public static boolean lerSimNao(String mensagem){
        while (true){
            System.out.print(mensagem + "(s/n)");
            String input = null;
        try {
            input = entrada.nextLine().trim().toLowerCase();
            if (input.isEmpty()) {
                System.out.println("Entrada vazia. Digite uma entrada válida (s/n)");
                continue;
            }

            if (!(input.equals("s")) && !(input.equals("n"))){
                System.out.println("Entrada inválida. Responda com (\"s\") ou (\"n\") ");
            } else {
                if (input.equals("s"))
                    return true;
                if (input.equals("n"))
                    return false;
            }

        } catch (NoSuchElementException e) {
        throw new RuntimeException("Entrada nao disponivel.", e);
        }

        }
    }

    /**
     * Pausa a execução e espera que o usuário pressione a tecla Enter.
     * @param mensagem A mensagem a ser exibida antes de esperar.
     */
    public static void esperarEnter(String mensagem){
        while (true){
            System.out.print(mensagem);
            String input = null;
        try {
            input = entrada.nextLine();
            if (input.isEmpty()) {
                return;
            } else {
                System.out.println("Entrada Inválida. Pressione a tecla \"ENTER\" ");
                continue;
            }
        } catch (NoSuchElementException e) {
        throw new RuntimeException("Entrada nao disponivel.", e);
        }

        }
    }


    /*
        public static void fecharScanner(){
            //entrada.close();
            //entrada = null;
        }
    */


    /**
     * Recria o objeto scanner. Usado para testes para que cada um tenha um stream de entrada limpo.
     */
    public static void reabrirScanner() {
        entrada = new Scanner(System.in);
}

}