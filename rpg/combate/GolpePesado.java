package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;

/**
 * Ataque que utiliza o dobro da força, mas com o custo de o usuário ficar com fadiga (não ataca no próximo turno).
 * Ataque utilizado pelo monstro Ciclope.
 */
public class GolpePesado implements AcaoDeCombate{ //golpe do ciclope
    @Override
    public void executar(Combatente user, Combatente alvo) {
        int dano = user.getForca()*2;
        System.out.println(user.getName() +" executa um GOLPE PESADO!");
        System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
        alvo.receberDano(dano);
        
    }
}
