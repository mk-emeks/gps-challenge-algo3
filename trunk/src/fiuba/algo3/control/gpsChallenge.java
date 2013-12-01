package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;
 import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import javax.swing.*;
import java.awt.*;



public class gpsChallenge {



    public static void main(String[] argv) {


        /** Configuracion Ventana **/


        JFrame unMarco = new JFrame("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setLayout(null);

        /** Creo el falso boton **/
        JLabel botonComenzar = new JLabel();
        botonComenzar.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonPartidaNueva.png"));
        botonComenzar.setBounds(0,0,369,80);
        unMarco.add(botonComenzar);


        /** zona de juego **/
        JPanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(440,50,870, 620); /** lo que mejor le queda? **/
        zonaDeJuego.setBackground(new Color(127, 197, 110));
        unMarco.add(zonaDeJuego);



        /**Creo Fondo **/
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/fondoMenuPrincipal.png"));
        fondo.setBounds(0,0,unMarco.getWidth(),unMarco.getHeight());
        unMarco.add(fondo);


        /**Una vez que se agrego lo que necesitamos al marco, se lo hace visible**/
        unMarco.setVisible(true);


        /** VAMOS A JUGAR**/
        Partida unaPartida = new Partida();
        unaPartida.asignarZonaDeJuego(zonaDeJuego);

        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();


        /**IMPORTANTE, EL MARCO ES EL QUE TIENE EL CONTROL DE MOVIMIENTOS **/
        unMarco.setFocusable(true);
        unMarco.addKeyListener((new Pausa(unaPartida)));
        unMarco.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));


        /** Control del boton**/
        botonComenzar.addMouseListener(new ControlDeClick(unaPartida,botonComenzar));

    }
}
