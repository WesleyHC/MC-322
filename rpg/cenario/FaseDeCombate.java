package rpg.cenario;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import rpg.eventos.Hermes;
import rpg.interfaces.*;
import rpg.personagens.*;
import rpg.personagens.monstros.Chimera;
import rpg.personagens.monstros.Ciclop;
import rpg.personagens.monstros.Harpy;

/**
 * Implementação concreta de uma Fase do jogo, focada em uma sequência de combates.
 * Esta classe armazena todos os monstros, o cenário e os eventos de um determinado nível.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({
    Ciclop.class,
    Harpy.class,
    Chimera.class,
    Hermes.class
})
public class FaseDeCombate implements Fase {
    //Atributos
    private int nivel;
    private TipoCenario cenario;
    private ArrayList<Monster> monstrosDolvl;
    private ArrayList<Evento> eventos;
    
    //Construtor
    /**
     * Constrói uma nova fase de combate.
     * @param nivel O número do nível desta fase.
     * @param monstrosDolvl A lista de monstros que o herói enfrentará.
     * @param cenario O Enum TipoCenario que define o ambiente e seus efeitos.
     * @param eventos A lista de eventos que podem ocorrer nesta fase.
     */
    public FaseDeCombate(int nivel, ArrayList<Monster> monstrosDolvl, TipoCenario cenario, ArrayList<Evento> eventos){
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstrosDolvl = monstrosDolvl;
        this.eventos = eventos;
    }

    public FaseDeCombate() {
        this.monstrosDolvl = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

     /**
     * Inicia a fase, exibindo a descrição e aplicando os efeitos do cenário sobre o herói.
     * @param heroi O herói que está adentrando na fase.
     */
    @Override
    public void iniciar(Hero heroi) {
        System.out.println(this.cenario.getDescricao());
        System.out.println("\n=================|" + this.cenario.getName() + "|===================");
        this.cenario.Effect(heroi);
    }

    /**
     * Verifica se a fase foi concluída, checando se todos os monstros foram derrotados.
     * @return true se todos os monstros da fase estão mortos, false caso contrário.
     */
    @Override
    public boolean isDone() {
        for (Monster monstro : this.monstrosDolvl) {
            if (monstro.isAlive()) {
                return false;
            }
        }
        return true;
    }

    //Getters
     /**
     * Retorna o número do nível desta fase.
     * @return O nível da fase.
     */
    @XmlElement
    public int getNivel(){
        return nivel;
    }

    /**
     * Retorna o tipo de cenário (Enum) associado a esta fase.
     * @return O TipoCenario da fase.
     */
    @Override
    @XmlElement
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }

    /**
     * Retorna a lista de monstros presentes nesta fase.
     * @return Uma lista de Monstros.
     */
    @XmlElementWrapper(name="monstros")
    @XmlElement(name="monstro")
    public ArrayList<Monster> getMonstros() {
        return monstrosDolvl;
    }
    
    /**
     * Retorna a lista de eventos que podem ocorrer nesta fase.
     * @return Uma lista de Eventos.
     */
    @XmlElementWrapper(name="eventos")
    @XmlElement(name="evento", type = Hermes.class)
    public ArrayList<Evento> getEventos(){
        return eventos;
    }

    //Setters
    public void setTipoDeCenario(TipoCenario cenario) {
        this.cenario = cenario;
    }
}
