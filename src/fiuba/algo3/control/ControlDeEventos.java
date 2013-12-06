package fiuba.algo3.control;

/** lo que necesita saber del modelo **/
import fiuba.algo3.modelo.*;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import java.util.ArrayList;
import java.util.ListIterator;

public class ControlDeEventos implements ObjetoVivo {

    private ArrayList<Aplicable> aplicables;
    private Partida partidaControlada;

    public ControlDeEventos(Partida unaPartida) {

        this.partidaControlada = unaPartida;
        this.aplicables = Mapa.getMapa().getAplicables();

    }

     private void actualizarElEstadoDeLaPartida() {

        Vehiculo vehiculoAVerificar = this.partidaControlada.getPiloto().getVehiculo();
        if ( vehiculoAVerificar.getPosicion().equals(Mapa.getMapa().getLlegada()) ) {
            this.partidaControlada.finalizar();
        }

    }

    private void actualizarAplicables() {

        Piloto pilotoAVerificar = this.partidaControlada.getPiloto();

        //this.borrarAplicablesTemporales(); //actualizamos la lista  //TERMINAR!!
        ListIterator<Aplicable> iterador = aplicables.listIterator();

        // eficiencia: break, si suponemos que no hay 2 aplicables en la misma posicion
        while (iterador.hasNext()) {

            Aplicable aplicable = iterador.next();
            aplicable.actualizar(pilotoAVerificar);

        }

    }

    private void borrarAplicablesTemporales() {

        ListIterator<Aplicable> iterador = aplicables.listIterator();

        // eficiencia: break, si suponemos que no hay 2 aplicables en la misma posicion
        while (iterador.hasNext()) {

            /** fuck necesito diferencia aplicable de aplicable temporales :S **/
            // RTTI AL PALO GUACHO!
            //if ( iterador.getClass().AplicableTemporal) {

                Aplicable aplicable = iterador.next();
                AplicableTemporal aplicableTemporal = (AplicableTemporal)aplicable;

                if (aplicableTemporal.aplicado()) {

                    this.aplicables.remove(aplicable);
                }

        }

    }



    public void actualizar() {

        this.actualizarAplicables();
        this.actualizarElEstadoDeLaPartida();

    }

    /** por implementar ObjetoVivo **/
    public void vivir() {

        this.actualizar();

    }

}
