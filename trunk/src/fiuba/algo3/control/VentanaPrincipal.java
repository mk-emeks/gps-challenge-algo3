package fiuba.algo3.control;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import fiuba.algo3.modelo.*;
import ar.uba.fi.algo3.titiritero.vista.Panel;
import fiuba.algo3.vista.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar menu;
    private JMenu juego, ayuda;
    private JMenuItem juegoNuevo,guardarPartida,cargarPartida,itemHistorial,salir,acercaDe;
    private AcercaDe labelAcercaDe;
    private HistorialJugadores historial;
    private Panel zonaDeJuego;

    public VentanaPrincipal() {

        /** Configuracion de la ventana **/

        setLayout(null);
        setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Menu **/
        crearMenuBar();

        /** Zona de Juego **/


        /*zonaDeJuego = new Panel(screenSize.width - 400, screenSize.height, new ControladorJuego(false) );
        zonaDeJuego.setLayout(null);
        zonaDeJuego.setBounds(390, 0, screenSize.width - 400, screenSize.height);*/
        //zonaDeJuego.setBackground(Color.DARK_GRAY);


        /*BufferedImage miImagen = new BufferedImage(screenSize.width - 400,screenSize.height,1);
        zonaDeJuego.setImagen(miImagen); */

        //El boton es para que veas donde esta la zona de juego, se puede borrar
        /*JButton boton = new JButton("ZONA DE JUEGO");
        boton.setBounds(0, 0, screenSize.width - 400, screenSize.height);
        zonaDeJuego.add(boton);   */


        //this.zonaDeJuego.setVisible(true);
        //this.add(this.zonaDeJuego);

        /** mostrate **/
        setVisible(true);

    }

    public void crearMenuBar() {

        labelAcercaDe = new AcercaDe();
        historial = new HistorialJugadores();
        menu = new JMenuBar();
        setJMenuBar(menu);
        juego = new JMenu("Juego...");
        menu.add(juego);
        juegoNuevo = new JMenuItem("Nuevo");
        juego.add(juegoNuevo);
        juegoNuevo.addActionListener(this);
        guardarPartida = new JMenuItem("Guardar");
        juego.add(guardarPartida);
        guardarPartida.addActionListener(this);
        cargarPartida = new JMenuItem("Cargar");
        juego.add(cargarPartida);
        cargarPartida.addActionListener(this);
        itemHistorial = new JMenuItem("Historial de jugadores");
        itemHistorial.addActionListener(this);
        juego.add(itemHistorial);
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        juego.add(salir);
        ayuda = new JMenu("Ayuda");
        menu.add(ayuda);
        acercaDe = new JMenuItem("Acerca de...");
        ayuda.add(acercaDe);
        acercaDe.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == acercaDe) {
            labelAcercaDe.setVisible(true);
        } else if ( e.getSource() == salir ) {
            System.exit(0);
        } else if (e.getSource() == itemHistorial) {
            historial.setVisible(true);
        }
    }

    public void crearPartida() {

        /** Eleccion Nivel **/
        Mapa.limpiar();
        Nivel nivel = new Nivel();


        /** Eleccion Nombre del Jugador **/
        Piloto piloto = new Piloto("pilotin");

        /** Nueva Partida **/

        Partida partida = new Partida(this,nivel,piloto);
        partida.iniciar();


    }

    public static void main(String[] argv) {

        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.crearPartida();


    }

}