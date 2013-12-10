package fiuba.algo3.control;

import fiuba.algo3.vista.VistaMenu;

import java.util.ArrayList;

public abstract class ControlDeClickBotonConJuego extends ControlDeClickBoton {


    protected Juego juego;

    public ControlDeClickBotonConJuego(Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(vistasOn,vistasOff);
        this.juego = unJuego;

    }
}
