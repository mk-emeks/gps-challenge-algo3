package fiuba.algo3.control;


import fiuba.algo3.persistencia.Partida;
import fiuba.algo3.vista.VistaJuegoGuardado;
import fiuba.algo3.vista.VistaMenu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ControlDeClickBotonGuardarJuego extends ControlDeClickBotonConJuego {

    //RegistroUsuarios registroUsuarios;

    /** pasar vistaOn y vistaOff en null **/
    public ControlDeClickBotonGuardarJuego(Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff)
    {
        super(unJuego,vistasOn,vistasOff);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Partida partidaGuardada = new Partida(this.juego);
        partidaGuardada.guardarPartida();
        this.juego.pausar();
        VistaJuegoGuardado unaVista = new VistaJuegoGuardado();

    }
}
