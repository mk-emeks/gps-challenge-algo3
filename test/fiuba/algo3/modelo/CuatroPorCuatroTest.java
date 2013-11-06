package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class CuatroPorCuatroTest {

    @Test
    public void testDeberiaCrearLaMotoConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(direccion,posicion);

        Assert.assertEquals(posicion, cuatroPorCuatro.getPosicion());
    }

    @Test
    public void testDeberiaCrearLaMotoConLaDireccionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(direccion,posicion);

        Assert.assertEquals(direccion,cuatroPorCuatro.getDireccion());
    }

    @Test
    public void testDeberiaColocarElVehiculoEnElTablero() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(direccion,posicion);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        cuatroPorCuatro.ponerEn(unTablero);

        Assert.assertTrue(unTablero.getCasilla(1, 2).contiene(cuatroPorCuatro));
    }

    @Test
    public void testNoDeberiaColocarElVehiculoEnElTableroPorSerCasillaCuadra() {
        Posicion posicion = new Posicion(0,0);
        Direccion direccion = new DireccionDerecha();
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro(direccion,posicion);
        Tablero unTablero = new Tablero(12,11);
        Pintor unPintor = new Pintor();
        unPintor.pintarTableroSimple(unTablero);
        cuatroPorCuatro.ponerEn(unTablero);

        Assert.assertFalse(unTablero.getCasilla(0, 0).contiene(cuatroPorCuatro));
    }
}
