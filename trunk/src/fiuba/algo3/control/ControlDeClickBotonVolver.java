package fiuba.algo3.control;


import fiuba.algo3.vista.VistasMenu.VistaMenu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ControlDeClickBotonVolver extends ControlDeClickBotonConPartida   {



    public ControlDeClickBotonVolver(Partida unaPartida, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff){

        super(unaPartida, vistasOn, vistasOff);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if(!this.partida.estaPausada()) {

            /**Hay que limpiar el gameloop!! **/
            this.partida.finalizar();
            this.partida.destruir();
            this.actualizar();
        }



    }


}
