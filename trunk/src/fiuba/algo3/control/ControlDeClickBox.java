package fiuba.algo3.control;

import fiuba.algo3.vista.VistasMenu.Box;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class ControlDeClickBox  implements MouseListener {

    protected Partida partida;
    protected Box box;


    public ControlDeClickBox(Partida unaPartida , Box box) {

        this.partida = unaPartida;
        this.box = box;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
