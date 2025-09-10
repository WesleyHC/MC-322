package tarefa2;

public class LevelConstructor {
    private static Level[] Fases;

    public static Level[] gerarFases(int nFases){
        for (int i = 1; i<=nFases; i++){
            Level Fase = new Level(i, "Cidade Grega");
        }
        return Fases;
    }
}
