package fiuba.algo3.control;

import fiuba.algo3.vista.VistasMenu.BotonAnimadoVehiculo;
import fiuba.algo3.vista.VistasMenu.VistaMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


// botonVolverAlMenuPrincipalDesdeJuegoEnAccion.addMouseListener(new ControlDeClickBotonVolverDesdeJuegoEnAccion(unJuego,stageMenuPrincipal,stageJuegoEnAccion));
public class ControlDeClickBotonVolverDesdeJuegoEnAccion extends ControlDeClickBotonConPartida {

    private BotonAnimadoVehiculo botonAnimadoVehiculo;

    public ControlDeClickBotonVolverDesdeJuegoEnAccion ( BotonAnimadoVehiculo botonAnimadoVehiculo, Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(unJuego,vistasOn,vistasOff);
        this.botonAnimadoVehiculo = botonAnimadoVehiculo;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.juego.destruir();
        this.botonAnimadoVehiculo.detenerAnimacion();
        this.actualizar();
    }
}
