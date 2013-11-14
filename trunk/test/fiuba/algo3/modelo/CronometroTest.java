package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class CronometroTest {

    /**Clase complicada de testear, al parecer anda bastante bien para el uso que necesitamos
     * El resultado global puede variar con diferentes tiempos por la calibracion, error de segundos (+-1, +--2 aprox)
     */

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

    @Test
    public void testDeberiaPausarse() throws Exception {

        int numeroRandom = this.RandomInt012();
        this.cronometroDePueba.iniciar();
        Thread.currentThread().sleep(numeroRandom*1000);
        this.cronometroDePueba.pausar();

        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());

        Thread.currentThread().sleep(1000);
        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());
    }

    @Test
    public void testDeberiaReanudarse() throws Exception {

        int numeroRandom = this.RandomInt012();
        this.cronometroDePueba.iniciar();
        Thread.currentThread().sleep(numeroRandom*1000);
        this.cronometroDePueba.pausar();

        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());

        Thread.currentThread().sleep(1000);
        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());

        this.cronometroDePueba.reanudar();
        Thread.currentThread().sleep(1000);
        Assert.assertEquals(numeroRandom+1,this.cronometroDePueba.tiempoEnSegundos());
    }

    @Test
    public void testDeberiaResetiarse() throws Exception {

        int numeroRandom = this.RandomInt012();
        this.cronometroDePueba.iniciar();
        Thread.currentThread().sleep(numeroRandom*1000);

        Assert.assertEquals(numeroRandom,this.cronometroDePueba.tiempoEnSegundos());

        this.cronometroDePueba.reset();
        Thread.currentThread().sleep(1000);
        Assert.assertEquals(0,this.cronometroDePueba.tiempoEnSegundos());
    }


   @Test
    public void testDeberiaPoderIncrementarUnPorcentajeDeTiempo() throws Exception {

       int numeroRandom = this.RandomInt012();
       this.cronometroDePueba.iniciar();
       Thread.currentThread().sleep(numeroRandom*1000);

        this.cronometroDePueba.variarPorcentaje(20);

        Assert.assertEquals(numeroRandom+((numeroRandom*20)/100),this.cronometroDePueba.tiempoEnSegundos());
    }

}
