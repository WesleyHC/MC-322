package game.combate;

import java.util.Random;

import game.interfaces.AcaoDeCombate;
import game.interfaces.Combatente;
import game.personagens.herois.Satyr;

public class Sintese implements AcaoDeCombate{
    public void executar(Combatente user, Combatente alvo) {
        Satyr User = (Satyr)user;
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
    
