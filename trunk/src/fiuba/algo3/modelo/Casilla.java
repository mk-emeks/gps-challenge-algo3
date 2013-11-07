package fiuba.algo3.modelo;

public class Casilla {

    /** Clase Casilla **/

    /**Atributos**/

    private Posicion posicion;
    private EstadoCasilla estado;
    private Posicionable contenido;

     /** Constructores **/

    public Casilla (Posicion unaPosicion) {

        this.posicion = unaPosicion;
        this.contenido = null;
    }

    public Casilla (Posicion unaPosicion , EstadoCasilla unEstado) {

        this.posicion = unaPosicion;
        this.estado = unEstado;
        this.contenido = null;
    }

    /** Metodos **/

    // manejo de la Posicion
    public Posicion devolverPosicion(){
        return this.posicion;
    }

    // manejo del estado
    public void setEstado( EstadoCasilla unEstado){
        this.estado = unEstado;
    }

    public EstadoCasilla getEstado() {
        return this.estado;
    }

    // manejo de los posicionables

    /** (!) si se pasa un nuevo posicionable pisa el que estaba **/
    public void agregarContenido(Posicionable unContenido) throws LaCasillaNoEsAlojable {
        if (this.getEstado().sosAlojable()) {
            this.contenido = unContenido;
        } else {
            throw new LaCasillaNoEsAlojable("estas intentando alojar un posicionable en una cuadra");
        }

    }

    public void sacarContenido() {

        this.contenido = null;

    }

    public Posicionable getContenido() {
        return this.contenido;
    }

    public boolean estaOcupada() {
        return (this.contenido != null);
    }

    public boolean contiene(Posicionable objeto) {
        return (this.contenido == objeto);
    }

}
