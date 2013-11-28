package fiuba.algo3.control;


import ar.uba.fi.algo3.titiritero.vista.Panel;
import fiuba.algo3.control.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** no le cambie nada: -> aca se deberia comenzar la partida: relacion con la clase ControlInicioPartida  **/

public class MenuDesarrolloDelJuego {

    private JPanel panelDesarrolloJuego;
    private Panel panelDeMapa;
    private ControlInicioPartida controlInicioPartida = new ControlInicioPartida();

    /*private ControlInicioPartida controlInicioPartida;

    public MenuDesarrolloDelJuego() {

        this.controlInicioPartida = new ControlInicioPartida();

    }*/

    public void cargarMenuDesarrolloDelJuego( JFrame unMarco, Juego unJuego) {

        unMarco.getContentPane().removeAll();

        /** Creo panel para el menu **/
        panelDesarrolloJuego = new JPanel();
        //panelDesarrolloJuego.setBackground(Color.BLACK);
        panelDesarrolloJuego.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
       // panelDesarrolloJuego.repaint();
        panelDesarrolloJuego.setLayout(null);

        JLabel fondo = new JLabel(new ImageIcon("src/fiuba/algo3/vista/imagenes/fondoMenuPrincipal.png"));
        fondo.setBounds(0,0,1440,900);
        fondo.repaint();

        JButton botonVolver = new JButton();
        botonVolver.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonVolver.png"));
        botonVolver.setBounds(5,20,300,75);
        botonVolver.repaint();
        botonVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //VistaMenuPrincipal sosUnBoton = new VistaMenuPrincipal(unMarco);   !!!!!!

            }
        });
        /** ======================================================================= **/

        /** Creo panel donde se desarrolla el juego **/

        panelDeMapa = new ar.uba.fi.algo3.titiritero.vista.Panel(800, 600);
        panelDeMapa.setBackground(Color.ORANGE);
        panelDeMapa.setBounds(panelDesarrolloJuego.getWidth()-900,panelDesarrolloJuego.getHeight()-650, 800, 600);
        panelDeMapa.repaint();
        panelDeMapa.setLayout(null);

        controlInicioPartida.iniciarPartida(panelDeMapa,unJuego);  /*** clave!! inicia partida  **/

        /** Agrego cosas al frame **/
        panelDesarrolloJuego.add(botonVolver);
        panelDesarrolloJuego.add(panelDeMapa);
        panelDesarrolloJuego.add(fondo);
        unMarco.add(panelDesarrolloJuego);

        unMarco.revalidate();
        unMarco.repaint();

    }
}
