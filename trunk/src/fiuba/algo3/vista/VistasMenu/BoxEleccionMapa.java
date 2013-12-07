package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;


public class BoxEleccionMapa extends Box {

    JLabel boxFacil;
    JLabel boxModerado;
    JLabel boxDificil;

    int distanciaXEntreEllas = 70;

    public BoxEleccionMapa(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);

        itembox1.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonFacil.png"));
        itembox2.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonMedio.png"));
        itembox3.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonDificil.png"));


    }

    public JLabel getBoxFacil() {
        return this.itembox1;
    }
    public JLabel getBoxModerado() {
        return this.itembox2;
    }
    public JLabel getBoxDificil() {
        return this.itembox3;
    }

}



