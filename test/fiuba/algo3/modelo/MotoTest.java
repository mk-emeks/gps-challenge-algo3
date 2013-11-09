package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MotoTest {

    @Test
    public void testDeberiaCrearLaMotoConLaPosicionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(posicion,direccion);

        Assert.assertEquals(posicion, moto.getPosicion());
    }

    @Test
    public void testDeberiaCrearLaMotoConLaDireccionIndicada() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Moto moto = new Moto(posicion,direccion);

        Assert.assertEquals(direccion,moto.getDireccion());
    }

    //* CAMINO FELIZ CUANDO SE PONE UN VEHICULO*//

    @Test
    public void testDeberiaPonerElVehiculoEnElMapa() throws NoSePuedeAgregarEnElMapaElPosicionableException, LaPosicionYaExisteEnElMapaException {

        Mapa mapa = new Mapa();
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(mapa,10,10);
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionAbajo();
        Moto moto = new Moto(posicion,direccion);
        moto.ponerEn(mapa);

        Assert.assertTrue(mapa.estaUbicado(moto));
    }


    //*CAMINO MALO CUANDO SE PONE UN VEHICULO*//
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanazarExcepcionAlPonerElVehiculoEnElMapaPorSerUnaPosicionInvalida() throws NoSePuedeAgregarEnElMapaElPosicionableException, LaPosicionYaExisteEnElMapaException {

        Mapa mapa = new Mapa();
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(mapa,10,10);
        Posicion posicion = new Posicion(1,1);
        Direccion direccion = new DireccionAbajo();
        Moto moto = new Moto(posicion,direccion);

        thrown.expect(NoSePuedeAgregarEnElMapaElPosicionableException.class);
        moto.ponerEn(mapa);
    }
}
