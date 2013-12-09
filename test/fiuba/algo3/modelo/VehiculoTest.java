/**package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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
    public void testDeberiaQuedarCreadoVehiculoConPosicionDireccionYEstado() {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        EstadoMoto unEstadoMoto = new EstadoMoto();

        Vehiculo unVehiculo = new Vehiculo(unaPosicion,derecha,unEstadoMoto);

        Assert.assertTrue(unVehiculo.getPosicion().equals(unaPosicion));
        Assert.assertTrue(unVehiculo.getDireccion().equals(derecha));
        Assert.assertEquals(unEstadoMoto,unVehiculo.getEstado());
    }

    @Test
    public void testDeberiaPonerAlVehiculoEnUnMapa() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        EstadoAuto unEstadoAuto = new EstadoAuto();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion,derecha,unEstadoAuto);

        unVehiculo.posicionarEnElMapa();

        Assert.assertEquals(map.getVehiculo(),unVehiculo);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testNoDeberiaPonerAlVehiculoEnUnMapaYaQueLaPosicionEsInvalida() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        EstadoAuto unEstadoAuto = new EstadoAuto();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion,derecha,unEstadoAuto);

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unVehiculo.posicionarEnElMapa();
    }

    @Test
    public void testDeberiaMoverAlVehiculoEnUnMapa() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        Estado4x4 unEstado4x4 = new Estado4x4();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion,derecha,unEstado4x4);

        unVehiculo.posicionarEnElMapa();
        Assert.assertEquals(map.getVehiculo(),unVehiculo);

        unVehiculo.mover();
        Assert.assertEquals(map.getVehiculo(),unVehiculo);
        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(2,2)));
    }

    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testNoDeberiaMoverAlVehiculoEnUnMapaYaQueLaDireccionEsInvalidadRespectoALaPosicionDondeSeEncuentra() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion arriba = new DireccionArriba();
        EstadoAuto unEstadoAuto = new EstadoAuto();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion,arriba,unEstadoAuto);

        unVehiculo.posicionarEnElMapa();
        Assert.assertEquals(map.getVehiculo(),unVehiculo);

        thrown1.expect(NoSePuedeMoverEnElMapaElMovibleException.class);
        unVehiculo.mover();

        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(1,2))); // creo que no llega a ejecutarse.. :S
    }
}**/