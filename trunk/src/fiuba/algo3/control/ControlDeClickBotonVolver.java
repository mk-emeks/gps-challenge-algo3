package fiuba.algo3.control;


import fiuba.algo3.vista.VistaMenu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ControlDeClickBotonVolver extends ControlDeClickBotonConPartida   {



    public ControlDeClickBotonVolver(Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff){

        super(unJuego, vistasOn, vistasOff);

    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if(!this.juego.estaPausada()) {

            /**Hay que limpiar el gameloop!! **/
            this.juego.finalizar();
            this.juego.destruir();
            this.actualizar();
        }



    }


}
