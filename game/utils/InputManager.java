package game.utils;

import java.util.Scanner;

public class InputManager {
    private static Scanner entrada = new Scanner (System.in);

    public static int lerInteiro(String mensagem, int min, int max){
        boolean verify = true;
        while (verify){
        System.out.println(mensagem);
        }
        return 16;
    }
    public static String lerString(String mensagem){
        return "salve";
    }

    public static boolean lerSimNao(String mensagem){
        return true;
    }

    public static void esperarEnter(String mensagem){

    };

    public static void fecharScanner(){

    }

    }