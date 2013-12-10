package fiuba.algo3.modelo;

import java.io.Serializable;
import org.jdom2.Element;

public abstract class Estado implements Serializable {

    /** es igual en todos, son distintos los this ver() **/
    public abstract void interactuarCon(Piloto piloto, Pozo pozo);
    public abstract void interactuarCon(Piloto piloto, Piquete piquete);
    public abstract void interactuarCon(Piloto piloto, ControlPolicial layuta);
    public abstract void interactuarCon(Piloto piloto, SorpresaFavorable sorpresaFavorable);
    public abstract void interactuarCon(Piloto piloto, SorpresaDesfavorable sorpresaDesfavorable);
    public abstract void interactuarCon(Piloto piloto, SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo);

    /** deberia tener esto para probarlo: no se me ocurre mas para las pruebas **/

    @Override
    public boolean equals(Object unObjetoEstado) {
        Estado unEstado = (Estado) unObjetoEstado;
        boolean iguales = false;

        if (this.getClass() == unEstado.getClass()) {   /** VILLERIADA, pero la hora lo permite? **/
            iguales = true;
        }
        return iguales;
    }

    /** por ser serializable **/
    public abstract Element serializar();
}
