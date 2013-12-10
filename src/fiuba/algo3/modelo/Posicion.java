package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.io.Serializable;

public class Posicion implements Serializable {

    private int posicionX;
    private int posicionY;

    public Posicion() {
        this.posicionX = 0;
        this.posicionY = 0;
    }

    public Posicion(int unaPosicionX, int unaPosicionY) {
        this.posicionX = unaPosicionX;
        this.posicionY = unaPosicionY;
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public int getPosicionY() {
        return this.posicionY;
    }

    public Posicion sumar(Posicion unaPosicion){

        int posicionFinalX = (this.getPosicionX() + unaPosicion.getPosicionX());
        int posicionFinalY = (this.getPosicionY() + unaPosicion.getPosicionY());

        Posicion posicionFinal = new Posicion(posicionFinalX, posicionFinalY);
        return posicionFinal;
    }

    public Posicion multiplicarPorEscalar(int unEscalar) {
        /** exceso de prolijidad..o sutil descuido: shit happens **/
        //this.posicionX = unEscalar*this.posicionX;
        //this.posicionY = unEscalar*this.posicionY;

        Posicion posicionMultiplicadaPorEscalar = new Posicion(unEscalar*this.posicionX, unEscalar*this.posicionY);

        return posicionMultiplicadaPorEscalar;
    }

    public Posicion restar(Posicion unaPosicion){

        Posicion posicionFinal = unaPosicion.multiplicarPorEscalar(-1);
        posicionFinal = this.sumar(posicionFinal);

        return posicionFinal;
    }

    /**Esto esta hecho de forma rapida, hay que verifcarlo bien**/
    @Override
    public boolean equals(Object unObjetoPosicion) {
        Posicion unaPosicion = (Posicion) unObjetoPosicion;
        boolean iguales = false;

        if ((this.getPosicionX() == unaPosicion.getPosicionX() && (this.getPosicionY() == unaPosicion.getPosicionY()))) {
            iguales = true;
        }
        return iguales;
    }

    /** Por ser Serializable **/

    public Posicion ( Element nodo ) {

        this.posicionX = Integer.parseInt(nodo.getAttributeValue("posicionX"));
        this.posicionY = Integer.parseInt(nodo.getAttributeValue("posicionY"));



    }

    public Element serializar() {

        Element xmlNode = new Element("Posicion");
        xmlNode.setAttribute("posicionX",String.valueOf(this.posicionX));
        xmlNode.setAttribute("posicionY",String.valueOf(this.posicionY));

        return xmlNode;

    }

    /** alto invento **/
    public Element serializar(String nombreIdentificador) {

        Element xmlNode = new Element("Posicion"+nombreIdentificador);
        xmlNode.setAttribute("posicionX",String.valueOf(this.posicionX));
        xmlNode.setAttribute("posicionY",String.valueOf(this.posicionY));

        return xmlNode;

    }
}
