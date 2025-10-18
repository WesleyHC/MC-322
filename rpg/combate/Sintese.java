package rpg.combate;

import java.util.Random;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.herois.Satyr;

/**
 * Representa a habilidade especial de cura "Síntese", exclusiva do Sátiro.
 * A cura é baseada no atributo Biomancia do Sátiro e pode ter seu efeito dobrado com base na sorte.
 */
public class Sintese implements AcaoDeCombate{
    /**
     * Executa a habilidade de cura Síntese.
     * Verifica se o usuário é um Sátiro, calcula e aplica a cura, com chance de ser um acerto crítico.
     * @param user O Combatente que usa a habilidade (deve ser um Satyr).
     * @param alvo O oponente no combate (ignorado por esta ação).
     */
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
    
