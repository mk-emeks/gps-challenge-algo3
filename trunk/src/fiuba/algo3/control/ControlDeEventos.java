package fiuba.algo3.control;

/** lo que necesita saber del modelo **/
import fiuba.algo3.masterOfPuppets.GameLoop;
import fiuba.algo3.modelo.*;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.vista.VistasMenu.VistaFinalizacion;

import java.util.ArrayList;
import java.util.Iterator;

public class ControlDeEventos implements ObjetoVivo {

    private ArrayList<Aplicable> aplicables;
    private ArrayList<AplicableTemporal> aplicablesTemporables;
    private Partida partidaControlada;

    public ControlDeEventos(Partida unaPartida) {

        this.partidaControlada = unaPartida;
        this.aplicables = Mapa.getMapa().getAplicables();
        this.aplicablesTemporables = Mapa.getMapa().getAplicablesTemporales();

    }

     private void actualizarElEstadoDeLaPartida() {

        Vehiculo vehiculoAVerificar = this.partidaControlada.getPiloto().getVehiculo();
        if ( vehiculoAVerificar.getPosicion().equals(Mapa.getMapa().getLlegada()) ) {
            this.partidaControlada.finalizar();
            VistaFinalizacion unaVistaFinalizado = new VistaFinalizacion();
        }

    }

    private void actualizarAplicables() {

        Piloto pilotoAVerificar = this.partidaControlada.getPiloto();

        // eficiencia: break, si suponemos que no hay 2 aplicables en la misma posicion

        Iterator<Aplicable> aplicapleIterador = this.aplicables.iterator();
        while (aplicapleIterador.hasNext()) {

            Aplicable aplicable = aplicapleIterador.next();
            aplicable.actualizar(pilotoAVerificar);

        }

        this.borrarAplicablesTemporales(); //actualizamos la lista

        Iterator<AplicableTemporal> aplicableTemporalIterador = this.aplicablesTemporables.iterator();
        while (aplicableTemporalIterador.hasNext()) {

            AplicableTemporal aplicableTemporal = aplicableTemporalIterador.next();
            aplicableTemporal.actualizar(pilotoAVerificar);

        }

    }

    private void borrarAplicablesTemporales() {

        /** para remover los iteradores son una verga **/
        for (int i = 0 ; i<this.aplicablesTemporables.size() ; i++) {

            if (aplicablesTemporables.get(i).aplicado()) {

                aplicablesTemporables.remove(i); //lo sacamos del mapa
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
