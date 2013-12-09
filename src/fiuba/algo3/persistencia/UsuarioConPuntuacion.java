package fiuba.algo3.persistencia;


import fiuba.algo3.modelo.Conversor;
import org.jdom2.Element;

public class UsuarioConPuntuacion extends Usuario implements Comparable<UsuarioConPuntuacion> {

    private int puntuacion; /** mientras mayor puntuacion, peor tiempo! **/

    public UsuarioConPuntuacion (String nombre, int puntuacion) {

        super(nombre);
        this.puntuacion = puntuacion;

    }

    public String getPuntuacionComoString() {

      Conversor conversor = new Conversor();
      String puntuacionComoString = conversor.devolverTiempoComoString(this.puntuacion);
      return puntuacionComoString;

    }

    public int getPuntuacion() {

        return this.puntuacion;

    }

    /** por ser serializable **/

    public UsuarioConPuntuacion(Element nodoUsuario) {

        super(nodoUsuario);
        this.puntuacion = Integer.parseInt(nodoUsuario.getAttributeValue("puntuacion"));

    }

    public Element serializar () {

        Element xmlNode = new Element("UsuarioConPuntuacion");
        xmlNode.setAttribute("nombre",String.valueOf(this.nombre));
        xmlNode.setAttribute("puntuacion", String.valueOf(this.puntuacion));

        return xmlNode;

    }

    /** por ser comparable **/

    public int compareTo(UsuarioConPuntuacion unUsuarioConPuntuacion) {

    if (this.getPuntuacion() > (unUsuarioConPuntuacion.getPuntuacion()) ) {
        return 1; // local es mayor

    } else if (this.getPuntuacion() < (unUsuarioConPuntuacion.getPuntuacion()) ) {
        return -1; // local es menor

    }  else return 0; //son iguales

    }

}
