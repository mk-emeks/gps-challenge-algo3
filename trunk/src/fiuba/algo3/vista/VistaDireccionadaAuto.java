package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.Direccionable;

public class VistaDireccionadaAuto extends VistaDireccionada {

    public VistaDireccionadaAuto(Vehiculo auto) {

        super(auto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoArriba.png");
        this.vistaAbajo.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoIzquiera.png");

    }

}
