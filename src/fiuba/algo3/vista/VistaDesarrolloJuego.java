package fiuba.algo3.vista;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaDesarrolloJuego {

    private JPanel panelDesarrolloJuego;
    private Panel panelDeMapa;

    public VistaDesarrolloJuego(final JFrame unMarco) {

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
                VistaMenuPrincipal sosUnBoton = new VistaMenuPrincipal(unMarco);

            }
        });
        /** ======================================================================= **/

        /** Creo panel donde se desarrolla el juego **/

        JPanel panelDeMapa = new JPanel();
        panelDeMapa.setBackground(Color.ORANGE);
        panelDeMapa.setBounds(panelDesarrolloJuego.getWidth()-900,panelDesarrolloJuego.getHeight()-650, 800, 600);
        panelDeMapa.repaint();
        panelDeMapa.setLayout(null);

        /** Agrego cosas al frame **/
        panelDesarrolloJuego.add(botonVolver);
        panelDesarrolloJuego.add(panelDeMapa);
        panelDesarrolloJuego.add(fondo);
        unMarco.add(panelDesarrolloJuego);

        unMarco.revalidate();
        unMarco.repaint();

    }
}
