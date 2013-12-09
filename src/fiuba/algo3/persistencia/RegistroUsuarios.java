package fiuba.algo3.persistencia;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistroUsuarios implements Serializable {

    private static final String nombreDelArchivo = "registroUsuarios.xml";
    public static String getNombreDelArchivo() { return nombreDelArchivo; }

    private static int cantidadDeUsuariosPermitidos = 3;

    private ArrayList <Usuario> usuarios;

    public RegistroUsuarios() {

        this.usuarios = new ArrayList<Usuario>();

    }

    public ArrayList<Usuario> getUsuarios() { return this.usuarios; }

    // servira?
    public boolean existe (Usuario usuarioBuscado) {

        Iterator<Usuario> iterator = this.usuarios.iterator();

        boolean encontrado = false;
        while (iterator.hasNext()) {

            Usuario usuario = iterator.next();
            if (usuario.equals(usuarioBuscado)) {
                encontrado = true;
                break;
            }

        }
        return encontrado;

    }

    /** por ser Serializable **/

    public RegistroUsuarios(Element nodoRegistroUsuarios) {

        this.usuarios = new ArrayList<Usuario>();

        List<Element> hijos = nodoRegistroUsuarios.getChildren();
        Iterator<Element> iteradorHijos = hijos.iterator();

        while (iteradorHijos.hasNext()) {

            Element nodoHijo = iteradorHijos.next();
            Usuario unUsuario = new Usuario(nodoHijo);
            this.usuarios.add(unUsuario);

        }
    }

    public Element serializar () {

        Element xmlNode = new Element("RegistroUsuarios");

        Iterator iteratorUsuarios= this.usuarios.iterator();
        while (iteratorUsuarios.hasNext()){

            Usuario usuarioAgregado = (Usuario) iteratorUsuarios.next();
            xmlNode.addContent(usuarioAgregado.serializar());

        }
        return xmlNode;

    }

    /** se agrega en la lista y en el xml(lo actualiza) **/
    public void agregarUsuario (Usuario unUsuario) {

        try {

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(nombreDelArchivo));
            Element raiz = doc.getRootElement();

            /** por ahora solo te deja tres, y si ya esta, no te los guarda un carajo, si queres más paga **/
            if (this.usuarios.size() < cantidadDeUsuariosPermitidos) {

            //this.cargarListaUsuarios(raiz);  /** EN EL MOMENTO QUE SE LLAMA LA LISTA YA FUE CARGADA **/
            //verifica que no haya repeticion
            Iterator<Usuario> iteradorUsuarios = this.usuarios.iterator();
            boolean duplicado = false;

            while (iteradorUsuarios.hasNext()){
                Usuario usuario = iteradorUsuarios.next();
                if (usuario.equals(unUsuario)) {
                    duplicado = true;
                    //VistaUsuarioYaExiste unaVista = new VistaUsuarioYaExiste();
                    System.out.println("estoy duplicado");
                }

            }
            if (!duplicado) {raiz.addContent(unUsuario.serializar());}

            this.actualizarArchivoXml(doc); // aca se llama a la frula: es decir se agrego pero hay que actualizar el archivo

            }

        } catch (Exception e) {System.out.println("no se pudo agregar el usuario al registoUsuarios.xml");}


    }

    /** toda la frula: se autoactualiza **/
    protected void actualizarArchivoXml(Document doc) {

        try{

            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream(nombreDelArchivo);
            out.output(doc,file);

            file.flush();
            file.close();

            //out.output(doc,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /** deberia tener un super consultor de existencia de archivos, y en caso de no tenerlos, crearlos..pero que paja **/
    /** el chabon se auto crea **/
    /*public void crearRegistroUsuariosXml() {

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

    /*private void cargarListaUsuarios ( Element nodoRegistroUsuarios ) {

        List<Element> hijos =  nodoRegistroUsuarios.getChildren();
        Iterator<Element> iteradorHijos = hijos.iterator();

        while (iteradorHijos.hasNext()) {

            Element nodoHijo = iteradorHijos.next();
            this.usuarios.add(new Usuario(nodoHijo));

        }

    } */

}

