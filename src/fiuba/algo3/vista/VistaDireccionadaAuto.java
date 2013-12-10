package fiuba.algo3.vista;


import fiuba.algo3.modelo.Direccionable;

public class VistaDireccionadaAuto extends VistaDireccionada {

    public VistaDireccionadaAuto(Direccionable auto) {

        super(auto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/autoArriba.png");
        this.vistaOrientada.setNombreArchivoImagen("imagenes/autoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/autoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/autoSurda.png");

    }

}
