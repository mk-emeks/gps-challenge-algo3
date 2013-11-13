package fiuba.algo3.modelo;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EditorMapaTest {

    Mapa unMapa;

    @Before
    public void setUp() {
        unMapa = Mapa.getMapa();
    }

    @After
    public void limpiezaMapa() {
        Mapa.limpiar();
    }

    /** ======== Tests Mapa Standard ======== **/
    @Test
    public void testDeberiaPoderEditarUnMapaMinimoJugable() throws Exception {
        EditorMapa unEditor = new EditorMapa();

        unEditor.editarMapaMinimoJugable();

        /** Recorro calles impares **/
        for (int j=1; j <= 3; j=j+2) {
            for (int i=2; i <= 3; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
        /** Recorro calles pares **/
        for (int j=2; j <= 3; j=j+2) {
            for (int i=1; i <= 3; i++) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaMinimoJugable() throws Exception {
        EditorMapa unEditor = new EditorMapa();

        unEditor.editarMapaMinimoJugable();

        Assert.assertEquals(3,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(2,unMapa.getLlegada().getPosicionY());
    }
    /**==============================================================================================================**/
    /**==============================================================================================================**/

    /** ======== Tests Felices Mapa Simple ======== **/

    @Test
    public void testDeberiaPoderEditarUnMapaSimpleCuadrado() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=7;
        int largoDelMapa=7;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=2; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
              Assert.assertTrue(unMapa.existe(unaPosicion));
           }
        }
        /** Recorro calles pares **/
        for (int j=2; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i++) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaCuadradoPar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=50;
        int largoDelMapa=50;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(50,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(50,unMapa.getLlegada().getPosicionY());
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaCuadradoImpar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=9;
        int largoDelMapa=9;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(9,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(8,unMapa.getLlegada().getPosicionY());
    }

    //Rectangular1 significa que el mapa es mar ancho que largo.
    @Test
    public void testDeberiaPoderEditarUnMapaSimpleRectangular1() throws Exception  {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=19;
        int largoDelMapa=6;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=2; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
        /** Recorro calles pares **/
        for (int j=2; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i++) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaRectangular1LargoPar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=25;
        int largoDelMapa=6;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(25,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(6,unMapa.getLlegada().getPosicionY());
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaRectangular1LargoImpar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=25;
        int largoDelMapa=3;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(25,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(2,unMapa.getLlegada().getPosicionY());
    }

    //Rectangular2 significa que el mapa es mar largo que ancho.
    @Test
    public void testDeberiaPoderEditarUnMapaSimpleRectangular2() throws Exception  {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=2;
        int largoDelMapa=20;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=2; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
        /** Recorro calles pares **/
        for (int j=2; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i++) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertTrue(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaRectangular2LargoPar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=5;
        int largoDelMapa=84;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(5,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(84,unMapa.getLlegada().getPosicionY());
    }

    @Test
    public void testLaLlegadaDeberiaEstarBienUbicadaEnUnMapaRectangular2LargoImpar() throws Exception {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=5;
        int largoDelMapa=11;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        Assert.assertEquals(5,unMapa.getLlegada().getPosicionX());
        Assert.assertEquals(10,unMapa.getLlegada().getPosicionY());
    }
    /**==============================================================================================================**/
    /**==============================================================================================================**/

    /** ======== Tests Malos Mapa Simple ======== **/

    @Test
    public void testNoDebertiaHaberCuadrasAlEditarUnMapaSimpleCuadrado() throws Exception  {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=6;
        int largoDelMapa=6;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares porque solo en ellas hay cuadras **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertFalse(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
     public void testNoDebertiaHaberCuadrasAlEditarUnMapaSimpleRectangular1() throws Exception  {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=14;
        int largoDelMapa=3;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares porque solo en ellas hay cuadras **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertFalse(unMapa.existe(unaPosicion));
            }
        }
    }

    @Test
    public void testNoDebertiaHaberCuadrasAlEditarUnMapaSimpleRectangular2() throws Exception  {
        EditorMapa unEditor = new EditorMapa();
        int anchoDelMapa=5;
        int largoDelMapa=30;

        unEditor.editarMapaSimple(anchoDelMapa,largoDelMapa);

        /** Recorro calles impares porque solo en ellas hay cuadras **/
        for (int j=1; j <= largoDelMapa; j=j+2) {
            for (int i=1; i <= anchoDelMapa; i=i+2) {

                Posicion unaPosicion = new Posicion (i,j);
                Assert.assertFalse(unMapa.existe(unaPosicion));
            }
        }
    }

}