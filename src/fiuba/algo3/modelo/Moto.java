package fiuba.algo3.modelo;

public class Moto extends Vehiculo {

    public Moto(Posicion posicion,Direccion direccion) {
        super(posicion,direccion);
    }

    public Auto obtenerTransformacion() {
        return ( new Auto(this.getPosicion(),this.getDireccion()));
    }
}
