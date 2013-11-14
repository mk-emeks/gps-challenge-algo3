package fiuba.algo3.modelo;


public abstract class Obstaculo implements Aplicable {

    private int turnosPenalizado;
    private Posicion posicion;

    public Obstaculo(int penalizacion, Posicion unaPosicion) {
        this.turnosPenalizado = penalizacion;
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

    /** implementacion **/

    public int cantidadDeTurnosPenalizado() {

        return this.turnosPenalizado;
    }
    private void restarCantidadDeTurnosPenalizado() {

        this.turnosPenalizado = this.turnosPenalizado-1;
    }

    protected void aplicar (Piloto piloto) {

        if ( (this.cantidadDeTurnosPenalizado()) > 0 ) {
            piloto.detenerVehiculo();
        } else {
            piloto.arrancarVehiculo();
        }
        this.restarCantidadDeTurnosPenalizado();

    }
}
