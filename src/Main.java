package src;

public class Main {
    public static void main(String[] args){
        Hero hero = new Demigod("Perseus", 100, 14, 5, 45, 20);
        //Monster harpy = new Harpy("Polífemo", 100, 30, 10, 20);
        Monster[] Monstros = {
            new Harpy("Ella", 20, 10, 15, 30),
            new Ciclop("Polífemo", 30, 15, 25),
            new Chimera("Ninaxander", 25, 12, 30, 10)
        };
        //Mensagem de Introdução
        System.out.println(hero.getName() + " é um herói habilidoso(a), mas sente que seus feitos passam despercebidos pelos Deuses.");
        System.out.println("Para chamar a atenção deles, o herói precisa de um feito que ninguém mais teve a coragem de tentar: recuperar a Caixa de Pandora.");
        System.out.println("Sua busca lhe trouxe até a entrada deste lugar. Segundo as lendas, a Caixa está guardada aqui dentro. É a chance de finalmente ser notado(a).");

        //Exibição de Status Inicial
        hero.exibirStatus();

        for (int i = 0; i<3; i++) { //For Monstros
            int turno = 1; //n do turno
            if (i == 0) {
                System.out.println("\nPorém, seu caminho é bloqueado por uma figura ameaçadora. O primeiro guardião se revela...");
                System.out.println(hero.getName() + " se depara com um temível oponente: " + Monstros[i].getName());
            } else if (i == 1) {
                System.out.println("\nO caminho agora está livre. " + hero.getName() + " avança.");
                System.out.println("Um novo oponente bloqueia seu caminho: " + Monstros[i].getName());  
            } else {
                System.out.println("\nA jornada continua...");
                System.out.println("Das sombras, emerge o desafio final: " + Monstros[i].getName());
            }
            
            while (Monstros[i].getPontosDeVida() > 0 && hero.getPontosDeVida() > 0) {
                System.out.println("\n=================|TURNO " + turno + "|===================");

                if (turno % 3 == 0) { // Usa habilidade especial depois de 2 turnos carregando
                    hero.usarHabilidadeEspecial(Monstros[i]);
                } else {
                    hero.atacar(Monstros[i], hero.getForca());
                }

                //Verificação se o Monstro morreu
                if (Monstros[i].getPontosDeVida() > 0) {
                    Monstros[i].atacar(hero, Monstros[i].getForca());
                }
                hero.exibirStatus();
                Monstros[i].exibirStatus();
                System.out.println("==============|FIM DO TURNO " + turno + "|===============");
                turno+=1;
            }

            //Verificação se o Herói morreu e mensagem final (Game Over)
            if (hero.getPontosDeVida()==0){
                    System.out.println("\n" + hero.getName() + " é derrotado(a)!\n\nPara os Deuses não há espaço para a fraqueza.");
                    System.out.println("O Olimpo vira o rosto, e o nome de " + hero.getName() + " se perde no esquecimento.");
                    System.out.println(hero.getName() + " foi considerado(a) indigno(a)!");
                    System.out.println("\n================|GAME OVER|===================");
                    System.exit(1);  
            }

            //Verificação da morte do Monstro e da Experiência concedida
            if (Monstros[i].getPontosDeVida()==0){
                System.out.println("\n" + Monstros[i].getName() + " é derrotado(a)");
                hero.ganharExperiencia(Monstros[i].getXpConcedido());
            }
        }
        //Mensagem final (vitoria)
        System.out.println("\nO silêncio na arena é quebrado por um trovão distante: o aplauso do Olimpo.");
        System.out.println("Com a Caixa de Pandora em mãos, " + hero.getName() + " se provou digno(a) da atenção dos Deuses!");
        System.out.println("\n=================|VITÓRIA|===================");
    }
}