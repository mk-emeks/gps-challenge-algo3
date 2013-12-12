package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Test;

public class EstadoMotoTest {

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
            unaMoto.getEstado().interactuarCon(unMotoquero,unPiquete); //Le aseguro al compilador que es un EstadoMoto
            unMotoquero.conducir();
            Assert.assertTrue(unMotoquero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el piquete **/
        unaMoto.getEstado().interactuarCon(unMotoquero,unPiquete);
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
            unaChopper.getEstado().interactuarCon(metalero, unPozo); //Le aseguro al compilador que es un EstadoMoto
            metalero.conducir();
            Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        unaChopper.getEstado().interactuarCon(metalero, unPozo);
        metalero.conducir();
        Assert.assertTrue(metalero.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }
}
