package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

public class SorpresaFavorableTest {

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaCrearLaSorpresaConUnaPosicion() {
        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaFavorable(unaPosicion);

        Assert.assertEquals(unaSorpresa.getPosicion(),unaPosicion);
    }

    /** por ser posicionable la sorpresa **/
    @Test
    public void testDeberiaPonerseEnElMapa() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaFavorable(unaPosicion);

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();

        unaSorpresa.posicionarEnElMapa();

        Assert.assertTrue(Mapa.getMapa().estaUbicado(unaSorpresa));

    }

    @Test
    public void testDeberiaRestarleTiempoAlCronometro() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaFavorable(unaPosicion);

        Piloto schumy = new Piloto();
        schumy.getCronometro().iniciar();
        schumy.getCronometro().pausar();

        int tiempoPrueba = 500;
        int tiempoRestado = (int)(tiempoPrueba*0.2);

        schumy.getCronometro().sumarSegundos(tiempoPrueba);
        unaSorpresa.aplicarA(schumy); // -20%

        Assert.assertTrue(schumy.getCronometro().tiempoEnSegundos() == (tiempoPrueba-tiempoRestado));

    }

}
