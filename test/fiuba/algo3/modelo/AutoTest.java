package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class AutoTest {

    @Test
    public void testDeberiaCrearElAutoConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);

        Assert.assertEquals(posicion,auto.getPosicion());
    }

    @Test
    public void testDeberiaCrearElAutoConLaDireccionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);

        Assert.assertEquals(direccion,auto.getDireccion());
    }

    @Test
    public void testDeberiaColocarElVehiculoEnElTablero() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        auto.ponerEn(unTablero);

        Assert.assertTrue(unTablero.getCasilla(1, 2).contiene(auto));
    }

    @Test
    public void testNoDeberiaColocarElVehiculoEnElTableroPorSerCasillaCuadra() {
        Posicion posicion = new Posicion(0,0);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        auto.ponerEn(unTablero);

        Assert.assertFalse(unTablero.getCasilla(0, 0).contiene(auto));
    }

}
