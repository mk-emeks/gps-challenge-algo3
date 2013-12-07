package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.List;

public class SorpresaCambioDeVehiculo extends Sorpresa {

    public SorpresaCambioDeVehiculo (Posicion unaPosicion) {

        this.aplicado = false;
        this.setPosicion(unaPosicion);
    }

    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion().equals(this.getPosicion()) )
        {
            this.aplicado = true;
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) { /** No hace nada **/ }

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto) {
        piloto.getVehiculo().setEstado( new Estado4x4() );
    }
    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        piloto.getVehiculo().setEstado( new EstadoAuto() );
    }
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        piloto.getVehiculo().setEstado( new EstadoMoto() );
    }

    /** por ser Serializable **/
    public SorpresaCambioDeVehiculo( Element nodoSorpresaCambioDeVehiculo) {

        this.aplicado = Boolean.parseBoolean(nodoSorpresaCambioDeVehiculo.getAttributeValue("aplicado"));

        // en este caso sabemos que el nodoSorpresa solo tiene un hijo, y es la posicion
        List<Element> hijo = nodoSorpresaCambioDeVehiculo.getChildren();
        Element nodoHijo = hijo.get(0);
        this.setPosicion(new Posicion(nodoHijo));
    }

    public Element serializar() {

        Element xmlNode = new Element("SorpresaCambioDeVehiculo");
        xmlNode.setAttribute("aplicado",String.valueOf(this.aplicado));
        xmlNode.setContent(this.getPosicion().serializar());

        return xmlNode;

    }

}

