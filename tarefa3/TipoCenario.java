package tarefa3;

import tarefa1.Hero;

public enum TipoCenario {
    OLIMPO("In the name of Hades! Olympus, I accept this message") {
        public void Effect(Hero heroi){
            System.out.println("Inspirado pelo Olimpo");
        }
    },
    ELÍSIO("Teseus e Astério estão me aguardando"){
        public void Effect(Hero heroi){
            System.out.println("Ansioso pra encontrar Patroclus");
        }
    },
    SALÃO("Sala qualquer aí"){
        public void Effect(Hero heroi){
            System.out.println("Medo do Boss");
        }
    };

    private String descricao;

    TipoCenario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public abstract void Effect(Hero heroi);
}



