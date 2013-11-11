package fiuba.algo3.modelo;


public interface Posicionable {

    void ponerEn(Mapa unMapa) throws NoSePuedePonerEnElMapaElPosicionableException;

    Posicion getPosicion();

    void setPosicion(Posicion nuevaPosicion);
}
