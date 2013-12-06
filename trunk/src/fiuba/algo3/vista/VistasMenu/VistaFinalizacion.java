package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;
import java.awt.*;

public class VistaFinalizacion {

    public VistaFinalizacion() {

        JFrame frameResultado = new JFrame();
        frameResultado.setBounds(500,200,300,120);
        //Si se usa la imagen descomentar la linea de abajo y comentar la de arriba
        //frameResultado.setBounds(500,200,300,180);
        frameResultado.setLayout(null);
        frameResultado.setDefaultCloseOperation(frameResultado.DISPOSE_ON_CLOSE);

        JLabel labelResultado = new JLabel();
        labelResultado.setText("LLegaste a la FIUBA!!");
        labelResultado.setForeground(new Color(197,0, 23));
        labelResultado.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        labelResultado.setBounds(50,0,200,30);
        labelResultado.setVisible(true);

        frameResultado.add(labelResultado);
        /** Hay un tema cuando se crea la imagen, por consola tira un interrupt y no la carga completa.

        JLabel imagenResultado = new JLabel();
        imagenResultado.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/resultado.png"));
        imagenResultado.setBounds(80, 30, 120, 120);
        imagenResultado.setVisible(true);

        frameResultado.add(imagenResultado);
         **/

        frameResultado.setVisible(true);

    }
}
