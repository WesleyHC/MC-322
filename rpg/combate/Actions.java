package rpg.combate;

public class Actions {
    //Ataques
    public static final BasicAtk ATAQUE_BASICO = new BasicAtk();
    public static final GolpePesado GOLPE_PESADO = new GolpePesado();
    public static final BioAtk BIO_ATAQUE = new BioAtk();

    //Especiais
    public static final FuriaDivina FURIA_DIVINA = new FuriaDivina();
    public static final Sintese SINTESE = new Sintese();

    //Outros
    public static final Rest DESCANSAR = new Rest();
    public static final Motivate MOTIVAR = new Motivate();
}
