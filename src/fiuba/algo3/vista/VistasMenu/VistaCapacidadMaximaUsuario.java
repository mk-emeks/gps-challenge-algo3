package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;
import java.awt.*;

public class VistaCapacidadMaximaUsuario {

    public VistaCapacidadMaximaUsuario() {
        {

            JDialog unFrame = new JDialog();
            unFrame.setBounds(200,200,450,120);
            unFrame.setLayout(null);

            unFrame.setDefaultCloseOperation(unFrame.DISPOSE_ON_CLOSE);

            JLabel labelMensaje1 = new JLabel();
            labelMensaje1.setText("Cupo de usuarios esta completo.");
            labelMensaje1.setForeground(new Color(197,0, 23));
            labelMensaje1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            labelMensaje1.setBounds(10,0,450,30);
            labelMensaje1.setVisible(true);

            JLabel labelMensaje2 = new JLabel();
            labelMensaje2.setText("Te vamos a dejar jugar igual!!!");
            labelMensaje2.setForeground(new Color(197,0, 23));
            labelMensaje2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            labelMensaje2.setBounds(10,30,450,30);
            labelMensaje2.setVisible(true);

            JLabel labelMensaje3 = new JLabel();
            labelMensaje3.setText("Cerrar para continuar");
            labelMensaje3.setForeground(new Color(197,0, 23));
            labelMensaje3.setFont(new Font(Font.SERIF, Font.BOLD, 10));
            labelMensaje3.setBounds(10,60,450,30);
            labelMensaje3.setVisible(true);

            unFrame.add(labelMensaje1);
            unFrame.add(labelMensaje2);
            unFrame.add(labelMensaje3);

            unFrame.setVisible(true);

        }
    }
}