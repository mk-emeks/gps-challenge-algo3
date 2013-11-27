package fiuba.algo3.control;

/** lo que necesita saber del modelo **/
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Aplicable;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Vehiculo;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
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
        ListIterator<Aplicable> iterador = aplicables.listIterator();

        // eficiencia: break, si suponemos que no hay 2 aplicables en la misma posicion
        while (iterador.hasNext()) {

            Aplicable aplicable = iterador.next();
            aplicable.actualizar(pilotoAVerificar);

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
