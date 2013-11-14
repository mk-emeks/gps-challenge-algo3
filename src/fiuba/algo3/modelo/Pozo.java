package fiuba.algo3.modelo;


public class Pozo extends Obstaculo {

    private static final int penalizacion = 3;  /** cambiar aca si se quiere modificar la clase -> para calibrar**/

    public Pozo(Posicion unaPosicion) {
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

    /** ahorrando codigo **/

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto){
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
        this.aplicar(piloto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) { /** No hace nada **/ }

}
