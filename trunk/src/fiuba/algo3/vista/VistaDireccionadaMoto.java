package fiuba.algo3.vista;


import fiuba.algo3.modelo.Vehiculo;

public class VistaDireccionadaMoto extends VistaDireccionada {

    public VistaDireccionadaMoto(Vehiculo moto) {


        super(moto);

        this.vistaArriba.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoArriba.png");
        this.vistaOrientada.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoAbajo.png");
        this.vistaDerecha.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoDerecha.png");
        this.vistaIzquierda.setNombreArchivoImagen("imagenes/Vehiculos/Moto/motoSurda.png");

        System.out.println("asigno Imagenes");
    }

    /*@Override
    public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
        super.dibujar(superficeDeDibujo);    //To change body of overridden methods use File | Settings | File Templates.
    }*/
}