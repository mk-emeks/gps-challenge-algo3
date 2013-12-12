package fiuba.algo3.modelo;

import org.jdom2.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Podria ser una clase private del Mapa, salvo si se usa un xmlWriter **/
public class ContenidoMapa implements Serializable {

    private ArrayList<Posicion> posicionesValidas;

    transient private Vehiculo vehiculo;  /** NO SIRVE DE NADA (OBSOLETO) **/
    transient private Posicion inicio; /** new  -> ESTA SIN TESTIAR, PERO ES LO MISMO QUE LA LLEGADA **/
    transient private Posicion llegada;
    private ArrayList<Aplicable> aplicables;
    private ArrayList<AplicableTemporal> aplicablesTemporales;


    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        if ( !this.posicionesValidas.contains(unaPosicion) ) {

            this.posicionesValidas.add(unaPosicion);

        } else { throw new LaPosicionYaExisteEnElMapaException(); }


    }

    public void ubicarPosicionDeLlegada(Posicion laLlegada) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(laLlegada) ) {

            this.llegada = laLlegada;

        } else { throw new LaPosicionNoExisteEnElMapaException(); }

    }

    /** new **/
    public void ubicarPosicionDeInicio(Posicion elInicio) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(elInicio) ) {

            this.inicio = elInicio;

        } else { throw new LaPosicionNoExisteEnElMapaException(); }

    }

    public void ubicar(Vehiculo unVehiculo) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(unVehiculo.getPosicion()) ) {

            this.vehiculo = unVehiculo;

        } else { throw new LaPosicionNoExisteEnElMapaException(); }


    }

    public void ubicar(Aplicable aplicable) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(aplicable.getPosicion()) ) {

            if ( !this.estaUbicado(aplicable) ) {

                this.aplicables.add(aplicable);
            }
            /** si existe la posicion donde se quiere ubicar el posicionable, y el mismo ya fue agregado a
             * la lista de contenidos no se tiene que hacer nada mas **/

        } else { throw new LaPosicionNoExisteEnElMapaException(); }
    }

    public void ubicar(AplicableTemporal aplicableTemporal) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(aplicableTemporal.getPosicion()) ) {

            if ( !this.estaUbicado(aplicableTemporal) ) {

                this.aplicablesTemporales.add(aplicableTemporal);
            }
            /** si existe la posicion donde se quiere ubicar el posicionable, y el mismo ya fue agregado a
             * la lista de contenidos no se tiene que hacer nada mas **/

        } else { throw new LaPosicionNoExisteEnElMapaException(); }
    }



    public Posicion getLlegada() {
        return this.llegada;
    }

    /** new **/
    public Posicion getInicio() {
        return this.inicio;
    }

    /** new **/
    public ArrayList<Aplicable> getAplicables() {
        return this.aplicables;
    }

    public ArrayList<AplicableTemporal> getAplicablesTemporales() {
        return this.aplicablesTemporales;
    }

    public ArrayList<Posicion> getPosicionesValidas() {
        return this.posicionesValidas;
    }

    /** testing **/
    // deberian ser private? los hacemos public para poder hacer tests con comodidad
    public boolean estaUbicado(Aplicable unAplicable) {

        return aplicables.contains(unAplicable);

    }

    public boolean estaUbicado(AplicableTemporal unAplicableTemporal) {

        return aplicablesTemporales.contains(unAplicableTemporal);

    }

    public boolean existe(Posicion unaPosicion) {

        return posicionesValidas.contains(unaPosicion);
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /** fin **/


    /** Por ser Serializable **/

    /** el constructor sirve tanto en general como para su desserializacion **/
    public ContenidoMapa () {

        this.posicionesValidas = new ArrayList<Posicion>(); // para que al serializar exista tal lista
        this.aplicables = new ArrayList<Aplicable>();
        this.aplicablesTemporales = new ArrayList<AplicableTemporal>();

    }

    public ContenidoMapa ( Element nodo ) {

        this.posicionesValidas = new ArrayList<Posicion>();
        this.aplicablesTemporales = new ArrayList<AplicableTemporal>();
        this.aplicables = new ArrayList<Aplicable>();

        List<Element> hijos = nodo.getChildren();
        Iterator<Element> iteradorHijos = hijos.iterator();

        /** este metodo es el mejor ejemplo de lo que "no" hay que hacer **/
        while (iteradorHijos.hasNext()) {

            Element nodoHijo = iteradorHijos.next();

            if (nodoHijo.getName() == "Posicion") {

                Posicion unaPos = new Posicion(nodoHijo);
                this.posicionesValidas.add(unaPos);

            } else if (nodoHijo.getName() == "Pozo") {

                Aplicable unPozo = new Pozo(nodoHijo);
                this.aplicables.add(unPozo);


            } else if (nodoHijo.getName() == "Piquete") {

                Aplicable unPozo = new Piquete(nodoHijo);
                this.aplicables.add(unPozo);


            }  else if (nodoHijo.getName() == "ControlPolicial") {

                Aplicable unPozo = new ControlPolicial(nodoHijo);
                this.aplicables.add(unPozo);


            } else if (nodoHijo.getName() == "SorpresaCambioDeVehiculo") {

                Sorpresa unaSorpresa = new SorpresaCambioDeVehiculo(nodoHijo);
                this.aplicablesTemporales.add(unaSorpresa);

            } else if (nodoHijo.getName() == "SorpresaDesfavorable") {

                Sorpresa unaSorpresa = new SorpresaDesfavorable(nodoHijo);
                this.aplicablesTemporales.add(unaSorpresa);

            } else if (nodoHijo.getName() == "SorpresaFavorable") {

                Sorpresa unaSorpresa = new SorpresaFavorable(nodoHijo);
                this.aplicablesTemporales.add(unaSorpresa);
            }

        }

    }

    public Element serializar() {

        Element xmlNode = new Element("contenidoMapa");

        Iterator iteratorPosiciones = posicionesValidas.iterator();
        while (iteratorPosiciones.hasNext()){

            Posicion posicionAgregada = (Posicion) iteratorPosiciones.next();
            xmlNode.addContent(posicionAgregada.serializar());

        }

        Iterator iteratorObstaculos = this.aplicables.iterator();
        while (iteratorObstaculos.hasNext()){

            Obstaculo obstaculoAgregado = (Obstaculo) iteratorObstaculos.next();
            xmlNode.addContent(obstaculoAgregado.serializar());

        }

        Iterator iteratorSorpresas = this.aplicablesTemporales.iterator();
        while (iteratorSorpresas.hasNext()){

            Sorpresa sorpresaAgregada = (Sorpresa) iteratorSorpresas.next();
            xmlNode.addContent(sorpresaAgregada.serializar());

        }

        return xmlNode;

    }

}