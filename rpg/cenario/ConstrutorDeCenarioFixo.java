package rpg.cenario;

import java.util.ArrayList;

import rpg.combate.*;
import rpg.eventos.*;
import rpg.interfaces.*;
import rpg.itens.weapons.*;
import rpg.personagens.Monster;
import rpg.personagens.monstros.*;

/**
 * Implementação concreta de um GeradorDeFases que cria uma campanha fixa.
 * Esta classe é responsável por definir quais monstros, cenários e eventos aparecerão em cada fase do jogo, além de controlar o balanceamento da dificuldade.
 */
public class ConstrutorDeCenarioFixo implements GeradorDeFases{
    private static final  BasicAtk ATAQUE_BASICO = new BasicAtk();
    private static final Rest DESCANSO = new Rest();
    //Difficulty[] Dificuldades = Difficulty.values();
    TipoCenario[] ambientes = TipoCenario.values();
    
    /**
     * Gera uma lista de fases para a campanha do jogo com base na quantidade e dificuldade.
     * A cada fase, os monstros se tornam progressivamente mais fortes.
     *
     * @param nFases O número de fases a serem criadas para a campanha.
     * @param dificuldade O nível de dificuldade (FACIL, NORMAL, DIFICIL) que afetará os status dos monstros.
     * @return Uma lista de Fases para serem jogadas.
     */
    @Override
    public ArrayList<Fase> gerar(int nFases, Difficulty dificuldade) {
        ArrayList<Fase> fases = new ArrayList<>();

        for (int i = 0; i < nFases; i++) {
            int nivelDolvl = i + 1;
            TipoCenario cenario = ambientes[i]; 
            
            ArrayList<Monster> monstrosDolvl = new ArrayList<>();
            int nMonstros = 1 + nivelDolvl;

            for (int j = 0; j < nMonstros; j++) { //up nos atributos dos monstros cada lvl da fase
                int vidaBonus = (int)(20*nivelDolvl*dificuldade.getMultVida());
                int forcaBonus = (int)(2*nivelDolvl*dificuldade.getMultDano());
                int xpBonus = 25*nivelDolvl;
                
                if (j == 0) {
                    Ciclop ciclope = new Ciclop("Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus, dificuldade);
                    ciclope.adicionarAcao(DESCANSO);
                    ciclope.addArmaComum(Sword.class.getName());
                    ciclope.addArmaRara(Club.class.getName());
                    monstrosDolvl.add(ciclope);
                } else if (j == 1) {
                    Harpy harpia = new Harpy("Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35, dificuldade);
                    harpia.adicionarAcao(ATAQUE_BASICO);
                    harpia.adicionarAcao(DESCANSO);
                    harpia.addArmaComum(Sword.class.getName());
                    harpia.addArmaRara(Bow.class.getName());
                    monstrosDolvl.add(harpia);
                } else {
                    Chimera quimera = new Chimera("Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 5*nivelDolvl, dificuldade);
                    quimera.adicionarAcao(ATAQUE_BASICO);
                    quimera.adicionarAcao(DESCANSO);
                    quimera.addArmaComum(Sword.class.getName());
                    quimera.addArmaRara(Spear.class.getName());
                    monstrosDolvl.add(quimera);
                }
                
            }
            //add eventos
                ArrayList<Evento> eventosDolvl = new ArrayList<>();
                eventosDolvl.add(new Hermes());

            FaseDeCombate newlvl = new FaseDeCombate(nivelDolvl, monstrosDolvl, cenario, eventosDolvl);
            fases.add(newlvl);
        }

        return fases;
    }

    }