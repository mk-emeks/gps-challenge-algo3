package fiuba.algo3.modelo;


public abstract class Sorpresa implements Aplicable {

    private Posicion posicion;

    public Sorpresa(Posicion unaPosicion) {

        this.posicion = unaPosicion;
    }

    public void posicionarEnElMapa() throws NoSePuedePonerEnElMapaElPosicionableException {

        try {

            Mapa.getMapa().ubicar(this);

        } catch (LaPosicionNoExisteEnElMapaException e) {

            throw new NoSePuedePonerEnElMapaElPosicionableException("la posicion en la cual se quiere ubicar es invalida");
        }

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion unaPosicion) {
        this.posicion = unaPosicion;
    }

}
