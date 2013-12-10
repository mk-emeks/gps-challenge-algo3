package fiuba.algo3.vista.VistasMenu;


import javax.swing.*;
import java.awt.*;

public class VistaInstrucciones {

    public VistaInstrucciones() {


        JDialog unFrame = new JDialog();
        unFrame.setBounds(50,50,770,700);
        unFrame.setTitle("Instrucciones");
        unFrame.setLayout(null);
        unFrame.setResizable(false);
        unFrame.setDefaultCloseOperation(unFrame.DISPOSE_ON_CLOSE);


        JLabel instrucciones = new JLabel();
        instrucciones.setBounds(0,0,770,670);
        instrucciones.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/instrucciones.png"));
        instrucciones.setVisible(true);

        unFrame.add(instrucciones);
        unFrame.setVisible(true);
    }
}
