package fiuba.algo3.control;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControlDeClick implements MouseListener {

    Partida partidaAControlar;

    public ControlDeClick(Partida unaPartida) {
        this.partidaAControlar = unaPartida;

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.partidaAControlar.iniciar();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

