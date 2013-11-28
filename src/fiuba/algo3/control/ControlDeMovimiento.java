package fiuba.algo3.control;


import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.Vehiculo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlDeMovimiento {

    public KeyListener unKey;

    public KeyListener devolverKey(final Vehiculo unVehiculo) {


         this.unKey = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int tecla = keyEvent.getKeyCode();

                switch (tecla) {

                    case KeyEvent.VK_RIGHT:
                        DireccionDerecha unaDireccionDerecha = new DireccionDerecha();
                        unVehiculo.setDireccion(unaDireccionDerecha);
                        System.out.println("Me muevo para la derecha");
                        break;

                    case KeyEvent.VK_LEFT:
                        DireccionIzquierda unaDireccionIzquierda = new DireccionIzquierda();
                        unVehiculo.setDireccion(unaDireccionIzquierda);
                        System.out.println("Me muevo para la izquierda");
                        break;

                    case KeyEvent.VK_UP:
                        DireccionArriba unaDireccionArriba = new DireccionArriba();
                        unVehiculo.setDireccion(unaDireccionArriba);
                        System.out.println("Me muevo para la arriba");
                        break;

                    case KeyEvent.VK_DOWN:
                        DireccionAbajo unaDireccionAbajo = new DireccionAbajo();
                        unVehiculo.setDireccion(unaDireccionAbajo);
                        System.out.println("Me muevo para la abajo");
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };

        return unKey;
    }

}

