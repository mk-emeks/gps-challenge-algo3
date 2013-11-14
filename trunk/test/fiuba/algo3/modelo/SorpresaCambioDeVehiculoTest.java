package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

public class SorpresaCambioDeVehiculoTest {

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }


    @Test
    public void testDeberiaCrearLaSorpresaConUnaPosicion() {
        Posicion unaPosicion = new Posicion(2,2);
        SorpresaCambioDeVehiculo unaSorpresa = new SorpresaCambioDeVehiculo(unaPosicion);

            Assert.assertEquals(unaSorpresa.getPosicion(),unaPosicion);
        }

    /** por ser posicionable la sorpresa **/
    @Test
    public void testDeberiaPonerseEnElMapa() throws Exception {

        Posicion unaPosicion = new Posicion(2,2);
        SorpresaCambioDeVehiculo unaSorpresa = new SorpresaCambioDeVehiculo(unaPosicion);

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();

        unaSorpresa.posicionarEnElMapa();

        Assert.assertTrue(Mapa.getMapa().estaUbicado(unaSorpresa));

    }

    @Test
    public void testCambiarElEstadoDeAutoPorElDe4x4() {

        Posicion unaPosicion = new Posicion(2,2);
        SorpresaCambioDeVehiculo unaSorpresa = new SorpresaCambioDeVehiculo(unaPosicion);
        Estado estadoInicial = new EstadoAuto();
        Estado estadoFinal = new Estado4x4();


        Vehiculo unVehiculo = new Vehiculo(unaPosicion,new DireccionDerecha(),estadoInicial);
        Piloto pilotin = new Piloto(unVehiculo);

        unaSorpresa.aplicarA(pilotin ,(EstadoAuto)pilotin.getVehiculo().getEstado());
        Assert.assertEquals(estadoFinal,pilotin.getVehiculo().getEstado());

    }

    @Test
    public void testCambiarElEstadoDeMotoPorElDeAuto() {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaCambioDeVehiculo(unaPosicion);
        Estado estadoInicial = new EstadoMoto();
        Estado estadoFinal = new EstadoAuto();


        Vehiculo unVehiculo = new Vehiculo(unaPosicion,new DireccionDerecha(),estadoInicial);
        Piloto pilotin = new Piloto(unVehiculo);

        unaSorpresa.aplicarA(pilotin ,(EstadoMoto)pilotin.getVehiculo().getEstado());
        Assert.assertEquals(estadoFinal,pilotin.getVehiculo().getEstado());

    }

    @Test
    public void testCambiarElEstadoDe4x4PorElDeMoto() {

        Posicion unaPosicion = new Posicion(2,2);
        Sorpresa unaSorpresa = new SorpresaCambioDeVehiculo(unaPosicion);
        Estado estadoInicial = new Estado4x4();
        Estado estadoFinal = new EstadoMoto();


        Vehiculo unVehiculo = new Vehiculo(unaPosicion,new DireccionDerecha(),estadoInicial);
        Piloto pilotin = new Piloto(unVehiculo);

        unaSorpresa.aplicarA(pilotin ,(Estado4x4)pilotin.getVehiculo().getEstado());
        Assert.assertEquals(estadoFinal,pilotin.getVehiculo().getEstado());

    }


}
