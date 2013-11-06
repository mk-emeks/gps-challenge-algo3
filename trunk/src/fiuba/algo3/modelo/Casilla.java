package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Casilla {

    /** Clase interna **/
    private class Vecino {

        private Casilla casilla;
        private Direccion direccion;

        public Vecino (Casilla unaCasilla, Direccion unaDireccion){

            this.casilla = unaCasilla;
            this.direccion = unaDireccion;

        }

        public Casilla devolverCasilla(){

            return this.casilla;
        }

        public Direccion devolverDireccion(){

            return this.direccion;
        }

    }

    /** Clase Casilla **/

    /**Atributos**/

    private ArrayList<Vecino> listaDeVecinos;
    private Posicion posicion;
    private EstadoCasilla estado;
    private Posicionable contenido;

     /** Constructores **/

    public Casilla (Posicion unaPosicion) {

        this.posicion = unaPosicion;
        this.listaDeVecinos = new ArrayList<Vecino>();
        this.contenido = null;
    }

    public Casilla (Posicion unaPosicion , EstadoCasilla unEstado) {

        this.posicion = unaPosicion;
        listaDeVecinos = new ArrayList<Vecino>();
        this.estado = unEstado;
        this.contenido = null;
    }

    /** Metodos **/

    public Posicion devolverPosicion(){
        return this.posicion;
    }

    public void setEstado( EstadoCasilla unEstado){
        this.estado = unEstado;
    }

    public EstadoCasilla getEstado() {
        return this.estado;
    }

    public void agregarContenido(Posicionable unContenido) {
        if (this.getEstado().sosAlojable()) {
            this.contenido = unContenido;
        }
    }

    public Posicionable getContenido() {
        return this.contenido;
    }

    public boolean estaOcupada() {
        return (this.contenido != null);
    }

    public boolean contiene(Posicionable objeto) {
        return (this.contenido == objeto);
    }

    public void agregarSiguiente(Casilla unaCasilla, Direccion unaDireccion){

        Vecino nuevoVecino = new Vecino(unaCasilla,unaDireccion);
        this.listaDeVecinos.add(nuevoVecino);
    }

    /** temporal; inecesario **/

    public boolean tenesSiguiente(){

        return !(listaDeVecinos.isEmpty());
    }

    public Casilla devolverSiguiente(Direccion unaDireccion) throws LaCasillaNoTieneSiguienteEnNingunaDireccion , LaCasillaNoTieneElSiguientePedido {

        //Casilla casillaBuscada = null;
        ListIterator<Vecino> iterador = listaDeVecinos.listIterator();
        if ( !(listaDeVecinos.isEmpty()) ) {

            while (iterador.hasNext()) {
            Vecino vecino = iterador.next();
                if ( vecino.devolverDireccion().esIgualA(unaDireccion) ) {

                    //casillaBuscada = vecino.devolverCasilla();
                    return vecino.devolverCasilla();
                }
            }
        throw new LaCasillaNoTieneElSiguientePedido("la casilla no posee el siguiente requerido");

        } else {
            throw new LaCasillaNoTieneSiguienteEnNingunaDireccion("la casilla se encuentra aislada");
        }

        //return casillaBuscada;
    }

}
