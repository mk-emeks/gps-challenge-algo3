package fiuba.algo3.vista;


import fiuba.algo3.modelo.Direccionable;

public class VistaDireccionadaAuto extends VistaDireccionada {

    public VistaDireccionadaAuto(Direccionable auto) {

        super(auto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoArriba.png");
        this.vistaOrientada.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/Vehiculos/Auto/autoSurda.png");

    }

}
