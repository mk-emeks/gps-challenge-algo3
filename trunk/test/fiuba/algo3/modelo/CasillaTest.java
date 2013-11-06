package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class CasillaTest {

    @Test
    public void testDeberiaAgregarUnContenido() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCalle estado = new EstadoCalle();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertTrue(casilla.estaOcupada());
    }

    @Test
    public void testDeberiaQuitarUnContenido() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCalle estado = new EstadoCalle();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertTrue(casilla.estaOcupada());

        casilla.sacarContenido();
        Assert.assertFalse(casilla.estaOcupada());
    }

    @Test
    public void testNoDeberiaAgregarElContenidoEnCasillaCuadra() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCuadra estado = new EstadoCuadra();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertFalse(casilla.estaOcupada());
    }


}
