package fiuba.algo3.modelo;


public class Piquete extends Obstaculo {

    private static final int penalizacion = 2;  /** cambiar aca si se quiere modificar la clase -> para calibrar**/


    public Piquete(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion() == this.getPosicion() )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) { /** No hace nada **/ }

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto){
        piloto.getVehiculo().getDireccion().invertir();
    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        piloto.getVehiculo().getDireccion().invertir();
    }


}
