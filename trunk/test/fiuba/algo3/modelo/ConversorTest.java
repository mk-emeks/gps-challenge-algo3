package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class ConversorTest {

    @Test
    public void testDeberiaConvertirSegundosAHoras() {

        Conversor unConversor = new Conversor();
        int segundos = 23548;

        Assert.assertEquals(6,unConversor.convertirSegundosAHoras(segundos));
    }

    @Test
    public void testDeberiaConvertirSegundosAMinutos() {

        Conversor unConversor = new Conversor();
        int segundos = 589415;

        Assert.assertEquals(9823,unConversor.convertirSegundosAMinutos(segundos));
    }

    @Test
    public void testDeberiaConvertirHorasASegundos() {

        Conversor unConversor = new Conversor();
        int horas = 9;

        Assert.assertEquals(32400,unConversor.convertirHorasASegundos(horas));
    }

    @Test
    public void testDeberiaConvertirMinutosASegundos() {

        Conversor unConversor = new Conversor();
        int minutos = 5498;

        Assert.assertEquals(329880,unConversor.convertirMinutosASegundos(minutos));
    }

    @Test
    public void testDeberiaDevolverElTiempoComoString() {

        Conversor unConversor = new Conversor();
        int segundos = 54475;

        Assert.assertEquals("15:07:55", unConversor.devolverTiempoComoString(segundos));

    }

}
