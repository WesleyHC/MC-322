package tarefa2;

import tarefa1.*;
import java.util.ArrayList;

public class LevelConstructor {

    public static ArrayList<Level> gerarFases(int nFases) {
        ArrayList<Level> levels = new ArrayList<>();
        String[] ambientes = {"PORTÃO SELADO", "SALÃO ECOANTE", "CAMÂRA ESQUECIDA"};
        
        ArrayList<Weapon> armas_ciclop = new ArrayList<>(); //clava do ciclop
        armas_ciclop.add(new Club());

        ArrayList<Weapon> armas_harpy = new ArrayList<>(); //armas harpy
        armas_harpy.add(new Bow());
        armas_harpy.add(new Sword());

        ArrayList<Weapon> armas_chimera = new ArrayList<>(); //armas chimera
        armas_chimera.add(new Sword());
        armas_chimera.add(new Club());

        for (int i = 0; i < nFases; i++) {
            int nivelDolvl = i + 1;
            String cenario = ambientes[i]; 
            
            ArrayList<Monster> monstrosDolvl = new ArrayList<>();
            int nMonstros = 1 + nivelDolvl;

            for (int j = 0; j < nMonstros; j++) { //up nos atributos dos monstros cada lvl da fase
                int vidaBonus = 20*nivelDolvl;
                int forcaBonus = 4*nivelDolvl;
                int xpBonus = 10*nivelDolvl;
                
                if (j == 0) {
                    monstrosDolvl.add(new Ciclop("Sérgio, o Ciclope", 40 + vidaBonus, 15 + forcaBonus, new Club(), 15 + xpBonus, armas_ciclop));
                } else if (j == 1) {
                    monstrosDolvl.add(new Harpy("Ana, a Harpia", 30 + vidaBonus, 5 + forcaBonus, new Bow(), 10 + xpBonus, 35, armas_harpy));
                } else {
                    monstrosDolvl.add(new Chimera("Ninaxander, a Quimera", 45 + vidaBonus, 10 + forcaBonus, new Sword(), 20 + xpBonus + 5, 10, armas_chimera));
                }
            }
            
           
            Level newlvl = new Level(nivelDolvl, cenario, monstrosDolvl);
            levels.add(newlvl);
        }

        return levels;
    }
}