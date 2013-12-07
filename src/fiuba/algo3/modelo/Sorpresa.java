package fiuba.algo3.modelo;

import org.jdom2.Element;
import java.io.Serializable;

public abstract class Sorpresa implements AplicableTemporal, Serializable {

    protected boolean aplicado;
    private Posicion posicion;

    /** Si la clase madre posee contructor. A la hora de tener una clase hija y plantiar distintos constructores para las misma
     *  me pincha, aun no se por que...
     */
    /*public Sorpresa(Posicion unaPosicion) {

        this.aplicado = false;
        this.posicion = unaPosicion;
    } */

    public void posicionarEnElMapa() throws NoSePuedePonerEnElMapaElPosicionableException {

        try {

            Mapa.getMapa().ubicar(this);

        } catch (LaPosicionNoExisteEnElMapaException e) {

            throw new NoSePuedePonerEnElMapaElPosicionableException("la posicion en la cual se quiere ubicar es invalida");
        }

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion unaPosicion) {
        this.posicion = unaPosicion;
    }


    public boolean aplicado() {

      return  this.aplicado;

    }

    /** por ser serializable **/

    public abstract Element serializar();

}
