package fiuba.algo3.control;

import fiuba.algo3.modelo.CargadorDeMapa;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.vista.VistasMenu.BoxEleccionMapa;

import java.awt.event.MouseEvent;

/** la idea es asignar un control a cada box que se pasa por paramentro, pero con Xml de mapas diferentes **/

public class ControlDeClickEleccionMapa extends ControlDeClickBox {

    private String nombreDelMapa;

    public ControlDeClickEleccionMapa(String nombreDelMapa, Juego unJuego, BoxEleccionMapa boxMapa) {

       super(unJuego,boxMapa);
       this.nombreDelMapa = nombreDelMapa;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Mapa.limpiar();
        CargadorDeMapa cargadorDeMapa = new CargadorDeMapa(this.nombreDelMapa);
        cargadorDeMapa.cargarMapa();
        this.box.setVisible(false);

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
