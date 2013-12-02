package fiuba.algo3.control;

import fiuba.algo3.vista.VistasMenu.CampoTexto;
import fiuba.algo3.vista.VistasMenu.VistaMenu;

import java.awt.event.MouseEvent;

import java.util.ArrayList;

/**seguramente necesite refactorizarse una vez que exista la persistencia de los nombres de los jugadores **/

public class ControlDeClickBotonGuardar extends ControlDeClickBotonConPartida {

    private CampoTexto areaTexto;

    public ControlDeClickBotonGuardar( Partida unaPartida, CampoTexto campoTexto, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff) {

        super(unaPartida,vistasOn,vistasOff);
        this.areaTexto = campoTexto;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (this.areaTexto.getTexto().length() <= 10 && !(this.areaTexto.getTexto().isEmpty())) {

            this.partida.crearPiloto(this.areaTexto.getTexto());
            /** falta persistencia! **/

            this.actualizar();


        }

    }

}