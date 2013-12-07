package fiuba.algo3.modelo;


import java.io.Serializable;

public interface Aplicable extends Posicionable {

    /** es igual en todos, son distintos los this ver() **/
    public void actualizar(Piloto piloto);

    public void aplicarA(Piloto piloto);

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto);
    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto);
    public void aplicarA(Piloto piloto, Estado4x4 estado4x4);


}

