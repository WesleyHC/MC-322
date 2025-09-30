package rpg.cenario;

public enum Difficulty {
    FACIL(1,1, 1){
        public void printar(){
        System.out.println("FACIL");
        }
    },
    MEDIO(2, 2, 2){
        public void printar(){
        System.out.println("MEDIO");
        }
    },
    DIFICL(3,3, 3){
        public void printar(){
        System.out.println("DIFÍCIL");
        }
    };

    private double mult_dano;
    private double mult_vida;
    private double mult_arma;

    Difficulty(double mult_dano, double mult_vida, double mult_arma){
        this.mult_dano = mult_dano;
        this.mult_vida = mult_vida;
        this.mult_arma = mult_arma;
    }

    public double getMultDano(){
        return this.mult_dano;
    }
    public double getMultVida(){
        return this.mult_vida;
    }
    public double getMultArma(){
        return this.mult_arma;
    }

    public abstract void printar();
}
