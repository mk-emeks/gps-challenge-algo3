package fiuba.algo3.vista.VistasMenu;


import fiuba.algo3.control.Partida;
import fiuba.algo3.modelo.Estado;
import fiuba.algo3.modelo.EstadoAuto;
import fiuba.algo3.modelo.EstadoMoto;

import javax.swing.*;

/** Habria que meter un en el algun lado un hilo que vaya preguntando constantemente  **/

public class BotonAnimadoVehiculo extends VistaMenu {

    Partida partida;
    JLabel foto;


    public BotonAnimadoVehiculo(Partida unaPartida ,JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.partida = unaPartida;
        foto = new JLabel();
        //foto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/Moto/moto.png"));
        foto.setBounds(posicionX, posicionY, ancho, largo);
        unMarco.add(foto);
        //hilo.start();

    }

    Thread hilo = new Thread() {
        public void run(){

            try {
                Thread.sleep(850);
                Estado estadoAuto = new EstadoAuto();
                Estado estadoMoto = new EstadoMoto();

                while (!partida.estaFinalizada()) {

                    Estado estadoAcomparar = partida.getPiloto().getVehiculo().getEstado();
                    if  (estadoAcomparar.equals(estadoAuto)) {
                        foto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/Auto/auto.png"));
                    } else {
                        if (estadoAcomparar.equals(estadoMoto)) {
                            foto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/Moto/moto.png"));
                        } else {
                            foto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/4x4/canyonero.png"));

                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("NO CARGE EL BOTON ANIMADO");
            }
        }
    };



    public void setVisible ( boolean visibilidad) {

        this.foto.setVisible(visibilidad);
    }

    public boolean isVisible() {

        return this.foto.isVisible();
    }



}

