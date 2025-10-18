package rpg.personagens.herois;

import rpg.combate.BasicAtk;
import rpg.combate.FuriaDivina;
import rpg.combate.Motivate;
import rpg.itens.weapons.Weapon;
import rpg.personagens.Hero;

/**
 * Representa a classe de herói "Semideus".
 * Este herói utiliza um recurso especial, a Afinidade Divina, em suas habilidades únicas que invocam o poder dos deuses.
 */
public class Demigod extends Hero {
    //Atributos
    private int divineAfinity;

    //Construtor
    /**
     * Constrói uma nova instância de um Semideus.
     * @param name Nome do herói.
     * @param pontosDeVida Pontos de vida do herói.
     * @param forca Força base do herói.
     * @param nivel Nível incial do herói.
     * @param experiencia Experiência inicial do herói.
     * @param arma Arma inicial do herói.
     * @param expProximoNivel Quantidade de experiência necessária para o herói subir de nível.
     * @param sorte Sorte inicial do herói.
     * @param divineAfinity Quantidade de Afinidade Divina inicial do herói.
     */
    public Demigod(String name, int pontosDeVida, int forca, int nivel, int experiencia, Weapon arma, int expProximoNivel, float sorte, int divineAfinity){
        super(name, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.divineAfinity = divineAfinity;
        adicionarAcao(new BasicAtk());
        adicionarAcao(new FuriaDivina());
        adicionarAcao(new Motivate());
    }

    //Getters
    /**
     * Retorna a quantidade de Afinidade Divina.
     * @return A afinidade divina do Semideus.
     */
    public int getDivineAfinity(){
        return divineAfinity;
    }

    /**
     * Modifica a quantidade de Afinidade Divina.
     * @param valor A quantidade de Afinidade Divina a ser adicionada ou subtraida.
     */
    public void setDivineAfinity(int valor){
        this.divineAfinity += valor;
    }

}

