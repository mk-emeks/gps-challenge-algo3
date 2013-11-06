package fiuba.algo3.modelo;


public class Posicion {

    private int posicionX;
    private int posicionY;

    public Posicion() {
        this.posicionX = 0;
        this.posicionY = 0;
    }

    public Posicion(int unaPosicionX, int unaPosicionY) {
        this.posicionX = unaPosicionX;
        this.posicionY = unaPosicionY;
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public int getPosicionY() {
        return this.posicionY;
    }

    public Posicion sumar(Posicion unaPosicion){

        int posicionFinalX = (this.getPosicionX() + unaPosicion.getPosicionX());
        int posicionFinalY = (this.getPosicionY() + unaPosicion.getPosicionY());

        Posicion posicionFinal = new Posicion(posicionFinalX, posicionFinalY);
        return posicionFinal;
    }

    public Posicion restar(Posicion unaPosicion){

        int posicionFinalX = (this.getPosicionX() - unaPosicion.getPosicionX());
        int posicionFinalY = (this.getPosicionY() - unaPosicion.getPosicionY());

        Posicion posicionFinal = new Posicion(posicionFinalX, posicionFinalY);
        return posicionFinal;
    }


    //Compara solo coordenadas.
    public boolean comparar(Posicion unaPosicion) {

        return ( (this.getPosicionX() == unaPosicion.getPosicionX()) && (this.getPosicionX() == unaPosicion.getPosicionX()));

    }

    public double calcularDistancia(Posicion unaPosicion) {
        Posicion posicionResultante = this.restar(unaPosicion);
        double distancia = (Math.pow(posicionResultante.getPosicionX(),2) + Math.pow(posicionResultante.getPosicionY(),2));
        return Math.sqrt(distancia);
    }
}
