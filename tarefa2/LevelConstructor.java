package tarefa2;

import tarefa1.*;
import java.util.ArrayList;

public class LevelConstructor {

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
                    Ciclop ciclope = new Ciclop("Sérgio, o Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus);
                    ciclope.addArmaComum(new Sword());
                    ciclope.addArmaRara(new Club());
                    monstrosDolvl.add(ciclope);
                    //monstrosDolvl.add(new Ciclop("Sérgio, o Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus, armas_ciclop));
                } else if (j == 1) {
                    Harpy harpia = new Harpy("Ana, a Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35);
                    harpia.addArmaComum(new Bow());
                    harpia.addArmaRara(new Sword());
                    monstrosDolvl.add(harpia);
                    //monstrosDolvl.add(new Harpy("Ana, a Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35, armas_harpy));
                } else {
                    Chimera quimera = new Chimera("Ninaxander, a Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 10);
                    quimera.addArmaComum(new Spear());
                    quimera.addArmaRara(new Sword());
                    monstrosDolvl.add(quimera);
                    //monstrosDolvl.add(new Chimera("Ninaxander, a Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 10, armas_chimera));
                }
            }
            
           
            Level newlvl = new Level(nivelDolvl, cenario, monstrosDolvl);
            levels.add(newlvl);
        }

        return levels;
    }

    }