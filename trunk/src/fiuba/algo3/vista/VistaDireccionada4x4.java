package fiuba.algo3.vista;

import fiuba.algo3.modelo.Vehiculo;

public class VistaDireccionada4x4 extends VistaDireccionada {

    public VistaDireccionada4x4(Vehiculo cuatri) {

        super(cuatri);

        this.vistaArriba.setNombreArchivoImagen("imagenes/4x4Arriba.png");
        this.vistaOrientada.setNombreArchivoImagen("imagenes/4x4Abajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/4x4Derecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/4x4Surda.png");

    }

}