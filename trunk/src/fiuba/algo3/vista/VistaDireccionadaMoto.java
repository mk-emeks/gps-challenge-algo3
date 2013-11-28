package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.Direccionable;

public class VistaDireccionadaMoto extends VistaDireccionada {

    public VistaDireccionadaMoto(Vehiculo moto) {

        super(moto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoArriba.png");
        this.vistaAbajo.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoIzquiera.png");

    }

}