package rpg.exceptions;

/**
 * Uma exceção lançada quando um herói tenta equipar um item mas não cumpre o requisito necessário de nível mínimo.
 */
public class LvlEquiparException extends Exception{
    /**
     * Constrói uma nova LvlEquiparException com uma mensagem especificada.
     * @param string A mensagem que explica por que a exceção ocorreu.
     */
    public LvlEquiparException(String string){
        super(string);
    }
}
