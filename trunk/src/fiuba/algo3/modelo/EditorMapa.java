package fiuba.algo3.modelo;

/** el "pintor" disfrazado, si obvio papa, volvio en forma de editor,
 * EDU: Un gran tema, cuando hiciste los metodos logre ver que al final cuando pintabas la casilla asignabas (i,j)
 * Si i es fila y j es columna, asignabas al reves de como esta implementada nuestra posicion, pero al mismo tiempo
 * funcionaba, asique nose..De tu codigo lo copie igual pero inverti la ultima asignacion porque supongo que el
 * algoritmo lo pensaste siendo conciente de que i es fila y j columna, seguramente anduvo antes
 * porque teniamos un mapa pintado "al reves" de lo que pensabamos. -> trata de fijarte que onda
 *
 * pd. te dejo que le hagas los test a tu hijo querido jajajaja
 */
public class EditorMapa {

    /** temporal: uso para probar el mapa plantiado en la consigna inicial **/

    public void editarMapaSimple(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        this.agregarCallesPares(map, columnas , filas);
        this.agregarCallesImpares(map, columnas , filas);

    }

    private void agregarCallesImpares(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 0; i < filas; i=i+2) {
            for(int j = 1; j < columnas; j=j+2) {

                map.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

    private void agregarCallesPares(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 1; i < filas; i=i+2) {
            for(int j = 0; j < columnas; j++) {

                map.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

}
