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

    public int RandomInt012() {

        int randomInt = 0;
        double randomDouble = Math.random();

        if ( randomDouble < 0.33)  {
            randomInt = 0;
        }
        if ( (randomDouble>= 0.33) && (randomDouble < 0.66)) {
            randomInt = 1;
        }
        if ( randomDouble >= 0.66)  {
            randomInt = 2;
        }
        return randomInt;
    }

    @Test
    public void testDeberiaMarcarLosSegundosQuePasen() throws Exception {

        int numeroRandom = this.RandomInt012();
        this.cronometroDePueba.iniciar();
        Thread.currentThread().sleep(numeroRandom*1000);
        this.cronometroDePueba.pausar();

        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());

    }


}
