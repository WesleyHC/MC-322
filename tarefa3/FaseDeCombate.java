package tarefa3;

import java.util.ArrayList;

import tarefa1.Hero;
import tarefa1.Monster;

public class FaseDeCombate implements Fase{
    private Hero heroi;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDoLvl = new ArrayList<>();
    
    public FaseDeCombate(ArrayList<Monster> monstrosDoLvl, TipoCenario cenario){
        this.cenario = cenario;
        this.monstrosDoLvl = monstrosDoLvl;
    }

    @Override
    public void iniciar(Hero heroi) {
        this.heroi = heroi;
    }

    @Override
    public boolean isDone(int kills, ArrayList<Monster> TotalMonstros) {
        if (kills == TotalMonstros.size()){
            return true;
        } else {
            return false;
        }
       // retorna true se todos os monstros foram derrotados
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }
    
    public void run(FaseDeCombate FaseDeCombate){
        System.out.println(cenario.getDescricao());
        int kills = 0;
        for (Monster monstro : monstrosDoLvl) {
                System.out.println(heroi.getName() + " se depara com um temível oponente: " + monstro.getName());
                int turno = 1;
                while (monstro.isAlive() && heroi.isAlive()) {
                    System.out.println("\n=================|TURNO " + turno + "|===================");
                    AcaoDeCombate HAction = heroi.escolherAcao(monstro);
                    HAction.executar(heroi, monstro);
                    

                    //Verificação se o Monstro morreu
                    if (!monstro.isAlive()) {
                        AcaoDeCombate MAction = monstro.escolherAcao(heroi);
                    MAction.executar(monstro, heroi);
                    }
                    heroi.exibirStatus();
                    monstro.exibirStatus();
                    System.out.println("==============|FIM DO TURNO " + turno + "|===============");
                    turno += 1;
                }

                //Verificação se o Herói morreu e mensagem final (Game Over)
                if (!heroi.isAlive()){
                        System.out.println("\n" + heroi.getName() + " é derrotado(a)!\n\nPara os Deuses não há espaço para a fraqueza.");
                        System.out.println("O Olimpo vira o rosto, e o nome de " + heroi.getName() + " se perde no esquecimento.");
                        System.out.println(heroi.getName() + " foi considerado(a) indigno(a)!");
                        System.out.println("\n================|GAME OVER|===================");
                        System.exit(1);  
                }

                //Verificação da morte do Monstro e da Experiência concedido
                if (!monstro.isAlive()){
                    kills += 1;
                    System.out.println("\n" + monstro.getName() + " é derrotado(a)");
                    Item drop = monstro.droparLoot(heroi);
                    heroi.equipar(drop);
                    heroi.ganharExperiencia(monstro.getXpConcedido());
                }
            }
            if (isDone(kills, monstrosDoLvl)){
                return;
            }
        }
    }
