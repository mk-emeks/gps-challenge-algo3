package fiuba.algo3.modelo;


import java.util.ArrayList;

public class Mapa {

    private ArrayList<Posicionable> contenido;
    private ArrayList<Posicion> posicionesValidas;
    private static Mapa elMapa;

    /** Para lograr hace un Singleton**/
    private Mapa() {
        this.posicionesValidas = new ArrayList<Posicion>();
        this.contenido = new ArrayList<Posicionable>();
    }

    public static Mapa getMapa() {
        if (elMapa == null) {

            elMapa = new Mapa();
        }
        return elMapa;
    }

    public static void limpiar() {
        elMapa = null;
    }
    /** ============================================== **/

    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        if ( !this.posicionesValidas.contains(unaPosicion) ) {

            this.posicionesValidas.add(unaPosicion);

        } else { throw new LaPosicionYaExisteEnElMapaException(); }


    }


    public void ubicar(Posicionable posicionable) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(posicionable.getPosicion()) ) {

            if ( !this.estaUbicado(posicionable) ) {

                this.contenido.add(posicionable);
            }
            /** si existe la posicion donde se quiere ubicar el posicionable, y el mismo ya fue agregado a
            * la lista de contenidos no se tiene que hacer nada mas **/

        } else { throw new LaPosicionNoExisteEnElMapaException(); }
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
