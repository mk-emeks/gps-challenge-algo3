package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;
public class TableroTest {

    @Test
    public void deberiaDevolverLaPosicionDeLaCasillaCorrespondiente() {
        Tablero tablero = new Tablero(12,11);
        int x = 1;
        int y = 1;

        Assert.assertEquals(tablero.getCasilla(x,y).devolverPosicion().getPosicionX(),1);
        Assert.assertEquals(tablero.getCasilla(x,y).devolverPosicion().getPosicionY(),1);
    }

    @Test
    public void deberiaCrearCasillasEnLaUltimaPosicionCorrespondienteSegunLosParametros() {
        Tablero tablero = new Tablero(12,11);
        Assert.assertNotNull(tablero.getCasilla(22,20));

    }

}