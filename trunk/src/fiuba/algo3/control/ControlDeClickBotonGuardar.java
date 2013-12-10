package fiuba.algo3.control;

import fiuba.algo3.persistencia.RegistroUsuarios;
import fiuba.algo3.persistencia.Usuario;
import fiuba.algo3.vista.CampoTexto;
import fiuba.algo3.vista.VistaMenu;

import java.awt.event.MouseEvent;

import java.util.ArrayList;

/**seguramente necesite refactorizarse una vez que exista la persistencia de los nombres de los jugadores **/

public class ControlDeClickBotonGuardar extends ControlDeClickBotonConPartida {

    private RegistroUsuarios registroUsuarios;
    private CampoTexto areaTexto;


    public ControlDeClickBotonGuardar(RegistroUsuarios registroUsuarios, Juego unJuego,CampoTexto campoTexto, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(unJuego,vistasOn,vistasOff);
        this.registroUsuarios = registroUsuarios;
        this.areaTexto = campoTexto;


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (this.areaTexto.getTexto().length() <= 10 && !(this.areaTexto.getTexto().isEmpty())) {

            String nombreDelCompetidor = this.areaTexto.getTexto();
            this.registroUsuarios.agregarUsuario(new Usuario(nombreDelCompetidor));
            this.juego.crearPiloto(nombreDelCompetidor);
            /** falta persistencia! **/

            this.actualizar();


        }

    }

}