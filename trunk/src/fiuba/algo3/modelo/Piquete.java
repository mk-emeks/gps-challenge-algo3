package fiuba.algo3.modelo;


public class Piquete extends Obstaculo {

    private static final int penalizacion = 2;

    public Piquete(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void aplicarA(Interactuable unInteractuable) {

    }

    public void aplicarA(Interactuable unInteractuable, Auto unAuto){
        unAuto.getDireccion().invertir();
    }
    public void aplicarA(Interactuable unInteractuable, Moto unaMoto) {
        //se necesita Piloto
    }
    public void aplicarA(Interactuable unInteractuable, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.getDireccion().invertir();
    }
}
