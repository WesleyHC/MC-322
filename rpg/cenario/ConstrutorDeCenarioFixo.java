package rpg.cenario;

import java.util.ArrayList;

import rpg.eventos.*;
import rpg.interfaces.*;
import rpg.itens.weapons.*;
import rpg.personagens.Monster;
import rpg.personagens.monstros.*;

public class ConstrutorDeCenarioFixo implements GeradorDeFases{
    //Difficulty[] Dificuldades = Difficulty.values();
    TipoCenario[] ambientes = TipoCenario.values();
    
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
                int armaBonus = (int)(nivelDolvl*dificuldade.getMultArma());
                
                if (j == 0) {
                    Ciclop ciclope = new Ciclop("Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus);
                    ciclope.addArmaComum(new Sword(), armaBonus);
                    ciclope.addArmaRara(new Club(), armaBonus);
                    monstrosDolvl.add(ciclope);
                } else if (j == 1) {
                    Harpy harpia = new Harpy("Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35);
                    harpia.addArmaComum(new Sword(), armaBonus);
                    harpia.addArmaRara(new Bow(), armaBonus);
                    monstrosDolvl.add(harpia);
                } else {
                    Chimera quimera = new Chimera("Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 5*nivelDolvl);
                    quimera.addArmaComum(new Sword(), armaBonus);
                    quimera.addArmaRara(new Spear(), armaBonus);
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