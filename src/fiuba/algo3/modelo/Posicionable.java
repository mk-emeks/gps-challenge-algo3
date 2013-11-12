package fiuba.algo3.modelo;


public interface Posicionable {

    void poner() throws NoSePuedePonerEnElMapaElPosicionableException;

    Posicion getPosicion();

    void setPosicion(Posicion nuevaPosicion);
}
