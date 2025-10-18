package rpg.exceptions;

/**
 * Uma exceção lançada quando um combatente tenta executar uma ação, mas não possui os recursos necessários.
 */
public class RecursoException extends Exception{
    /**
     * Constrói uma nova RecursoException com uma mensagem especificada.
     * @param string A mensagem que explica por que a exceção ocorreu.
     */
    public RecursoException(String string){
        super(string);
    }
}
