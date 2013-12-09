package fiuba.algo3.control;

import fiuba.algo3.modelo.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlDeMovimiento implements KeyListener {

    private Juego juego;

    public ControlDeMovimiento(Juego unJuego) {

        this.juego = unJuego;

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void keyPressed(KeyEvent keyEvent) {
        Vehiculo vehiculo = this.juego.getPiloto().getVehiculo();
        int tecla = keyEvent.getKeyCode();

        switch (tecla) {

            case KeyEvent.VK_RIGHT:
                if(!juego.estaPausada()) {
                    DireccionDerecha unaDireccionDerecha = new DireccionDerecha();
                    vehiculo.setDireccion(unaDireccionDerecha);
                    System.out.println("Me muevo para la derecha");
                }
                break;

            case KeyEvent.VK_LEFT:
                if(!juego.estaPausada()) {
                    DireccionIzquierda unaDireccionIzquierda = new DireccionIzquierda();
                    vehiculo.setDireccion(unaDireccionIzquierda);
                    System.out.println("Me muevo para la izquierda");
                }
                break;

            case KeyEvent.VK_UP:
                if(!juego.estaPausada()) {
                    DireccionArriba unaDireccionArriba = new DireccionArriba();
                    vehiculo.setDireccion(unaDireccionArriba);
                    System.out.println("Me muevo para la arriba");

                }
                break;

            case KeyEvent.VK_DOWN:
                if(!juego.estaPausada()) {
                    DireccionAbajo unaDireccionAbajo = new DireccionAbajo();
                    vehiculo.setDireccion(unaDireccionAbajo);
                    System.out.println("Me muevo para la abajo");

                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
