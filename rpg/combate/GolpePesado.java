package rpg.combate;

import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.monstros.Ciclop;

public class GolpePesado implements AcaoDeCombate{ //golpe do ciclope
    @Override
    public void executar(Combatente user, Combatente alvo) {
        Ciclop User = (Ciclop)user;

        int dano;
        if (User.getHeavystrike()) {
            dano = User.getForca()*2;
            System.out.println(User.getName() +" executa um GOLPE PESADO!");
            System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
            User.setHeavystrike(false);
        } else {
            dano = 0;
            System.out.println(User.getName() + " está fatigado do último golpe e não consegue atacar.");
            User.setHeavystrike(true);
        }
        alvo.receberDano(dano);
    }
}
