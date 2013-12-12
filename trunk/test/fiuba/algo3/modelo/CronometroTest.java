package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CronometroTest {

    //El resultado global puede variar con diferentes tiempos por la calibracion
    //Comento porque a mirko le molesta que cuente mucho el cronometro :p
    Cronometro cronometroDePueba;
    int errorMaximo;
    int errorMinimo;
    Thread hiloTiempo;


    @Before
    public void setUp() {
        cronometroDePueba = new Cronometro();
        hiloTiempo = new Thread(){
            public void run(){
                try {
                    while (!cronometroDePueba.estaEnEjecucion()) {

                        Thread.sleep(850);
                        cronometroDePueba.contar();
                        System.out.println(cronometroDePueba.devolverTiempoComoString());

                    }
                } catch(Exception e){}
            }
        };
    }

    @After
    public void resetear() throws Exception {
        this.cronometroDePueba.reset();
    }

    @Test
    public void testDeberiaMarcarLosSegundosQuePasen() throws Exception {

        this.cronometroDePueba.comenzarCronometro();
        Thread.currentThread().sleep(2000); //Cuenta 10 seg
        this.cronometroDePueba.detenerCronometro();

        //Errores bordes, tiempo transcurrido + - el error del cronometro.
        this.errorMaximo = 2 + this.cronometroDePueba.errorEnSegundos();
        this.errorMinimo = 2 - this.cronometroDePueba.errorEnSegundos();

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);
    }

    @Test
    public void testDeberiaPausarse() throws Exception {

        this.cronometroDePueba.comenzarCronometro();
        Thread.currentThread().sleep(3000); //Transcurren 10 seg
        this.cronometroDePueba.detenerCronometro();

        //Errores bordes, tiempo transcurrido + - el error del cronometro.
        this.errorMaximo = 3 + this.cronometroDePueba.errorEnSegundos();
        this.errorMinimo = 3 - this.cronometroDePueba.errorEnSegundos();

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);

        Thread.currentThread().sleep(2000); //cronometro sigue pausado y deberia seguir valiendo lo mismo

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);
    }

    @Test
    public void testDeberiaReanudarse() throws Exception {

        this.cronometroDePueba.comenzarCronometro();
        Thread.currentThread().sleep(2000); //Transcurren 9 seg
        this.cronometroDePueba.detenerCronometro();

        //Errores bordes, tiempo transcurrido + - el error del cronometro.
        this.errorMaximo = 2 + this.cronometroDePueba.errorEnSegundos();
        this.errorMinimo = 2 - this.cronometroDePueba.errorEnSegundos();

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);

        Thread.currentThread().sleep(1000);  //Sigue pausado
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);

        this.cronometroDePueba.comenzarCronometro();
        Thread.currentThread().sleep(1000); //Reanudo y dejo correr 4 segundos.

        this.errorMaximo = errorMaximo + 1;   //Se acumula el error porque sigue transcurriendo tiempo.
        this.errorMinimo = errorMinimo + 1;

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);
    }

    @Test
    public void testDeberiaResetiarse() throws Exception {

        this.cronometroDePueba.comenzarCronometro();
        Thread.currentThread().sleep(2000); //Cuenta 10 seg
        this.cronometroDePueba.detenerCronometro();

        //Errores bordes, tiempo transcurrido + - el error del cronometro.
        this.errorMaximo = 2 + this.cronometroDePueba.errorEnSegundos();
        this.errorMinimo = 2 - this.cronometroDePueba.errorEnSegundos();

        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
        Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);

        this.cronometroDePueba.reset();
        Thread.currentThread().sleep(1000); //Transcurre mas tiempo pero como esta reseteado deberia ser 0 el tiempo.

        Assert.assertEquals(0,this.cronometroDePueba.tiempoEnSegundos());
    }


    @Test
    public void testDeberiaPoderIncrementarUnPorcentajeDeTiempo() throws Exception {

       this.cronometroDePueba.comenzarCronometro();
       Thread.currentThread().sleep(2000); //Pasan 10 seg

       //Errores bordes, tiempo transcurrido + - el error del cronometro.
       this.errorMaximo = 2 + this.cronometroDePueba.errorEnSegundos();
       this.errorMinimo = 2 - this.cronometroDePueba.errorEnSegundos();

       Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
       Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);

       this.cronometroDePueba.variarPorcentaje(20);

       this.errorMaximo = errorMaximo + 2;   //Si pasaron 10 seg deberia sumarle unos 2 seg
       this.errorMinimo = errorMinimo + 2;

       Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) <= errorMaximo);
       Assert.assertTrue((this.cronometroDePueba.tiempoEnSegundos()) >= errorMinimo);
    }

}
