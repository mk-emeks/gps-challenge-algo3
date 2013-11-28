package fiuba.algo3.control;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import fiuba.algo3.modelo.*;

import java.awt.event.KeyEvent;

public class ControlDeMovimiento implements KeyPressedObservador {

    private Vehiculo vehiculo;

    public ControlDeMovimiento(Vehiculo unVehiculo) {

        this.vehiculo = unVehiculo;

    }

    public void keyPressed(KeyEvent keyEvent) {
        int tecla = keyEvent.getKeyCode();

        switch (tecla) {

            case KeyEvent.VK_RIGHT:
                DireccionDerecha unaDireccionDerecha = new DireccionDerecha();
                this.vehiculo.setDireccion(unaDireccionDerecha);
                System.out.println("Me muevo para la derecha");
                break;

            case KeyEvent.VK_LEFT:
                DireccionIzquierda unaDireccionIzquierda = new DireccionIzquierda();
                this.vehiculo.setDireccion(unaDireccionIzquierda);
                System.out.println("Me muevo para la izquierda");
                break;

            case KeyEvent.VK_UP:
                DireccionArriba unaDireccionArriba = new DireccionArriba();
                this.vehiculo.setDireccion(unaDireccionArriba);
                System.out.println("Me muevo para la arriba");
                break;

            case KeyEvent.VK_DOWN:
                DireccionAbajo unaDireccionAbajo = new DireccionAbajo();
                this.vehiculo.setDireccion(unaDireccionAbajo);
                System.out.println("Me muevo para la abajo");
                break;
        }
    }

    public void keyRelease(KeyEvent e) {}

}
