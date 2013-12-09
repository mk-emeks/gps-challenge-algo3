package fiuba.algo3.vista.VistasMenu;


import fiuba.algo3.persistencia.RegistroUsuarios;
import fiuba.algo3.persistencia.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoxUsuariosExistentes extends Box {


    public BoxUsuariosExistentes (RegistroUsuarios registroUsuarios ,JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);

        ArrayList<Usuario> listaUsuarios = registroUsuarios.getUsuarios();

        try {
            this.itembox1.setText(listaUsuarios.get(0).getNombre());
            this.itembox1.setForeground(new Color(197, 104, 13));
            this.itembox1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 1er usuario"); }

        try {
            this.itembox2.setText(listaUsuarios.get(1).getNombre());
            this.itembox2.setForeground(new Color(197, 104, 13));
            this.itembox2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 2er usuario"); }

        try{
            this.itembox3.setText(listaUsuarios.get(2).getNombre());
            this.itembox3.setForeground(new Color(197, 104, 13));
            this.itembox3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        } catch (Exception e1) { System.out.println("error al cargar el nombre del 3er usuario"); }


    }



    public JLabel getItemBox1erNombre() {
        return this.itembox1;
    }

    public JLabel getItemBox2doNombre() {
        return this.itembox2;
    }

    public JLabel getItemBox3erNombre() {
        return this.itembox3;
    }

}
