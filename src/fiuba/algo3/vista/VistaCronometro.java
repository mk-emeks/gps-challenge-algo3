package fiuba.algo3.vista;


import fiuba.algo3.modelo.Cronometro;

import javax.swing.*;
import java.awt.*;

public class VistaCronometro extends VistaMenu implements Runnable {

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

    /*public void setText (String texto) {

        this.vistaTiempo.setText(texto);
    }*/

    public void setVisible(boolean visibilidad) {

        this.vistaTiempo.setVisible(visibilidad);

    }

    public boolean isVisible() {

        return this.vistaTiempo.isVisible();
    }

    private boolean estaEnEjecucion;
    private Thread hilo;

    public boolean estaEnEjecucion(){
        return this.estaEnEjecucion;
    }

    public void comenzarAnimacion() {
        this.estaEnEjecucion = true;
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public void detenerAnimacion() {
        this.estaEnEjecucion = false;
        this.hilo.interrupt();
    }

    public void run(){

        estaEnEjecucion = true;
        while (estaEnEjecucion) {
            vistaTiempo.setText(unCronometro.devolverTiempoComoString());

            try {
                Thread.sleep(10);
            } catch (Exception e) { System.out.println("interrupcion a la vistaCronometro");}

        }
    }

}