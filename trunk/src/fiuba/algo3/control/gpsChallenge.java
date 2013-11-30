package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class gpsChallenge {



    public static void main(String[] argv) {


        /** Configuracion Ventana **/


        final JFrame unMarco = new JFrame();
        unMarco.setLayout(null);
        unMarco.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setVisible(true);

        final JButton unBotonComenzar = new JButton();
        unBotonComenzar.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        unBotonComenzar.setBounds(0,300,369,80);

        unMarco.getContentPane().add(unBotonComenzar);

        unBotonComenzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SuperficiePanel zonaDeJuego = new SuperficiePanel();
                zonaDeJuego.setBounds(400, 0, unMarco.getWidth() - 400, unMarco.getHeight());
                zonaDeJuego.setBackground(Color.black);
                zonaDeJuego.setVisible(true);
                zonaDeJuego.repaint();
                unMarco.getContentPane().add(zonaDeJuego);


                /** VAMOS A JUGAR**/

                Partida unaPartida = new Partida();
                unaPartida.asignarZonaDeJuego(zonaDeJuego);

                Mapa.limpiar();
                Nivel nivel = new Nivel();
                unaPartida.cargarNivel(nivel);
                unaPartida.crearPiloto("pilotin");
                unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
                unaPartida.cargarVehiculoParaElPiloto();

                zonaDeJuego.setFocusable(true);
                unBotonComenzar.setFocusable(false);
                zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));
                /**
                unaPartida.iniciar();  **/
            }
        });

    }




}
