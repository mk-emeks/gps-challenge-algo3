package fiuba.algo3.vista.VistasMenu;


import javax.swing.*;

public class BotonVolver extends Boton {

    public BotonVolver(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);
        boton.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonVolver.png"));
    }
}
