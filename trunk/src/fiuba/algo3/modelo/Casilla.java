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

    private ArrayList<Vecino> listaDeVecinos = new ArrayList<Vecino>();
    private ListIterator<Vecino> iterador = listaDeVecinos.listIterator();
    private Posicion posicion;
    private EstadoCasilla estado;

     /** Constructores **/

    public Casilla (Posicion unaPosicion) {

        this.posicion = unaPosicion;


    }

    public Casilla (Posicion unaPosicion , EstadoCasilla unEstado) {

        this.posicion = unaPosicion;
        this.estado = unEstado;

    }

    /** Metodos **/

    public Posicion devolverPosicion(){

        return this.posicion;
    }

    public void setEstado( EstadoCasilla unEstado){

        this.estado = unEstado;
    }

    public void agregarSiguiente(Casilla unaCasilla, Direccion unaDireccion){

        Vecino nuevoVecino = new Vecino(unaCasilla,unaDireccion);
        this.listaDeVecinos.add(nuevoVecino);

    }

    /** temporal; inecesario **/

    public boolean tenesSiguiente(){

        return !(listaDeVecinos.isEmpty());
    }

    /**version Beta**/
    public Casilla devolverSiguiente(Direccion unaDireccion) throws LaCasillaNoTieneSiguienteEnNingunaDireccion , LaCasillaNoTieneElSiguientePedido {

        Casilla casillaBuscada = null;
        if ( !(listaDeVecinos.isEmpty()) ) {

            Vecino vecino = iterador.next();
            if ( vecino.devolverDireccion().esIgualA(unaDireccion) ) {

                casillaBuscada = vecino.devolverCasilla();

            } else  { throw new LaCasillaNoTieneElSiguientePedido("la casilla no posee el siguiente requerido"); }


        } else { throw new LaCasillaNoTieneSiguienteEnNingunaDireccion("la casilla se encuentra aislada"); }

        return casillaBuscada;
    }

}
