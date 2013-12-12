package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Test;

public class DireccionArribaTest {

    /** Test por ser clases heredadas de Direccion **/
    @Test
    public void testLasDireccionesArribaDeberianSerIguales() {

        Direccion unaDireccion = new DireccionArriba();
        Direccion otroDireccion = new DireccionArriba();

        Assert.assertTrue(unaDireccion.equals(otroDireccion));
    }

    @Test
    public void testLasDireccionesAbajoYArribaDeberianSerDistintos() {

        Direccion unaDireccion = new DireccionAbajo();
        Direccion otroDireccion = new DireccionArriba();

        Assert.assertFalse(unaDireccion.equals(otroDireccion));
    }

    @Test
    public void testLasDireccionesDerechaYArribaDeberianSerDistintos() {

        Direccion unaDireccion = new DireccionDerecha();
        Direccion otroDireccion = new DireccionArriba();

        Assert.assertFalse(unaDireccion.equals(otroDireccion));
    }

    @Test
    public void testLasDireccionesIzquieraYArribaDeberianSerDistintos() {

        Direccion unaDireccion = new DireccionIzquierda();
        Direccion otroDireccion = new DireccionArriba();

        Assert.assertFalse(unaDireccion.equals(otroDireccion));
    }


}
