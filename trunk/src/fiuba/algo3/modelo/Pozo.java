package fiuba.algo3.modelo;


public class Pozo extends Obstaculo {

    private static final int penalizacion = 3;

    public Pozo(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//
    public void actualizarInteraccion(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoAInteractuar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoAInteractuar.getPosicion() == this.getPosicion() )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Interactuable unInteractuable) {

    }

    public void aplicarA(Interactuable unInteractuable, Vehiculo vehiculo){
        //se necesita Piloto
    }

    public void aplicarA(Interactuable unInteractuable, Auto unAuto){
        //se necesita Piloto
    }
    public void aplicarA(Interactuable unInteractuable, Moto unaMoto) {
        //se necesita Piloto
    }
    public void aplicarA(Interactuable unInteractuable, CuatroPorCuatro cuatroPorCuatro) {
        //No hace nada.
    }


}
