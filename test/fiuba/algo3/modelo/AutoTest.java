package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AutoTest {

    @Test
    public void testDeberiaCrearElAutoConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(posicion,direccion);

        Assert.assertEquals(posicion, auto.getPosicion());
    }

    @Test
    public void testDeberiaCrearElAutoConLaDireccionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(posicion,direccion);

        Assert.assertEquals(direccion,auto.getDireccion());
    }

    //* CAMINO FELIZ CUANDO SE PONE UN VEHICULO*//

    @Test
    public void testDeberiaPonerElVehiculoEnElMapa() throws NoSePuedeAgregarEnElMapaElPosicionableException, LaPosicionYaExisteEnElMapaException {

        Mapa mapa = new Mapa();
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(mapa,10,10);
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionAbajo();
        Auto auto = new Auto(posicion,direccion);
        auto.ponerEn(mapa);

        Assert.assertTrue(mapa.estaUbicado(auto));
    }

    //*CAMINO MALO CUANDO SE PONE UN AUTO*//

    @Rule
    public  ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanazarExcepcionAlPonerElVehiculoEnElMapaPorSerUnaPosicionInvalida() throws NoSePuedeAgregarEnElMapaElPosicionableException, LaPosicionYaExisteEnElMapaException {

        Mapa mapa = new Mapa();
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(mapa,10,10);
        Posicion posicion = new Posicion(1,1);
        Direccion direccion = new DireccionAbajo();
        Auto auto = new Auto(posicion,direccion);

        thrown.expect(NoSePuedeAgregarEnElMapaElPosicionableException.class);
        auto.ponerEn(mapa);
    }
}
