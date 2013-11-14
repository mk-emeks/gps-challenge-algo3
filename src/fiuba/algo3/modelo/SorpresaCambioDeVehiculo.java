package fiuba.algo3.modelo;

public class SorpresaCambioDeVehiculo extends Sorpresa {

    public SorpresaCambioDeVehiculo (Posicion unaPosicion) {

        super(unaPosicion);
    }

    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion() == this.getPosicion() )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) { /** No hace nada **/ }

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto) {
        piloto.getVehiculo().setEstado( new Estado4x4() );
    }
    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        piloto.getVehiculo().setEstado( new EstadoAuto() );
    }
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        piloto.getVehiculo().setEstado( new EstadoMoto() );
    }

}
