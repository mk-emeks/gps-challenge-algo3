package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mirko
 * Date: 01/12/13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class BotonVerPuntajes extends Boton {

    public BotonVerPuntajes(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);
        boton.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonIngresarUsuario.png"));
    }
}