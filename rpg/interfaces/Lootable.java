package rpg.interfaces;

import java.util.ArrayList;

import rpg.personagens.Hero;

/**
 * Contrato que define uma entidade como lootável, ou seja, ela pode dropar (soltar) itens ao ser derrotada.
 */
public interface Lootable {
    /**
     * Calcula e retorna o item deixado pela entidade.
     * @param heroi O herói que derrotou a entidade, onde sua sorte influenciará o item dropado (solto).
     * @return Uma lista de itens dropados (soltos).
     */
    ArrayList<Item> droparLoot(Hero heroi);
}
