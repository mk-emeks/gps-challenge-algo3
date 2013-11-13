package fiuba.algo3.modelo;


public class Piquete extends Obstaculo {

    private static final int penalizacion = 2;


    public Piquete(Posicion unaPosicion) {
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

    public void aplicarA(Piloto piloto, Auto unAuto){
        unAuto.getDireccion().invertir();
    }
    public void aplicarA(Piloto piloto, Moto unaMoto) {
        //se necesita Piloto
    }
    public void aplicarA(Piloto piloto, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.getDireccion().invertir();
    }





}
