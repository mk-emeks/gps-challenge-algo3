package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class DireccionTest {

    @Test
    public void testDeberiaInicializarseUnaDireccionConCeroCero() {
        Direccion unaDireccion = new Direccion();
        Posicion posicionTesteo = unaDireccion.devolverComoPosicion();
        Posicion posicionEsperada = new Posicion(0,0);

        Assert.assertEquals(posicionEsperada.getPosicionX(), posicionTesteo.getPosicionX());
        Assert.assertEquals(posicionEsperada.getPosicionY(), posicionTesteo.getPosicionY());
    }

    @Test
    public void testDeberiaPoderCompararDosDireccionesIguales() {
        DireccionArriba direccionArriba1  = new DireccionArriba();
        DireccionArriba direccionArriba2  = new DireccionArriba();

        Assert.assertTrue(direccionArriba1.esIgualA(direccionArriba2));
    }

    @Test
    public void testDeberiaPoderCompararDosDireccionesDiferentes() {
        DireccionIzquierda direccionIzquierda  = new DireccionIzquierda();
        DireccionAbajo direccionAbajo  = new DireccionAbajo();

        Assert.assertFalse(direccionAbajo.esIgualA(direccionIzquierda));
    }
}
