package fiuba.algo3.modelo;


import junit.framework.Assert;
import org.junit.Test;

public class Estado4x4Test {

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
        unaCamioneta.getEstado().interactuarCon(unPiloto, unPiquete); //Le aseguro al compilador que es un Estado4x4

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
            unaCamioneta.getEstado().interactuarCon(unPiloto, unPozo); //Le aseguro al compilador que es un Estado4x4
            unPiloto.conducir();
            /**Nunca le afectan la penalizacion del Pozo**/
            Assert.assertFalse(unPiloto.getVehiculo().getPosicion().equals(posicionInicial));
        }

        /**Y sigo avanzando**/
        unaCamioneta.getEstado().interactuarCon(unPiloto, unPozo);
        unPiloto.conducir();
        Assert.assertTrue(unPiloto.getVehiculo().getPosicion().equals(new Posicion(2,2)));
    }

    /** Test por ser clases heredadas de Estado **/
    @Test
    public void testLosEstados4x4DeberianSerIguales() {

        Estado unEstado4x4 = new Estado4x4();
        Estado otroEstado4x4 = new Estado4x4();

        Assert.assertTrue(unEstado4x4.equals(otroEstado4x4));
    }

    @Test
    public void testLosEstadosAutoy4x4DeberianSerDistintos() {

        Estado estadoAuto = new EstadoAuto();
        Estado estado4x4 = new Estado4x4();

        Assert.assertFalse(estadoAuto.equals(estado4x4));
    }

    @Test
    public void testLosEstadosMotoy4x4DeberianSerDistintos() {

        Estado estadoMoto = new EstadoMoto();
        Estado estado4x4 = new Estado4x4();

        Assert.assertFalse(estadoMoto.equals(estado4x4));
    }

    @Test
    public void testLosEstadosMotoyAutoDeberianSerDistintos() {

        Estado estadoMoto = new EstadoMoto();
        Estado estadoAuto = new EstadoAuto();

        Assert.assertFalse(estadoMoto.equals(estadoAuto));
    }
    /**fin**/
}
