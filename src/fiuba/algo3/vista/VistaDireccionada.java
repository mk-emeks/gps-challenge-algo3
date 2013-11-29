package fiuba.algo3.vista;


import fiuba.algo3.modelo.Direccion;
import fiuba.algo3.modelo.DireccionArriba;
import fiuba.algo3.modelo.DireccionAbajo;
import fiuba.algo3.modelo.DireccionDerecha;
import fiuba.algo3.modelo.DireccionIzquierda;
import fiuba.algo3.modelo.Direccionable;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public abstract class VistaDireccionada implements ObjetoDibujable {

    protected VistaOrientada vistaArriba = new VistaOrientada();
    protected VistaOrientada vistaOrientada = new VistaOrientada();
    protected VistaOrientada vistaDerecha = new VistaOrientada();
    protected VistaOrientada vistaIzquierda = new VistaOrientada();

    protected Direccionable direccionable;

    public VistaDireccionada( Direccionable unDireccionable) {


       /** LOS DIRECCIONABLES QUE PASEMOS DEBEN IMPLEMENTAR POSICIONABLE(TITIRITERO) **/
       //Posicionable unPosicionable = (Posicionable)unDireccionable;

       this.direccionable = unDireccionable;

       this.vistaArriba.setObjetoPosicionable((ObjetoPosicionable) this.direccionable);
       this.vistaOrientada.setObjetoPosicionable((ObjetoPosicionable) this.direccionable);
       this.vistaDerecha.setObjetoPosicionable((ObjetoPosicionable) this.direccionable);
       this.vistaIzquierda.setObjetoPosicionable((ObjetoPosicionable) this.direccionable);
       System.out.println("asigno Posiciones");


    }

     @Override
     public void dibujar(SuperficieDeDibujo superficieDeDibujo) {

        Direccion arriba = new DireccionArriba();
        Direccion abajo = new DireccionAbajo();
        Direccion derecha = new DireccionDerecha();
        Direccion izquierda = new DireccionIzquierda();

        /** sumamente horrible, pero no hay tiempo, despues se refactoriza **/
        if  ( (this.direccionable.getDireccion()).equals(arriba) ) {

            this.vistaArriba.dibujar(superficieDeDibujo);
        }

        if  ( (this.direccionable.getDireccion()).equals(abajo) ) {

            this.vistaOrientada.dibujar(superficieDeDibujo);
        }

        if  ( (this.direccionable.getDireccion()).equals(derecha) ) {

            this.vistaDerecha.dibujar(superficieDeDibujo);

        }

        if  ( (this.direccionable.getDireccion()).equals(izquierda) ) {

            this.vistaIzquierda.dibujar(superficieDeDibujo);
        }

    }

}
