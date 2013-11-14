package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Eventos {

    private ArrayList<Aplicable> aplicables;

    public Eventos() {

        this.aplicables = Mapa.getMapa().getAplicables();

    }

     private void actualizarElEstadoDeLaPartida( Partida unaPartida) {

        Vehiculo vehiculoAVerificar = unaPartida.getPiloto().getVehiculo();
        if ( vehiculoAVerificar.getPosicion().equals(Mapa.getMapa().getLlegada()) ) {
            unaPartida.finalizar();
        }

    }

    private void actualizarAplicables( Partida unaPartida) {

        Piloto pilotoAVerificar = unaPartida.getPiloto();
        ListIterator<Aplicable> iterador = aplicables.listIterator();

        // eficiencia: break, si suponemos que no hay 2 aplicables en la misma posicion
        while (iterador.hasNext()) {

            Aplicable aplicable = iterador.next();
            aplicable.actualizar(pilotoAVerificar);

        }

    }

    public void actualizar(Partida unaPartida) {

        this.actualizarAplicables(unaPartida);
        this.actualizarElEstadoDeLaPartida(unaPartida);

    }

}
