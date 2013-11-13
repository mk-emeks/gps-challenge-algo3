package fiuba.algo3.modelo;


public abstract class Obstaculo implements Aplicable {

    private int tiempoPenalizado;
    private Posicion posicion;

    public Obstaculo(int penalizacion, Posicion unaPosicion) {
        this.tiempoPenalizado = penalizacion;
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
