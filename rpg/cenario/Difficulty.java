package rpg.cenario;

public enum Difficulty {
    FACIL(1,1){
        public void printar(){
        System.out.println("FÁCIL");
        }
    },
    MEDIO(1.5, 1.5){
        public void printar(){
        System.out.println("MÉDIO");
        }
    },
    DIFICL(2,2){
        public void printar(){
        System.out.println("DIFÍCIL");
        }
    };

    private double mult_dano;
    private double mult_vida;

    Difficulty(double mult_dano, double mult_vida){
        this.mult_dano = mult_dano;
        this.mult_vida = mult_vida;
    }

    public double getMultDano(){
        return this.mult_dano;
    }
    public double getMultVida(){
        return this.mult_vida;
    }

    public abstract void printar();
}
