package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class EditorTableroTest {

    @Test
    public void testDeberiaPintarUnaCuadra() {
        Tablero unTablero = new Tablero(4,4);
        EditorTablero pintor = new EditorTablero();
        Casilla unaCasillaDePrueba = unTablero.getCasilla(1,1);
        EstadoCuadra unaCuadra = new EstadoCuadra();

        pintor.pintar(unaCasillaDePrueba, unaCuadra);

        Assert.assertFalse(unTablero.getCasilla(1,1).getEstado().sosAlojable());
    }

    @Test
    public void testDeberiaPintarUnaCalle() {
        Tablero unTablero = new Tablero(4,4);
        EditorTablero pintor = new EditorTablero();
        Casilla unaCasillaDePrueba = unTablero.getCasilla(1,1);
        EstadoCalle unaCalle = new EstadoCalle();

        pintor.pintar(unaCasillaDePrueba, unaCalle);

        Assert.assertTrue(unTablero.getCasilla(1,1).getEstado().sosAlojable());
    }

    @Test
    public void testDeberiaDarleUnFormatoSimpleAUnTablero() {
        Tablero unTablero = new Tablero(4,4);
        EditorTablero pintor = new EditorTablero();

        pintor.darFormatoSimpleA(unTablero);

        Assert.assertTrue(unTablero.getCasilla(0,1).getEstado().sosAlojable());
    }
}
