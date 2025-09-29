package rpg.game;

import java.util.ArrayList;

import rpg.cenario.*;
import rpg.exceptions.LvlEquiparException;
import rpg.exceptions.RecursoException;
import rpg.interfaces.*;
import rpg.itens.Dracmas;
import rpg.itens.weapons.*;
import rpg.personagens.*;
import rpg.personagens.herois.Demigod;
import rpg.utils.InputManager;
import rpg.utils.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        Difficulty[] Dificuldades = Difficulty.values();
        GeradorDeFases geradordefases = new ConstrutorDeCenarioFixo();
        int dificuldade = MenuPrincipal.loop();
        if (dificuldade != 5){
        ArrayList<Fase> fases = geradordefases.gerar(3, Dificuldades[dificuldade]);
        Sword Espada = new Sword();
        Hero hero = new Demigod("Perseus", 250, 18, 1, 0, Espada, 100, 0.25f , 9);
        
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
                        try{heroiAcao.executar(hero, monstro);
                        } catch (RecursoException e){
                            System.out.println("A ação falhou:" + e.getMessage());
                        }

                        //Verificação se o Monstro morreu
                        if (monstro.isAlive()) {
                            AcaoDeCombate monstroAcao = monstro.escolherAcao(hero);
                            try{monstroAcao.executar(monstro, hero);
                        } catch (RecursoException e){
                            System.out.println("A ação falhou: " + e.getMessage());
                        }
                    }

                        hero.exibirStatus();
                        monstro.exibirStatus();
                        System.out.println("==============|FIM DO TURNO " + turno + "|===============");
                        turno += 1;
                    }
                    

                    if (!hero.isAlive()) { //Verificação se o heroi morreu
                        // hero.exibirStatus();
                        // monstro.exibirStatus();
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
                        PosCombate(hero, loot);

                        
                        //eventos
                        ArrayList<Evento> eventosDolvl = fase.getEventos();
                        for (Evento evento : eventosDolvl) {
                            if (evento.Trigger()) {
                                evento.start(hero);
                            }
                        }
                    }
                }

                if (hero.isAlive()) { //fase clear
                    System.out.println("\n" + hero.getName() + " limpou todos os inimigos de " + fase.getTipoDeCenario().getName() + "! O caminho está livre.");
                }
        }
        
        //Mensagem final (Vitoria)
        System.out.println("\nO silêncio na arena é quebrado por um trovão distante: o aplauso do Olimpo.");
        System.out.println("Com a Caixa de Pandora em mãos, " + hero.getName() + " se provou digno(a) da atenção dos Deuses!");
        System.out.println("\n=================|VITÓRIA|===================");

        } 
        System.out.println("Finalizando o Jogo");
        System.exit(1);
    }

    private static void PosCombate(Hero hero, ArrayList<Item> loot) {
        boolean continuar = true;
        while (continuar){
            System.out.println("\n=================|PÓS COMBATE|=================");
            System.out.println("[1] Interagir com Loot");
            System.out.println("[2] Informações do Herói");
            System.out.println("[3] Desistir do Jogo");

            int opcao = rpg.utils.InputManager.lerInteiro("Escolha sua ação > ", 1, 3);

            switch (opcao) {
                case 1:
                    if (!loot.isEmpty()){ 
                    for (Item item : new ArrayList<>(loot)) {
                            if (item instanceof Dracmas) {
                                hero.setDracmas(((Dracmas)item).getQuantity());
                            } else if (item instanceof Weapon) {
                                System.out.println(hero.getName() + " obteve: " + item.getName() + " - Dano:" + ((Weapon)(item)).getDano());
                                try {hero.equipar((Weapon) item);
                            } catch (LvlEquiparException e) {
                                System.out.println("Não foi possível equipar: " + e.getMessage());
                            }
                        } loot.clear();
                    } continuar = false;
                } //continuar = false;

                case 2:
                    hero.exibirStatus();
                    InputManager.esperarEnter("Pressione a tecla \"ENTER\" para voltar ao menu pós combate");
                    break;

                case 3:
                    System.exit(1);
                    break;

                default:
                    break;
            }
        }
    }
}
