package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;

/** son extremadamente parecidos los dos vistaBox..pero a esta altura **/

public class BoxEleccionMapa extends VistaMenu {

    JLabel boxFacil;
    JLabel boxModerado;
    JLabel boxDificil;

    int distanciaXEntreEllas = 70;

    public BoxEleccionMapa(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.boxFacil = new JLabel ();//"soy Marica");
        boxFacil.setBounds(posicionX,posicionY,ancho,largo);
        boxFacil.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonFacil.png"));
        unMarco.add(boxFacil);
        this.boxFacil.setVisible(true);

        this.boxModerado = new JLabel ();//"no soy Arriesgado");
        boxModerado.setBounds(posicionX,posicionY+this.distanciaXEntreEllas,ancho,largo);
        boxModerado.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonMedio.png"));
        unMarco.add(boxModerado);
        this.boxModerado.setVisible(true);

        this.boxDificil = new JLabel ();//"soy Macho Argentino");
        this.boxDificil.setBounds(posicionX,posicionY+2*this.distanciaXEntreEllas,ancho,largo);
        boxDificil.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonDificil.png"));
        unMarco.add(boxDificil);
        this.boxDificil.setVisible(true);

    }

    public void setVisible ( boolean visibilidad) {

        this.boxFacil.setVisible(visibilidad);
        this.boxModerado.setVisible(visibilidad);
        this.boxDificil.setVisible(visibilidad);
    }

    public JLabel getBoxFacil() {
        return this.boxFacil;
    }
    public JLabel getBoxModerado() {
        return this.boxModerado;
    }
    public JLabel getBoxDificil() {
        return this.boxDificil;
    }

    public boolean isVisible() {

        boolean visibilidad = false;

        if ( this.getBoxFacil().isVisible() && this.boxModerado.isVisible() && this.boxDificil.isVisible() ) {

            visibilidad = true;
        }

        return visibilidad;
    }

}

