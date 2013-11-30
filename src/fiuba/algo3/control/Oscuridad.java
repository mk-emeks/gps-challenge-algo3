/*package fiuba.algo3.control;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

import fiuba.algo3.vista.VistaSombra;

import java.util.ArrayList;
import java.util.ListIterator;

public class Oscuridad  {

    ArrayList<VistaSombra> sombras;

    public Oscuridad() {

        this.sombras = new ArrayList<VistaSombra>();

    }

    public void agregar(VistaSombra unaSombra) {

        this.sombras.add(unaSombra);
    }



    public void actualizarNeblina(Vehiculo unVehiculo) {

        ListIterator<VistaSombra> iterador = this.sombras.listIterator();

        while (iterador.hasNext()) {

            VistaSombra sombra = iterador.next();
            ObjetoPosicionable posicionableSombra = sombra.getPosicionable();
            Posicion posicionSombra = new Posicion(posicionableSombra.getX()/50,posicionableSombra.getY()/50);

            if ( posicionSombra.equals(unVehiculo.getPosicion()) ) {

                sombra.quitarNeblina();

            } else {
                sombra.ponerNeblina();
            }
        }


    }
}  */
