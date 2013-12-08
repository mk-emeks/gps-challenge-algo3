package fiuba.algo3.control;

import fiuba.algo3.modelo.Estado;
import fiuba.algo3.vista.VistasMenu.BoxEleccionVehiculo;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Estados diferentes **/

public class ControlDeClickEleccionVehiculo extends ControlDeClickBox {

    private Estado estadoActivado;

    public ControlDeClickEleccionVehiculo(Estado estadoActivado , Partida unaPartida , BoxEleccionVehiculo boxVehiculo) {

        super (unaPartida,boxVehiculo);
        this.estadoActivado = estadoActivado;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.partida.asignarCarroceriaDelVehiculo(this.estadoActivado);
        this.box.setVisible(false);

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
