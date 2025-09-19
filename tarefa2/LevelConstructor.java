/*package tarefa2;

import tarefa1.*;
import tarefa3.*;

import java.util.ArrayList;

public class LevelConstructor implements GeradorDeFases{

    public static ArrayList<Level> gerarFases(int nFases) {
        ArrayList<Level> levels = new ArrayList<>();
        String[] ambientes = {"PORTÃO SELADO", "SALÃO ECOANTE", "CAMPOS DA PERDIÇÃO"};

        for (int i = 0; i < nFases; i++) {
            int nivelDolvl = i + 1;
            String cenario = ambientes[i]; 
            
            ArrayList<Monster> monstrosDolvl = new ArrayList<>();
            int nMonstros = 1 + nivelDolvl;

            for (int j = 0; j < nMonstros; j++) { //up nos atributos dos monstros cada lvl da fase
                int vidaBonus = 20*nivelDolvl;
                int forcaBonus = 4*nivelDolvl;
                int xpBonus = 25*nivelDolvl;
                
                if (j == 0) {
                    Ciclop ciclope = new Ciclop("Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus);
                    ciclope.addArmaComum(new Sword());
                    ciclope.addArmaRara(new Club());
                    monstrosDolvl.add(ciclope);
                } else if (j == 1) {
                    Harpy harpia = new Harpy("Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35);
                    harpia.addArmaComum(new Bow());
                    harpia.addArmaRara(new Sword());
                    monstrosDolvl.add(harpia);
                } else {
                    Chimera quimera = new Chimera("Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 10);
                    quimera.addArmaComum(new Spear());
                    quimera.addArmaRara(new Sword());
                    monstrosDolvl.add(quimera);
                }
            }
            
           
             newlvl = new Fase(nivelDolvl, monstrosDolvl, cenario);
            levels.add(newlvl);
        }

        return levels;
    }

    }*/