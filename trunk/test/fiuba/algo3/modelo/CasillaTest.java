package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CasillaTest {

    /** si heredo 'LaCasillaNoEsAlojable' de Excepcion; aunque no se lanze la excepcion tiene que estar contemplada en
     *  la prueba
     * **/
    @Test
    public void testDeberiaAgregarUnContenido() throws LaCasillaNoEsAlojable {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCalle estado = new EstadoCalle();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertTrue(casilla.estaOcupada());
    }


    @Test
    public void testDeberiaQuitarUnContenido() throws LaCasillaNoEsAlojable {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCalle estado = new EstadoCalle();
        Casilla casilla = new Casilla(posicion,estado);
        casilla.agregarContenido(auto);

        Assert.assertTrue(casilla.estaOcupada());

        casilla.sacarContenido();
        Assert.assertFalse(casilla.estaOcupada());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testNoDeberiaAgregarElContenidoEnCasillaCuadra() throws LaCasillaNoEsAlojable {
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        Auto auto = new Auto(direccion,posicion);
        EstadoCuadra estado = new EstadoCuadra();
        Casilla casilla = new Casilla(posicion,estado);

        thrown.expect(LaCasillaNoEsAlojable.class);
        casilla.agregarContenido(auto);

        Assert.assertFalse(casilla.estaOcupada());  //llega a esta linea?
    }


}
