package rpg.cenario;

import rpg.personagens.Hero;

/**
 * Enum que representa os diferentes tipos de cenários do jogo.
 * Cada cenário possui um nome, uma descrição narrativa e um efeito único que é aplicado ao herói quando a fase inicia.
 */
public enum TipoCenario {
    /**
     * O primeiro cenário, a entrada do desafio. Inspira o herói, dando um bônus de força.
     */
    PORTAO_SELADO("PORTÃO SELADO", "O herói aproxima-se de uma estrutura de magnitude colossal, trazendo calafrios ao seu corpo inteiro: O inacreditável Portão Selado! Os terrores mais assombrosos que Echidna poderia conjurar emanam seus desejos mais desumanos através do selo de aço forjado por Hefesto.") {
        public void Effect(Hero heroi){
            int efeito = 2;
            System.out.println("A magnitude do desafio inspira " + heroi.getName() + "!");
            heroi.receberForca(efeito);
        }
    },
    /**
     * O segundo cenário, um local de perturbação mental. Aplica uma penalidade na sorte do herói.
     */
    SALAO_ECOANTE("SALÃO ECOANTE", "Ao adentrar nesse recinto, as vozes dos espíritos de tudo que houve, e que vai haver, ecoavam incessantemente em reverberações capazes de enlouquecer até o mais robusto dos guerreiros. Um local de pleno desespero e perdição: O Salão Ecoante."){
        public void Effect(Hero heroi){
            float efeito = 0.05f;
            System.out.println("As vozes incessantes do salão abalam a concentração de " + heroi.getName() + "! Sua sorte diminui em " + efeito + ".");
            heroi.setSorte(-efeito);
        }
    },
    /**
     * O terceiro e último cenário, um lugar hostil. Causa dano direto ao herói.
     */
    CAMPOS_DA_PERDICAO("CAMPOS DA PERDIÇÃO", "As terras por onde os espíritos vagam sem rumo, o plano onde todos os seres buscam eternamente seu destino final. Um espaço sustentado meramente pelos sonhos e sentimentos daqueles que já não mais vivem. Os temerários Campos da Perdição."){
        public void Effect(Hero heroi){
            int efeito = 30;
            System.out.println("A energia espiritual dos Campos da Perdição é avassaladora! O miasma do local causa " + efeito + " de dano em " + heroi.getName());
            heroi.receberDano(efeito);
        }
    };

    private String descricao;
    private String name;

    /**
     * Construtor para cada constante de cenário.
     * @param name O nome de exibição do cenário.
     * @param descricao A descrição narrativa completa do cenário.
     */
    TipoCenario(String name, String descricao){
        this.name = name;
        this.descricao = descricao;
    }

    /**
     * Retorna o nome do cenário.
     * @return O nome para ser mostrado ao jogador.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Retorna a descrição narrativa completa do cenário.
     * @return A descrição do cenário.
     */
    public String getDescricao(){
        return this.descricao;
    }

    /**
     * Método abstrato que força cada cenário a implementar seu próprio efeito único quando a fase inicia.
     * @param heroi O herói que sofrerá o efeito do cenário.
     */
    public abstract void Effect(Hero heroi);
}



