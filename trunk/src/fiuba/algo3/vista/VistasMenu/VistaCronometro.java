package fiuba.algo3.vista.VistasMenu;


import fiuba.algo3.modelo.Cronometro;

import javax.swing.*;
import java.awt.*;

public class VistaCronometro extends VistaMenu {

    public Cronometro unCronometro = new Cronometro();
    JLabel vistaTiempo;

    Thread hiloTiempo = new Thread(){
        public void run(){
            try {
                while (!unCronometro.estaPausado()) {

                    Thread.sleep(850);
                    unCronometro.contar();
                    vistaTiempo.setText(unCronometro.devolverTiempoComoString());
                }
            } catch(Exception e){}
        }
    };

    public VistaCronometro(Cronometro cronometroPiloto , JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.unCronometro= cronometroPiloto;
        vistaTiempo = new JLabel("00:00:00");
        vistaTiempo.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        vistaTiempo.setForeground(new Color(197, 104, 13));
        vistaTiempo.setBounds(posicionX,posicionY,ancho,largo);
        unMarco.add(vistaTiempo);


    }

    public Thread getThread() {
        return hiloTiempo;
    }

    public void setVisible(boolean visibilidad) {

        this.vistaTiempo.setVisible(visibilidad);

    }

    public boolean isVisible() {

        return this.vistaTiempo.isVisible();
    }
}
