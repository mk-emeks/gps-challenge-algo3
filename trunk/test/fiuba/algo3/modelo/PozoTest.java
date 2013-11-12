package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

public class PozoTest {

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaCrearUnPozoConLaUnaPosicionYSuPenalizacion() {
        Posicion unaPosicion = new Posicion(2,2);
        Pozo unPozo = new Pozo(unaPosicion);

        Assert.assertEquals(unPozo.getPosicion().getPosicionX(),2);
        Assert.assertEquals(unPozo.getPosicion().getPosicionY(),2);
    }

    @Test
    public void testDeberiaPonerseElPozoEnElMapa() {
        //para evitar conflictos, cuando mirko commitea el correcto uso del singleton se hara este test

    }


}
