 //CLASE QUE SIRVE SI TENES LA PC DE LA NASA! :P
package fiuba.algo3.vista;


import fiuba.algo3.control.Juego;
import fiuba.algo3.modelo.*;

import javax.swing.*;

//Esta clase se usa creandola y comenzando animacion, su set visible solo la deja invisible

public class BotonAnimadoVehiculo extends VistaMenu implements Runnable {

    private Juego juego;


    private JLabel fotoAuto;
    private JLabel fotoMoto;
    private JLabel foto4x4;

    private JLabel fotoAlf;


    public BotonAnimadoVehiculo(Juego unJuego,JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.juego = unJuego;

        fotoAlf = new JLabel();

        fotoAlf.setBounds(posicionX, posicionY, ancho, largo);
        fotoAlf.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/alfBorracho.png"));
        unMarco.add(fotoAlf);
        fotoAlf.setVisible(false);


        fotoAuto = new JLabel();
        fotoAuto.setBounds(posicionX,posicionY,ancho,largo);
        fotoAuto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/auto.png"));
        unMarco.add(fotoAuto);
        fotoAuto.setVisible(false);

        fotoMoto= new JLabel();
        fotoMoto.setBounds(posicionX, posicionY, ancho, largo);
        fotoMoto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/moto.png"));
        unMarco.add(fotoMoto);
        fotoMoto.setVisible(false);

        foto4x4 = new JLabel();
        foto4x4.setBounds(posicionX,posicionY,ancho,largo);
        foto4x4.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/canyonero.png"));
        unMarco.add(foto4x4);
        foto4x4.setVisible(false);

    }

   //mintiendole al usuario
    public void setVisible ( boolean visibilidad) {

        fotoAuto.setVisible(false);
        fotoMoto.setVisible(false);
        foto4x4.setVisible(false);
        fotoAlf.setVisible(false);
    }

    //no sirve
    public boolean isVisible() {

        return false;
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

    private Estado estadoAuto = new EstadoAuto();
    private Estado estadoMoto = new EstadoMoto();
    private Estado estado4x4 = new Estado4x4();
    private Estado estadoAlf = new EstadoAlf();

    public void run() {

        while (estaEnEjecucion) {
            Estado estadoAcomparar = juego.getPiloto().getVehiculo().getEstado();

            if  (estadoAcomparar.equals(estadoAuto)) {
                fotoAuto.setVisible(true);
                fotoMoto.setVisible(false);
                foto4x4.setVisible(false);
                fotoAlf.setVisible(false);

             } else if (estadoAcomparar.equals(estadoMoto)) {
                fotoAuto.setVisible(false);
                fotoMoto.setVisible(true);
                foto4x4.setVisible(false);
                fotoAlf.setVisible(false);

            } else if (estadoAcomparar.equals(estado4x4)) {
                fotoAuto.setVisible(false);
                fotoMoto.setVisible(false);
                foto4x4.setVisible(true);
                fotoAlf.setVisible(false);
            } else if (estadoAcomparar.equals(estadoAlf)) {

                fotoAuto.setVisible(false);
                fotoMoto.setVisible(false);
                foto4x4.setVisible(false);
                fotoAlf.setVisible(true);
            }

            try {
            hilo.sleep(310);
            } catch (InterruptedException e) {System.out.println("interrupcion al boton animado"); }
        }
    }





    }

