package fiuba.algo3.modelo;


import org.jdom2.Element;

import java.util.ArrayList;

public class Mapa {

    /** Para lograr hace un Singleton**/

    private static Mapa elMapa;

    private Mapa() {}

    public static Mapa getMapa() {
        if (elMapa == null) {

            elMapa = new Mapa();
        }
        return elMapa;
    }

    /** fin **/


    public static void limpiar() {
        elMapa = null;
    }

    private ContenidoMapa contenidoMapa;


    public void cargarContenidoMapa(Element nodoContenidoMapa) {

        this.contenidoMapa = new ContenidoMapa(nodoContenidoMapa);
    }

    /** para cuando se recupera la persistencia **/
    public void cargarContenidoMapa(ContenidoMapa unContenidoMapa) {

        this.contenidoMapa = unContenidoMapa;
    }

    public void cargarContenidoMapa() {

        this.contenidoMapa = new ContenidoMapa();
    }

    public ContenidoMapa getContenidoMapa(/*se le pasara el mapa a levantar*/) {

        return  this.contenidoMapa;
    }

    /** ya que el mapa fue refactorizado mantendra sus prestaciones pero
     *  delegara las acciones a la clase ContenidoMapa
     */

    public void agregar(Posicion unaPosicion) throws LaPosicionYaExisteEnElMapaException {

        this.contenidoMapa.agregar(unaPosicion);

    }

    public void ubicarPosicionDeLlegada(Posicion laLlegada) throws LaPosicionNoExisteEnElMapaException {

        this.contenidoMapa.ubicarPosicionDeLlegada(laLlegada);

    }

    /** new **/
    public void ubicarPosicionDeInicio(Posicion elInicio) throws LaPosicionNoExisteEnElMapaException {

        this.contenidoMapa.ubicarPosicionDeInicio(elInicio);

    }

    public void ubicar(Vehiculo unVehiculo) throws LaPosicionNoExisteEnElMapaException {

        this.contenidoMapa.ubicar(unVehiculo);

    }

    public void ubicar(Aplicable aplicable) throws LaPosicionNoExisteEnElMapaException {

        this.contenidoMapa.ubicar(aplicable);

    }

    public void ubicar(AplicableTemporal aplicableTemporal) throws LaPosicionNoExisteEnElMapaException {

        this.contenidoMapa.ubicar(aplicableTemporal);
    }

    public Posicion getLlegada() {
        return this.contenidoMapa.getLlegada();
    }

    /** new **/
    public Posicion getInicio() {
        return this.contenidoMapa.getInicio();
    }

    /** new **/
    public ArrayList<Aplicable> getAplicables() {
        return this.contenidoMapa.getAplicables();
    }

    public ArrayList<AplicableTemporal> getAplicablesTemporales() {
        return this.contenidoMapa.getAplicablesTemporales();
    }

    public ArrayList<Posicion> getPosicionesValidas() {
        return this.contenidoMapa.getPosicionesValidas();
    }

    /** testing **/
    // deberian ser private? los hacemos public para poder hacer tests con comodidad
    public boolean estaUbicado(Aplicable unAplicable) {

        return this.contenidoMapa.estaUbicado(unAplicable);

    }

    public boolean estaUbicado(AplicableTemporal unAplicableTemporal) {

        return this.contenidoMapa.estaUbicado(unAplicableTemporal);

    }

    public boolean existe(Posicion unaPosicion) {

        return this.contenidoMapa.existe(unaPosicion);
    }

    public Vehiculo getVehiculo() {
        return this.getVehiculo();
    }

    /** fin prestaciones **/



}
