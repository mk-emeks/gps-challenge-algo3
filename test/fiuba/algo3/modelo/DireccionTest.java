package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Test;

public class DireccionTest {

    @Test
    public void testDeberiaInicializarseUnaDireccionConCeroCero() {
        Direccion unaDireccion = new Direccion();
        Posicion unaPosicion = unaDireccion.devolverComoPosicion();

        Assert.assertEquals(0, unaPosicion.getPosicionX());
        Assert.assertEquals(0, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaDevolverLaDireccionArribaComoUnaPosicion(){
        DireccionArriba unaDireccionArriba = new DireccionArriba();
        Posicion unaPosicion = unaDireccionArriba.devolverComoPosicion();

        Assert.assertEquals(0, unaPosicion.getPosicionX());
        Assert.assertEquals(-1, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaDevolverLaDireccionAbajoComoUnaPosicion(){
        DireccionAbajo unaDireccionAbajo = new DireccionAbajo();
        Posicion unaPosicion = unaDireccionAbajo.devolverComoPosicion();

        Assert.assertEquals(0, unaPosicion.getPosicionX());
        Assert.assertEquals(1, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaDevolverLaDireccionDerechaComoUnaPosicion(){
        DireccionDerecha unaDireccionDerecha = new DireccionDerecha();
        Posicion unaPosicion = unaDireccionDerecha.devolverComoPosicion();

        Assert.assertEquals(1, unaPosicion.getPosicionX());
        Assert.assertEquals(0, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaDevolverLaDireccionIzquierdaComoUnaPosicion(){
        DireccionIzquierda unaDireccionIzquierda = new DireccionIzquierda();
        Posicion unaPosicion = unaDireccionIzquierda.devolverComoPosicion();

        Assert.assertEquals(-1, unaPosicion.getPosicionX());
        Assert.assertEquals(0, unaPosicion.getPosicionY());
    }

    @Test
    public void testDeberiaPoderCompararDosDireccionesIguales(){
        DireccionIzquierda direccionIzquierda1 = new DireccionIzquierda();
        DireccionIzquierda direccionIzquierda2 = new DireccionIzquierda();

        Assert.assertTrue(direccionIzquierda1.equals(direccionIzquierda2));
    }

    @Test
    public void testDeberiaPoderCompararDosDireccionesDiferentes(){
        DireccionIzquierda direccionIzquierda1 = new DireccionIzquierda();
        DireccionDerecha direccionIzquierda2 = new DireccionDerecha();

        Assert.assertFalse(direccionIzquierda1.equals(direccionIzquierda2));
    }

    @Test
    public void testDeberiaInvertirseLaDireccion() {
        DireccionArriba unaDireccionArriba = new DireccionArriba();
        unaDireccionArriba.invertir();
        Posicion unaPosicion = unaDireccionArriba.devolverComoPosicion();

        Assert.assertEquals(0, unaPosicion.getPosicionX());
        Assert.assertEquals(1, unaPosicion.getPosicionY());
    }
}
