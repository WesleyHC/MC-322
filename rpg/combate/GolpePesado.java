package rpg.combate;

import rpg.exceptions.RecursoException;
import rpg.interfaces.AcaoDeCombate;
import rpg.interfaces.Combatente;
import rpg.personagens.monstros.Ciclop;

/**
 * Ataque que utiliza o dobro da força, mas com o custo de o usuário ficar com fadiga (não ataca no próximo turno).
 * Ataque utilizado pelo monstro Ciclope.
 */
public class GolpePesado implements AcaoDeCombate{ //golpe do ciclope
    /**
     * Executa o Golpe Pesado.
     * Verifica se o usuário é um Ciclop e se ele não está fatigado.
     * Se as condições forem atendidas, causa dano dobrado e aplica a fadiga.
     * @param user O Combatente que usa a habilidade (deve ser um Ciclop).
     * @param alvo O Combatente que recebe o ataque.
     * @throws RecursoException Se o Ciclope estiver fatigado do turno anterior.
     */
    @Override
    public void executar(Combatente user, Combatente alvo) throws RecursoException {
        Ciclop User = (Ciclop)user;
        int dano;
        if (!User.getHeavystrike()) {
            User.setHeavystrike(true);
            throw new RecursoException(User.getName() + " está fatigado do último golpe e não consegue atacar.");
        }
        dano = User.getForca()*2 + User.getArma().getDano();
        System.out.println(User.getName() +" executa um GOLPE PESADO!");
        System.out.println("O ataque causa " + dano + " de dano em " + alvo.getName() + "!");
        User.setHeavystrike(false);
        alvo.receberDano(dano);
        
    }
}
