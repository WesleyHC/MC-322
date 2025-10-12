package rpg.interfaces;

import rpg.exceptions.RecursoException;
/**
 * Representa uma ação única que um combatente pode executar durante uma batalha.
 * Cada implementação desta interface define a lógica de um ataque, habilidade ou outra ação.
 */
public interface AcaoDeCombate {
    /**
     * Contém a lógica principal da ação de combate.
     * @param user O combatente (usuário) que está executando a ação.
     * @param alvo O combatente que está sofrendo a ação.
     * @throws RecursoException Se o usuário não tiver algum recurso necessário para executar a ação.
     */
    void executar(Combatente user, Combatente alvo) throws RecursoException;
}
