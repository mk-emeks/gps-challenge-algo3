package fiuba.algo3.vista;


import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.Posicionable;

import fiuba.algo3.modelo.Direccion;
import fiuba.algo3.modelo.DireccionArriba;
import fiuba.algo3.modelo.DireccionAbajo;
import fiuba.algo3.modelo.DireccionDerecha;
import fiuba.algo3.modelo.DireccionIzquierda;

import fiuba.algo3.modelo.Direccionable;

public abstract class VistaDireccionada extends Imagen {

    protected Imagen vistaArriba = new Imagen();
    protected Imagen vistaAbajo = new Imagen();
    protected Imagen vistaDerecha = new Imagen();
    protected Imagen vistaIzquierda = new Imagen();

    private Direccionable direccionable;

    public VistaDireccionada( Direccionable unDireccionable) {

       /** LOS DIRECCIONABLES QUE PASEMOS DEBEN IMPLEMENTAR POSICIONABLE(TITIRITERO) **/
       Posicionable unPosicionable = (Posicionable)unDireccionable;

       this.vistaArriba.setPosicionable(unPosicionable);
       this.vistaAbajo.setPosicionable(unPosicionable);
       this.vistaDerecha.setPosicionable(unPosicionable);
       this.vistaIzquierda.setPosicionable(unPosicionable);

       this.direccionable = unDireccionable;

    }

    @Override
    public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecha = new DireccionDerecha();
        Direccion izquierda = new DireccionIzquierda();

        /** sumamente horrible, pero no hay tiempo, despues se refactoriza **/
        if  ( (this.direccionable.getDireccion()).equals(arriba) ) {

            this.vistaArriba.dibujar(superficeDeDibujo);
        }

        if  ( (this.direccionable.getDireccion()).equals(abajo) ) {

            this.vistaAbajo.dibujar(superficeDeDibujo);
        }

        if  ( (this.direccionable.getDireccion()).equals(derecha) ) {

            this.vistaDerecha.dibujar(superficeDeDibujo);
        }

        if  ( (this.direccionable.getDireccion()).equals(izquierda) ) {

            this.vistaIzquierda.dibujar(superficeDeDibujo);
        }

    }

}
