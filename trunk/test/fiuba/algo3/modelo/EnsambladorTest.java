package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class EnsambladorTest {

    /**probamos el caso del tablero minimo **/
    @Test
    public void testDeberiaQuedarEnsambladoElTableroMasPequeñoPermitidoDeFormaSimple() {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecho = new DireccionDerecha();
        Direccion izquierdo = new DireccionIzquierda();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (2,2);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(0,0);
        Casilla unVecino = unTablero.getCasilla(0,1);
        Casilla otroVecino = unTablero.getCasilla(1,0);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(1,0);
        unVecino = unTablero.getCasilla(1,1);
        otroVecino = unTablero.getCasilla(0,0);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(0,1);
        unVecino = unTablero.getCasilla(0,0);
        otroVecino = unTablero.getCasilla(1,1);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(1,1);
        unVecino = unTablero.getCasilla(1,0);
        otroVecino = unTablero.getCasilla(0,1);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),otroVecino);

    }

    /** probamos el caso en el medio **/
    @Test
    public void testDeberiaQuedarEnsambladoElTableroDeFormaSimpleTalQueLaCasillaDelMedioTuvieseSusRespectivos4Siguientes() {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecho = new DireccionDerecha();
        Direccion izquierdo = new DireccionIzquierda();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (3,3);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(1,1);
        Casilla vecinoDerecho = unTablero.getCasilla(2,1);
        Casilla vecinoIzquierdo = unTablero.getCasilla(0,1);
        Casilla vecinoArriba = unTablero.getCasilla(1,0);
        Casilla vecinoAbajo = unTablero.getCasilla(1,2);

        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),vecinoDerecho);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),vecinoIzquierdo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),vecinoAbajo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),vecinoArriba);


    }

    /** probamos el caso del borde derecho horizontal **/
    @Test
    public void testDeberiaQuedarEnsambladoElTableroDeFormaSimpleTalQueLaCasillaDelBordeDerechoTuvieseSusRespectivos3Siguientes() {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecho = new DireccionDerecha();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (3,3);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(0,1);
        Casilla vecinoDerecho = unTablero.getCasilla(1,1);
        Casilla vecinoArriba = unTablero.getCasilla(0,0);
        Casilla vecinoAbajo = unTablero.getCasilla(0,2);

        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),vecinoDerecho);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),vecinoAbajo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),vecinoArriba);
    }

    /** probamos el caso del borde de arriba  **/
    @Test
    public void testDeberiaQuedarEnsambladoElTableroDeFormaSimpleTalQueLaCasillaDelBordeDeArribaTuvieseSusRespectivos3Siguientes() {

        Direccion abajo = new DireccionAbajo();
        Direccion derecho = new DireccionDerecha();
        Direccion izquierdo = new DireccionIzquierda();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (3,3);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(1,0);
        Casilla vecinoDerecho = unTablero.getCasilla(2,0);
        Casilla vecinoIzquierdo = unTablero.getCasilla(0,0);
        Casilla vecinoAbajo = unTablero.getCasilla(1,1);

        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),vecinoDerecho);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),vecinoIzquierdo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),vecinoAbajo);

    }

    @Test
    public void testLaCasillaNoDeberiaTenerUnVecinoQueNoFueseConsecutivoEnElEnsableSimpleDeTablero() {


        Direccion derecho = new DireccionDerecha();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (3,3);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(1,1);
        Casilla vecinoAbajo = unTablero.getCasilla(1,2);

        Assert.assertNotSame(casillaEnsamblada.devolverSiguiente(derecho),vecinoAbajo);

    }

}
