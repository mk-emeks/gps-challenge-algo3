package fiuba.algo3.modelo;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;

public class EditorMapa {

    private Mapa unMapa;

    public EditorMapa() {

        this.unMapa = Mapa.getMapa();
        this.unMapa.cargarContenidoMapa(); /** NUEVO NUEVO NUEVO **/

    }

    public void editarMapaSimple() {

        int ancho =20;
        int largo = 14;

        this.pintarMapaDeDimensiones(ancho, largo); /** el maximo **/


        /** Posicion de inicio **/

        try {
            unMapa.ubicarPosicionDeInicio( new Posicion(1,2) );  /** agregado villa, no hace falta, porque mucho de esto va a cambiar **/
        } catch (Exception e) { System.out.println("no se pudo ubicar el inicio");}

        /** Posicion de llegada **/

        Posicion posicionDeLlegada;

        if( (largo%2)==0) {

            posicionDeLlegada = new Posicion(ancho,largo);
        } else {
            posicionDeLlegada = new Posicion(ancho,largo-1);
        }

        try {
            unMapa.ubicarPosicionDeLlegada(posicionDeLlegada);
        } catch (Exception e) { System.out.println("no se pudo ubicar la posicion de llegada");}

        /** Obstaculos**/
        try{
            unMapa.ubicar(new Pozo(new Posicion(12,3)));
            unMapa.ubicar(new Piquete(new Posicion(2,6)));
            unMapa.ubicar(new ControlPolicial(new Posicion(9,8)));

        } catch (Exception e) { System.out.println("no se pudo ubicar obstaculos");}

        /**Sorpresas**/
        try{
            unMapa.ubicar(new SorpresaDesfavorable(new Posicion(11,4)));
            unMapa.ubicar(new SorpresaFavorable(new Posicion(2,11)));
            unMapa.ubicar(new SorpresaCambioDeVehiculo((new Posicion(11,12))));

        } catch (Exception e) { System.out.println("no se pudo ubicar sorpresas");}


    }

    private void pintarMapaDeDimensiones(int ancho, int largo) {

        this.agregarCallesPares(ancho,largo);
        this.agregarCallesImpares(ancho,largo);

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

    /** metodo existente solo para el testing, plantea el mapa mas pequeño con el que se podria jugar **/
    public void editarMapaMinimoJugable() {

        this.pintarMapaDeDimensiones(3, 3);

    }

    /** solo para testing **/
    public void editarMapaDeDimensiones(int ancho, int largo) {

        this.pintarMapaDeDimensiones(ancho,largo);

    }

    /** xmlWriter **/
    public void crearXml() {

        ContenidoMapa contenidoMapa = Mapa.getMapa().getContenidoMapa();
        Document docContenidoMapa = new Document(contenidoMapa.serializar());

        try{

            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());

            FileOutputStream file = new FileOutputStream("mapaSimple.xml");
            out.output(docContenidoMapa,file);

            file.flush();
            file.close();

            out.output(docContenidoMapa,System.out);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
