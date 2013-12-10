package fiuba.algo3.control;


import fiuba.algo3.vista.BoxUsuariosExistentes;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ControlDeClickEleccionUsuarioExistente extends ControlDeClickBox {

    private String nombreDelUsuario ;

    /** Future Refactor: esto es horrible, presupone conocer implementacion de las itemBox, en un futuro,
     *  las item box deberian ser clases aparte y tener metodos propios con el cual comunicarse con el resto de los objetos
     */

    public ControlDeClickEleccionUsuarioExistente (JLabel itemBoxControlada, Juego unJuego, BoxUsuariosExistentes boxUsuariosExistentes) {

        super(unJuego,boxUsuariosExistentes);

        this.nombreDelUsuario = itemBoxControlada.getText();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        this.juego.crearPiloto(nombreDelUsuario);
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
