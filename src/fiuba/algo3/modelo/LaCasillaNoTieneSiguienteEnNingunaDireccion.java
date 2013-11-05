package fiuba.algo3.modelo;

/**no deberian ser RuntimeException, pero por ahora las deja asi, para que no molesten **/
public class LaCasillaNoTieneSiguienteEnNingunaDireccion extends RuntimeException{

    public LaCasillaNoTieneSiguienteEnNingunaDireccion (String msg) {
        super(msg);
    }
}
