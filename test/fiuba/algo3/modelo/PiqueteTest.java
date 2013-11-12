package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

public class PiqueteTest {

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaCrearUnPozoConLaUnaPosicionYSuPenalizacion() {
        Posicion unaPosicion = new Posicion(2,2);
        Piquete unPiquete = new Piquete(unaPosicion);

        Assert.assertEquals(unPiquete.getPosicion().getPosicionX(), 2);
        Assert.assertEquals(unPiquete.getPosicion().getPosicionY(),2);
    }
}
