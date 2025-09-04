package src;

public class Chimera extends Monster {
    //Atributo intimidador (dano do inimigo reduzido)
    private int intimidate;
    private boolean intimidate_msg;

    //Construtor
    public Chimera(String name, int pontosDeVida, int forca, int xpConcedido, int intimidate){
        super(name, pontosDeVida, forca, xpConcedido);
        this.intimidate = intimidate;
        this.intimidate_msg = true;
    }

    //Getters
    public int getIntimidate(){
        return intimidate;
    }

    //Métodos
    public void atacar(Character alvo){
        super.atacar(alvo, this.getForca());
    }
    public void receberDano(int dano){
        if (intimidate_msg) {
            System.out.println("O herói está intimidado por " + this.getName() + ", enfraquecendo seu ataque!");
            intimidate_msg = false;
        }
        super.receberDano(dano - intimidate);
    }
}
