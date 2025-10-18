package rpg.personagens.herois;

import rpg.combate.BasicAtk;
import rpg.combate.BioAtk;
import rpg.combate.Rest;
import rpg.combate.Sintese;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

/**
 * Representa a classe de herói "Sátiro".
 * Este herói tem uma forte conexão com a natureza e utiliza um recurso especial chamado Biomancia em suas habilidades de cura e ataque.
 */
public class Satyr extends Hero {
    //Atributos
    private int biomance;

    //Construtor
    /**
     * 
     * @param name Nome do herói.
     * @param pontosDeVida Pontos de vida do herói.
     * @param forca Força inicial do herói.
     * @param nivel Nível inicial do herói.
     * @param experiencia Experiência inicial do herói.
     * @param arma Arma inicial do herói.
     * @param expProximoNivel Quantidade de experiência necessária para o herói subir de nível.
     * @param sorte Sorte inicial do herói.
     * @param biomance Quantidade Biomancia inicial do herói.
     */
    public Satyr(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int biomance){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.biomance = biomance;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new Sintese());
        adicionarAcao(new BioAtk());
        adicionarAcao(new Rest());
    }

    //Getters
    /**
     * Retorna a quantidade de Biomancia.
     * @return A Biomancia do Sátiro.
     */
    public int getBiomance(){
        return biomance;
    }

    /**
     * Modifica a quantidade de Biomancia.
     * @param valor A quantidade de Biomancia a ser adicionada ou subtraida.
     */
    public void setBiomance(int valor){
        this.biomance += valor;
    }
}
