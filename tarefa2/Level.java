package tarefa2;

import java.util.ArrayList;

import tarefa1.Hero;
import tarefa1.Monster;
import tarefa3.Fase;

public class Level implements Fase{
    //Atributos
    private int nivel;
    private String ambiente;
    private ArrayList<Monster> monstros;

    // Construtor
    public Level(int nivel, String ambiente, ArrayList<Monster> monstros){
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = monstros;
    }

    //Getters
    public int getNivel() {
        return nivel;
    }
    public String getAmbiente() {
        return ambiente;
    }
    public ArrayList<Monster> getMonstros() {
        return monstros;
    }

    public void LevelDescription(String ambiente) {
        switch(ambiente){
            case ("PORTÃO SELADO"):
                System.out.println("O herói aproxima-se de uma estrutura de magnitude colossal, trazendo calafrios ao seu corpo inteiro: O inacreditável Portão Selado! Os terrores mais assombrosos que Echidna poderia conjurar emanam seus desejos mais desumanos através do selo de aço forjado por Hefesto");
                break;
            case ("SALÃO ECOANTE"):
                System.out.println("Ao adentrar nesse recinto, as vozes dos espíritos de tudo que houve, e que vai haver, ecoavam incessantemente em reverberações capazes de enlouquecer até o mais robusto dos guerreiros. Um local de pleno desespero e perdição: O Salão Ecoante");
                break;            
            case ("CAMPOS DA PERDIÇÃO"):
                System.out.println("As terras por onde os espíritos vagam sem rumo, o plano onde todos os seres buscam eternamente seu destino final. Um espaço sustentado meramente pelos sonhos e sentimentos daqueles que já não mais vivem. Os temerários Campos da Perdição");
                break;
        }
    }

    @Override
    public void iniciar(Hero heroi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciar'");
    }

    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDone'");
    }
}
