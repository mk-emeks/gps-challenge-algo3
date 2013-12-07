package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;


public class BotonAceptar extends Boton {

    public BotonAceptar(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {
        super(unMarco, posicionX, posicionY, ancho, largo);
        boton.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonAceptar.png"));
    }
}
