package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CasillaTest {

    /** temporal; su fin era para ir probando por pasos, la verdad que el metodo tenesSiguiente es incesario **/
    @Test
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

    @Test
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
    @Rule
    public  ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarExcepcionLaCasillaNoTieneElSiguientePedido() throws LaCasillaNoTieneElSiguientePedido  {

        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);

        Direccion abajo = new DireccionAbajo();
        Direccion arriba = new DireccionArriba();

        Casilla casillaDePrueba = new Casilla(unaPosicion);
        Casilla casillaDeAbajo = new Casilla(otraPosicion);

        casillaDePrueba.agregarSiguiente(casillaDeAbajo,abajo);

        thrown1.expect(LaCasillaNoTieneElSiguientePedido.class);
        casillaDePrueba.devolverSiguiente(arriba);

    }

    /** tiene un siguiente, pero no en la direccion que se solicita **/
    @Rule
    public  ExpectedException thrown2 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarExcepcionLaCasillaNoTieneSiguienteEnNingunaDireccion() throws LaCasillaNoTieneSiguienteEnNingunaDireccion   {

        Posicion unaPosicion = new Posicion(1,1);
        Direccion abajo = new DireccionAbajo();

        Casilla casillaDePrueba = new Casilla(unaPosicion);

        thrown2.expect(LaCasillaNoTieneSiguienteEnNingunaDireccion.class);
        casillaDePrueba.devolverSiguiente(abajo);
    }

    @Test
    public void testDeberiaAgregarUnContenido() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);
        EstadoCalle estado = new EstadoCalle();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertTrue(casilla.estaOcupada());
    }

    @Test
    public void testNoDeberiaAgregarElContenidoEnCasillaCuadra() {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Piloto piloto = new Piloto();
        Auto auto = new Auto(direccion,posicion,piloto);
        EstadoCuadra estado = new EstadoCuadra();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertFalse(casilla.estaOcupada());
    }


}
