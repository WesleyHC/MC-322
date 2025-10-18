package rpg.cenario;

/**
 * Representa os diferentes níveis de dificuldade do jogo.
 * Cada nível armazena multiplicadores para ajustar dinamicamente os status
 * dos monstros e a qualidade das recompensas.
 */
public enum Difficulty {
    /**
     * Dificuldade Fácil: Multiplicadores base para uma experiência mais tranquila.
     */
    FACIL(1,1, 1){
        public void printar(){
        System.out.println("FACIL");
        }
    },
    /**
     * Dificuldade Média: Multiplicadores balanceados para a experiência padrão.
     */
    MEDIO(2, 2, 2){
        public void printar(){
        System.out.println("MEDIO");
        }
    },
    /**
     * Dificuldade Difícil: Multiplicadores elevados para um desafio maior.
     */
    DIFICL(3,3, 3){
        public void printar(){
        System.out.println("DIFÍCIL");
        }
    };

    private double mult_dano;
    private double mult_vida;
    private double mult_arma;

    /**
     * Construtor para cada constante de dificuldade.
     * @param mult_dano Multiplicador para o dano dos monstros.
     * @param mult_vida Multiplicador para a vida dos monstros.
     * @param mult_arma Multiplicador para o dano das armas dropadas (soltas).
     */
    Difficulty(double mult_dano, double mult_vida, double mult_arma){
        this.mult_dano = mult_dano;
        this.mult_vida = mult_vida;
        this.mult_arma = mult_arma;
    }

    /**
     * Retorna o multiplicador de dano para esta dificuldade.
     * @return O valor do multiplicador de dano.
     */
    public double getMultDano(){
        return this.mult_dano;
    }
    /**
     * Retorna o multiplicador de vida para esta dificuldade.
     * @return O valor do multiplicador de vida.
     */
    public double getMultVida(){
        return this.mult_vida;
    }
    /**
     * Retorna o multiplicador de dano de arma para esta dificuldade.
     * @return O valor do multiplicador de dano de arma.
     */
    public double getMultArma(){
        return this.mult_arma;
    }

    /**
     * Método abstrato que força cada constante a ter uma forma de se apresentar.
     * Imprime o nome da dificuldade.
     */
    public abstract void printar();
}
