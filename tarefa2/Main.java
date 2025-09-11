package tarefa2;

import tarefa1.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sword Espada = new Sword();
        Hero hero = new Demigod("Perseus", 100, 7, 1, 0, Espada, 100, 0.4f, 20);
        ArrayList<Level> levels = LevelConstructor.gerarFases(3);
        
        //Mensagem de Introdução
        System.out.println(hero.getName() + " é um herói habilidoso(a), mas sente que seus feitos passam despercebidos pelos Deuses.");
        System.out.println("Para chamar a atenção deles, o herói precisa de um feito que ninguém mais teve a coragem de tentar: recuperar a Caixa de Pandora.");
        System.out.println("Sua busca lhe trouxe até a entrada deste lugar. Segundo as lendas, a Caixa está guardada aqui dentro. É a chance de finalmente ser notado(a).");

        //Exibição de Status Inicial
        hero.exibirStatus();

        for (Level lvl : levels) { //For Monstros
            if (lvl.getNivel() == 1) {
                System.out.println("\n" + lvl.getAmbiente());
                System.out.println("Seu caminho é bloqueado por uma figura ameaçadora. O primeiro guardião se revela...");
            } else if (lvl.getNivel() == 2) {
                System.out.println("\nO caminho agora está livre. " + hero.getName() + " avança para " + lvl.getAmbiente() + ".");
            } else {
                System.out.println("\nA jornada continua para " + lvl.getAmbiente() + "...");
                System.out.println("Das sombras, emerge o desafio final...");
            }
            
            for (Monster monstro : lvl.getMonstros()) {
                System.out.println(hero.getName() + " se depara com um temível oponente: " + monstro.getName());
                int turno = 1;
                while (monstro.getPontosDeVida() > 0 && hero.getPontosDeVida() > 0) {
                    System.out.println("\n=================|TURNO " + turno + "|===================");

                    if (turno % 3 == 0) { // Usa habilidade especial depois de 2 turnos carregando
                        hero.usarHabilidadeEspecial(monstro);
                    } else {
                        hero.atacar(monstro);
                    }

                    //Verificação se o Monstro morreu
                    if (monstro.getPontosDeVida() > 0) {
                        monstro.atacar(hero);
                    }
                    hero.exibirStatus();
                    monstro.exibirStatus();
                    System.out.println("==============|FIM DO TURNO " + turno + "|===============");
                    turno += 1;
                }

                //Verificação se o Herói morreu e mensagem final (Game Over)
                if (hero.getPontosDeVida() == 0){
                        System.out.println("\n" + hero.getName() + " é derrotado(a)!\n\nPara os Deuses não há espaço para a fraqueza.");
                        System.out.println("O Olimpo vira o rosto, e o nome de " + hero.getName() + " se perde no esquecimento.");
                        System.out.println(hero.getName() + " foi considerado(a) indigno(a)!");
                        System.out.println("\n================|GAME OVER|===================");
                        System.exit(1);  
                }

                //Verificação da morte do Monstro e da Experiência concedida
                if (monstro.getPontosDeVida() == 0){
                    System.out.println("\n" + monstro.getName() + " é derrotado(a)");
                    hero.ganharExperiencia(monstro.getXpConcedido());
                }
            }
        }
        //Mensagem final (vitoria)
        System.out.println("\nO silêncio na arena é quebrado por um trovão distante: o aplauso do Olimpo.");
        System.out.println("Com a Caixa de Pandora em mãos, " + hero.getName() + " se provou digno(a) da atenção dos Deuses!");
        System.out.println("\n=================|VITÓRIA|===================");
    
    }
}