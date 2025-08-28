package src;
import java.util.Random;

public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;
    private String [] Gods = {"Zeus", "Poseidon", "Afrodite", "Ares", "Hades"};

    //Construtor
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia);
        this.divineAfinity = divineAfinity;
    }

    //Getters
    public int getDivineAfinity(){
        return divineAfinity;
    }

    //Métodos
    public void atacar(Character alvo){ //Ataque = Força + Nível*10
        super.atacar(alvo, (this.getForca()+getNivel()*3));
    }

    public void usarHabilidadeEspecial(Character alvo){ //Usa o poder concedido por um Deus aleatório
        super.usarHabilidadeEspecial(alvo);
        System.out.println("God's Plan em " + alvo.getName());
        Random random = new Random();
        int deus = random.nextInt(5);
        switch(Gods[deus]){
            case("Zeus"):
                super.atacar(alvo, (this.getForca()+divineAfinity*2));
                System.out.println("BENÇÃO DE ZEUS");
                break;
            case("Poseidon"):
                super.atacar(alvo, (this.getForca()+divineAfinity*1));
                System.out.println("BENÇÃO DE POSEIDON");
                break;
            case("Afrodite"):
                super.atacar(alvo, (this.getForca()-10));
                System.out.println("BENÇÃO DE AFRODITE");
                break;
            case("Ares"): 
                super.atacar(alvo, (5*this.getForca()));
                System.out.println("BENÇÃO DE ARES");
                break;
            case("Hades"):
                super.atacar(alvo, divineAfinity);  
                this.receberDano(divineAfinity);
                System.out.println("BENÇÃO DE HADES");
                break;
        }
    }
}

