package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MapaTest {

    Mapa map;

    protected void setUp() throws Exception {

    map = new Mapa();

    }

    @Test
    public void TestDeberiaAgregarUnaPosicion() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);

        Assert.assertTrue(map.existe(unaPosicion));


    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none();
    @Test
    public void TestDeberiaLanzarExcepcionAlAgregarDeVueltaLaMismaUnaPosicion() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        thrown.expect(LaPosicionYaExisteEnElMapaException.class);
        map.agregar(unaPosicion);

    }

    @Test
    public void TestDeberiaUbicarUnPosicionable() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionDerecha());
        map.ubicar(auto);
        Assert.assertTrue(map.estaUbicado(auto));

    }

    @Rule
    public  ExpectedException thrown2 = ExpectedException.none();
    @Test
    public void TestDeberiaLanzarExcepcionAlUbicarUnPosicionableEnUnPosicionQueNoExisteEnElMapa() throws Exception {

        this.setUp();
        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionDerecha());

        thrown2.expect(LaPosicionNoExisteEnElMapaException.class);
        map.ubicar(auto);

    }

}
