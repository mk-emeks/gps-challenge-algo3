package fiuba.algo3.modelo;

/** ver el tema de las dimensiones requeridas para un correcto funcionamiento
 *  probar con ciertos rectangulos anda mal
 *  Igualmente no es importante por el momento, con tableros cuadradros anda bien,
 *  (ojo que hay un par de pruebas que tiene tamaño distinto y corren bien igual)
 * **/

public class Pintor {

    private EstadoCuadra pinturaCuadra = new EstadoCuadra();
    private EstadoCalle pinturaCalle = new EstadoCalle();

    public void pintar(Casilla unaCasilla, EstadoCasilla unEstadoCasilla) {

        unaCasilla.setEstado(unEstadoCasilla);
    }

    public void pintarUnaCalleEn(Casilla unaCasilla){

        unaCasilla.setEstado(pinturaCalle);
    }

    public void pintarUnaCuadraEn(Casilla unaCasilla) {

        unaCasilla.setEstado(pinturaCuadra);
    }

    private void pintarCallesImpares(Tablero unTablero) {

        for(int i = 0; i < unTablero.cantidadDeFilas(); i=i+2) {
            for(int j = 1; j < unTablero.cantidadDeColumnas(); j=j+2) {

                this.pintarUnaCalleEn(unTablero.getCasilla(i,j));
            }
        }
    }

    private void pintarCallesPares(Tablero unTablero) {

        for(int i = 1; i < unTablero.cantidadDeFilas(); i=i+2) {
            for(int j = 0; j < unTablero.cantidadDeColumnas(); j++) {

                this.pintarUnaCalleEn(unTablero.getCasilla(i,j));
            }
        }
    }

    private void pintarCuadrasSimplesA(Tablero unTablero){

        for(int i = 0; i < unTablero.cantidadDeFilas(); i=i+2) {
            for(int j = 0; j < unTablero.cantidadDeColumnas(); j=j+2) {

                this.pintarUnaCuadraEn(unTablero.getCasilla(i,j));
            }
        }
    }

    private void pintarCallesSimplesA(Tablero unTablero) {

        this.pintarCallesImpares(unTablero);
        this.pintarCallesPares(unTablero);
    }

    public void pintarTableroSimple(Tablero unTablero) {
        this.pintarCuadrasSimplesA(unTablero);
        this.pintarCallesSimplesA(unTablero);
    }
}
