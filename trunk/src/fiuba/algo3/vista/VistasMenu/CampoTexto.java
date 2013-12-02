package fiuba.algo3.vista.VistasMenu;


import javax.swing.*;

public class CampoTexto extends VistaMenu {

    private JTextField campoTexto;

    public CampoTexto(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        campoTexto = new JTextField();
        campoTexto.setBounds(posicionX, posicionY, ancho, largo);
        unMarco.add(campoTexto);

    }

    public String getTexto() {
        return this.campoTexto.getText();

    }

    public void setVisible ( boolean visibilidad) {

        this.campoTexto.setVisible(visibilidad);
    }

    public boolean isVisible() {

        return this.campoTexto.isVisible();
    }



}
