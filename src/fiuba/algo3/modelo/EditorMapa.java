package fiuba.algo3.modelo;

public class EditorMapa {

    /** toquetiado **/
    private Mapa unMapa;

    public EditorMapa() {

        this.unMapa = Mapa.getMapa();

    }


    /** temporal: uso para probar el mapa plantiado en la consigna inicial **/

    //Deja un mapa en las condiciones minimas establecidad para que sea jugable, respetando calles, cuadras y ubicando una llegada.
    public void editarMapaMinimoJugable() {
        this.editarMapaSimple(3,3);
    }

    public void editarMapaNivel() {

        this.editarMapaSimple(15,15);

        /** Obstaculos**/
        try{
            unMapa.ubicar(new ControlPolicial(new Posicion(2,2)));
            unMapa.ubicar(new ControlPolicial(new Posicion(5,6)));
            unMapa.ubicar(new Piquete(new Posicion(2,6)));
            unMapa.ubicar(new Pozo(new Posicion(4,4)));
        } catch (Exception e) { System.out.println("no se pudo ubicar obstaculos");}

        /**Sorpresas**/
        try{
            unMapa.ubicar(new SorpresaDesfavorable(new Posicion(4,2)));
            unMapa.ubicar(new SorpresaFavorable((new Posicion(6,4))));
            unMapa.ubicar(new SorpresaFavorable((new Posicion(4,6))));
        } catch (Exception e) { System.out.println("no se pudo ubicar sorpresas");}
    }


    public void editarMapaSimple(int ancho, int largo) {

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

        try {
        unMapa.ubicarPosicionDeLlegada(posicionDeLlegada);
        } catch (Exception e) { System.out.println("no se pudo ubicar la posicion de llegada");}

        try {
        unMapa.ubicarPosicionDeInicio( new Posicion(1,2) );  /** agregado villa, no hace falta, porque mucho de esto va a cambiar **/
        } catch (Exception e) { System.out.println("no se pudo ubicar el inicio");}
    }

    private void agregarCallesImpares(int ancho, int largo) {

        for(int i = 1; i <= largo; i=i+2) {
            for(int j = 2; j <= ancho; j=j+2) {

                try {
                unMapa.agregar(new Posicion(j,i));
                } catch (Exception e) { System.out.println("no se pudo agregar calles Impares");}
            }
        }
    }

    private void agregarCallesPares(int ancho, int largo) {

        for(int i = 2; i <= largo; i=i+2) {
            for(int j = 1; j <= ancho; j++) {

                try {
                unMapa.agregar(new Posicion(j,i));
                } catch (Exception e) { System.out.println("no se pudo argegar calles Pares");}
            }
        }
    }

}
