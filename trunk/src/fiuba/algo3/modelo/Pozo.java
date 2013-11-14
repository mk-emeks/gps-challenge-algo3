package fiuba.algo3.modelo;


public class Pozo extends Obstaculo {

    private static final int penalizacion = 4;

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

    public void aplicarA(Piloto piloto) {
        //No hace nada.
    }


    /** ahorrando codigo **/
    private void aplicar (Piloto piloto) {

        if ( (this.cantidadDeTurnosPenalizado()) > 0 ) {
            piloto.detenerVehiculo();
        } else {
            piloto.arrancarVehiculo();
        }
        this.restarCantidadDeTurnosPenalizado();

    }

    public void aplicarA(Piloto piloto, EstadoAuto EstadoAuto){
        aplicar(piloto);
    }
    public void aplicarA(Piloto piloto, EstadoMoto EstadoAuto) {
        aplicar(piloto);
    }
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        //No hace nada.
    }
}
