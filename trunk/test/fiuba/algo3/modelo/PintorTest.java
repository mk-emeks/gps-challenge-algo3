package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class PintorTest {

    @Test
    public void testDeberiaPintarUnaCuadra() {

        Tablero unTablero = new Tablero(4,4);
        Pintor unPintor = new Pintor();
        Casilla unaCasillaDePrueba = unTablero.getCasilla(1,1);

        unPintor.pintarUnaCuadraEn(unaCasillaDePrueba);

        Assert.assertFalse(unTablero.getCasilla(1,1).getEstado().sosAlojable());
    }

    @Test
    public void testDeberiaPintarUnaCalle() {
        Tablero unTablero = new Tablero(4,4);
        Pintor unPintor = new Pintor();
        Casilla unaCasillaDePrueba = unTablero.getCasilla(1,1);

        unPintor.pintarUnaCalleEn(unaCasillaDePrueba);

        Assert.assertTrue(unTablero.getCasilla(1,1).getEstado().sosAlojable());
    }

    @Test
    public void testDeberiaPintarUnTableroSimple() {
        Tablero unTablero = new Tablero(4,4);
        Pintor unPintor = new Pintor();

        unPintor.pintarTableroSimple(unTablero);

        Assert.assertFalse(unTablero.getCasilla(0,2).getEstado().sosAlojable());
        Assert.assertTrue(unTablero.getCasilla(1,2).getEstado().sosAlojable());
    }

}
