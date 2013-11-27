package fiuba.algo3.vista;

import fiuba.algo3.modelo.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;

/** Esta clase es un artilugio, que cumple con el fin de adaptar la vista de calles, con el modelo presentado;
 *  Ya que el framework usado (titiritero) para mostrar objetos necesita de ObjetoPosicionables y no solo coordenadas.
 */

public class RepresentacionDeCalle implements Posicionable {

    private Posicion posicion;

    public RepresentacionDeCalle (Posicion unaPosicion) {

        this.posicion = unaPosicion;

    }

    public int getX() {

        return (50*this.posicion.getPosicionX());

    }

    public int getY() {

        return (50*this.posicion.getPosicionY());

    }
}
