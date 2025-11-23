package rpg.combate;

import java.util.Random;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Habilidade especial do Sátiro.
 * Cura e pode ser crítico.
 */
public class Sintese implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) {
        user.setAtributoEspecial(4);
        int cura = user.getAtributoEspecial();
        float crit = new Random().nextFloat();
        boolean AE = false;
        if (crit <= user.getSorte()) {
            AE = true;
            System.out.println("Os espíritos da natureza favorecem " + user.getName() + "! Sua cura foi fortalecida");
        }
        System.out.println(user.getName() + " usa a habilidade especial 'Síntese'!");
        System.out.println(user.getName() + " absorve energia vital e se cura!");
        if (AE){
            cura *= 2;
        }
        user.receberCura(cura);
    }
}
    
