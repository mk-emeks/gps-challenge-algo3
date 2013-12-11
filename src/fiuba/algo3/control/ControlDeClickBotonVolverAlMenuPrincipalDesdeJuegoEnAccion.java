package fiuba.algo3.control;


import fiuba.algo3.vista.VistaMenu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ControlDeClickBotonVolverAlMenuPrincipalDesdeJuegoEnAccion extends ControlDeClickBotonConJuego {

    //BotonAnimadoVehiculo botonAnimadoVehiculo;

    public ControlDeClickBotonVolverAlMenuPrincipalDesdeJuegoEnAccion (/*BotonAnimadoVehiculo botonAnimadoVehiculo,*/Juego unJuego, java.util.ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(unJuego,vistasOn,vistasOff);
        //this.botonAnimadoVehiculo = botonAnimadoVehiculo;
    }

    public void mouseClicked(MouseEvent e) {

        if (this.juego.estaPausada()) {
        //this.botonAnimadoVehiculo.detenerAnimacion();
        this.juego.finalizar(); // va?
        this.juego.destruir();
        this.actualizar();

        }
    }
}
