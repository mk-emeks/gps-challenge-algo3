/**package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class VehiculoTest {

    @Test
    public void TestDeberiaQuedarCreadoVehiculoConPosicionYDireccion() {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();

        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        Assert.assertTrue(unVehiculo.getPosicion().equals(unaPosicion));
        Assert.assertTrue(unVehiculo.getDireccion().equals(derecha));

    }

    @Test
    public void TestDeberiaQuedarCreadoVehiculoConPosicionDireccionYEstado() {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        EstadoAuto soyAuto = new EstadoAuto();

        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha , soyAuto);

        Assert.assertTrue(unVehiculo.getPosicion().equals(unaPosicion));
        Assert.assertTrue(unVehiculo.getDireccion().equals(derecha));
        Assert.assertEquals(unVehiculo.getEstado(),soyAuto);
    }


    private Mapa mapaDePrueba() throws Exception {

        Mapa map = new Mapa();
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(map,3,3); // creo mapa de prueba de 3x3
        return map;

    }

    @Test
    public void TestDeberiaPonerAlVehiculoEnUnMapa() throws Exception {

        Mapa map = this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        unVehiculo.ponerEn(map);

        Assert.assertTrue(map.estaUbicado(unVehiculo));

    }

    @Rule
    public  ExpectedException thrown = ExpectedException.none();
    @Test
    public void TestNoDeberiaPonerAlVehiculoEnUnMapaYaQueLaPosicionEsInvalida() throws Exception {

        Mapa map = this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,1);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unVehiculo.ponerEn(map);

    }

    @Test
    public void TestDeberiaMoverAlVehiculoEnUnMapa() throws Exception {

        Mapa map = this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion derecha = new DireccionDerecha();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , derecha);

        unVehiculo.ponerEn(map);
        Assert.assertTrue(map.estaUbicado(unVehiculo));

        unVehiculo.moverEn(map);
        Assert.assertTrue(map.estaUbicado(unVehiculo));
        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(2,2)));

    }

    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void TestNoDeberiaMoverAlVehiculoEnUnMapaYaQueLaDireccionEsInvalidadRespectoALaPosicionDondeSeEncuentra() throws Exception {

        Mapa map = this.mapaDePrueba();
        Posicion unaPosicion = new Posicion(1,2);
        Direccion arriba = new DireccionArriba();
        Vehiculo unVehiculo = new Vehiculo(unaPosicion , arriba);

        unVehiculo.ponerEn(map);
        Assert.assertTrue(map.estaUbicado(unVehiculo));

        thrown1.expect(NoSePuedeMoverEnElMapaElMovibleException.class);
        unVehiculo.moverEn(map);

        Assert.assertTrue(unVehiculo.getPosicion().equals(new Posicion(1,2))); // creo que no llega a ejecutarse.. :S

    }
}
   **/