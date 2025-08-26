package src;
public class Character {
    //Atributos
    private String name;
    private int pontosDeVida;
    private int forca;
    
    //Construtor
    public Character(String name, int pontosDeVida, int forca){
        this.name = name;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }
    //getters
    public String getName(){
        return name;
    }
    public int getPontosDeVida(){
        return pontosDeVida;
    }
    public int getForca(){
        return forca;
    }

    //Métodos
    public void receberDano(int dano){
        pontosDeVida -= dano;

        if (pontosDeVida < 0)
            pontosDeVida = 0;
    }

    public void exibirStatus(){
        System.out.println("Status de " + name);
        System.out.print("Vida: " + pontosDeVida + " | ");
        System.out.println("Força: " + forca);
    }

    public void atacar(Character Alvo){

    }
}
