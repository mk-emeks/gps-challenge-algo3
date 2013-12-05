package fiuba.algo3.persistencia;

import fiuba.algo3.modelo.LaPosicionYaExisteEnElMapaException;
//import fiuba.algo3.modelo.Posicion;
import org.jdom2.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContenidoMapa implements Serializable {


    private ArrayList<Posicion> posicionesValidas;


    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        if ( !this.posicionesValidas.contains(unaPosicion) ) {

            this.posicionesValidas.add(unaPosicion);

        } else { throw new LaPosicionYaExisteEnElMapaException(); }


    }


    /** Por ser Serializable **/

    public ContenidoMapa () {}


    public ContenidoMapa ( Element nodo ) {
        this.posicionesValidas = new ArrayList<Posicion>();
        List<Element> hijos = nodo.getChildren();
        Iterator<Element> atributos = hijos.iterator();
        while (atributos.hasNext()) {
           Element atributo = atributos.next();
            if (atributo.getName() == "Posicion") {
                Posicion unaPos = new Posicion(atributo);
                posicionesValidas.add(unaPos);
            } else if (atributo.getName() == "Obstaculo") {
                //TO-DO
            } else if (atributo.getName() == "Sorpresa") {
                //TO-DO
            }
        }
        /*int cantidadDePosiciones = nodo.getContentSize();
        for ( int i= 0 ; i< cantidadDePosiciones ; i++) {

            Posicion poscionRecuperda = new Posicion((Element)nodo.getContent(i));
            posicionesValidas.add(poscionRecuperda);

        }*/

    }

    public Element serializar() {

        Element xmlNode = new Element("Mapa");

        Iterator iterator = posicionesValidas.iterator();
        while (iterator.hasNext()){

            Posicion posicionAgregada = (Posicion) iterator.next();
            xmlNode.addContent(posicionAgregada.serializar());

        }

        return xmlNode;

    }

}
