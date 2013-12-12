package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PilotoTest {

    Mapa map;
    String nombrePiloto = "Pilotin";
    Piloto piloto = new Piloto();


    @Before
    public void setUp() {
        map = Mapa.getMapa();
    }

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    @Test
    public void TestDeberiaConducirUnVehiculoHaciaOtraPosicion() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        EstadoAuto estadoAuto = new EstadoAuto();
        Vehiculo auto = new Vehiculo(posicion,direccion,estadoAuto);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion.sumar(direccion.devolverComoPosicion()));
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionYaQueAunNoArranco() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);

        Vehiculo auto = new Vehiculo(posicion,new DireccionDerecha(),new EstadoAuto());
        piloto.asignarVehiculo(auto);

        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion);
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionYaQueLaPosicionSiguienteEsInvalida() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionArriba();
        EstadoAuto estadoAuto = new EstadoAuto();
        Vehiculo auto = new Vehiculo(posicion,direccion,estadoAuto);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion);
    }

    @Test
    public void TestNoDeberiaConducirUnVehiculoHaciaOtraPosicionUnaVezDetenidoElMismo() throws Exception {

        EditorMapa editor = new EditorMapa();
        editor.editarMapaMinimoJugable();
        Posicion posicion = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        EstadoAuto estadoAuto = new EstadoAuto();
        Vehiculo auto = new Vehiculo(posicion,direccion,estadoAuto);
        piloto.asignarVehiculo(auto);

        piloto.arrancarVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(), posicion.sumar(direccion.devolverComoPosicion()));

        piloto.detenerVehiculo();
        piloto.conducir();

        Assert.assertEquals(piloto.getVehiculo().getPosicion(),posicion.sumar(direccion.devolverComoPosicion()));
    }

    /** comienza el robo**/
    @Test
    public void testElPiqueteDeberiaInvertirDireccionAUnVehiculo4x4() throws Exception{
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
        unPiloto.interactuarCon(unPiquete); //Le aseguro al compilador que es un Estado4x4

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionArriba()));
    }

    @Test
    public void testElPozoNoDeberiaPenalizarAUnVehiculo4x4() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        //Creo un mapa mas grande
        unEditor.editarMapaDeDimensiones(6, 3);

        Posicion posicionInicial = new Posicion(6,2);
        Direccion direccion = new DireccionIzquierda();
        Estado4x4 unEstado4x4 = new Estado4x4();

        Vehiculo unaCamioneta = new Vehiculo(posicionInicial, direccion, unEstado4x4);
        String nombrePiloto = "Pilotin";
        Piloto unPiloto = new Piloto(unaCamioneta,nombrePiloto);
        unaCamioneta.posicionarEnElMapa();
        unPiloto.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unPiloto.interactuarCon(unPozo); //Le aseguro al compilador que es un Estado4x4
            unPiloto.conducir();
            /**Nunca le afectan la penalizacion del Pozo**/
            Assert.assertFalse(unPiloto.getVehiculo().getPosicion().equals(posicionInicial));
        }

        /**Y sigo avanzando**/
        unPiloto.interactuarCon(unPozo);
        unPiloto.conducir();
        Assert.assertTrue(unPiloto.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

    @Test
    public void testElPiqueteDeberiaInvertirDireccionAUnVehiculoAuto() throws Exception{
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
        unPiloto.interactuarCon(unPiquete); //Le aseguro al compilador que es un EstadoAuto

        Assert.assertTrue(unPiloto.getVehiculo().getDireccion().equals(new DireccionIzquierda()));
    }

    @Test
    public void testElPozoDeberiaPoderPenalizarAUnVehiculoAuto() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(1,2);
        Direccion direccion = new DireccionDerecha();
        EstadoAuto unEstadoAuto = new EstadoAuto();

        Vehiculo unaFerrari = new Vehiculo(posicionInicial, direccion, unEstadoAuto);
        String nombrePiloto = "Schumacher";
        Piloto schumacher = new Piloto(unaFerrari,nombrePiloto);
        unaFerrari.posicionarEnElMapa();
        schumacher.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            schumacher.interactuarCon(unPozo); //Le aseguro al compilador que es un EstadoAuto
            schumacher.conducir();
            Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        schumacher.interactuarCon(unPozo);
        schumacher.conducir();
        Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

    @Test
    public void testElPiqueteDeberiaPoderPenalizarAUnVehiculoMotoYLuegoDejarloAvanzar() throws Exception{
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

        Piquete unPiquete = new Piquete(new Posicion(2,2));
        unPiquete.posicionarEnElMapa();

        int numeroPenalizacion = unPiquete.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            unMotoquero.interactuarCon(unPiquete); //Le aseguro al compilador que es un EstadoMoto
            unMotoquero.conducir();
            Assert.assertTrue(unMotoquero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el piquete **/
        unMotoquero.interactuarCon(unPiquete);
        unMotoquero.conducir();
        Assert.assertTrue(unMotoquero.getVehiculo().getPosicion().equals(new Posicion(1,2)));
    }

    @Test
    public void testElPozoDeberiaPoderPenalizarAUnVehiculoMoto() throws Exception{
        EditorMapa unEditor = new EditorMapa();
        unEditor.editarMapaMinimoJugable();

        Posicion posicionInicial = new Posicion(3,2);
        Direccion direccion = new DireccionIzquierda();
        EstadoMoto unEstadoMoto = new EstadoMoto();

        Vehiculo unaChopper = new Vehiculo(posicionInicial, direccion, unEstadoMoto);
        String nombrePiloto = "Metalero";
        Piloto metalero = new Piloto(unaChopper,nombrePiloto);
        unaChopper.posicionarEnElMapa();
        metalero.arrancarVehiculo();

        Pozo unPozo = new Pozo(new Posicion(2,2));
        unPozo.posicionarEnElMapa();

        int numeroPenalizacion = unPozo.cantidadDeTurnosPenalizado();

        for(int i =1; i<=numeroPenalizacion;i++) {
            metalero.interactuarCon(unPozo); //Le aseguro al compilador que es un EstadoMoto
            metalero.conducir();
            Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        metalero.interactuarCon(unPozo);
        metalero.conducir();
        Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }


}
