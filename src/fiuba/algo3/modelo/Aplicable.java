package fiuba.algo3.modelo;


public interface Aplicable extends Posicionable {

    public void actualizarInteraccion(Piloto piloto);

    public void aplicarA(Piloto piloto);

    public void aplicarA(Piloto piloto, Auto auto);
    public void aplicarA(Piloto piloto, Moto unaMoto);
    public void aplicarA(Piloto piloto, CuatroPorCuatro cuatroPorCuatro);


}

