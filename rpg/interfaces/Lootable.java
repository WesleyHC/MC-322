package rpg.interfaces;

import java.util.ArrayList;

import rpg.personagens.Hero;

public interface Lootable {
    ArrayList<Item> droparLoot(Hero heroi);
}
