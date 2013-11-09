package fiuba.algo3.modelo;


public interface Movible extends Posicionable {

    void moverEn(Mapa unMapa) throws NoSePuedeMoverEnElMapaElMovibleException;
    Direccion getDireccion();
    void setDireccion(Direccion nuevaDireccion);
}
