package fiuba.algo3.vista.VistasMenu;

import fiuba.algo3.control.Juego;

import javax.swing.*;
import java.awt.*;

public class VistaFinalizacion extends VistaMenu {

    Juego juego;
    JDialog frameResultado = new JDialog();

    Thread hilo = new Thread() {
        public void run(){

            try {
                Thread.sleep(300);
                while (!juego.estaTerminada()) {
                    frameResultado.setVisible(false);
                }

                frameResultado.setVisible(true);

            } catch (Exception e) {}
        }
    };



    public VistaFinalizacion(Juego unJuego) {

        this.juego = unJuego;

        frameResultado.setBounds(700,300,300,200);
        frameResultado.setLayout(null);
        frameResultado.setDefaultCloseOperation(frameResultado.DISPOSE_ON_CLOSE);

        JLabel labelResultado = new JLabel();
        labelResultado.setText("LLegaste a la FIUBA!!");
        labelResultado.setForeground(new Color(197,0, 23));
        labelResultado.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        labelResultado.setBounds(30,0,300,30);
        labelResultado.setVisible(true);

        frameResultado.add(labelResultado);

        JLabel imagenResultado = new JLabel();
        imagenResultado.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/resultado.png"));
        imagenResultado.setBounds(90, 40, 120, 120);
        imagenResultado.setVisible(true);

        frameResultado.add(imagenResultado);

        JLabel labelMensaje = new JLabel();
        labelMensaje.setText("Cerrar para continuar");
        labelMensaje.setForeground(new Color(197,0, 23));
        labelMensaje.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        labelMensaje.setBounds(90,150,400,30);
        labelMensaje.setVisible(true);

        frameResultado.add(labelMensaje);

    }



   /* @Override
    public void setVisible(boolean visibilidad) {}

    @Override
    public boolean isVisible() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void comenzarVista() {

        this.hilo.start();

    }*/
}
