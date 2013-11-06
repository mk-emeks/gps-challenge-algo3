package fiuba.algo3.modelo;


public abstract class Vehiculo implements Posicionable, Interceptable {

    private Posicion posicion;
    private Direccion direccion;
    private Piloto piloto;

    public Vehiculo(Direccion unaDireccion, Posicion unaPosicion, Piloto unPiloto) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
        this.piloto = unPiloto;
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

    public Piloto getPiloto() {
        return this.piloto;
    }

    public void ponerEn(Tablero tablero) {
        int x = this.getPosicion().getPosicionX();
        int y = this.getPosicion().getPosicionY();
        Casilla casillaContenedora = tablero.getCasilla(x,y);
        casillaContenedora.agregarContenido(this);
    }

}
