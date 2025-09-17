package tarefa3;

import tarefa1.Hero;

public enum TipoCenario {
    OLIMPO("In the name of Hades! Olympus, I accept this message") {
        public void Effect(Hero heroi){
            heroi.setSorte(10);
            System.out.println("Inspirado pelo Olimpo");
        }
    },
    ELÍSIO("Teseus e Astério estão me aguardando"){
        public void Effect(Hero heroi){
            heroi.receberForca(30);
            System.out.println("Ansioso pra encontrar Patroclus");
        }
    },
    CAMPOS("Sala qualquer aí"){
        public void Effect(Hero heroi){
            heroi.setSorte(-10);
            System.out.println("Medo do Boss");
        }
    };

    private final String descricao;

    TipoCenario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public abstract void Effect(Hero heroi);
}



