package fiuba.algo3.modelo;


public abstract class Vehiculo implements Movible, Interceptable {

    private Posicion posicion;
    private Direccion direccion;

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

    /** por implementar interfaz **/

    // este metodo tiene el fin de juntar codigo que se repite en ponerEn y MoverEn
    private Casilla devolverCasillaDondeEstoy(Tablero tablero) {
        int x = this.getPosicion().getPosicionX();
        int y = this.getPosicion().getPosicionY();
        return (tablero.getCasilla(x,y));
    }

    public void ponerEn(Tablero tablero) throws LaCasillaNoEsAlojable {

        Casilla casillaContenedora = this.devolverCasillaDondeEstoy(tablero);

        try {
            casillaContenedora.agregarContenido(this);

        } catch (LaCasillaNoEsAlojable excepcion) {
            /** provisorio; para avisar por donde viene la excepcion, sin tener que crear una excepcion
             *  propia y reducir la cantidad de codigo
             */
            System.out.print("el posicionable no se coloco -> motivo: ");
            System.out.println(excepcion.getMessage());
        }
    }

    /** obs: el moverEn debera usarse siempre despues de que las sorpresas surtan efecto, ya que la casilla guarda
     * un solo posicionable por vez.
     */
    public void moverEn(Tablero tablero) throws LaCasillaNoEsAlojable {

        Casilla casillaActual = this.devolverCasillaDondeEstoy(tablero);

        Posicion avance = this.getDireccion().devolverComoPosicion();
        Posicion posicionNueva = casillaActual.devolverPosicion().sumar(avance);

        Casilla casillaNueva = tablero.getCasilla(posicionNueva.getPosicionX(),posicionNueva.getPosicionY());

        try {
            casillaNueva.agregarContenido(this);
            this.setPosicion(posicionNueva);
            casillaActual.sacarContenido();
        } catch (LaCasillaNoEsAlojable excepcion) {
            /** provisorio; para avisar por donde viene la excepcion, sin tener que crear una excepcion
             *  propia y reducir la cantidad de codigo
             */
            System.out.print("no se pudo efectuar el movimiento -> motivo: ");
            System.out.println(excepcion.getMessage());
        }

    }

}
