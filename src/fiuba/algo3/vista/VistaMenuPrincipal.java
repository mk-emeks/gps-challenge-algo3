package fiuba.algo3.vista;



//import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaMenuPrincipal {
    /*
    private JPanel panelBotonesPrincipales;

    public VistaMenuPrincipal(final JFrame unMarco) {

        unMarco.getContentPane().removeAll();

        panelBotonesPrincipales = new JPanel();
        panelBotonesPrincipales.setBackground(Color.DARK_GRAY);
        panelBotonesPrincipales.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
        panelBotonesPrincipales.repaint();
        panelBotonesPrincipales.setLayout(null);


        //JLabel fondo = new JLabel(new ImageIcon());
        //fondo.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
        //fondo.repaint();

        /** Creo botones con las diferentes opciones **/ /*
        JButton botonComenzarPartida = new JButton("Comenzar Partida");
        botonComenzarPartida.setBounds(0,0,300,75);
        botonComenzarPartida.repaint();
        botonComenzarPartida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VistaDesarrolloJuego unBoton = new VistaDesarrolloJuego(unMarco);

            }
        });

        JButton botonRetomarPartida = new JButton("Retomar Partida Guardada");
        botonRetomarPartida.setBounds(0,300,300,75);
        botonRetomarPartida.repaint();

        JButton botonVerPuntajes = new JButton("Ver Puntajes");
        botonVerPuntajes.setBounds(0,150,300,75);
        botonVerPuntajes.repaint();
        /** ======================================================================= **/

        /*
        panelBotonesPrincipales.add(botonComenzarPartida);
        panelBotonesPrincipales.add(botonRetomarPartida);
        panelBotonesPrincipales.add(botonVerPuntajes);
        unMarco.getContentPane().add(panelBotonesPrincipales);

        unMarco.revalidate();
        unMarco.repaint();
    }

    /*
    public static void main(String[] argv) {

        // Esta primera parte deberia estar creada en el control si uno quiere
        JFrame marcoPrincipal = new JFrame();
        marcoPrincipal.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        marcoPrincipal.setBounds(0, 0, screenSize.width, screenSize.height);
        marcoPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoPrincipal.setLayout(null);
        marcoPrincipal.setVisible(true);
        // =======================================================================

        VistaMenuPrincipal ventana = new VistaMenuPrincipal(marcoPrincipal);


    }   */




}
