package fiuba.algo3.persistencia;

import fiuba.algo3.control.Juego;
import fiuba.algo3.modelo.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Partida implements Serializable {

    private static final String terminacionArchivo = "Partida.xml";

    public static String getTerminacionArchivo() {return terminacionArchivo;}

    Posicion posicionInicio;
    Posicion posicionLlegada;
    ContenidoMapa contenidoMapa;

    String nombreUsuario;
    Posicion posicionActualDelVehiculo;
    Estado estadoVehiculo;
    int tiempoTranscurrido;

    public Partida ( Juego unJuego) {

        this.contenidoMapa = Mapa.getMapa().getContenidoMapa();
        this.posicionInicio = Mapa.getMapa().getInicio();
        this.posicionLlegada = Mapa.getMapa().getLlegada();

        this.nombreUsuario = unJuego.getPiloto().getNombre();
        this.posicionActualDelVehiculo = unJuego.getPiloto().getVehiculo().getPosicion(); /** es la posicion actual que tenga el vehiculo **/
        this.estadoVehiculo = unJuego.getPiloto().getVehiculo().getEstado();
        this.tiempoTranscurrido = unJuego.getPiloto().getCronometro().tiempoEnSegundos();

    }

    /** se le pasa un juego donde cargar la partida guardad **/
    /** solo restaria iniciar o reiniciar y luego pausar obvio) **/
    public void cargarPartidaGuardada(Juego unJuego) {

        Mapa.getMapa().cargarContenidoMapa(this.contenidoMapa);
        try{
            Mapa.getMapa().ubicarPosicionDeInicio(this.posicionInicio);
            Mapa.getMapa().ubicarPosicionDeLlegada(this.posicionLlegada);
        } catch (Exception e) {}

        unJuego.crearPiloto(this.nombreUsuario);
        unJuego.getPiloto().getCronometro().sumarSegundos(this.tiempoTranscurrido);
        unJuego.asignarCarroceriaDelVehiculo(this.estadoVehiculo); // despues de asignar el inicio!
        unJuego.cargarVehiculoParaElPiloto(this.posicionActualDelVehiculo); //despues de asignar carroceria

    }


    /** por ser serializable **/
    public Partida(){}

    public Partida( Element nodoPartida ) {

        this.nombreUsuario = nodoPartida.getAttributeValue("nombreUsuario");
        this.tiempoTranscurrido = Integer.parseInt(nodoPartida.getAttributeValue("tiempoTranscurrido"));


        List<Element> hijos = nodoPartida.getChildren();
        Iterator<Element> iteradorHijos = hijos.iterator();

        /** este metodo es el mejor ejemplo de lo que "no" hay que hacer **/
        while (iteradorHijos.hasNext()) {

            Element nodoHijo = iteradorHijos.next();

            if (nodoHijo.getName() == "PosicionActualDelVehiculo") {

                this.posicionActualDelVehiculo = new Posicion(nodoHijo);

            } else if (nodoHijo.getName() == "Estado4x4") {

                this.estadoVehiculo = new Estado4x4(nodoHijo);

            } else if (nodoHijo.getName() == "EstadoAuto") {

                this.estadoVehiculo = new EstadoAuto(nodoHijo);

            } else if (nodoHijo.getName() == "EstadoMoto") {

                this.estadoVehiculo = new EstadoMoto(nodoHijo);

            } else if (nodoHijo.getName() == "EstadoAlf") {

                this.estadoVehiculo = new EstadoAlf(nodoHijo);

            } else if (nodoHijo.getName() == "EstadoAlf") {

                this.estadoVehiculo = new EstadoAlf(nodoHijo);

            } else if (nodoHijo.getName() == "PosicionInicio") {

                this.posicionInicio = new Posicion(nodoHijo);

            } else if (nodoHijo.getName() == "PosicionLlegada") {

                this.posicionLlegada = new Posicion(nodoHijo);

            } else if (nodoHijo.getName() == "contenidoMapa") {

                this.contenidoMapa = new ContenidoMapa(nodoHijo);

            }

        }

    }

    public Element serializar() {

        Element xmlNode = new Element(this.nombreUsuario+terminacionArchivo);

        xmlNode.setAttribute("nombreUsuario",this.nombreUsuario);
        xmlNode.setAttribute("tiempoTranscurrido",String.valueOf(this.tiempoTranscurrido));

        xmlNode.addContent(this.posicionActualDelVehiculo.serializar("ActualDelVehiculo"));
        xmlNode.addContent(this.estadoVehiculo.serializar());

        xmlNode.addContent(this.posicionInicio.serializar("Inicio"));
        xmlNode.addContent(this.posicionLlegada.serializar("Llegada"));
        xmlNode.addContent(this.contenidoMapa.serializar());

        return xmlNode;

    }

    /** deberia tener un super consultor de existencia de archivos, y en caso de no tenerlos, crearlos..pero que paja **/
    /** el chabon se auto crea **/
    public void guardarPartida() {

        Document doc = new Document(this.serializar());

        try{

            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream(this.nombreUsuario+terminacionArchivo);
            out.output(doc,file);

            file.flush();
            file.close();

            //out.output(doc,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /** nota: en el boton cargar partida, hacer el xmlreader correspondiente con el nombre del usuario **/

}
