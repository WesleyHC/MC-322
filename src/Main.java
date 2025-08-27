package src;

public class Main {
    public static void main(String[] args){
        Character hero = new Hero("mosfet", 100, 20, 5, 200);
        Character monster = new Monster("fet", 100, 30, 10);

        // Exibindo status inicial
        hero.exibirStatus();
        monster.exibirStatus();
    }
}
