package rpg.utils;

/**
 * Classe de utilidade que gerencia o menu principal do jogo, permitindo que o jogador inicie o jogo, veja informações ou saia.
 */
public class MenuPrincipal {
    static boolean exit = false;

    /**
     * Exibe o menu principal em loop até que o jogador escolha iniciar o jogo ou sair.
     * @return A dificuldade escolhida pelo jogador, ou null se o jogador decidir sair.
     */
    public static int loop(){
        while(!exit){
        PrintMenuPrincipal();
        int opcao = InputManager.lerInteiro("Digite sua opção >", 1, 4);
        switch (opcao) {
                case 1:
                    return IniciarNovoJogo();
                case 2:
                    ExibirHerois();
                    break;
                case 3:
                    ExibirMonstros();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } return 5;
    }

    /**
     * Exibe as opções do menu principal.
     */
    public static void PrintMenuPrincipal(){
        System.out.println("\n          A PROVAÇÃO DO OLIMPO: O RPG          ");
        System.out.println("==================================================");
        System.out.println("");
        System.out.println("[1] Iniciar Novo Jogo");
        System.out.println("[2] Ver Informações das Classes de Heróis");
        System.out.println("[3] Ver Informações das Classes de Monstros");
        System.out.println("[4] Sair do Jogo");
        System.out.println("==================================================");
        }

    /**
     * Exibe o menu de seleção de dificuldade e captura a escolha do jogador.
     * @return O indice da dificuldade escolhida.
     */
    private static int IniciarNovoJogo(){
        System.out.println("\nIniciando Novo Jogo! Escolha a dificuldade desejada");
        System.out.println("==================================================");
        System.out.println("[1] Fácil - \" Um passeio tranquilo para nosso herói, monstros letárgicos diante da força de Perseus. Perfeito para acompanhar a história e acompanhar os eventos\" ");
        System.out.println("[2] Médio - \" Uma aventura com equílibrio áureo entre narrativa e combate dinâmico! Uma jornada de herói clássica\" ");
        System.out.println("[3] Difícil - \" Uma verdadeira provação para nosso herói! Costumam dizer as lendas que os deuses concedem os maiores desafios aos seus favoritos, será essa uma prova de tal?");
        System.out.println("==================================================");
        int opcao = InputManager.lerInteiro("Escolha sua dificuldade >", 1, 3);
        switch (opcao){
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                default:
                    System.out.println("");
                    break;
            }
        return 5;
    }

    /**
     * Exibe as descrições das classes de heróis disponíveis.
     */
    private static void ExibirHerois(){
        boolean status = true;
        while (status){
        System.out.println("\n              Disposição de Heróis              ");
        System.out.println("==================================================");
        System.out.println("[1] \"Semideus\" ");
        System.out.println("[2] \"Sátiro\" ");
        System.out.println("[3] Voltar ao Menu Principal");
        int opcao = InputManager.lerInteiro("Digite uma opção >", 1, 3);
        switch (opcao) {
                case 1:
                    System.out.println("\n-Semideus-");
                    System.out.println("Uma classe baseada na Afinidade Divina com os deuses!");
                    System.out.println("É capaz de se motivar, aumentando sua vida e força. Sua habilidade especial é capaz de canalizar os poderes de um deus aleatório");
                    System.out.println("==================================================");
                    break;
                case 2:
                    System.out.println("\n-Sátiro-");
                    System.out.println("Uma classe baseada na conexão de Biomancia com a natureza");
                    System.out.println("Consegue se curar através dos espíritos naturais. Pode executar um golpe que drena a vida do inimigo. Ocasionalmente precisa descansar");
                    System.out.println("==================================================");
                    break;
                case 3:
                    status = false;
                    break;
                default:
                    System.out.println("a");
                    break;
            }
        }
        return;
        }
    
    /**
     * Exibe as descrições dos tipos de monstros do jogo.
     */
    private static void ExibirMonstros(){
        boolean status = true;
        while (status){
        System.out.println("\n              Elenco de Monstros              ");
        System.out.println("==================================================");
        System.out.println("[1] \"Ciclope\" ");
        System.out.println("[2] \"Harpia\" ");
        System.out.println("[3] \"Quimera\" ");
        System.out.println("[4] Voltar ao Menu Principal");
        int opcao = InputManager.lerInteiro("Digite uma opção >", 1, 4);
        switch (opcao) {
                case 1:
                    System.out.println("\n-Ciclope-");
                    System.out.println("Um dos monstros mais reconhecidos da mitologia grega. Conhecidos por sua intimidante estatura e porte, marcado pelo seu único olho penetrante");
                    System.out.println("Apresenta um ataque pesado que depois de realizado força o ciclope a descansar pelo próximo turno");
                    System.out.println("==================================================");
                    break;
                case 2:
                    System.out.println("\n-Harpia-");
                    System.out.println("Monstros rápidos e plumados, alçando voo e constantemente aterrorizando os céus");
                    System.out.println("Devido a sua destreza de locomoção aérea, ocasionalmente consegue desviar de algum golpe recebido");
                    System.out.println("==================================================");
                    break;
                case 3:
                    System.out.println("\n-Quimera-");
                    System.out.println("As criaturas híbridas que aterrorizam a humanidade há eras! A junção monstruosa de diferentes seres em um só corpo");
                    System.out.println("Sua reputação e imponência intimidam nosso herói, fazendo com que os golpes causem menos dano");
                    System.out.println("==================================================");
                    break;
                case 4:
                    status = false;
                    break;
                default:
                    System.out.println("erro");
                    break;
            }
        }
        return;
        }
}

