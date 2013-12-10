package fiuba.algo3.control;



import fiuba.algo3.vista.VistaMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ControlDeClickBoton  implements MouseListener {

    protected ArrayList<VistaMenu> vistasOn;
    protected ArrayList<VistaMenu> vistasOff;

    public ControlDeClickBoton(ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        this.vistasOn = vistasOn;
        this.vistasOff = vistasOff;

    }

    protected void actualizar() {

        this.ActivarVistas();
        this.DesactivarVistas();

    }

    protected void ActivarVistas() {

      Iterator<VistaMenu> iterador = this.vistasOn.iterator();

        while (iterador.hasNext()) {

            VistaMenu vistaOn = iterador.next();
            vistaOn.setVisible(true);
        }
    }

    protected void DesactivarVistas() {

        Iterator<VistaMenu> iterador = this.vistasOff.iterator();

        while (iterador.hasNext()) {

            VistaMenu vistaOff = iterador.next();
            vistaOff.setVisible(false);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        this.actualizar();

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
