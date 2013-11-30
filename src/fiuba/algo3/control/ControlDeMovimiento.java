package fiuba.algo3.control;

import fiuba.algo3.modelo.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlDeMovimiento implements KeyListener {

    private Vehiculo vehiculo;

    public ControlDeMovimiento(Vehiculo unVehiculo) {

        this.vehiculo = unVehiculo;

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
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

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
