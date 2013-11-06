package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class MotoTest {

    @Test
    public void testDeberiaCrearLaMotoConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(direccion,posicion);

        Assert.assertEquals(posicion,moto.getPosicion());
    }

    @Test
    public void testDeberiaCrearLaMotoConLaDireccionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(direccion,posicion);

        Assert.assertEquals(direccion,moto.getDireccion());
    }

    @Test
    public void testDeberiaColocarElVehiculoEnElTablero() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(direccion,posicion);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        moto.ponerEn(unTablero);

        Assert.assertTrue(unTablero.getCasilla(1, 2).contiene(moto));
    }

    @Test
    public void testNoDeberiaColocarElVehiculoEnElTableroPorSerCasillaCuadra() {
        Posicion posicion = new Posicion(0,0);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(direccion,posicion);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        moto.ponerEn(unTablero);

        Assert.assertFalse(unTablero.getCasilla(0, 0).contiene(moto));
    }

    /** test de movimiento **/
    @Test
    public void testDeberiaMoverseEnLaDireccionRequerida() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(direccion,posicion);
        Tablero unTablero = new Tablero(4,4);
        EditorTablero unEditor = new EditorTablero();
        unEditor.darFormatoSimpleA(unTablero);

        moto.ponerEn(unTablero);
        Assert.assertTrue(unTablero.getCasilla(1,2).contiene(moto));
        Assert.assertFalse(unTablero.getCasilla(1,3).estaOcupada());

        moto.moverEn(unTablero, new DireccionAbajo());
        Assert.assertTrue(unTablero.getCasilla(1,3).contiene(moto));
        Assert.assertFalse(unTablero.getCasilla(1,2).estaOcupada());
    }

}
