package fiuba.algo3.vista;


import javax.swing.*;
import java.awt.*;

public class VistaInstrucciones {

    public VistaInstrucciones() {


        JDialog unDialog = new JDialog();
        unDialog.setBounds(50,50,770,700);
        unDialog.setTitle("Instrucciones");
        unDialog.setLayout(null);
        unDialog.setDefaultCloseOperation(unDialog.DISPOSE_ON_CLOSE);
        unDialog.setModal(true);


        JLabel instrucciones = new JLabel();
        instrucciones.setBounds(0,0,770,670);
        instrucciones.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/instrucciones.png"));
        instrucciones.setVisible(true);

        unDialog.add(instrucciones);
        unDialog.setVisible(true);
    }
}
