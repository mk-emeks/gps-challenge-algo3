package fiuba.algo3.modelo;

import org.jdom2.Element;

/** alf cheat (el misterioso señor null) **/
public class EstadoAlf extends Estado {

    public void interactuarCon(Piloto piloto, Pozo pozo){}
    public void interactuarCon(Piloto piloto, Piquete piquete){}
    public void interactuarCon(Piloto piloto, ControlPolicial layuta){}
    public void interactuarCon(Piloto piloto, SorpresaFavorable sorpresaFavorable){}
    public void interactuarCon(Piloto piloto, SorpresaDesfavorable sorpresaDesfavorable){}
    public void interactuarCon(Piloto piloto, SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo){}

    /** por ser serializable **/

    public EstadoAlf(){}

    public EstadoAlf(Element xmlEstadoAlf) {}

    public Element serializar() {

        Element xmlNode = new Element("EstadoAlf");

        return xmlNode;

    }

}


