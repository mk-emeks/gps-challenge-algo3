package fiuba.algo3.vista;

import fiuba.algo3.control.Juego;

import javax.swing.*;
import java.awt.*;

public class VistaFinalizacion extends VistaMenu {

    Juego juego;
    JDialog dialogResultado = new JDialog();
    Thread hilo;


    public VistaFinalizacion(Juego unJuego) {

        this.juego = unJuego;

        dialogResultado.setBounds(700,300,300,200);
        dialogResultado.setLayout(null);
        dialogResultado.setDefaultCloseOperation(dialogResultado.DISPOSE_ON_CLOSE);
        dialogResultado.setModal(true);

        JLabel labelResultado = new JLabel();
        labelResultado.setText("LLegaste a la FIUBA!!");
        labelResultado.setForeground(new Color(197,0, 23));
        labelResultado.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        labelResultado.setBounds(30,0,300,30);
        labelResultado.setVisible(true);

        dialogResultado.add(labelResultado);

        JLabel imagenResultado = new JLabel();
        imagenResultado.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/resultado.png"));
        imagenResultado.setBounds(90, 40, 120, 120);
        imagenResultado.setVisible(true);

        dialogResultado.add(imagenResultado);

        JLabel labelMensaje = new JLabel();
        labelMensaje.setText("Cerrar para continuar");
        labelMensaje.setForeground(new Color(197,0, 23));
        labelMensaje.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        labelMensaje.setBounds(90,150,400,30);
        labelMensaje.setVisible(true);

        dialogResultado.add(labelMensaje);

    }



    @Override
    public void setVisible(boolean visibilidad) {}

    @Override
    public boolean isVisible() {
        return false;
    }

    public void comenzarVista() {

        this.hilo = new Thread() {
            public void run(){

                try {
                    Thread.sleep(300);
                    while (!juego.estaTerminada()) {
                        dialogResultado.setVisible(false);
                    }

                    dialogResultado.setVisible(true);

                } catch (Exception e) {}
            }
        };

        this.hilo.start();

    }
}
