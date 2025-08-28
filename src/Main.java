package src;

public class Main {
    public static void main(String[] args){
        Hero hero = new Demigod("Perseus", 100, 20, 5, 45, 20);
        Monster monster = new Monster("Polífemo", 100, 30, 10);

        // Exibindo status inicial
        monster.exibirStatus();
        hero.usarHabilidadeEspecial(monster);
        monster.exibirStatus();

    }
}
