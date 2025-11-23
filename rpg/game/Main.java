package rpg.game;

import rpg.utils.InputManager;
import rpg.utils.MenuPrincipal;
import rpg.cenario.Difficulty;

/**
 * Classe principal do jogo (motor).
 * É responsável por organizar toda a campanha.
 */
public class Main {

    public static void main(String[] args) {
        Batalha batalha = null;
        int escolhaMenu = MenuPrincipal.loop();

        if (escolhaMenu >= 0 && escolhaMenu <= 2) {
            Difficulty[] dificuldades = Difficulty.values();
            Difficulty dificuldadeEscolhida = dificuldades[escolhaMenu];
            batalha = new Batalha(dificuldadeEscolhida);
        } else if (escolhaMenu == 3) {
            batalha = new Batalha();
            batalha.carregarJogo("save.xml");
        }

        if (batalha != null && batalha.getHero() != null) {
            if (escolhaMenu != 3) {
                System.out.println("\n" + batalha.getHero().getName() + " é um herói habilidoso(a), mas sente que seus feitos passam despercebidos pelos Deuses.");
                System.out.println("Para chamar a atenção deles, o herói precisa de um feito que ninguém mais teve a coragem de tentar: recuperar a Caixa de Pandora.");
                System.out.println("Sua busca lhe trouxe até a entrada deste lugar. Segundo as lendas, a Caixa está guardada aqui dentro. É a chance de finalmente ser notado(a).");
            }

            System.out.println("\nA aventura continua!");
            batalha.getHero().exibirStatus();

            //Loop fases
            while (!batalha.runFinished()) {
                batalha.executarProxFase();

                //herói morreu, termina o jogo
                if (!batalha.getHero().isAlive()) {
                    break;
                }
            }

            //final
            if (batalha.getFaseAtual() >= batalha.getFases().size()) {
                System.out.println("\nO silêncio na arena é quebrado por um trovão distante: o aplauso do Olimpo.");
                System.out.println("Com a Caixa de Pandora em mãos, " + batalha.getHero().getName() + " se provou digno(a) da atenção dos Deuses!");
                System.out.println("\n=================|VITÓRIA|===================");
            } else if (!batalha.getHero().isAlive()) {
                System.out.println("\n" + batalha.getHero().getName() + " foi derrotado(a)!");
                System.out.println("O Olimpo vira o rosto, e o nome de " + batalha.getHero().getName() + " se perde no esquecimento.");
                System.out.println("\n================|GAME OVER|===================");
            } else {
                System.out.println("\nJogo encerrado. Até a próxima!");
            }
        }

        System.out.println("\nFinalizando o programa...");
        InputManager.fecharScanner();
    }
}
