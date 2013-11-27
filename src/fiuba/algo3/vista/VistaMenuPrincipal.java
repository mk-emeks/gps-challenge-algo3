package fiuba.algo3.vista;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaMenuPrincipal {

    private JPanel panelBotonesPrincipales;

    public VistaMenuPrincipal(final JFrame unMarco) {

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
        botonComenzarPartida.setBounds(panelBotonesPrincipales.getWidth()-900,300,369,80);
        botonComenzarPartida.repaint();
        botonComenzarPartida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //VistaDesarrolloJuego unBoton = new VistaDesarrolloJuego(unMarco);

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


    public static void main(String[] argv) {

        /** Esta primera parte deberia estar creada en el control si uno quiere **/
        JFrame marcoPrincipal = new JFrame();
        marcoPrincipal.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        marcoPrincipal.setBounds(0, 0, screenSize.width, screenSize.height);
        marcoPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoPrincipal.setLayout(null);
        marcoPrincipal.setVisible(true);
        /** ======================================================================= **/

        VistaMenuPrincipal ventana = new VistaMenuPrincipal(marcoPrincipal);


    }
}
