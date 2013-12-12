package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControlPolicialTest {

    Mapa unMapa;

    @Before
    public void setUp() {
        unMapa = Mapa.getMapa();
    }

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void testDeberiaCrearUnControlPolicialConUnaDeterminadaPosicion() {
        Posicion unaPosicion = new Posicion(3,15);
        ControlPolicial unControl = new ControlPolicial(new Posicion(3,15));

        Assert.assertTrue(unControl.getPosicion().equals(unaPosicion));
        Assert.assertEquals(3, unControl.cantidadDeTurnosPenalizado());
    }

    @Test
    public void testDeberiaCrearUnControlPolicialConUnaDeterminadaPosicionYUbicarloEnUnMapa() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        ControlPolicial unControl = new ControlPolicial(new Posicion(2,2));
        unControl.posicionarEnElMapa();

        Assert.assertTrue(unMapa.estaUbicado(unControl));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnControlPolicialEnUnaPosicionFueraDelMapa() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        ControlPolicial unControl = new ControlPolicial(new Posicion(4,4));

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unControl.posicionarEnElMapa();
    }

    @Rule
    public ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnControlPolicialEnUnaPosicionCuadra() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        ControlPolicial unControl = new ControlPolicial(new Posicion(1,1));

        thrown1.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unControl.posicionarEnElMapa();
    }

    /** Los test que restan sobre el funcionamiento de la clase, dependen de un mecanismo random,
     *  preferimos no hacerlos por el hecho de no contar con las herramientas adecuadas, igualmente
     *  esta clase fue probada manualmente una vez realizada la vista.
     */

}
