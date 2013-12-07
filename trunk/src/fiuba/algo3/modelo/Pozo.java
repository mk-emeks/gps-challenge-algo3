package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.List;

public class Pozo extends Obstaculo {

    private static final int penalizacion = 3;  /** cambiar aca si se quiere modificar la clase -> para calibrar**/

    public Pozo(Posicion unaPosicion) {

        this.turnosPenalizado = penalizacion;
        this.turnosPenalizadosMomentaneos = this.turnosPenalizado;
        this.setPosicion(unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion().equals(this.getPosicion()) )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) { /** No hace nada **/ }

    /** ahorrando codigo **/

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto){
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) { /** No hace nada **/ }


    /** por ser Serializable **/

    public Pozo( Element nodoPozo) {

        this.turnosPenalizadosMomentaneos = Integer.parseInt(nodoPozo.getAttributeValue("turnosPenalizadosMomentaneos"));
        this.turnosPenalizado = penalizacion; // es static

        // en este caso sabemos que el nodoSorpresa solo tiene un hijo, y es la posicion
        List<Element> hijo = nodoPozo.getChildren();
        Element nodoHijo = hijo.get(0);
        this.setPosicion(new Posicion(nodoHijo));
    }

    public Element serializar() {

        Element xmlNode = new Element("Pozo");

        xmlNode.setAttribute("turnosPenalizadosMomentaneos",String.valueOf(this.turnosPenalizadosMomentaneos));
        xmlNode.setContent(this.getPosicion().serializar());

        return xmlNode;

    }

}
