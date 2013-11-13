package fiuba.algo3.modelo;

public class EditorMapa {

    private Mapa unMapa = Mapa.getMapa();

    /** temporal: uso para probar el mapa plantiado en la consigna inicial **/

    public void editarMapaSimple(int ancho, int largo) throws Exception {

        this.agregarCallesPares(ancho,largo);
        this.agregarCallesImpares(ancho,largo);
        /** agregarLLegada() **/

    }

    private void agregarCallesImpares(int ancho, int largo) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 1; i <= largo; i=i+2) {
            for(int j = 2; j <= ancho; j=j+2) {

                unMapa.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

    private void agregarCallesPares(int ancho, int largo) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 2; i <= largo; i=i+2) {
            for(int j = 1; j <= ancho; j++) {

                unMapa.agregar(new Posicion(j,i));  /**!**/
            }
        }
    }

}
