package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.vista.VistaDesarrolloJuego;
import fiuba.algo3.vista.VistaMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gpsChallenge {



    public static void main(String[] argv) {


        /** Configuracion Ventana **/
        //final Partida unaPartida = new Partida();

        JFrame unMarco = new JFrame();
        unMarco.setLayout(null);
        unMarco.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setVisible(true);



         VistaMenuPrincipal unMenuPrincipal = new VistaMenuPrincipal(unMarco);


        JButton botonComenzarPartida = new JButton();//new ImageIcon("botonPartidaNueva.png"));
        botonComenzarPartida.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        botonComenzarPartida.setBounds(/**unMenuPrincipal.getPanel().getWidth()-900**/0, 300, 369, 80);
        botonComenzarPartida.repaint();


        botonComenzarPartida.addActionListener(new ControlDeClick(unMarco));


        JButton botonRetomarPartida = new JButton(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonAbrirPartida.png"));
        botonRetomarPartida.setBounds(0,450,369,80);
        botonRetomarPartida.repaint();

        JButton botonVerPuntajes = new JButton(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonVerPuntajes.png"));
        botonVerPuntajes.setBounds(0,600,369,80);
        botonVerPuntajes.repaint();

        unMenuPrincipal.getPanel().add(botonComenzarPartida);
        unMenuPrincipal.getPanel().add(botonRetomarPartida);
        unMenuPrincipal.getPanel().add(botonVerPuntajes);
        unMenuPrincipal.activarFondo();

        /**
        unaPartida.asignarZonaDeJuego(zonaDeJuego);
        unMarco.getContentPane().add(zonaDeJuego);

        //VAMOS A JUGAR
        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();

        zonaDeJuego.setFocusable(true);
        zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));

        unaPartida.iniciar();   **/





    }




}
