package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Mapa;
//import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.masterOfPuppets.SuperficiePanel;

import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.vista.AcercaDe;
import fiuba.algo3.vista.HistorialJugadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


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

        /** Agrego ZonaDeJuego **/
        final SuperficiePanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(400, 0, unMarco.getWidth() - 400, unMarco.getHeight());
        zonaDeJuego.setBackground(Color.GRAY);
        zonaDeJuego.setVisible(false);
        unMarco.getContentPane().add(zonaDeJuego);



        /** Creo la partida **/

        final Partida unaPartida = new Partida();
        unaPartida.asignarZonaDeJuego(zonaDeJuego);

        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();

        /**!**/
        zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));

        /** inicio BototComenzar **/
        final JButton unBotonComenzar = new JButton();
        unBotonComenzar.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        unBotonComenzar.setBounds(0,300,369,80);
        unMarco.getContentPane().add(unBotonComenzar);

        /** inicio BotonFinalizar **/
        final JButton unBotonFinalizar = new JButton();
        unBotonFinalizar.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        unBotonFinalizar.setBounds(0,600,369,80);
        unMarco.getContentPane().add(unBotonFinalizar);

        unMarco.repaint();


        /** Accion BotonComenzar **/
        unBotonComenzar.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {

                //unBotonComenzar.setVisible(false);
                //unBotonComenzar.setFocusable(false);
                //unMarco.remove(unBotonComenzar); /**SIRVE, hasta ahi**/



                /** no borarr **/
                /*SuperficiePanel zonaDeJuego = new SuperficiePanel();
                zonaDeJuego.setBounds(400, 0, unMarco.getWidth() - 400, unMarco.getHeight());
                //zonaDeJuego.setBackground(Color.DARK_GRAY);
                //zonaDeJuego.setVisible(true);
                //zonaDeJuego.repaint();

                // AGREGALO Y DESPUES SETIALE ALGUNA PROPIEDAD
                unMarco.getContentPane().add(zonaDeJuego);

                zonaDeJuego.setBackground(Color.GRAY);
                zonaDeJuego.paint(unMarco.getGraphics());*/



                /** VAMOS A JUGAR**/

                //final Partida unaPartida = new Partida();
                /*unaPartida.asignarZonaDeJuego(zonaDeJuego);

                Mapa.limpiar();
                Nivel nivel = new Nivel();
                unaPartida.cargarNivel(nivel);
                unaPartida.crearPiloto("pilotin");
                unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
                unaPartida.cargarVehiculoParaElPiloto();    */



                //unBotonComenzar.setFocusable(false);
                /**zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));**/

                /*zonaDeJuego.add(unBotonComenzar);
                unBotonComenzar.setVisible(true);
                zonaDeJuego.paint(zonaDeJuego.getGraphics());*/



                unaPartida.iniciar();
                zonaDeJuego.removeNotify();
                /**zonaDeJuego.setBackground(Color.GRAY);
                zonaDeJuego.paint(unMarco.getGraphics());*/
                //unBotonFinalizar.setFocusable(true);

           }
        });

        /** Accion BotonFinalizar **/
        unBotonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                unBotonComenzar.setVisible(false);
                //unMarco.remove(unBotonComenzar);
                unMarco.repaint();


            }

        });





        JMenuBar menu = new JMenuBar();
        unMarco.setJMenuBar(menu);

        JMenu juego = new JMenu("Juego...");
        menu.add(juego);


        AcercaDe labelAcercaDe = new AcercaDe();
        HistorialJugadores historial = new HistorialJugadores();
        JMenuItem juegoNuevo = new JMenuItem("Nuevo");
        juego.add(juegoNuevo);
        //juegoNuevo.addActionListener(unMarco);
        JMenuItem guardarPartida = new JMenuItem("Guardar");
        juego.add(guardarPartida);
        //guardarPartida.addActionListener(this);
        JMenuItem cargarPartida = new JMenuItem("Cargar");
        juego.add(cargarPartida);
        //cargarPartida.addActionListener(this);
        JMenuItem itemHistorial = new JMenuItem("Historial de jugadores");
        //itemHistorial.addActionListener(this);
        juego.add(itemHistorial);
        JMenuItem salir = new JMenuItem("Salir");
        //salir.addActionListener(this);
        juego.add(salir);
        JMenuItem ayuda = new JMenu("Ayuda");
        menu.add(ayuda);
        JMenuItem acercaDe = new JMenuItem("Acerca de...");
        ayuda.add(acercaDe);
        //acercaDe.addActionListener(this);





    /** llave del main **/
    }

}

