package fiuba.algo3.modelo;

/**no deberian ser RuntimeException, pero por ahora las deja asi, para que no molesten **/
public class LaCasillaNoTieneElSiguientePedido extends RuntimeException{

    public LaCasillaNoTieneElSiguientePedido (String msg) {
        super(msg);
    }

}