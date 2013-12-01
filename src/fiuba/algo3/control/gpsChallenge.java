package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;

import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class gpsChallenge {



    public static void main(String[] argv) {


        /** Configuracion Ventana **/
        final Partida unaPartida = new Partida();

        final JFrame unMarco = new JFrame("GPS Challenge");


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setLayout(null);


        JLabel botonComenzar = new JLabel();
        botonComenzar.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        botonComenzar.setBounds(0,0,369,80);
        unMarco.add(botonComenzar);


        /** zona de juego **/
        JPanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(400, 0, screenSize.width - 400, screenSize.height);
        zonaDeJuego.setBackground(Color.black);

        zonaDeJuego.setVisible(true);

        unaPartida.asignarZonaDeJuego(zonaDeJuego);
        unMarco.getContentPane().add(zonaDeJuego);
        unMarco.setVisible(true);

        botonComenzar.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                unaPartida.iniciar();


            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });




        /** VAMOS A JUGAR**/
        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();

        unMarco.setFocusable(true);
        unMarco.addKeyListener((new Pausa(unaPartida)));
        unMarco.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));









    }




}
