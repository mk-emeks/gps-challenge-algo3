package fiuba.algo3.persistencia;


import java.io.Serializable;
import org.jdom2.Element;


public class Usuario implements Serializable {

    protected String nombre;


    public Usuario(String nombre) {

        this.nombre = nombre;

    }

    public String getNombre() { return this.nombre; }

    @Override
    public boolean equals(Object unObjetoPosicion) {

        Usuario unUsuario = (Usuario) unObjetoPosicion;
        boolean iguales = false;

        if (unUsuario.getNombre().equals(this.nombre)) {
            iguales = true;
        }
        return iguales;
    }


    /** por ser Serializable **/

    public Usuario(Element nodoUsuario) {

        this.nombre = nodoUsuario.getAttributeValue("nombre");

    }

    public Element serializar () {

        Element xmlNode = new Element("Usuario");
        xmlNode.setAttribute("nombre",String.valueOf(this.nombre));

        return xmlNode;

    }



}
