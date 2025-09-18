package tarefa2;

import tarefa1.*;
import tarefa3.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GeradorDeFases geradordefases = new ConstrutorDeCenarioFixo();
        ArrayList<Fase> fases = geradordefases.gerar(3);
        Sword Espada = new Sword();
        Hero hero = new Demigod("Perseus", 250, 18, 1, 0, Espada, 100, 0.25f , 10);
        
        //Mensagem de Introdução
        System.out.println(hero.getName() + " é um herói habilidoso(a), mas sente que seus feitos passam despercebidos pelos Deuses.");
        System.out.println("Para chamar a atenção deles, o herói precisa de um feito que ninguém mais teve a coragem de tentar: recuperar a Caixa de Pandora.");
        System.out.println("Sua busca lhe trouxe até a entrada deste lugar. Segundo as lendas, a Caixa está guardada aqui dentro. É a chance de finalmente ser notado(a).");

        //Exibição de Status Inicial
        hero.exibirStatus();

        for (Fase fase : fases) { //For Fases
                fase.iniciar(hero);
                ArrayList<Monster> monstrosdolvl = fase.getMonstros();
                
                for (Monster monstro : monstrosdolvl) { //For monstros
                    System.out.println(hero.getName() + " se depara com um temível oponente: " + monstro.getName());
                    int turno = 1;
                    
                    while (monstro.isAlive() && hero.isAlive()) {
                        System.out.println("\n=================|TURNO " + turno + "|===================");

                        AcaoDeCombate heroiAcao = hero.escolherAcao(monstro);
                        heroiAcao.executar(hero, monstro);

                        //Verificação se o Monstro morreu
                        if (monstro.isAlive()) {
                            AcaoDeCombate monstroAcao = monstro.escolherAcao(hero);
                            monstroAcao.executar(monstro, hero);
                        }
                        hero.exibirStatus();
                        monstro.exibirStatus();
                        System.out.println("==============|FIM DO TURNO " + turno + "|===============");
                        turno += 1;
                    }

                    if (!hero.isAlive()) { //Verificação se o heroi morreu
                        System.out.println("\n" + hero.getName() + " é derrotado(a)!\n\nPara os Deuses não há espaço para a fraqueza.");
                        System.out.println("O Olimpo vira o rosto, e o nome de " + hero.getName() + " se perde no esquecimento.");
                        System.out.println(hero.getName() + " foi considerado(a) indigno(a)!");
                        System.out.println("\n================|GAME OVER|===================");
                        System.exit(1); 
                    } else {
                        System.out.println("\n" + monstro.getName() + " é derrotado(a)");
                        hero.ganharExperiencia(monstro.getXpConcedido());

                        //loots
                        ArrayList<Item> loot = monstro.droparLoot(hero);
                        for (Item item : loot) {
                            if (item instanceof Dracmas) {
                                hero.setDracmas(((Dracmas)item).getQuantity());
                            } else if (item instanceof Weapon) {
                                System.out.println(hero.getName() + " obteve: " + item.getName());
                                hero.equipar((Weapon) item);
                            }
                        }
                    }
                }

                if (hero.isAlive()) { //fase clear
                    System.out.println("\n" + hero.getName() + " limpou todos os inimigos de " + fase.getTipoDeCenario().getName() + "! O caminho está livre.");
                }
        }
        
        //Mensagem final (vitoria)
        System.out.println("\nO silêncio na arena é quebrado por um trovão distante: o aplauso do Olimpo.");
        System.out.println("Com a Caixa de Pandora em mãos, " + hero.getName() + " se provou digno(a) da atenção dos Deuses!");
        System.out.println("\n=================|VITÓRIA|===================");

    }
}