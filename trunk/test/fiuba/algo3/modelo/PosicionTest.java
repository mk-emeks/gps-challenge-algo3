package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class PosicionTest {

    @Test
    public void testDeberiaCrearseUnaPosicionConDeterminadosParametros() {
        Posicion unaPosicion = new Posicion(2.0,3.5);

        Assert.assertEquals(2.0, unaPosicion.getPosicionX()); //No esta bueno esto de los dos asserts pero es lo mas sencillo.
        Assert.assertEquals(3.5, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaSumarseUnaPosicionConOtra() {
        Posicion posicionUno = new Posicion(2.0,1.0);
        Posicion posicionDos = new Posicion(3.0,-6.0);

        Posicion posicionFinal = posicionUno.sumar(posicionDos);

        Assert.assertEquals(5.0, posicionFinal.getPosicionX());
        Assert.assertEquals(-5.0, posicionFinal.getPosicionY());
    }

    @Test
    public void testDeberiaRestarseUnaPosicionConOtra() {
        Posicion posicionUno = new Posicion(2.0,1.0);
        Posicion posicionDos = new Posicion(3.0,-6.0);

        Posicion posicionFinal = posicionUno.restar(posicionDos);

        Assert.assertEquals(-1.0, posicionFinal.getPosicionX());
        Assert.assertEquals(7.0, posicionFinal.getPosicionY());
    }

    @Test
    public void testDeberiaPoderCompararDosPosiciones() {
        Posicion posicionUno = new Posicion (2.0,1.0);
        Posicion posicionDos = new Posicion (3.0,1.0);

        Assert.assertFalse(posicionUno.comparar(posicionDos));
    }

    @Test
    public void testDeberiaPoderCalcularLaDistanciaEntreDosPosiciones() {
        Posicion posicionUno = new Posicion (2.0,1.0);
        Posicion posicionDos = new Posicion (3.0,1.0);

        Assert.assertEquals(1.0, posicionUno.calcularDistancia(posicionDos));
    }
}
