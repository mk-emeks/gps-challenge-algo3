package fiuba.algo3.control;

import fiuba.algo3.modelo.CargadorDeMapa;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.vista.VistasMenu.BoxEleccionMapa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Xml de mapas diferentes **/

public class ControlDeClickEleccionMapa implements MouseListener {

    Partida partida;
    String nombreDelMapa;
    BoxEleccionMapa boxMapa;


    public ControlDeClickEleccionMapa(Partida unaPartida ,String nombreDelMapa, BoxEleccionMapa boxMapa) {

        this.partida = unaPartida;
        this.nombreDelMapa = nombreDelMapa;

        this.boxMapa = boxMapa;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Mapa.limpiar();
        CargadorDeMapa cargadorDeMapa = new CargadorDeMapa(this.nombreDelMapa);
        cargadorDeMapa.cargarMapa();
        this.boxMapa.setVisible(false);

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
