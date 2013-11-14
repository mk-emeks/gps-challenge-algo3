package fiuba.algo3.modelo;


public interface Aplicable extends Posicionable {

    public void actualizar(Piloto piloto);

    public void aplicarA(Piloto piloto);

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto);
    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto);
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4);


}

