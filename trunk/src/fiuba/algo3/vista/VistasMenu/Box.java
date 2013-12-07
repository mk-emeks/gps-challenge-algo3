package fiuba.algo3.vista.VistasMenu;


import javax.swing.*;

/** este es un check box de 3 items **/

public abstract class Box extends VistaMenu {

    protected JLabel itembox1;
    protected JLabel itembox2;
    protected JLabel itembox3;

    protected int distanciaXEntreEllas = 70;

    public Box (JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.itembox1 = new JLabel ();
        itembox1.setBounds(posicionX, posicionY, ancho, largo);
        unMarco.add(itembox1);
        this.itembox1.setVisible(true);

        this.itembox2 = new JLabel ();
        itembox2.setBounds(posicionX,posicionY+this.distanciaXEntreEllas,ancho,largo);
        unMarco.add(itembox2);
        this.itembox2.setVisible(true);

        this.itembox3 = new JLabel ();
        this.itembox3.setBounds(posicionX,posicionY+2*this.distanciaXEntreEllas,ancho,largo);
        unMarco.add(itembox3);
        this.itembox3.setVisible(true);

    }


    public void setVisible ( boolean visibilidad) {

        this.itembox1.setVisible(visibilidad);
        this.itembox2.setVisible(visibilidad);
        this.itembox3.setVisible(visibilidad);
    }


    public boolean isVisible() {

        boolean visibilidad = false;

        if ( this.itembox1.isVisible() && this.itembox2.isVisible() && this.itembox3.isVisible() ) {

            visibilidad = true;
        }

        return visibilidad;
    }
}
