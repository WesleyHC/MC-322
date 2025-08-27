package src;

public class Main {
    public static void main(String[] args){
        Hero hero = new Satyr("mosfet", 100, 20, 5, 45, 20);
        Monster monster = new Monster("fet", 100, 30, 10);

        // Exibindo status inicial
        hero.exibirStatus();
        monster.exibirStatus();
        hero.atacar(monster, 40);
        monster.atacar(hero, 60);
        hero.exibirStatus();
        monster.exibirStatus();

    }
}
