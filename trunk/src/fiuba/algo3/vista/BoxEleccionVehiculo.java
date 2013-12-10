package fiuba.algo3.vista;

import javax.swing.*;

/** son extremadamente parecidos los dos vistaBox..pero a esta altura **/
//  fuente: http://www.javaya.com.ar/detalleconcepto.php?codigo=111&inicio=20

public class BoxEleccionVehiculo extends fiuba.algo3.vista.Box {

    public BoxEleccionVehiculo(JFrame unMarco, int posicionX, int posicionY, int ancho, int largo) {

        super(unMarco,posicionX,posicionY,ancho,largo);

        itembox1.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/botonAuto.png"));
        itembox2.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/botonMoto.png"));
        itembox3.setIcon(new ImageIcon("src/fiuba/algo3/vista/imagenes/boton4x4.png"));

    }

    public JLabel getItemBoxAuto() {
        return this.itembox1;
    }
    public JLabel getItemBoxMoto() {
        return this.itembox2;
    }
    public JLabel getItemBox4x4() {
        return this.itembox3;
    }

}
