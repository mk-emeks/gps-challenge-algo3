package fiuba.algo3.vista.VistasMenu;

import javax.swing.*;

/** son extremadamente parecidos los dos vistaBox..pero a esta altura **/
//  fuente: http://www.javaya.com.ar/detalleconcepto.php?codigo=111&inicio=20

public class BoxEleccionVehiculo extends VistaMenu {

    JLabel boxAuto;
    JLabel boxMoto;
    JLabel box4x4;

    int distanciaXEntreEllas = 70;

    public BoxEleccionVehiculo(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        this.boxAuto = new JLabel ("AUTO");
        boxAuto.setBounds(posicionX, posicionY, ancho, largo);
        boxAuto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonAuto.png"));
        unMarco.add(boxAuto);
        this.boxAuto.setVisible(true);

        this.boxMoto = new JLabel ("MOTO");
        boxMoto.setBounds(posicionX,posicionY+this.distanciaXEntreEllas,ancho,largo);
        boxMoto.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/botonMoto.png"));
        unMarco.add(boxMoto);
        this.boxMoto.setVisible(true);

        this.box4x4 = new JLabel ("4X4");
        this.box4x4.setBounds(posicionX,posicionY+2*this.distanciaXEntreEllas,ancho,largo);
        box4x4.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/Botones/boton4x4.png"));
        unMarco.add(box4x4);
        this.box4x4.setVisible(true);

    }

    public void setVisible ( boolean visibilidad) {

        this.boxAuto.setVisible(visibilidad);
        this.boxMoto.setVisible(visibilidad);
        this.box4x4.setVisible(visibilidad);
    }

    public JLabel getBoxAuto() {
        return this.boxAuto;
    }
    public JLabel getBoxMoto() {
        return this.boxMoto;
    }
    public JLabel getBox4x4() {
        return this.box4x4;
    }


    public boolean isVisible() {

        boolean visibilidad = false;

        if ( this.getBoxAuto().isVisible() && this.boxMoto.isVisible() && this.box4x4.isVisible() ) {

            visibilidad = true;
        }

        return visibilidad;
    }

}
