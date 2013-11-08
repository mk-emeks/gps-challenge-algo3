package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;


public class PosicionTest {

    @Test
    public void deberiaCrearUnaPosicionConDeterminadosParametros() {
        Posicion unaPosicion = new Posicion(1,6);

        Assert.assertEquals(1, unaPosicion.getPosicionX());
        Assert.assertEquals(6,unaPosicion.getPosicionY());
    }

    @Test
    public void deberiaPoderSumarDosPosiciones() {
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(3,10);

        Posicion posicionFinal = posicion1.sumar(posicion2);

        Assert.assertEquals(4,posicionFinal.getPosicionX());
        Assert.assertEquals(12,posicionFinal.getPosicionY());
    }

    @Test
    public void deberiaPoderMultiplicarPorUnEscalar() {
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicionFinal = posicion1.multiplicarPorEscalar(-1);

        Assert.assertEquals(-1,posicionFinal.getPosicionX());
        Assert.assertEquals(-2,posicionFinal.getPosicionY());
    }

    @Test
    public void deberiaPoderRestarDosPosiciones() {
        Posicion posicion1 = new Posicion(7,4);
        Posicion posicion2 = new Posicion(6,-1);

        Posicion posicionFinal = posicion1.restar(posicion2);

        Assert.assertEquals(1,posicionFinal.getPosicionX());
        Assert.assertEquals(5,posicionFinal.getPosicionY());
    }

    @Test
    public void deberiaPoderComparaDosPosicionesIguales() {
        Posicion posicion1 = new Posicion(7,5);
        Posicion posicion2 = new Posicion(7,5);

        Assert.assertTrue(posicion1.equals(posicion2));
    }

    @Test
    public void deberiaPoderComparaDosPosicionesDiferentes() {
        Posicion posicion1 = new Posicion(7,5);
        Posicion posicion2 = new Posicion(4,5);

        Assert.assertFalse(posicion1.equals(posicion2));
    }




}
