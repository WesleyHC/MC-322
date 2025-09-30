package rpg.cenario;

import rpg.personagens.Hero;

public enum TipoCenario {
    PORTAO_SELADO("PORTÃO SELADO", "O herói aproxima-se de uma estrutura de magnitude colossal, trazendo calafrios ao seu corpo inteiro: O inacreditável Portão Selado! Os terrores mais assombrosos que Echidna poderia conjurar emanam seus desejos mais desumanos através do selo de aço forjado por Hefesto.") {
        public void Effect(Hero heroi){
            int efeito = 2;
            System.out.println("A magnitude do desafio inspira " + heroi.getName() + "!");
            heroi.receberForca(efeito);
        }
    },
    SALAO_ECOANTE("SALÃO ECOANTE", "Ao adentrar nesse recinto, as vozes dos espíritos de tudo que houve, e que vai haver, ecoavam incessantemente em reverberações capazes de enlouquecer até o mais robusto dos guerreiros. Um local de pleno desespero e perdição: O Salão Ecoante."){
        public void Effect(Hero heroi){
            float efeito = 0.05f;
            System.out.println("As vozes incessantes do salão abalam a concentração de " + heroi.getName() + "! Sua sorte diminui em " + efeito + ".");
            heroi.setSorte(-efeito);
        }
    },
    CAMPOS_DA_PERDICAO("CAMPOS DA PERDIÇÃO", "As terras por onde os espíritos vagam sem rumo, o plano onde todos os seres buscam eternamente seu destino final. Um espaço sustentado meramente pelos sonhos e sentimentos daqueles que já não mais vivem. Os temerários Campos da Perdição."){
        public void Effect(Hero heroi){
            int efeito = 30;
            System.out.println("A energia espiritual dos Campos da Perdição é avassaladora! O miasma do local causa " + efeito + " de dano em " + heroi.getName());
            heroi.receberDano(efeito);
        }
    };

    private String descricao;
    private String name;

    TipoCenario(String name, String descricao){
        this.name = name;
        this.descricao = descricao;
    }

    public String getName(){
        return this.name;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public abstract void Effect(Hero heroi);
}



