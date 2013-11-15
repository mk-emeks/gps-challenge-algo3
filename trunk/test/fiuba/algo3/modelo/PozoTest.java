package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PozoTest {

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
    public void testDeberiaCrearUnPozoConUnaDeterminadaPosicion() {
        Posicion unaPosicion = new Posicion(3,15);
        Pozo unPozo = new Pozo(new Posicion(3,15));

        Assert.assertTrue(unPozo.getPosicion().equals(unaPosicion));
        Assert.assertEquals(3, unPozo.cantidadDeTurnosPenalizado());
    }

    @Test
    public void testDeberiaCrearUnPozoConUnaDeterminadaPosicionYUbicarloEnUnMapa() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        Assert.assertTrue(unMapa.estaUbicado(unPozo));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnPozoEnUnaPosicionFueraDelMapa() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Pozo unPozo = new Pozo(new Posicion(4,4));

        thrown.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unPozo.posicionarEnElMapa();
    }

    @Rule
    public ExpectedException thrown1 = ExpectedException.none();
    @Test
    public void testDeberiaLanzarUnaExceptionAlQuererUbicarUnPozoEnUnaPosicionCuadra() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Pozo unPozo = new Pozo(new Posicion(1,1));

        thrown1.expect(NoSePuedePonerEnElMapaElPosicionableException.class);
        unPozo.posicionarEnElMapa();
    }

    @Test
    public void testDeberiaPoderPenalizarAUnVehiculoAuto() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        EstadoAuto unEstadoAuto = new EstadoAuto();

        Vehiculo unaFerrari = new Vehiculo(posicionInicial, direccion, unEstadoAuto);
        Piloto schumacher = new Piloto(unaFerrari);
        unaFerrari.posicionarEnElMapa();
        schumacher.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unPozo.aplicarA(schumacher, (EstadoAuto)unaFerrari.getEstado()); //Le aseguro al compilador que es un EstadoAuto
            schumacher.conducir();
            Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        unPozo.aplicarA(schumacher, (EstadoAuto)unaFerrari.getEstado());
        schumacher.conducir();
        Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

    @Test
    public void testDeberiaPoderPenalizarAUnVehiculoMoto() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(3,2);
        Direccion direccion = new DireccionIzquierda();
        EstadoMoto unEstadoMoto = new EstadoMoto();

        Vehiculo unaChopper = new Vehiculo(posicionInicial, direccion, unEstadoMoto);
        Piloto metalero = new Piloto(unaChopper);
        unaChopper.posicionarEnElMapa();
        metalero.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unPozo.aplicarA(metalero, (EstadoMoto)unaChopper.getEstado()); //Le aseguro al compilador que es un EstadoMoto
            metalero.conducir();
            Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        unPozo.aplicarA(metalero, (EstadoMoto)unaChopper.getEstado());
        metalero.conducir();
        Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

    @Test
    public void testDeberiaPoderPenalizarAUnVehiculo4x4() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        //Creo un mapa mas grande
        unEditor.editarMapaSimple(6, 3);

        Posicion posicionInicial = new Posicion(6,2);
        Direccion direccion = new DireccionIzquierda();
        Estado4x4 unEstado4x4 = new Estado4x4();

        Vehiculo unaCamioneta = new Vehiculo(posicionInicial, direccion, unEstado4x4);
        Piloto unPiloto = new Piloto(unaCamioneta);
        unaCamioneta.posicionarEnElMapa();
        unPiloto.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unPozo.aplicarA(unPiloto, (Estado4x4)unaCamioneta.getEstado()); //Le aseguro al compilador que es un Estado4x4
            unPiloto.conducir();
            /**Nunca le afectan la penalizacion del Pozo**/
            Assert.assertFalse(unPiloto.getVehiculo().getPosicion().equals(posicionInicial));
        }

        /**Y sigo avanzando**/
        unPozo.aplicarA(unPiloto, (Estado4x4)unaCamioneta.getEstado());
        unPiloto.conducir();
        Assert.assertTrue(unPiloto.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }


}
