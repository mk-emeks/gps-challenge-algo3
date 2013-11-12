package fiuba.algo3.modelo;


public class Pozo extends Obstaculo {

    private static final int penalizacion = 3;

    public Pozo(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void aplicarA(Interactuable unInteractuable) {

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
