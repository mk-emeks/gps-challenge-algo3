package fiuba.algo3.control;

import fiuba.algo3.vista.Box;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class ControlDeClickBox  implements MouseListener {

    protected Juego juego;
    protected Box box;


    public ControlDeClickBox(Juego unJuego, Box box) {

        this.juego = unJuego;
        this.box = box;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
