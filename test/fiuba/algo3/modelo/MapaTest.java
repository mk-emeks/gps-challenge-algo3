package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MapaTest {

    Mapa map;

    @Before
    public void setUp() {
        map = Mapa.getMapa();
    }

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaAgregarUnaPosicion() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);

        Assert.assertTrue(map.existe(unaPosicion));


    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanzarExcepcionAlAgregarDeVueltaLaMismaUnaPosicion() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        thrown.expect(LaPosicionYaExisteEnElMapaException.class);
        map.agregar(unaPosicion);

    }

    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarExcepcionAlAgregarDeVueltaLaMismaPosicion() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        thrown1.expect(LaPosicionYaExisteEnElMapaException.class);
        map.agregar(new Posicion(1,1));

    }

    @Test
    public void testDeberiaUbicarLaLlegada() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Posicion llegada = new Posicion(1,1);
        map.ubicar(unaPosicion);
        Assert.assertEquals(map.getLlegada(),llegada);

    }

    @Rule
    public  ExpectedException thrown2 = ExpectedException.none();
    @Test
    public void testNoDeberiaUbicarLaLlegadaYaQueSuPosicionNoEsValida() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Posicion llegada = new Posicion(1,3);

        thrown2.expect(LaPosicionNoExisteEnElMapaException.class);
        map.ubicar(llegada);


    }

    @Test
    public void testDeberiaUbicarAlVehiculo() throws Exception {

        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Vehiculo auto = new Auto(new Posicion(1,1),new DireccionDerecha());
        map.ubicar(auto);
        Assert.assertEquals(map.getVehiculo(),auto);

    }

    @Rule
    public  ExpectedException thrown3 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarExcepcionAlUbicarUnPosicionableEnUnPosicionQueNoExisteEnElMapa() throws Exception {

        Vehiculo auto = new Auto(new Posicion(1,1),new DireccionDerecha());

        thrown3.expect(LaPosicionNoExisteEnElMapaException.class);
        map.ubicar(auto);
    }

    /** los aplicables no estan probados: metodo ubicar(Aplicable) **/


}
