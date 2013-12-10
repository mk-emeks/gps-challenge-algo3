package fiuba.algo3.vista;


import fiuba.algo3.persistencia.RegistroUsuariosConPuntuacion;
import fiuba.algo3.persistencia.UsuarioConPuntuacion;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class BoxUsuariosConPuntajes extends fiuba.algo3.vista.Box {

    RegistroUsuariosConPuntuacion registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion();
    ArrayList<UsuarioConPuntuacion> listaUsuariosConPuntajes;

    public BoxUsuariosConPuntajes(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco, posicionX, posicionY, ancho, largo);
        this.vistaDeLosBoxUsuarios();
    }

    private void vistaDeLosBoxUsuarios() {

        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(registroUsuariosConPuntuacion.getNombreDelArchivo()));
            Element raiz = doc.getRootElement();
            registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion(raiz);

        } catch (Exception e) {System.out.println("no se pudo cargar el registro de usuarios con puntuacion");}

        listaUsuariosConPuntajes = registroUsuariosConPuntuacion.getUsuariosConPuntuacion();

        try {

            this.itembox1.setText("1) " + listaUsuariosConPuntajes.get(0).getNombre() + "   " + listaUsuariosConPuntajes.get(0).getPuntuacionComoString());
            this.itembox1.setForeground(new Color(197, 104, 13));
            this.itembox1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 1er usuario"); }

        try {
            this.itembox2.setText("2) " + listaUsuariosConPuntajes.get(1).getNombre() + "   " + listaUsuariosConPuntajes.get(1).getPuntuacionComoString());
            this.itembox2.setForeground(new Color(197, 104, 13));
            this.itembox2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 2er usuario"); }

        try{
            this.itembox3.setText("3) " + listaUsuariosConPuntajes.get(2).getNombre() + "   " + listaUsuariosConPuntajes.get(2).getPuntuacionComoString());
            this.itembox3.setForeground(new Color(197, 104, 13));
            this.itembox3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 3er usuario"); }
    }

    @Override
    public void setVisible ( boolean visibilidad) {

        if(visibilidad) {
            this.vistaDeLosBoxUsuarios();
        }

        this.itembox1.setVisible(visibilidad);
        this.itembox2.setVisible(visibilidad);
        this.itembox3.setVisible(visibilidad);

    }

}