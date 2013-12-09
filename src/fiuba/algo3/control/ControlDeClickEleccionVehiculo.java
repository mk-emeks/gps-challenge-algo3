package fiuba.algo3.control;

import fiuba.algo3.modelo.Estado;
import fiuba.algo3.modelo.EstadoAlf;
import fiuba.algo3.sonido.MusicaCheat;
import fiuba.algo3.vista.VistasMenu.BoxEleccionVehiculo;


import java.awt.event.MouseEvent;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Estados diferentes **/

public class ControlDeClickEleccionVehiculo extends ControlDeClickBox {

    private Estado estadoActivado;

    public ControlDeClickEleccionVehiculo(Estado estadoActivado , Juego unJuego, BoxEleccionVehiculo boxVehiculo) {

        super (unJuego,boxVehiculo);
        this.estadoActivado = estadoActivado;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        /** alf cheat (el misterioso señor null) **/
        if (this.juego.getPiloto().getNombre() == null) {
            MusicaCheat.playMusic();
            this.juego.asignarCarroceriaDelVehiculo(new EstadoAlf());
        }  else {
            this.juego.asignarCarroceriaDelVehiculo(this.estadoActivado);
        }

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
