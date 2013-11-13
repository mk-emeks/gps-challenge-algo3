package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PilotoTest {

    Mapa map;
    Piloto piloto = new Piloto();


    @Before
    public void setUp() {
        map = Mapa.getMapa();
    }

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void TestDeberiaConducirUnVehiculoHaciaOtraPosicion() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Vehiculo auto = new Auto(posicion,direccion);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion.sumar(direccion.devolverComoPosicion()));
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionYaQueAunNoArranco() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Vehiculo auto = new Auto(posicion,new DireccionDerecha());
        piloto.asignarVehiculo(auto);

        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion);
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionYaQueLaPosicionSiguienteEsInvalida() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionArriba();
        Vehiculo auto = new Auto(posicion,direccion);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion);
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionUnaVezDetenidoElMismo() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Vehiculo auto = new Auto(posicion,direccion);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion.sumar(direccion.devolverComoPosicion()));

        piloto.detenerVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion.sumar(direccion.devolverComoPosicion()));
    }

}
