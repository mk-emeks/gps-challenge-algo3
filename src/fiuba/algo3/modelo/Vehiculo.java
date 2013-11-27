package fiuba.algo3.modelo;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class Vehiculo implements Movible , Posicionable {

    /** atributos **/

    private Posicion posicion;
    private Direccion direccion;
    private Estado estado;

    /**Constructores**/

    public Vehiculo(Posicion unaPosicion , Direccion unaDireccion, Estado unEstado) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
        this.estado = unEstado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado unEstado) {
        this.estado = unEstado;
    }


    /**implementacion por ser movible**/

    public void mover() throws NoSePuedeMoverEnElMapaElMovibleException {

        System.out.println("(" +this.getPosicion().getPosicionX()+" , "+ this.getPosicion().getPosicionY()+")");
        System.out.println("(" +this.getDireccion().devolverComoPosicion().getPosicionX()+" , "+ this.getDireccion().devolverComoPosicion().getPosicionY()+")");
        Posicion avance = this.getDireccion().devolverComoPosicion();
        this.setPosicion(this.getPosicion().sumar(avance));
        System.out.println("(" +this.getPosicion().getPosicionX()+" , "+ this.getPosicion().getPosicionY()+")");
        System.out.println("(" +this.getDireccion().devolverComoPosicion().getPosicionX()+" , "+ this.getDireccion().devolverComoPosicion().getPosicionY()+")");

        try {

            Mapa.getMapa().ubicar(this);

        } catch (LaPosicionNoExisteEnElMapaException e) {

            this.setPosicion(this.getPosicion().restar(avance));
            System.out.println("caca");
            System.out.println("(" +this.getPosicion().getPosicionX()+" , "+ this.getPosicion().getPosicionY()+")");
            System.out.println("(" +this.getDireccion().devolverComoPosicion().getPosicionX()+" , "+ this.getDireccion().devolverComoPosicion().getPosicionY()+")");
            throw new NoSePuedeMoverEnElMapaElMovibleException("la direccion es invalida para la posicion actual") ;

        }

    }

    public void setDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }


    public void posicionarEnElMapa() throws NoSePuedePonerEnElMapaElPosicionableException {

        try {

            Mapa.getMapa().ubicar(this);

        } catch (LaPosicionNoExisteEnElMapaException e) {

            throw new NoSePuedePonerEnElMapaElPosicionableException("la posicion en la cual se quiere ubicar es invalida");
        }

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    /** Por implementar ObjetoPosicionable **/

    public int getX() {

        return (54*this.posicion.getPosicionX());
        //return (this.posicion.getPosicionX());

    }

    public int getY() {

        return (60*this.posicion.getPosicionY());
        //return (this.posicion.getPosicionY());

    }

}
