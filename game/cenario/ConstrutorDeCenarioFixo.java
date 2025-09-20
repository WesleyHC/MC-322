package game.cenario;

import java.util.ArrayList;

import game.eventos.*;
import game.interfaces.*;
import game.itens.weapons.*;
import game.personagens.Monster;
import game.personagens.monstros.*;

public class ConstrutorDeCenarioFixo implements GeradorDeFases{
    TipoCenario[] Cenarios = TipoCenario.values();

    @Override
    public ArrayList<Fase> gerar(int nFases) {
        ArrayList<Fase> fases = new ArrayList<>();
        TipoCenario[] ambientes = TipoCenario.values();

        for (int i = 0; i < nFases; i++) {
            int nivelDolvl = i + 1;
            TipoCenario cenario = ambientes[i]; 
            
            ArrayList<Monster> monstrosDolvl = new ArrayList<>();
            int nMonstros = 1 + nivelDolvl;

            for (int j = 0; j < nMonstros; j++) { //up nos atributos dos monstros cada lvl da fase
                int vidaBonus = 50*nivelDolvl;
                int forcaBonus = 4*nivelDolvl;
                int xpBonus = 25*nivelDolvl;
                
                if (j == 0) {
                    Ciclop ciclope = new Ciclop("Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus);
                    ciclope.addArmaComum(new Sword(), nivelDolvl);
                    ciclope.addArmaRara(new Club(), nivelDolvl);
                    monstrosDolvl.add(ciclope);
                } else if (j == 1) {
                    Harpy harpia = new Harpy("Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35);
                    harpia.addArmaComum(new Sword(), nivelDolvl);
                    harpia.addArmaRara(new Bow(), nivelDolvl);
                    monstrosDolvl.add(harpia);
                } else {
                    Chimera quimera = new Chimera("Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 5*nivelDolvl);
                    quimera.addArmaComum(new Sword(), nivelDolvl);
                    quimera.addArmaRara(new Spear(), nivelDolvl);
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