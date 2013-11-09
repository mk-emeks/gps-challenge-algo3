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
    public void TestDeberiaAgregarUnaPosicionable() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionDerecha());
        map.agregar(auto);
        Assert.assertTrue(map.estaUbicado(auto));

    }

    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void TestDeberiaLanzarExcepcionAlAgregarDeVueltaElMismoPosicionable() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));

        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionDerecha());
        map.agregar(auto);
        Assert.assertTrue(map.estaUbicado(auto));

        thrown1.expect(ElPosicionableYaEstaUbicadoEnElMapaException.class);
        map.agregar(auto);

    }

    @Rule
    public  ExpectedException thrown2 = ExpectedException.none();
    @Test
    public void TestDeberiaLanzarExcepcionAlAgregarUnPosicionableEnUnPosicionQueNoExisteEnElMapa() throws Exception {

        this.setUp();
        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionDerecha());

        thrown2.expect(LaPosicionNoExisteEnElMapaException.class);
        map.agregar(auto);

    }

    /** prueba chanta: el mover para el tablero tiene sentido si la poscion no esta
     * es como que el mismo te deje moverte donde quieras mientras sea posible **/
    @Test
    public void TestDeberiaMoverUnMovibleEnElMapa() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);
        map.agregar(unaPosicion);
        map.agregar(otraPosicion);

        Assert.assertTrue(map.existe(unaPosicion));
        Assert.assertTrue(map.existe(otraPosicion));

        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionAbajo());
        map.agregar(auto);

        Assert.assertTrue(map.estaUbicado(auto));

        auto.setPosicion(auto.getPosicion().sumar(auto.getDireccion().devolverComoPosicion())); //esto haria el moverEn del auto
        map.mover(auto);

        Assert.assertTrue(map.estaUbicado(auto));

    }

    @Rule
    public  ExpectedException thrown3 = ExpectedException.none();
    @Test
    public void TestDeberiaLanzarExcepcionAlIntentarMoverUnMovibleEnElMapaHaciaUnaPosicionQueNoExiste() throws Exception {

        this.setUp();
        Posicion unaPosicion = new Posicion(1,1);
        map.agregar(unaPosicion);
        Assert.assertTrue(map.existe(unaPosicion));


        Vehiculo auto = new Vehiculo(new Posicion(1,1),new DireccionAbajo());
        map.agregar(auto);

        Assert.assertTrue(map.estaUbicado(auto));

        auto.setPosicion(auto.getPosicion().sumar(auto.getDireccion().devolverComoPosicion())); //esto haria el moverEn del auto
        thrown3.expect(LaPosicionNoExisteEnElMapaException.class);
        map.mover(auto);

    }


}
