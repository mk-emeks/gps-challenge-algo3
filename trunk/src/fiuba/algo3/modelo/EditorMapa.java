package fiuba.algo3.modelo;

public class EditorMapa {

    /** temporal: uso para probar el mapa plantiado en la consigna inicial **/

    public void editarMapaSimple(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        this.agregarCallesPares(map, columnas , filas);
        this.agregarCallesImpares(map, columnas , filas);

    }

    private void agregarCallesImpares(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 1; i <= filas; i=i+2) {
            for(int j = 2; j <= columnas; j=j+2) {

                map.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

    private void agregarCallesPares(Mapa map, int columnas, int filas) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 2; i <= filas; i=i+2) {
            for(int j = 1; j <= columnas; j++) {

                map.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

}
