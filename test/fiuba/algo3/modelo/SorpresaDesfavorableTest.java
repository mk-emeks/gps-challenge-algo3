
package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

public class SorpresaDesfavorableTest {

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaCrearLaSorpresaConUnaPosicion() {
        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaDesfavorable(unaPosicion);

        Assert.assertEquals(unaSorpresa.getPosicion(), unaPosicion);
    }

    //por ser posicionable la sorpresa
    @Test
    public void testDeberiaPonerseEnElMapa() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaDesfavorable(unaPosicion);

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();

        unaSorpresa.posicionarEnElMapa();

        Assert.assertTrue(Mapa.getMapa().estaUbicado(unaSorpresa));

    }

    @Test
    public void testDeberiaSumarleTiempoAlCronometro() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaDesfavorable(unaPosicion);

        Piloto schumy = new Piloto();

        int tiempoPrueba = 500;
        int tiempoSumado = (int)(tiempoPrueba*0.40);

        schumy.getCronometro().sumarSegundos(tiempoPrueba);
        unaSorpresa.aplicarA(schumy); // +40%

        Assert.assertTrue(schumy.getCronometro().tiempoEnSegundos() == (tiempoPrueba+tiempoSumado));

    }

    @Test
    public void testDeberiaPasarAEstarAplicadaAlSumarleTiempoAlCronometro() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaDesfavorable(unaPosicion);

        Piloto schumy = new Piloto();

        Vehiculo unAuto = new Vehiculo(new Posicion(2,2),new DireccionArriba(),new EstadoAuto());
        schumy.asignarVehiculo(unAuto);

        int tiempoPrueba = 500;

        schumy.getCronometro().sumarSegundos(tiempoPrueba);
        unaSorpresa.actualizar(schumy); // +40%

        Assert.assertTrue(unaSorpresa.aplicado());

    }

}
