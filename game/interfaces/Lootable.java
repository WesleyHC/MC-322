package game.interfaces;

import java.util.ArrayList;

import game.personagens.Hero;

public interface Lootable {
    ArrayList<Item> droparLoot(Hero heroi);
}
