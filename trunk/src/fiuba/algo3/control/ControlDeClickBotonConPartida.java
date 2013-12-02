package fiuba.algo3.control;

import fiuba.algo3.vista.VistasMenu.VistaMenu;

import java.util.ArrayList;

public class ControlDeClickBotonConPartida extends ControlDeClickBoton {


    protected Partida partida;

    public ControlDeClickBotonConPartida( Partida unaPartida, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(vistasOn,vistasOff);
        this.partida = unaPartida;

    }
}
