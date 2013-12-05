package fiuba.algo3.control;

import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.vista.VistasMenu.BoxEleccionMapa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Xml de mapas diferentes **/

public class ControlDeClickEleccionMapa implements MouseListener {

    Partida partida;
    // el xmlMapa
    BoxEleccionMapa boxMapa;


    public ControlDeClickEleccionMapa(Partida unaPartida /*,XML xmlMapa*/, BoxEleccionMapa boxMapa) {

        this.partida = unaPartida;

        // el xmlMapa

        this.boxMapa = boxMapa;


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Mapa.limpiar();
        Nivel nivel = new Nivel(/*elXmlMapa*/);
        this.partida.cargarNivel(nivel);
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
