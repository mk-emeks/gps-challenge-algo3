package fiuba.algo3.control;

import fiuba.algo3.vista.VistaMenu;

import java.util.ArrayList;

public class ControlDeClickBotonConPartida extends ControlDeClickBoton {


    protected Juego juego;

    public ControlDeClickBotonConPartida( Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(vistasOn,vistasOff);
        this.juego = unJuego;

    }
}
