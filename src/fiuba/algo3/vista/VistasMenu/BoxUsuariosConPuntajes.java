package fiuba.algo3.vista.VistasMenu;


import fiuba.algo3.persistencia.RegistroUsuariosConPuntuacion;
import fiuba.algo3.persistencia.Usuario;
import fiuba.algo3.persistencia.UsuarioConPuntuacion;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class BoxUsuariosConPuntajes extends Box {

    RegistroUsuariosConPuntuacion registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion();
    ArrayList<UsuarioConPuntuacion> listaUsuariosConPuntajes;

    public BoxUsuariosConPuntajes(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco, posicionX, posicionY, ancho, largo);


        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(registroUsuariosConPuntuacion.getNombreDelArchivo()));
            Element raiz = doc.getRootElement();
            registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion(raiz);

        } catch (Exception e) {System.out.println("no se pudo cargar el registro de usuarios con puntuacion");}

        listaUsuariosConPuntajes = registroUsuariosConPuntuacion.getUsuariosConPuntuacion();
        this.vistaDeLosBoxUsuarios();
    }

    private void vistaDeLosBoxUsuarios() {
        try {

            this.itembox1.setText(listaUsuariosConPuntajes.get(0).getNombre() + "   " + listaUsuariosConPuntajes.get(0).getPuntuacion());
            this.itembox1.setForeground(new Color(197, 104, 13));
            this.itembox1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 1er usuario"); }

        try {
            this.itembox2.setText(listaUsuariosConPuntajes.get(1).getNombre() + "   " + listaUsuariosConPuntajes.get(1).getPuntuacion());
            this.itembox2.setForeground(new Color(197, 104, 13));
            this.itembox2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 2er usuario"); }

        try{
            this.itembox3.setText(listaUsuariosConPuntajes.get(2).getNombre() + "   " + listaUsuariosConPuntajes.get(2).getPuntuacion());
            this.itembox3.setForeground(new Color(197, 104, 13));
            this.itembox3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 3er usuario"); }
    }

    @Override
    public void setVisible ( boolean visibilidad) {

        if(visibilidad) {
            this.vistaDeLosBoxUsuarios();
        }
    }

}
