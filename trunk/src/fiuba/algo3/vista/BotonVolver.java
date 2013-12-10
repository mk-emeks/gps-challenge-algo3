package fiuba.algo3.vista;


import javax.swing.*;

public class BotonVolver extends Boton {

    public BotonVolver(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);
        boton.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/botonVolver.png"));
    }
}
