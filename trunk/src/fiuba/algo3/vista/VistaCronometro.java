package fiuba.algo3.vista;


import fiuba.algo3.modelo.Cronometro;

import javax.swing.*;
import java.awt.*;

public class VistaCronometro {

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

    public VistaCronometro(Cronometro cronometroPiloto) {

        this.unCronometro= cronometroPiloto;
        vistaTiempo = new JLabel("00:00:00");
        vistaTiempo.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        vistaTiempo.setForeground(new Color(197, 104, 13));
        vistaTiempo.setBounds(100,500,300,40);
        vistaTiempo.setVisible(false);


    }

    public Thread dameHiloTiempo() {
        return hiloTiempo;
    }

    public  JLabel devolverTiempoLabel() {
        return vistaTiempo;
    }
}
