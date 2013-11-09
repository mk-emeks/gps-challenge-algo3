package fiuba.algo3.modelo;

public abstract class Vehiculo implements Movible, Interceptable {

    private Posicion posicion;
    private Direccion direccion;

    public Vehiculo(Direccion unaDireccion, Posicion unaPosicion) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
    }

    public void setDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void moverEn(Mapa unMapa) {

    }

    public void ponerEn(Mapa unMapa) {

    }




}
