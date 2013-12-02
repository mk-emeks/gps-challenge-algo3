/** CLASE QUE SIRVE SI TENES LA PC DE LA NASA! :P
package fiuba.algo3.vista.VistasMenu;


import fiuba.algo3.control.Partida;
import fiuba.algo3.modelo.Estado;
import fiuba.algo3.modelo.EstadoAuto;
import fiuba.algo3.modelo.EstadoMoto;

import javax.swing.*;

//Esta clase se usa creandola y comenzando animacion, su set visible solo la deja invisible

public class BotonAnimadoVehiculo extends VistaMenu {

    Partida partida;
    //JLabel foto;

    JLabel fotoAuto;
    JLabel fotoMoto;
    JLabel foto4x4;


    public BotonAnimadoVehiculo(Partida unaPartida ,JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.partida = unaPartida;
        //foto = new JLabel();

        //foto.setBounds(posicionX, posicionY, ancho, largo);
        //unMarco.add(foto);

        fotoAuto = new JLabel();
        fotoAuto.setBounds(posicionX,posicionY,ancho,largo);
        fotoAuto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/Auto/auto.png"));
        unMarco.add(fotoAuto);
        fotoAuto.setVisible(false);

        fotoMoto= new JLabel();
        fotoMoto.setBounds(posicionX, posicionY, ancho, largo);
        fotoMoto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/Moto/moto.png"));
        unMarco.add(fotoMoto);
        fotoMoto.setVisible(false);

        foto4x4 = new JLabel();
        foto4x4.setBounds(posicionX,posicionY,ancho,largo);
        foto4x4.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Vehiculos/4x4/canyonero.png"));
        unMarco.add(foto4x4);
        foto4x4.setVisible(false);



    }

    Thread hilo = new Thread() {
        public void run(){

            try {
                Thread.sleep(100);
                Estado estadoAuto = new EstadoAuto();
                Estado estadoMoto = new EstadoMoto();

                while (!partida.estaFinalizada()) {

                    Estado estadoAcomparar = partida.getPiloto().getVehiculo().getEstado();
                    if  (estadoAcomparar.equals(estadoAuto)) {
                      fotoAuto.setVisible(true);
                      fotoMoto.setVisible(false);
                      foto4x4.setVisible(false);
                    } else {
                        if (estadoAcomparar.equals(estadoMoto)) {
                            fotoAuto.setVisible(false);
                            fotoMoto.setVisible(true);
                            foto4x4.setVisible(false);

                        } else {
                            fotoAuto.setVisible(false);
                            fotoMoto.setVisible(false);
                            foto4x4.setVisible(true);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("NO CARGE EL BOTON ANIMADO");
            }
        }
    };


   //mintiendole al usuario
    public void setVisible ( boolean visibilidad) {

        fotoAuto.setVisible(false);
        fotoMoto.setVisible(false);
        foto4x4.setVisible(false);
        //this.foto.setVisible(visibilidad);
    }

    //no sirve
    public boolean isVisible() {

        return false;
        //return this.foto.isVisible();
    }
    // fin

    public void comenzarAnimacion() {

        this.hilo.start();

    }



} **/

