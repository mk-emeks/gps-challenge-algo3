package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.List;

public class ControlPolicial extends Obstaculo {

    /** cambiar aca si se quiere modificar la clase -> para calibrar **/
    private static final int penalizacion = 3;
    private static final double probabilidadAuto = 0.5;
    private static final double probabilidad4x4 = 0.3;
    private static final double probabilidadMoto = 0.8;

    public ControlPolicial(Posicion unaPosicion) {

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

        this.aplicar(piloto,this.probabilidadAuto);

    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
       this.aplicar(piloto,this.probabilidadMoto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        this.aplicar(piloto,this.probabilidad4x4);
    }

    /** ahorrando codigo **/
    protected void aplicar(Piloto piloto,double probabilidad) {
        double numeroRandom = Math.random();
        if ( numeroRandom < probabilidad ) {
            this.aplicar(piloto);
        }
    }

    /** por ser Serializable **/

    public ControlPolicial( Element nodoControlPolicial) {

        this.turnosPenalizadosMomentaneos = Integer.parseInt(nodoControlPolicial.getAttributeValue("turnosPenalizadosMomentaneos"));
        this.turnosPenalizado = penalizacion; // es static

        // en este caso sabemos que el nodoSorpresa solo tiene un hijo, y es la posicion
        List<Element> hijo = nodoControlPolicial.getChildren();
        Element nodoHijo = hijo.get(0);
        this.setPosicion(new Posicion(nodoHijo));
    }

    public Element serializar() {

        Element xmlNode = new Element("ControlPolicial");

        xmlNode.setAttribute("turnosPenalizadosMomentaneos",String.valueOf(this.turnosPenalizadosMomentaneos));
        xmlNode.setContent(this.getPosicion().serializar());

        return xmlNode;

    }

}
