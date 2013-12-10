package fiuba.algo3.vista;

import javax.swing.*;
import java.awt.event.MouseListener;


public abstract class Boton extends VistaMenu {

    protected JLabel boton;

    public Boton(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        boton = new JLabel();
        boton.setBounds(posicionX, posicionY, ancho, largo);
        unMarco.add(boton);

    }

    public void setVisible ( boolean visibilidad) {

        this.boton.setVisible(visibilidad);
    }

    public boolean isVisible() {

        return this.boton.isVisible();
    }

    public void addMouseListener(MouseListener unMouseListener) {
        this.boton.addMouseListener(unMouseListener);
    }
}
