package fiuba.algo3.control;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControlDeClick implements MouseListener {

    Partida partidaAControlar;
    JLabel jLabelAsociado;

    public ControlDeClick(Partida unaPartida, JLabel unJLabel) {

        this.partidaAControlar = unaPartida;
        this.jLabelAsociado = unJLabel;


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.partidaAControlar.iniciar();
        this.jLabelAsociado.setVisible(false);
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

