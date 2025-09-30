package rpg.combate;

import java.util.Random;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.herois.Satyr;

public class Sintese implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) {
        Satyr User = (Satyr)user;
        User.setBiomance(4);
        int cura = User.getBiomance();
        float crit = new Random().nextFloat();
        boolean AE = false;
        if (crit <= User.getSorte()) {
            AE = true;
            System.out.println("Os espíritos da natureza favorecem " + User.getName() + "! Sua cura foi fortalecida");
        }
        System.out.println(User.getName() + " usa a habilidade especial 'Síntese'!");
        System.out.println(User.getName() + " absorve energia vital e se cura!");
        if (AE){
            cura *= 2;
        }
        User.receberCura(cura);
    }
}
    
