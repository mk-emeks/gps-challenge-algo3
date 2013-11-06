package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class EditorTableroTest {

    @Test
    public void testDeberiaDarleUnFormatoSimpleAUnTablero() {
        Tablero unTablero = new Tablero(4,4);
        EditorTablero pintor = new EditorTablero();

        pintor.darFormatoSimpleA(unTablero);

        Assert.assertTrue(unTablero.getCasilla(0,1).getEstado().sosAlojable());
    }
}
