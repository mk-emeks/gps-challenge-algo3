package fiuba.algo3.modelo;


public abstract class Vehiculo implements Posicionable, Intersectable {

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


}
