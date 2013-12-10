package fiuba.algo3.persistencia;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.*;

// parecido a RegistroUsuarios

public class RegistroUsuariosConPuntuacion implements Serializable {

    private static final String nombreDelArchivo = "registroUsuariosConPuntuacion.xml";
    public static String getNombreDelArchivo() { return nombreDelArchivo; }

    private static int cantidadDeUsuariosPermitidos = 3;

    private ArrayList <UsuarioConPuntuacion> usuarios;

    public RegistroUsuariosConPuntuacion() {

        this.usuarios = new ArrayList<UsuarioConPuntuacion>();

    }

    public ArrayList<UsuarioConPuntuacion> getUsuariosConPuntuacion() { return this.usuarios; }

    /** por ser Serializable **/

    public RegistroUsuariosConPuntuacion(Element nodoRegistroUsuariosConPuntuacion) {

        this.usuarios = new ArrayList<UsuarioConPuntuacion>();

        List<Element> hijos = nodoRegistroUsuariosConPuntuacion.getChildren();
        Iterator<Element> iteradorHijos = hijos.iterator();

        while (iteradorHijos.hasNext()) {

            Element nodoHijo = iteradorHijos.next();
            UsuarioConPuntuacion unUsuario = new UsuarioConPuntuacion(nodoHijo);
            this.usuarios.add(unUsuario);

        }
    }

    public Element serializar () {

        // solo le cambie la linea del nombre del Element
        Element xmlNode = new Element("RegistroUsuariosConPuntuacion");

        Iterator iteratorUsuarios= this.usuarios.iterator();
        while (iteratorUsuarios.hasNext()){

            Usuario usuarioAgregado = (Usuario) iteratorUsuarios.next();
            xmlNode.addContent(usuarioAgregado.serializar());

        }
        return xmlNode;

    }

    /** Este metodo, agregara el usuario al registro, en caso de que el mismo haya mejorado alguna marca de puntaje preexistente,
     *  caso contrario, no sera guardado **/
    public void agregarUsuario (UsuarioConPuntuacion unUsuario) {

        try {

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(nombreDelArchivo));
            Element raiz = doc.getRootElement();

            this.usuarios.add(unUsuario);  // agrego el usuario nuevo
            int cantidadUsuariosTemporales = this.usuarios.size(); // guardo la cantidad de usuarios momentanea

            // creo vector con los todos los usuarios, para luego ordenarlo
            UsuarioConPuntuacion vectorUsuariosOrdenados[] = new UsuarioConPuntuacion[cantidadUsuariosTemporales]; // lo creo
            for (int i = 0 ; i < cantidadUsuariosTemporales ; i++) {  // lo lleno!!!!!!!!!
                vectorUsuariosOrdenados[i] = this.usuarios.get(i);
            }

            // ordena de menor a mayor puntaje : es decir, en el primer lugar esta el menor int, es decir, la mejor marca
            Arrays.sort(vectorUsuariosOrdenados);

            // hago una nueva lista con el filtro de usuarios permitidos para guardar
            int cantidadUsuariosAGuardar;
            // filtro
            if (cantidadUsuariosTemporales >= cantidadDeUsuariosPermitidos) {
                cantidadUsuariosAGuardar = cantidadDeUsuariosPermitidos;
            } else { cantidadUsuariosAGuardar = cantidadUsuariosTemporales;}
            // lleno la nueva lista
            this.usuarios = new ArrayList<UsuarioConPuntuacion>();
            for (int i = 0 ; i < cantidadUsuariosAGuardar ; i++)  {
                this.usuarios.add(vectorUsuariosOrdenados[i]);
            }

            // borro todos y agrego los que pertenecen a la lista actualizada
            raiz.removeContent();
            Iterator<UsuarioConPuntuacion> iterator = this.usuarios.iterator();
            while (iterator.hasNext()) {
                raiz.addContent(iterator.next().serializar());
            }

            this.actualizarArchivoXml(doc); // aca se llama a la frula: es decir se agrego pero hay que actualizar el archivo


        } catch (Exception e) {System.out.println("no se pudo agregar el usuario al registoUsuariosConPuntuacion.xml");}

    }


    /** toda la frula: se autoactualiza **/
    protected void actualizarArchivoXml(Document doc) {

        try{

            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream(nombreDelArchivo);
            out.output(doc,file);

            file.flush();
            file.close();

            out.output(doc,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /*public void crearRegistroUsuariosConPuntuacionXml() {

        Document doc = new Document(this.serializar());

        try{

            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream(nombreDelArchivo);
            out.output(doc,file);

            file.flush();
            file.close();

            out.output(doc,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }*/

}
