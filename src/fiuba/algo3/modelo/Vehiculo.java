package fiuba.algo3.modelo;

public abstract class Vehiculo implements Movible {

    /** atributos **/

    private Posicion posicion;
    private Direccion direccion;

    /**Constructores**/

    public Vehiculo(Posicion unaPosicion , Direccion unaDireccion) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
    }

    /**implementacion por ser movible**/

    public void mover() throws NoSePuedeMoverEnElMapaElMovibleException {

        Posicion avance = this.getDireccion().devolverComoPosicion();
        this.setPosicion(this.getPosicion().sumar(avance));

        try {

            Mapa.getMapa().ubicar(this);

        } catch (LaPosicionNoExisteEnElMapaException e) {

            this.setPosicion(this.getPosicion().restar(avance));
            throw new NoSePuedeMoverEnElMapaElMovibleException("la direccion es invalida para la posicion actual") ;

        }

    }

    public void setDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }


    public void poner() throws NoSePuedePonerEnElMapaElPosicionableException {

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

}
