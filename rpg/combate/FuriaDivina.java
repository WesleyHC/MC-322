package rpg.combate;

import java.util.Random;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
/**
 * Habilidade especial e exclusiva do Semideus (Demigod).
 * Invoca o poder de um deus aleatório do panteão grego, com efeitos variados que podem ser fortalecidos pela sorte do herói.
 */
public class FuriaDivina implements AcaoDeCombate {
    private String [] Gods = {"Zeus", "Poseidon", "Afrodite", "Ares", "Hades"};

    /**
     * Executa a Fúria Divina. Verifica se o usuário é um Semideus e se tem afinidade o suficiente. Em caso positivo, sorteia um deus e aplica seu efeito.
     * @param user O Combatente que usa a habilidade (deve ser um Demigod).
     * @param alvo O alvo da bênção divina (pode ser o próprio usuário em caso de cura).
     * @throws RecursoException Se o Semideus não tiver Afinidade Divina suficiente.
     */
    @Override
    public void executar(Combatente user, Combatente alvo) throws RecursoException {
        if (user.getAtributoEspecial()<10){
           throw new RecursoException(user.getName() + " não teve conexão suficiente com os deuses para canalizar suas preces!");
        }
        user.setAtributoEspecial(-1);
        System.out.println(user.getName() + " usa a habilidade especial 'Fúria Divina'!");
        Random random = new Random();
        int deus = random.nextInt(5);
        int dano;
        boolean CH = false;
        float crit = new Random().nextFloat();
        if (crit <= user.getSorte()) {
            CH = true;
            System.out.println("Os deuses estão ao lado de " + user.getName() + "! Seu acerto será crítico");
        }

        switch(Gods[deus]){
            case("Zeus"):
                dano = user.getForca() + user.getAtributoEspecial() * 2 + user.getArma().getDano();
                if (CH){
                    dano *= 1.5;
                }
                System.out.println("BENÇÃO DE ZEUS!\nUm raio atinge " + alvo.getName() + "! Causando ferimentos de " + dano);
                alvo.receberDano(dano);
                break;
            case("Poseidon"):
                dano = user.getForca() + user.getAtributoEspecial() + user.getArma().getDano();
                if (CH){
                    dano *= 1.5;
                }
                System.out.println("BENÇÃO DE POSEIDON!\nUma onda esmaga " + alvo.getName() + "! Causando um impacto de " + dano );
                alvo.receberDano(dano);
                break;
            case("Afrodite"):
                int cura = user.getAtributoEspecial() + (user.getNivel() * 15);
                if (CH){
                    cura *= 2;
                }
                System.out.println("BENÇÃO DE AFRODITE!\nUma aura pura envolve " + user.getName() + ", fechando seus ferimentos!");
                user.receberCura(cura);
                break;
            case("Ares"): 
                dano = user.getForca() * 3 + user.getArma().getDano();
                if (CH){
                    dano *= 1.5;
                }
                System.out.println("BENÇÃO DE ARES!\nA fúria da guerra inspira um golpe devastador de " + dano + " em " + alvo.getName());
                alvo.receberDano(dano);
                break;
            case("Hades"):  
                dano = user.getAtributoEspecial() * 2 + user.getArma().getDano();
                if (CH){
                    dano *= 1.5;
                }
                System.out.println("BENÇÃO DE HADES!\nA energia vital de " + alvo.getName() + " é drenada!");
                int drain = alvo.receberDano(dano);
                user.receberCura(drain);
                break;
            }
        }
    }
    
