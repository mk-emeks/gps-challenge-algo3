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
        Partida unaPartida = new Partida();

        JFrame unMarco = new JFrame();
        unMarco.setLayout(null);
        unMarco.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        unMarco.setBounds(0, 0, screenSize.width, screenSize.height);
        unMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unMarco.setVisible(true);


        /** zona de juego **/
        SuperficiePanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(400, 0, screenSize.width - 400, screenSize.height);
        zonaDeJuego.setBackground(Color.black);

        zonaDeJuego.setVisible(true);

        unaPartida.asignarZonaDeJuego(zonaDeJuego);
        unMarco.getContentPane().add(zonaDeJuego);

        /** VAMOS A JUGAR**/
        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();

        zonaDeJuego.setFocusable(true);
        zonaDeJuego.addKeyListener((new Pausa(unaPartida)));
        zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));

        unaPartida.iniciar();


    }




}
