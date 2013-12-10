package fiuba.algo3.vista.VistasMenu;


import javax.swing.*;
import java.awt.*;

public class VistaUsuarioYaExiste {

    public VistaUsuarioYaExiste() {
        {

            JFrame unFrame = new JFrame();
            unFrame.setBounds(200,200,400,90);
            unFrame.setLayout(null);

            unFrame.setDefaultCloseOperation(unFrame.DISPOSE_ON_CLOSE);

            JLabel labelMensaje1 = new JLabel();
            labelMensaje1.setText("Ese usuario ya estaba registrado");
            labelMensaje1.setForeground(new Color(197,0, 23));
            labelMensaje1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            labelMensaje1.setBounds(10,0,400,30);
            labelMensaje1.setVisible(true);

            JLabel labelMensaje2 = new JLabel();
            labelMensaje2.setText("Cerrar para continuar");
            labelMensaje2.setForeground(new Color(197,0, 23));
            labelMensaje2.setFont(new Font(Font.SERIF, Font.BOLD, 10));
            labelMensaje2.setBounds(10,30,400,30);
            labelMensaje2.setVisible(true);

            unFrame.add(labelMensaje1);
            unFrame.add(labelMensaje2);

            unFrame.setVisible(true);

        }
    }
}
