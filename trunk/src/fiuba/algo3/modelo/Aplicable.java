package fiuba.algo3.modelo;


public interface Aplicable extends Posicionable {

    public void actualizarInteraccion(Piloto piloto);

    public void aplicarA(Interactuable unInteractuable);

    public void aplicarA(Interactuable unInteractuable, Auto auto);
    public void aplicarA(Interactuable unInteractuable, Moto unaMoto);
    public void aplicarA(Interactuable unInteractuable, CuatroPorCuatro cuatroPorCuatro);


}

