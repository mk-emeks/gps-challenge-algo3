package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class EnsambladorTest {

    /**probamos los casos bordes **/
    @Test
    public void testDeberiaQuedarEnsambladoElTableroMasPequeñoPermitidoDeFormaSimple() {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecho = new DireccionDerecha();
        Direccion izquierdo = new DireccionIzquierda();
        Ensamblador unEnsablador = new Ensamblador();
        Tablero unTablero = new Tablero (2,2);

        unEnsablador.ensambleSimpleDeTablero(unTablero);

        Casilla casillaEnsamblada = unTablero.getCasilla(1,1);
        Casilla unVecino = unTablero.getCasilla(1,2);
        Casilla otroVecino = unTablero.getCasilla(2,1);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(2,1);
        unVecino = unTablero.getCasilla(2,2);
        otroVecino = unTablero.getCasilla(1,2);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(1,2);
        unVecino = unTablero.getCasilla(1,1);
        otroVecino = unTablero.getCasilla(2,2);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),unVecino);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),otroVecino);

        casillaEnsamblada = unTablero.getCasilla(2,2);
        unVecino = unTablero.getCasilla(1,2);
        otroVecino = unTablero.getCasilla(2,1);
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

        Casilla casillaEnsamblada = unTablero.getCasilla(2,2);
        Casilla vecinoDerecho = unTablero.getCasilla(1,2);
        Casilla vecinoIzquierdo = unTablero.getCasilla(3,2);
        Casilla vecinoArriba = unTablero.getCasilla(2,1);
        Casilla vecinoAbajo = unTablero.getCasilla(2,3);

        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(derecho),vecinoDerecho);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(izquierdo),vecinoIzquierdo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(abajo),vecinoAbajo);
        Assert.assertEquals(casillaEnsamblada.devolverSiguiente(arriba),vecinoArriba);

    }
}
