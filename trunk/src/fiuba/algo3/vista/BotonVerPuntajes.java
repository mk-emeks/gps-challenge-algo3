package fiuba.algo3.vista;

import javax.swing.*;

public class BotonVerPuntajes extends Boton {

    public BotonVerPuntajes(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);
        boton.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/botonVerPuntajes.png"));
    }
}
