package tarefa3;

import java.util.Random;

import tarefa1.Demigod;

public class FuriaDivina implements AcaoDeCombate {
    private String [] Gods = {"Zeus", "Poseidon", "Afrodite", "Ares", "Hades"};

    @Override
    public void executar(Combatente user, Combatente alvo) {
        Demigod User = (Demigod)user; //Usa o poder concedido por um Deus aleatório
        System.out.println(User.getName() + " usa a habilidade especial 'Fúria Divina'!");
        Random random = new Random();
        int deus = random.nextInt(5);
        int dano;
        boolean CH = false;
        float crit = new Random().nextFloat();
        if (crit <= User.getSorte()) {
            CH = true;
            System.out.println("Os deuses estão ao lado de " + User.getName() + "! Seu acerto será crítico");
        }

        switch(Gods[deus]){
            case("Zeus"):
                dano = User.getForca() + User.getDivineAfinity() * 2 + User.getArma().getDano();
                if (CH){
                    dano *= 2;
                }
                System.out.println("BENÇÃO DE ZEUS!\nUm raio atinge " + alvo.getName() + "!");
                alvo.receberDano(dano);
                break;
            case("Poseidon"):
                dano = User.getForca() + User.getDivineAfinity() + User.getArma().getDano();
                if (CH){
                    dano *= 2;
                }
                System.out.println("BENÇÃO DE POSEIDON!\nUma onda esmaga " + alvo.getName() + "!");
                alvo.receberDano(dano);
                break;
            case("Afrodite"):
                int cura = User.getDivineAfinity() + (User.getNivel() * 2);
                if (CH){
                    cura *= 2;
                }
                System.out.println("BENÇÃO DE AFRODITE!\nUma aura pura envolve " + User.getName() + ", fechando seus ferimentos!");
                User.receberCura(cura);
                break;
            case("Ares"): 
                dano = User.getForca() * 3 + User.getArma().getDano();
                if (CH){
                    dano *= 2;
                }
                System.out.println("BENÇÃO DE ARES!\nA fúria da guerra inspira um golpe devastador em " + alvo.getName());
                alvo.receberDano(dano);
                break;
            case("Hades"):  
                dano = User.getDivineAfinity() * 2 + User.getArma().getDano();
                if (CH){
                    dano *= 2;
                }
                System.out.println("BENÇÃO DE HADES!\nA energia vital de " + alvo.getName() + " é drenada!");
                alvo.receberDano(dano);
                User.receberCura(dano);
                break;
        }
    }
}
    
