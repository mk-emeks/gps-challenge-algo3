package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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

        SuperficiePanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(400, 0, screenSize.width - 400, screenSize.height);
        zonaDeJuego.setBackground(Color.black);

        zonaDeJuego.setVisible(true);

        unaPartida.asignarZonaDeJuego(zonaDeJuego);
        unMarco.getContentPane().add(zonaDeJuego);

        /** VAMOS A JUGAR**/
        Mapa.limpiar();
        Nivel nivel = new Nivel();


        zonaDeJuego.setFocusable(true);

        unaPartida.crearPiloto("pilotin");
        unaPartida.cargarNivel(nivel);
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();


        zonaDeJuego.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {

                int tecla = e.getKeyCode();

                switch (tecla){
                    case KeyEvent.VK_RIGHT:
                        System.out.println("Me muevo para la Derecha");
                        break;

                    case KeyEvent.VK_LEFT:
                        System.out.println("Me muevo para la Izquierda");
                        break;

                    case KeyEvent.VK_UP:
                        System.out.println("Me muevo para la Arriba");
                        break;

                    case KeyEvent.VK_DOWN:
                        System.out.println("Me muevo para la Abajo");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });


        unaPartida.iniciar();





    }




}
