package fiuba.algo3.modelo;


public interface Posicionable {

    void posicionarEnElMapa() throws NoSePuedePonerEnElMapaElPosicionableException;

    Posicion getPosicion();

    void setPosicion(Posicion nuevaPosicion);
}
