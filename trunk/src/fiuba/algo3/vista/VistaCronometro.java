package fiuba.algo3.vista;


import fiuba.algo3.modelo.Cronometro;

import javax.swing.*;
import java.awt.*;

public class VistaCronometro extends VistaMenu {

    public Cronometro unCronometro = new Cronometro();
    JLabel vistaTiempo;

    public VistaCronometro(Cronometro cronometroPiloto , JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.unCronometro= cronometroPiloto;
        vistaTiempo = new JLabel(this.unCronometro.devolverTiempoComoString());
        vistaTiempo.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        vistaTiempo.setForeground(new Color(197, 104, 13));
        vistaTiempo.setBounds(posicionX,posicionY,ancho,largo);
        unMarco.add(vistaTiempo);


    }


    /** refactor; el modelo no conosca la vista **/
    /*Thread hilo;

    public void comenzarVista() {

        this.hilo = new Thread() {
            public void run(){

                try {
                    vistaTiempo.setText(unCronometro.devolverTiempoComoString());
                    Thread.sleep(10);

                } catch (Exception e) {}
            }
        };

        this.hilo.start();

    }*/

    public void setText (String texto) {

        this.vistaTiempo.setText(texto);
    }

    public void setVisible(boolean visibilidad) {

        this.vistaTiempo.setVisible(visibilidad);

    }

    public boolean isVisible() {

        return this.vistaTiempo.isVisible();
    }
}
