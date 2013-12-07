package fiuba.algo3.modelo;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import java.io.FileInputStream;

public class CargadorDeMapa {


    //private EditorMapa editor;
    private String nombreDelMapa;

    public CargadorDeMapa(String nombreDelMapa) {

        //editor = new EditorMapa();
        this.nombreDelMapa = nombreDelMapa;
    }


    /** xmlReader **/
    public void cargarMapa () {

        try {

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(nombreDelMapa));
            Element raiz = doc.getRootElement();
            Mapa.getMapa().cargarContenidoMapa(raiz);

        } catch (Exception e) {System.out.println("no se pudo cargar el mapa requerido");}

        this.cargarInicioYLlegada();

    }

    /** deben ser los limites del mapa (completar) **/
    int limiteSuperiorX = 20;
    int limiteInferiorX = 3;
    int limiteSuperiorY = 14;
    int limiteInferiorY = 3;

    private void cargarInicioYLlegada() {

        int xInicio,yInicio,xLlegada,yLlegada;
        Posicion inicio,llegada;

         do {

            xInicio = this.numeroRandomEntre1yLimite(limiteSuperiorX);
            yInicio = this.numeroRandomEntre1yLimite(limiteSuperiorY);
            xLlegada =  this.numeroRandomEntre1yLimite(limiteSuperiorX);
            yLlegada = this.numeroRandomEntre1yLimite(limiteSuperiorY);
            System.out.println("inicio x:" + xInicio + " y:" + yInicio + " llegada x" + xLlegada + " y:" + yLlegada);

            inicio = new Posicion(xInicio,yInicio);
            llegada = new Posicion(xLlegada,yLlegada);

         } while (!this.randomValido(inicio,llegada)); // hacerlo mientras el random no sea valido

        // asignamos al mapa
        try {
            Mapa.getMapa().ubicarPosicionDeInicio(inicio);
            Mapa.getMapa().ubicarPosicionDeLlegada(llegada);

        }catch (Exception e){}

    }

    private int numeroRandomEntre1yLimite (int limite) {

        int numeroRandom =  (int) (Math.random() * limite);
        while ( numeroRandom == 0) {
            numeroRandom = (int) (Math.random() * limite);
        }
        return numeroRandom;

    }

    private boolean randomValido(Posicion inicio, Posicion llegada) {

        int xInicio = inicio.getPosicionX();
        int yInicio = inicio.getPosicionY();
        int xLlegada = llegada.getPosicionX();
        int yLlegada = llegada.getPosicionY();

        boolean aprobadoCoordenadasValidas = false;

        if ( (this.coordenadasValidas(xInicio,yInicio)) && (this.coordenadasValidas(xLlegada,yLlegada)) ) {
            aprobadoCoordenadasValidas = true;
        }

        boolean aprobadoPosicionesValides = false;
        if (this.posicionesValidas(inicio,llegada)) { aprobadoPosicionesValides = true; }

        return (aprobadoCoordenadasValidas && aprobadoPosicionesValides);

    }

    /** Validacion de las posiciones **/
    // no se valida que la llegada y el inicio se superpongan con una sorpresa u obstaculo

    private boolean posicionesValidas ( Posicion inicio, Posicion llegada) {

        boolean aprobadoNoIgualdad = false;
        if (!this.posicionesIguales(inicio,llegada)) { aprobadoNoIgualdad = true; }

        boolean aprobadoInicio = false;
        if (posicionExistenteEnElMapa(inicio)) { aprobadoInicio = true; }


        boolean aprobadoLlegada = false;
        if (posicionExistenteEnElMapa(llegada)) { aprobadoLlegada = true; }

        return  (aprobadoNoIgualdad && aprobadoInicio && aprobadoLlegada);

    }

    private boolean posicionesIguales(Posicion inicio, Posicion llegada) {

        return  (inicio.equals(llegada));
    }

    private boolean posicionExistenteEnElMapa(Posicion unaPosicion) {

        boolean aprobado = false;
        if (Mapa.getMapa().existe(unaPosicion)) {
            aprobado = true;
        }
        return aprobado;

    }

    /** Validacion de las coordenadas **/
    private boolean coordenadasValidas(int x, int y) {

        boolean aprobadoX = false;
        if (this.limitesValidos(x, limiteSuperiorX, limiteInferiorX)) {
            aprobadoX = true;
        }

        boolean aprobadoY = false;
        if (this.limitesValidos(y, limiteSuperiorY, limiteInferiorY)) {
            aprobadoY = true;
        }

        return (aprobadoX && aprobadoY);

    }

    private boolean limitesValidos(int coordenada, int limiteSuperior, int limiteInferior) {

        boolean aprobado = false;
        if  ( ( coordenada < limiteSuperior) && ( coordenada > limiteInferior ) ) {
            aprobado = true;
        }

        return  aprobado;
    }


}
