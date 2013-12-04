package fiuba.algo3.persistencia;

import fiuba.algo3.modelo.LaPosicionYaExisteEnElMapaException;
//import fiuba.algo3.modelo.Posicion;
import org.jdom2.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ContenidoMapa implements Serializable {


    private ArrayList<Posicion> posicionesValidas;


    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        if ( !this.posicionesValidas.contains(unaPosicion) ) {

            this.posicionesValidas.add(unaPosicion);

        } else { throw new LaPosicionYaExisteEnElMapaException(); }


    }


    /** Por ser Serializable **/

    public ContenidoMapa () {

        this.posicionesValidas = new ArrayList<Posicion>();

    }

    public ContenidoMapa ( Element nodo ) {

        int cantidadDePosiciones = nodo.getContentSize();
        for ( int i= 0 ; i< cantidadDePosiciones ; i++) {

            Posicion poscionRecuperda = new Posicion((Element)nodo.getContent(i));
            posicionesValidas.add(poscionRecuperda);

        }

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
