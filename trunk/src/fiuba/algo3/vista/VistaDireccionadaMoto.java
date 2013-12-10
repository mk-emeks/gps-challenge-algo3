package fiuba.algo3.vista;


import fiuba.algo3.modelo.Vehiculo;

public class VistaDireccionadaMoto extends VistaDireccionada {

    public VistaDireccionadaMoto(Vehiculo moto) {


        super(moto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/motoArriba.png");
        this.vistaOrientada.setNombreArchivoImagen("imagenes/motoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/motoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/motoSurda.png");

    }

}