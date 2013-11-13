package fiuba.algo3.modelo;

public class EditorMapa {

    private Mapa unMapa = Mapa.getMapa();


    /** temporal: uso para probar el mapa plantiado en la consigna inicial **/

    //Deja un mapa en las condiciones minimas establecidad para que sea jugable, respetando calles, cuadras y ubicando una llegada.
    public void editarMapaMinimoJugable() throws Exception {
        this.editarMapaSimple(3,3);
    }


    public void editarMapaSimple(int ancho, int largo) throws Exception {

        Posicion posicionDeLlegada;
        this.agregarCallesPares(ancho,largo);
        this.agregarCallesImpares(ancho,largo);

        //La llegada siempre se ubica en una misma posicion con respecto al tamaño del mapa
        //Siempre en la ultima columna (ancho)
        //En caso de que el largo sea par se lo ubica ultimo
        //En caso de que el largo sea impar se sube una posicion (porque si va ultimo hay una cuadra)
        if( (largo%2)==0) {

            posicionDeLlegada = new Posicion(ancho,largo);
        } else {
            posicionDeLlegada = new Posicion(ancho,largo-1);
        }

        unMapa.ubicarPosicionDeLlegada(posicionDeLlegada);
    }

    private void agregarCallesImpares(int ancho, int largo) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 1; i <= largo; i=i+2) {
            for(int j = 2; j <= ancho; j=j+2) {

                unMapa.agregar(new Posicion(j,i));
            }
        }
    }

    private void agregarCallesPares(int ancho, int largo) throws LaPosicionYaExisteEnElMapaException {

        for(int i = 2; i <= largo; i=i+2) {
            for(int j = 1; j <= ancho; j++) {

                unMapa.agregar(new Posicion(j,i));
            }
        }
    }

}
