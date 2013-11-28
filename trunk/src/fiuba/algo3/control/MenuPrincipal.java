package fiuba.algo3.control;


import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal {

    /** los control de cada "stage" donde el usuario elige **/
    //private ControlInicioNivel  controlInicioNivel;
    //private ControlInicioPartida controlInicioPartida;

    private JPanel panelBotonesPrincipales;

    public void cargarMenuPrincipal( final JFrame unMarco , Juego unJuego) {

        unMarco.getContentPane().removeAll();

        panelBotonesPrincipales = new JPanel();
        //panelBotonesPrincipales.setBackground(Color.DARK_GRAY);
        panelBotonesPrincipales.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
        // panelBotonesPrincipales.repaint();
        panelBotonesPrincipales.setLayout(null);


        JLabel fondo = new JLabel(new ImageIcon("src/fiuba/algo3/vista/imagenes/fondoMenuPrincipal.png"));
        fondo.setBounds(0,0,1440,900);
        fondo.repaint();

        /** Creo botones con las diferentes opciones **/
        JButton botonComenzarPartida = new JButton();//new ImageIcon("botonPartidaNueva.png"));
        botonComenzarPartida.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        botonComenzarPartida.setBounds(panelBotonesPrincipales.getWidth() - 900, 300, 369, 80);
        botonComenzarPartida.repaint();
        botonComenzarPartida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDesarrolloDelJuego unBoton = new MenuDesarrolloDelJuego(unMarco); /** no deberia estar **/
                /** controlInicioPartida.iniciarPartida(unMarco,unaPartida,unJugador,unNivel); **/
            }
        });


        JButton botonRetomarPartida = new JButton(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonAbrirPartida.png"));
        botonRetomarPartida.setBounds(panelBotonesPrincipales.getWidth()-900,450,369,80);
        botonRetomarPartida.repaint();

        JButton botonVerPuntajes = new JButton(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonVerPuntajes.png"));
        botonVerPuntajes.setBounds(panelBotonesPrincipales.getWidth()-900,600,369,80);
        botonVerPuntajes.repaint();
        /** ======================================================================= **/


        panelBotonesPrincipales.add(botonComenzarPartida);
        panelBotonesPrincipales.add(botonRetomarPartida);
        panelBotonesPrincipales.add(botonVerPuntajes);
        panelBotonesPrincipales.add(fondo);

        unMarco.getContentPane().add(panelBotonesPrincipales);

        unMarco.revalidate();
        unMarco.repaint();
    }

}
