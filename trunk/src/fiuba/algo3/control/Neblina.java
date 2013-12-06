package fiuba.algo3.control;



import fiuba.algo3.modelo.Posicion;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.vista.RepresentacionDePosicionable;
import fiuba.algo3.vista.VistaSombra;

import java.util.ArrayList;
import java.util.Iterator;



public class Neblina {

    /** estas 2 listas poseen correlacion, la primera de las vistas, tiene como posicion en el modelo
     *  la primera de las posiciones
     */
    private ArrayList<Posicion> posicionesDeLasSombras;
    private ArrayList<VistaSombra> vistaSombras;

    public Neblina() {

        this.posicionesDeLasSombras = new ArrayList<Posicion>();
        this.vistaSombras = new ArrayList<VistaSombra>();

    }

    public void sacarTodasLasSombras() {

        this.vistaSombras.clear();
        this.posicionesDeLasSombras.clear();

    }

    public void agregar ( VistaSombra unaVistaSombra ) {

        this.vistaSombras.add(unaVistaSombra);
        this.posicionesDeLasSombras.add(this.recuperarPosicionDeLaSombraEnElModelo(unaVistaSombra));

    }

    private Posicion recuperarPosicionDeLaSombraEnElModelo(VistaSombra unaVistaSombra) {

        ObjetoPosicionable objetoPosicionalbleSombra = unaVistaSombra.getPosicionable();

        /** suponemos que el ObjetoPosicionable es un RepresentacionDePosicionable **/
        int factorDeEscala = ((RepresentacionDePosicionable)objetoPosicionalbleSombra).getFactorDeEscala();

        int coordenadaX = objetoPosicionalbleSombra.getX()/factorDeEscala;
        int coordenadaY = objetoPosicionalbleSombra.getY()/factorDeEscala;

        return (new Posicion(coordenadaX,coordenadaY));
    }


    public ArrayList<Posicion> getPosicionesDeLasSombras() {

        return this.posicionesDeLasSombras;
    }

    /** devuelve la vistaSombra correspondiente a la posicion que representa en el modelo **/
    public VistaSombra getVistaSombra( Posicion unaPosicionSombra) throws LaPosicionDeLaSombraNoExiste {

        int index;
        if  ( this.posicionesDeLasSombras.indexOf(unaPosicionSombra) != -1 ) {

            index = this.posicionesDeLasSombras.indexOf(unaPosicionSombra);
            return this.vistaSombras.get(index);

        } else { throw new LaPosicionDeLaSombraNoExiste(); }
    }

    /** metodo general para activar la niebla de todas las sombras **/
    public void nublar() {

        Iterator<VistaSombra> iterator = this.vistaSombras.iterator();
        while (iterator.hasNext()) {

            iterator.next().ponerNeblina();

        }

    }

}
