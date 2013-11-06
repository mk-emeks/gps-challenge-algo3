package fiuba.algo3.modelo;

/**la joda de esta clase es que si en algun momento se quiziese lograr que en un determinado tablero, un vehiculo
 * llegase al extremo del mismo, este pudiese en el proximo movimiento aparecer por ejemplo en la correspondiente fila pero al
 * principio. Para lograrlo, restaria agregar un metodo publico que dejara ensamblar un casilla a gusto, es decir, modificar alguna
 * de sus referencias hacia la casilla desiada, siendo esta, por ejemplo, no consecutiva en la posicion real del tablero
 */
public class Ensamblador {

    private Direccion arriba,abajo,derecho,izquierdo;
    private Casilla casilla; // la casilla a la que le vamos vinculando las demas


    public Ensamblador() {
        arriba = new DireccionArriba();
        abajo = new DireccionAbajo();
        derecho = new DireccionDerecha();
        izquierdo = new DireccionIzquierda();
    }


    private void ensambleSimpleDeCasilla (Casilla casilla, Tablero tablero, Direccion unaDireccion) {

        Posicion poscionDelVecino = unaDireccion.devolverComoPosicion().sumar(casilla.devolverPosicion());
        Casilla vecino = tablero.getCasilla( poscionDelVecino.getPosicionX() , poscionDelVecino.getPosicionY());

        casilla.agregarSiguiente(vecino,unaDireccion);

    }

    /** pre condicion: supone como minimo un tablero de 2x2 **/

    /** el ensamble simple deja a las casillas de un tablero conectadas de forma convencional **/
    public void ensambleSimpleDeTablero(Tablero tablero){

        int maxColumnas = tablero.cantidadDeColumnas()-1;
        int maxFilas = tablero.cantidadDeFilas()-1;

        for (int col = 0 ; col <= maxColumnas ; col++) {

            for (int fil = 0 ; fil <= maxFilas ; fil++ ) {

                casilla = tablero.getCasilla(col,fil);

                if ( col == 1 )  { this.ensambleSimpleDeCasilla(casilla,tablero,derecho); }
                if ( col == maxColumnas ) { this.ensambleSimpleDeCasilla(casilla,tablero,izquierdo); }
                if ( fil == 1 )  { this.ensambleSimpleDeCasilla(casilla,tablero,abajo); }
                if ( fil == maxFilas ) { this.ensambleSimpleDeCasilla(casilla,tablero,arriba); }
                if ( ( col != 1 ) && (col != maxColumnas) ) {
                    this.ensambleSimpleDeCasilla(casilla,tablero,arriba);
                    this.ensambleSimpleDeCasilla(casilla,tablero,abajo);
                }
                if ( ( fil != 1 ) && (fil != maxFilas) ) {
                    this.ensambleSimpleDeCasilla(casilla,tablero,derecho);
                    this.ensambleSimpleDeCasilla(casilla,tablero,izquierdo);
                }
            }
        }
    }


}

