package fiuba.algo3.modelo;

// importar nodoXml
/** es el equivalente de nuestra clase editor, se encargara de dejar el mapa listo para jugar, a partir de levantar
 *  el nodo xml
 */



public class Nivel {

    // NodoXml nodo;
    private EditorMapa editor;

    public Nivel(/** NodoXml unNodo **/) {

        editor = new EditorMapa();
        // this.nodo = unNodo;

    }

    public void cargarMapa() {

        this.editor.editarMapaNivel();

        /** deberia cargar el xml correspondiente (PASADO POR PARAMETRO) , segun el sea nivel facil, normal, dificil
         *  esto se lo designarar en el momento que el player eliga la dificultad.
         */

    }




}
