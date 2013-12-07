package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.List;

public class Piquete extends Obstaculo {

    private static final int penalizacion = 2;  /** cambiar aca si se quiere modificar la clase -> para calibrar**/


    public Piquete(Posicion unaPosicion) {

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

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto){
        piloto.getVehiculo().getDireccion().invertir();
    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        piloto.getVehiculo().getDireccion().invertir();
    }

    /** por ser Serializable **/

    public Piquete( Element nodoPiquete) {

        this.turnosPenalizadosMomentaneos = Integer.parseInt(nodoPiquete.getAttributeValue("turnosPenalizadosMomentaneos"));
        this.turnosPenalizado = penalizacion; // es static

        // en este caso sabemos que el nodoSorpresa solo tiene un hijo, y es la posicion
        List<Element> hijo = nodoPiquete.getChildren();
        Element nodoHijo = hijo.get(0);
        this.setPosicion(new Posicion(nodoHijo));
    }

    public Element serializar() {

        Element xmlNode = new Element("Piquete");

        xmlNode.setAttribute("turnosPenalizadosMomentaneos",String.valueOf(this.turnosPenalizadosMomentaneos));
        xmlNode.setContent(this.getPosicion().serializar());

        return xmlNode;

    }


}
