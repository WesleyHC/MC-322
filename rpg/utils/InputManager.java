package rpg.utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {
    private static Scanner entrada = new Scanner (System.in);

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

            if ((input.equals("s")) && (input.equals("n"))){
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

    public static void fecharScanner(){
        entrada.close();
    }

}