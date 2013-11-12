package fiuba.algo3.modelo;


public interface Movible extends Posicionable {

    void mover() throws NoSePuedeMoverEnElMapaElMovibleException;
    Direccion getDireccion();
    void setDireccion(Direccion nuevaDireccion);
}
