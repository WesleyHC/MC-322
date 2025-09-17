package tarefa3;

import tarefa1.*;
import tarefa2.Level;
import tarefa2.Sword;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sword Espada = new Sword();
        Hero hero = new Demigod("Perseus", 420, 7, 1, 0, Espada, 100, 0.35f , 20);
        GeradorDeFases Generator = new ConstrutorDeCenarioFixo();
        ArrayList<Level> levels = ConstrutorDeCenarioFixo.gerarFases(3);
        
        //Mensagem de Introdução
        System.out.println(hero.getName() + " é um herói habilidoso(a), mas sente que seus feitos passam despercebidos pelos Deuses.");
        System.out.println("Para chamar a atenção deles, o herói precisa de um feito que ninguém mais teve a coragem de tentar: recuperar a Caixa de Pandora.");
        System.out.println("Sua busca lhe trouxe até a entrada deste lugar. Segundo as lendas, a Caixa está guardada aqui dentro. É a chance de finalmente ser notado(a).");

        //Exibição de Status Inicial
        hero.exibirStatus();

        for (Level lvl : levels) { //For Monstros
            if (lvl.getNivel() == 1) {
                System.out.println("\n" + lvl.getAmbiente());
                lvl.LevelDescription(lvl.getAmbiente());
                System.out.println("Seu caminho é bloqueado por uma figura ameaçadora. O primeiro guardião se revela...");
            } else if (lvl.getNivel() == 2) {
                System.out.println("\nO caminho agora está livre. " + hero.getName() + " avança para " + lvl.getAmbiente() + ".");
                lvl.LevelDescription(lvl.getAmbiente());
            } else {
                System.out.println("\nA jornada continua para " + lvl.getAmbiente() + "...");
                lvl.LevelDescription(lvl.getAmbiente());
                System.out.println("Das sombras, emerge o desafio final...");
            }
            
            
}