package fiuba.algo3.control;


import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.vista.VistasMenu.VistaMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class ControlDeClickBotonJugar extends ControlDeClickBotonConPartida {


    public ControlDeClickBotonJugar( Partida unaPartida, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff){

        super(unaPartida,vistasOn,vistasOff);
        this.partida = unaPartida;

    }


    @Override
    public void mouseClicked(MouseEvent e) {


        //this.ActivarVistas();
        this.DesactivarVistas();

        this.partida.cargarVehiculoParaElPiloto();
        this.partida.iniciar();

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

