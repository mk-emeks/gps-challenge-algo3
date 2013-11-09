package fiuba.algo3.modelo;


import java.util.ArrayList;

public class Mapa {

    private ArrayList<Posicionable> contenido;
    private ArrayList<Posicion> posicionesValidas;

    // constructor de mapa vacio
    public Mapa() {
        this.posicionesValidas = new ArrayList<Posicion>();
        this.contenido = new ArrayList<Posicionable>();

    }

    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        if ( !this.posicionesValidas.contains(unaPosicion) ) {

            this.posicionesValidas.add(unaPosicion);

        } else { throw new LaPosicionYaExisteEnElMapaException(); }


    }

    public void agregar(Posicionable posicionable) throws ElPosicionableYaEstaUbicadoEnElMapaException, LaPosicionNoExisteEnElMapaException {

        if ( !this.estaUbicado(posicionable) ) {

            if ( this.existe(posicionable.getPosicion()) ) {

                this.contenido.add(posicionable);

            }  else  {

                throw new LaPosicionNoExisteEnElMapaException();
            }

        } else {

            throw new ElPosicionableYaEstaUbicadoEnElMapaException();
        }

    }

    public void mover(Movible movil) throws LaPosicionNoExisteEnElMapaException {

        if ( !this.existe(movil.getPosicion()) ) {
            throw new LaPosicionNoExisteEnElMapaException();
        }
    }

    /** informadores **/
    // deberian ser private? los hacemos public para poder hacer tests con comodidad
    public boolean estaUbicado(Posicionable unPosicionable) {

        return contenido.contains(unPosicionable);

    }

    public boolean existe(Posicion unaPosicion) {

        return posicionesValidas.contains(unaPosicion);
    }
    /** fin **/


}
