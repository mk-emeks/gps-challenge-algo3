package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CronometroTest {

    Cronometro cronometroDePueba;

    @Before
    public void setUp() {
        cronometroDePueba = new Cronometro();
    }

    @Test
    public void testDeberiaMarcar5Segundos() {

        this.cronometroDePueba.iniciar();
        try
        {
            Thread.currentThread().sleep(5000);
        } catch (Exception e) {}

        this.cronometroDePueba.devolverTiempoComoString();

    }

}
