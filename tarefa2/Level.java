package tarefa2;

import java.util.ArrayList;
import tarefa1.Monster;

public class Level {
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
}
