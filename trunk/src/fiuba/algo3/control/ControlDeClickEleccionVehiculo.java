package fiuba.algo3.control;

import fiuba.algo3.modelo.Estado;
import fiuba.algo3.vista.VistasMenu.BoxEleccionVehiculo;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Estados diferentes **/

public class ControlDeClickEleccionVehiculo implements MouseListener {

    Partida partida;
    Estado estadoActivado;
    BoxEleccionVehiculo boxVehiculo;


    public ControlDeClickEleccionVehiculo(Partida unaPartida ,Estado estadoActivado, BoxEleccionVehiculo boxVehiculo) {

        this.partida = unaPartida;

        this.estadoActivado = estadoActivado;

        this.boxVehiculo = boxVehiculo;


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.partida.asignarCarroceriaDelVehiculo(this.estadoActivado);
        this.boxVehiculo.setVisible(false);

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
