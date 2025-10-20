package rpg.game;

import rpg.personagens.monstros.*;
import rpg.utils.InputManager;
import rpg.personagens.*;
import rpg.personagens.herois.*;
import rpg.cenario.*;
import rpg.itens.Dracmas;
import rpg.itens.weapons.*;
import rpg.exceptions.LvlEquiparException;
import rpg.exceptions.RecursoException;
import rpg.interfaces.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.util.ArrayList;

@XmlRootElement
@XmlSeeAlso({Demigod.class, Satyr.class, Ciclop.class, Harpy.class, Chimera.class, Sword.class, Bow.class, Club.class, Spear.class, FaseDeCombate.class})
public class Batalha {
    private Hero hero;
    private ArrayList<Fase> fases;
    private int faseAtual;

    public Batalha(Difficulty dificuldade) {
        this.hero = new Demigod("Perseus", 250, 18, 1, 0, new Sword(), 100, 0.25f , 9);
        GeradorDeFases geradordefases = new ConstrutorDeCenarioFixo();
        this.fases = geradordefases.gerar(3, dificuldade);
        this.faseAtual = 0;
    }

    public Batalha(){
        
    }

    //Getters
    @XmlElement
    public Hero getHero() {
        return hero; 
    }
    @XmlElement
    public ArrayList<Fase> getFases() {
        return fases;
    }
    @XmlElement
    public int getFaseAtual() {
        return faseAtual;
    }

    //Setters
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setFases(ArrayList<Fase> fases) {
        this.fases = fases;
    }

    public void setFaseAtualIndex(int i) {
        this.faseAtual = i;
    }

    public void executarProxFase() {
        if (runFinished()) {
            System.out.println("A aventura terminou!");
            return;
        }
        Fase fase = fases.get(faseAtual);
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
                return;
                
            } else {
                System.out.println("\n" + monstro.getName() + " é derrotado(a)");
                hero.ganharExperiencia(monstro.getXpConcedido());

                //loots
                ArrayList<Item> loot = new ArrayList<>();
                if (monstro instanceof Lootable) {
                    loot = ((Lootable) monstro).droparLoot(hero);
                }
                boolean continuar = posCombate(loot);
                if (!continuar) {
                    hero.receberDano(9999); 
                    return;
                }    
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
            this.faseAtual++;
        }
        }

    public boolean runFinished() {
        if (!hero.isAlive() || faseAtual>=fases.size()) {
            return true;
        } else {
            return false;
        }
    }
    public void carregarJogo(String nomeSave) {
        Batalha batalhaCarregada = GerenciadorDePersistencia.carregarBatalha(nomeSave);

        if (batalhaCarregada != null) {
            this.hero = batalhaCarregada.getHero();
            this.fases = batalhaCarregada.getFases();
            this.faseAtual = batalhaCarregada.getFaseAtual();
            System.out.println("Batalha pronta para continuar!");
        } else {
            System.out.println("Não foi possível carregar o estado do jogo.");
        }
    }
    /**
     * Exibe o menu pós-combate, permitindo que o jogador interaja com o loot, veja seu status, salve o jogo ou desista.
     * @param loot A lista de itens dropados pelo monstro.
     * @return true se o jogador decidir continuar para a próxima batalha/fase, false se decidir sair.
     */
    private boolean posCombate(ArrayList<Item> loot) {
        boolean lootProcessado = false;

        while (true) {
            System.out.println("\n=================| PÓS-COMBATE |=================");
            if (!loot.isEmpty() && !lootProcessado) {
                System.out.println("[1] Interagir com o Loot");
            }
            System.out.println("[2] Ver Status do Herói");
            System.out.println("[3] Salvar Jogo e Sair");
            System.out.println("[4] Desistir da Aventura (Sem Salvar)");
            System.out.println("==================================================");

            int opcao = rpg.utils.InputManager.lerInteiro("Escolha sua ação > ", 1, 4);

            switch (opcao) {
                case 1: //Interagir com loot
                    if (!loot.isEmpty() && !lootProcessado) {
                        System.out.println("--- Recompensas ---");
                        for (Item item : loot) {
                            System.out.println(this.hero.getName() + " obteve: " + item.getName());
                            if (item instanceof Dracmas) {
                                this.hero.setDracmas(((Dracmas) item).getQuantity());
                            } else if (item instanceof Weapon) {
                                try {
                                    this.hero.equipar((Weapon) item);
                                } catch (LvlEquiparException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                        System.out.println("-------------------");
                        lootProcessado = true;
                    } else {
                        System.out.println("Não há loot para interagir ou ele já foi coletado.");
                    }
                    break;

                case 2: //Ver status
                    this.hero.exibirStatus();
                    InputManager.esperarEnter("Pressione Enter para voltar...");
                    break;
                
                case 3: //Salvar e sair
                    GerenciadorDePersistencia.salvarBatalha(this, "save.xml");
                    return false;

                case 4: //Desistir
                    System.out.println(this.hero.getName() + " desiste de sua jornada...");
                    return false;
            }
            
            if (lootProcessado) {
                return true;
            }
        }
    }
}
