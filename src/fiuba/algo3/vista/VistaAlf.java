package fiuba.algo3.vista;


import fiuba.algo3.modelo.Direccionable;

/** alf cheat (el misterioso señor null) **/

public class VistaAlf extends VistaDireccionada {


    public VistaAlf(Direccionable alf) {

            super(alf);

            this.vistaArriba.setNombreArchivoImagen("imagenes/alf.png");
            this.vistaOrientada.setNombreArchivoImagen("imagenes/alf.png");
            this.vistaDerecha.setNombreArchivoImagen("imagenes/alf.png");
            this.vistaIzquierda.setNombreArchivoImagen("imagenes/alf.png");

        }

    }
