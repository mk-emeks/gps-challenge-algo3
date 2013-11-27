package fiuba.algo3.vista;


import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaVehiculo extends Imagen {

    public VistaVehiculo (ObjetoPosicionable posicionable) {

        super(posicionable);
        this.setNombreArchivoImagen("/imagenes/calle.jpg");

    }
}