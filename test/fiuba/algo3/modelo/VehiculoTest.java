package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class VehiculoTest {

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
    public void testDeberiaQuedarCreadoVehiculoConPosicionYDireccion() {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();

        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        Assert.assertTrue(unVehiculo.getPosicion().equals(unaPosicion));
        Assert.assertTrue(unVehiculo.getDireccion().equals(derecha));
    }

    @Test
    public void testDeberiaQuedarCreadoVehiculoConPosicionDireccionYEstado() {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        EstadoAuto soyAuto = new EstadoAuto();

        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha , soyAuto);

        Assert.assertTrue(unVehiculo.getPosicion().equals(unaPosicion));
        Assert.assertTrue(unVehiculo.getDireccion().equals(derecha));
        Assert.assertEquals(unVehiculo.getEstado(),soyAuto);
    }


    private void mapaDePrueba() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(3,3); // creo mapa de prueba de 3x3

    }

    @Test
    public void testDeberiaPonerAlVehiculoEnUnMapa() throws Exception {

        this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        unVehiculo.poner();

        Assert.assertTrue(map.estaUbicado(unVehiculo));
    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none();
    @Test
    public void testNoDeberiaPonerAlVehiculoEnUnMapaYaQueLaPosicionEsInvalida() throws Exception {

        this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unVehiculo.poner();
    }

    @Test
    public void testDeberiaMoverAlVehiculoEnUnMapa() throws Exception {

        this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        unVehiculo.poner();
        Assert.assertTrue(map.estaUbicado(unVehiculo));

        unVehiculo.mover();
        Assert.assertTrue(map.estaUbicado(unVehiculo));
        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(2,2)));
    }

    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testNoDeberiaMoverAlVehiculoEnUnMapaYaQueLaDireccionEsInvalidadRespectoALaPosicionDondeSeEncuentra() throws Exception {

        this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion arriba = new DireccionArriba();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , arriba);

        unVehiculo.poner();
        Assert.assertTrue(map.estaUbicado(unVehiculo));

        thrown1.expect(NoSePuedeMoverEnElMapaElMovibleException.class);
        unVehiculo.mover();

        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(1,2))); // creo que no llega a ejecutarse.. :S
    }
}