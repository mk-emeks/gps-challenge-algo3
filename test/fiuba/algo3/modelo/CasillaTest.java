package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

public class CasillaTest {

    @Test

    /** temporal; su fin era para ir probando por pasos, la verdad que el metodo tenesSiguiente es incesario **/
    public void testDeberiaAgregarseUnaCasillaSiguiente() {

        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);
        Direccion abajo = new DireccionAbajo();
        Direccion arriba = new DireccionArriba();

        Casilla casillaDePrueba = new Casilla(unaPosicion);
        Casilla casillaDeAbajo = new Casilla(otraPosicion);

        casillaDePrueba.agregarSiguiente(casillaDeAbajo,abajo);
        Assert.assertTrue(casillaDePrueba.tenesSiguiente());

    }

    public void testDeberiaDevolverCasillaSiguiente() {

        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);
        Direccion abajo = new DireccionAbajo();
        Direccion arriba = new DireccionArriba();

        Casilla casillaDePrueba = new Casilla(unaPosicion);
        Casilla casillaDeAbajo = new Casilla(otraPosicion);

        casillaDePrueba.agregarSiguiente(casillaDeAbajo,abajo);
        casillaDeAbajo.agregarSiguiente(casillaDePrueba,arriba);

        Assert.assertEquals( casillaDePrueba.devolverSiguiente(abajo) , casillaDeAbajo );
        Assert.assertEquals( casillaDeAbajo.devolverSiguiente(arriba) , casillaDePrueba );
    }

    /** tiene un siguiente, pero no en la direccion que se solicita **/
    public void testDeberiaLanzarExcepcionLaCasillaNoTieneElSiguientePedido() {

        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);

        Direccion abajo = new DireccionAbajo();
        Direccion arriba = new DireccionArriba();

        Casilla casillaDePrueba = new Casilla(unaPosicion);
        Casilla casillaDeAbajo = new Casilla(otraPosicion);

        casillaDePrueba.agregarSiguiente(casillaDeAbajo,abajo);

        /** nose como probar excepciones en java; deberua saltar con la condicion comentada aca abajo**/
        //casillaDePrueba.devolverSiguiente(arriba)

    }

    /** tiene un siguiente, pero no en la direccion que se solicita **/
    public void testDeberiaLanzarExcepcionLaCasillaNoTieneSiguienteEnNingunaDireccion() {

        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);

        Direccion abajo = new DireccionAbajo();


        Casilla casillaDePrueba = new Casilla(unaPosicion);

        /** nose como probar excepciones en java; deberua saltar con la condicion comentada aca abajo**/
        //casillaDePrueba.devolverSiguiente(abajo)
    }


}
