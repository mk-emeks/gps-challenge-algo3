package fiuba.algo3.modelo;


public class Pozo extends Obstaculo {

    private static final int penalizacion = 4;

    public Pozo(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void actualizarInteraccion(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion() == this.getPosicion() )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) {

    }

    public void aplicarA(Piloto piloto, Vehiculo vehiculo){
        //se necesita Piloto
    }

    public void aplicarA(Piloto piloto, Auto unAuto){
        piloto.getCronometro().sumarSegundos(penalizacion);
    }
    public void aplicarA(Piloto piloto, Moto unaMoto) {
        piloto.getCronometro().sumarSegundos(penalizacion);
    }
    public void aplicarA(Piloto piloto, CuatroPorCuatro cuatroPorCuatro) {
        //No hace nada.
    }
}
