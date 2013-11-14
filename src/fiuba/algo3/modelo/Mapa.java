package fiuba.algo3.modelo;


import java.util.ArrayList;

public class Mapa {

    private ArrayList<Posicion> posicionesValidas;

    private Vehiculo vehiculo;  /** dudoso uso **/
    private Posicion llegada;
    private ArrayList<Aplicable> aplicables;


    private static Mapa elMapa;
    /** Para lograr hace un Singleton**/
    private Mapa() {
        this.posicionesValidas = new ArrayList<Posicion>();
        this.aplicables = new ArrayList<Aplicable>();
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

    public void ubicarPosicionDeLlegada(Posicion laLlegada) throws LaPosicionNoExisteEnElMapaException {

        if ( this.posicionesValidas.contains(laLlegada) ) {

            this.llegada = laLlegada;

        } else { throw new LaPosicionNoExisteEnElMapaException(); }

    }

    public void ubicar(Vehiculo unVehiculo) throws LaPosicionNoExisteEnElMapaException {

        if ( this.posicionesValidas.contains(unVehiculo.getPosicion()) ) {

            this.vehiculo = unVehiculo;

        } else { throw new LaPosicionNoExisteEnElMapaException(); }


    }

    public void ubicar(Aplicable aplicable) throws LaPosicionNoExisteEnElMapaException {

        if ( this.existe(aplicable.getPosicion()) ) {

            if ( !this.estaUbicado(aplicable) ) {

                this.aplicables.add(aplicable);
            }
            /** si existe la posicion donde se quiere ubicar el posicionable, y el mismo ya fue agregado a
            * la lista de contenidos no se tiene que hacer nada mas **/

        } else { throw new LaPosicionNoExisteEnElMapaException(); }
    }


    public Posicion getLlegada() {
        return this.llegada;
    }

    public ArrayList<Aplicable> getAplicables() {
        return this.aplicables;
    }

    /** testing **/
    // deberian ser private? los hacemos public para poder hacer tests con comodidad
    public boolean estaUbicado(Aplicable unAplicable) {

        return aplicables.contains(unAplicable);

    }

    public boolean existe(Posicion unaPosicion) {

        return posicionesValidas.contains(unaPosicion);
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    /** fin **/

}
