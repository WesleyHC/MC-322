package game.cenario;

public enum Difficulty {
    FACIL(1){
        public void printar(){
        System.out.println("Fácil escolhido");
        }
    },
    MEDIO(2){
        public void printar(){
        System.out.println("Médio escolhido");
        }
    },
    DIFICL(3){
        public void printar(){
        System.out.println("Difícil escolhido");
        }
    };

    private int mult;

    Difficulty(int mult){
        this.mult = mult;
    }

    public int getMult(){
        return this.mult;
    }

    public abstract void printar();
}
