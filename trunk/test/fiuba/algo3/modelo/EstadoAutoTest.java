package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Test;

public class EstadoAutoTest {


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
        unAuto.getEstado().interactuarCon(unPiloto, unPiquete); //Le aseguro al compilador que es un EstadoAuto

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
            unaFerrari.getEstado().interactuarCon(schumacher, unPozo); //Le aseguro al compilador que es un EstadoAuto
            schumacher.conducir();
            Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(posicionInicial));
        }
        /**Ahora no deberia afectarme el pozo **/
        unaFerrari.getEstado().interactuarCon(schumacher, unPozo);
        schumacher.conducir();
        Assert.assertTrue(schumacher.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

}
