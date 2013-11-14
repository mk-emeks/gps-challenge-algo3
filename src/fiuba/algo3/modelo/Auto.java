package fiuba.algo3.modelo;


public class Auto extends Vehiculo {

    public Auto(Posicion posicion,Direccion direccion) {
        super(posicion,direccion);
    }

    public CuatroPorCuatro obtenerTransformacion() {
        return ( new CuatroPorCuatro(this.getPosicion(),this.getDireccion()));
    }

}
