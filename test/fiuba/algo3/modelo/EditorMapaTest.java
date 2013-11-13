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