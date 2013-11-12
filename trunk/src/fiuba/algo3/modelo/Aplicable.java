package fiuba.algo3.modelo;


public interface Aplicable extends Posicionable {

    void aplicarA(Interactuable unInteractuable);
    void aplicarA(Interactuable unInteractuable, Auto unAuto);
    void aplicarA(Interactuable unInteractuable, Moto unaMoto);
    void aplicarA(Interactuable unInteractuable, CuatroPorCuatro cuatroPorCuatro);
}
