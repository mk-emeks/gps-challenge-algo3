package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PiqueteTest {

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
    public void testDeberiaCrearUnPiqueteConUnaDeterminadaPosicion() {
        Posicion unaPosicion = new Posicion(5,1);
        Piquete unPiquete = new Piquete(new Posicion(5,1));

        Assert.assertTrue(unPiquete.getPosicion().equals(unaPosicion));
        Assert.assertEquals(2, unPiquete.cantidadDeTurnosPenalizado());
    }

    @Test
    public void testDeberiaCrearUnPiqueteConUnaDeterminadaPosicionYUbicarloEnUnMapa() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Piquete unPiquete = new Piquete(new Posicion(2,2));
        unPiquete.posicionarEnElMapa();

        Assert.assertTrue(unMapa.estaUbicado(unPiquete));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnPiqueteEnUnaPosicionFueraDelMapa() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Piquete unPiquete = new Piquete(new Posicion(4,4));

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unPiquete.posicionarEnElMapa();
    }

    @Rule
    public ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnPiqueteEnUnaPosicionCuadra() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Piquete unPiquete = new Piquete(new Posicion(1,1));

        thrown1.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unPiquete.posicionarEnElMapa();
    }

    @Test
    public void testDeberiaInvertirDireccionAUnVehiculoAuto() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        EstadoAuto unEstadoAuto = new EstadoAuto();

        Vehiculo unAuto = new Vehiculo(posicionInicial, direccion, unEstadoAuto);
        String nombrePiloto = "Pilotin";
        Piloto unPiloto = new Piloto(unAuto,nombrePiloto);
        unAuto.posicionarEnElMapa();
        unPiloto.arrancarVehiculo();

        Piquete unPiquete = new Piquete(new Posicion(2,2));
        unPiquete.posicionarEnElMapa();

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionDerecha()));
        unPiquete.aplicarA(unPiloto, (EstadoAuto)unAuto.getEstado()); //Le aseguro al compilador que es un EstadoAuto

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionIzquierda()));
    }

    @Test
    public void testDeberiaInvertirDireccionAUnVehiculo4x4() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(1,2);
        Direccion direccion = new DireccionAbajo();
        Estado4x4 unEstado4x4 = new Estado4x4();

        Vehiculo unaCamioneta = new Vehiculo(posicionInicial, direccion, unEstado4x4);
        String nombrePiloto = "Pilotin";
        Piloto unPiloto = new Piloto(unaCamioneta,nombrePiloto);
        unaCamioneta.posicionarEnElMapa();
        unPiloto.arrancarVehiculo();

        Piquete unPiquete = new Piquete(new Posicion(2,2));
        unPiquete.posicionarEnElMapa();

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionAbajo()));
        unPiquete.aplicarA(unPiloto, (Estado4x4)unaCamioneta.getEstado()); //Le aseguro al compilador que es un Estado4x4

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionArriba()));
    }

    @Test
    public void testDeberiaPoderPenalizarAUnVehiculoMotoYLuegoDejarloAvanzar() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(2,2);
        Direccion direccion = new DireccionIzquierda();
        EstadoMoto unEstadoMoto = new EstadoMoto();

        Vehiculo unaMoto = new Vehiculo(posicionInicial, direccion, unEstadoMoto);
        String nombrePiloto = "Pilotin";
        Piloto unMotoquero = new Piloto(unaMoto,nombrePiloto);
        unaMoto.posicionarEnElMapa();
        unMotoquero.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unPozo.aplicarA(unMotoquero, (EstadoMoto)unaMoto.getEstado()); //Le aseguro al compilador que es un EstadoMoto
            unMotoquero.conducir();
            Assert.assertTrue(unMotoquero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el piquete **/
        unPozo.aplicarA(unMotoquero, (EstadoMoto)unaMoto.getEstado());
        unMotoquero.conducir();
        Assert.assertTrue(unMotoquero.getVehiculo().getPosicion().equals(new Posicion(1,2)));
    }
}
