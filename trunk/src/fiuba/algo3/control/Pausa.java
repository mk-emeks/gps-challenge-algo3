package fiuba.algo3.control;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pausa implements KeyListener {


    private Partida partida;
    private boolean pausa;

    public Pausa(Partida laPartida) {

        this.partida = laPartida;
        pausa = false;

    }

    private boolean estaEnPausa() {
        return this.pausa;
    }

    private void pausar() {
       this.pausa = true;
    }
    private void reanudar() {
        this.pausa = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void keyPressed(KeyEvent keyEvent) {
        int tecla = keyEvent.getKeyCode();

        switch (tecla) {

            case KeyEvent.VK_ENTER:

                if (this.estaEnPausa()) {
                    this.partida.reanudar();
                    System.out.println("quiero seguir!");
                    this.reanudar();
                    break;
                } else {
                    this.partida.pausar();
                    System.out.println("toque pausa mierda!");
                    this.pausar();

                }

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
