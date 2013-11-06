package fiuba.algo3.modelo;


public abstract class Vehiculo implements Movible, Interceptable {

    private Posicion posicion;
    private Direccion direccion;
    //private Piloto piloto;

    /*public Vehiculo(Direccion unaDireccion, Posicion unaPosicion, Piloto unPiloto) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
        this.piloto = unPiloto;
    } */

    public Vehiculo(Direccion unaDireccion, Posicion unaPosicion) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setPosicion(Posicion pos) {
        this.posicion = pos;
    }

    public void setDireccion(Direccion dir) {
        this.direccion = dir;
    }

    /*public Piloto getPiloto() {
        return this.piloto;
    }*/

    /** por implementar interfaz **/

    // este metodo tiene el fin de juntar codigo que se repite en ponerEn y MoverEn
    private Casilla devolverCasillaDondeEstoy(Tablero tablero) {
        int x = this.getPosicion().getPosicionX();
        int y = this.getPosicion().getPosicionY();
        return (tablero.getCasilla(x,y));
    }

    public void ponerEn(Tablero tablero) {

        Casilla casillaContenedora = this.devolverCasillaDondeEstoy(tablero);
        casillaContenedora.agregarContenido(this);
    }

    /** obs: el moverEn debera usarse siempre despues de que las sorpresas surtan efecto, ya que la casilla guarda
     * un solo posicionable por vez.
     */
    public void moverEn(Tablero tablero, Direccion unaDireccion) {

        Casilla casillaActual =  this.devolverCasillaDondeEstoy(tablero);

        Casilla casillaNueva = casillaActual.devolverSiguiente(unaDireccion);

        Posicion posicionNueva = casillaNueva.devolverPosicion();
        this.setPosicion(posicionNueva);

        casillaNueva.agregarContenido(this);

        casillaActual.sacarContenido();

    }

}
