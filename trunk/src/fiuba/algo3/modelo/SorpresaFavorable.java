package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.List;

public class SorpresaFavorable extends SorpresaCambioDeTiempo {

    private static final int porcentaje = -40;  /** cambiar aca si se quiere modificar la clase**/

    public SorpresaFavorable (Posicion unaPosicion) {

        this.aplicado = false;
        this.setPosicion(unaPosicion);

        this.porcentajeTiempo = porcentaje;
    }


    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion().equals(this.getPosicion()) )
        {
            this.aplicado = true;
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) {
        piloto.getCronometro().variarPorcentaje(this.devolverPorcentaje());
    }

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto) { /** No hace nada **/ }
    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) { /** No hace nada **/ }
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) { /** No hace nada **/ }


    /** por ser Serializable **/
    public SorpresaFavorable( Element nodoSorpresaFavorable) {

        this.aplicado = Boolean.parseBoolean(nodoSorpresaFavorable.getAttributeValue("aplicado"));
        this.porcentajeTiempo = porcentaje;

        // en este caso sabemos que el nodoSorpresa solo tiene un hijo, y es la posicion
        List<Element> hijo = nodoSorpresaFavorable.getChildren();
        Element nodoHijo = hijo.get(0);
        this.setPosicion(new Posicion(nodoHijo));
    }

    public Element serializar() {

        Element xmlNode = new Element("SorpresaFavorable");
        xmlNode.setAttribute("aplicado",String.valueOf(this.aplicado));
        xmlNode.setContent(this.getPosicion().serializar());

        return xmlNode;

    }

}
