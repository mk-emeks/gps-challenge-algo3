package fiuba.algo3.modelo;


public class Posicion {

    private double posicionX;
    private double posicionY;

    public Posicion() {
        this.posicionX = 0.0;
        this.posicionY = 0.0;
    }

    public Posicion(double unaPosicionX, double unaPosicionY) {
        this.posicionX = unaPosicionX;
        this.posicionY = unaPosicionY;
    }

    public double getPosicionX() {
        return this.posicionX;
    }

    public double getPosicionY() {
        return this.posicionY;
    }

    public Posicion sumar(Posicion unaPosicion){

        double posicionFinalX = (this.getPosicionX() + unaPosicion.getPosicionX());
        double posicionFinalY = (this.getPosicionY() + unaPosicion.getPosicionY());

        Posicion posicionFinal = new Posicion(posicionFinalX, posicionFinalY);
        return posicionFinal;
    }

    public Posicion restar(Posicion unaPosicion){

        double posicionFinalX = (this.getPosicionX() - unaPosicion.getPosicionX());
        double posicionFinalY = (this.getPosicionY() - unaPosicion.getPosicionY());

        Posicion posicionFinal = new Posicion(posicionFinalX, posicionFinalY);
        return posicionFinal;
    }


    //Compara solo coordenadas.
    public boolean comparar(Posicion unaPosicion) {
        boolean iguales = false;

        if ( (this.getPosicionX() == unaPosicion.getPosicionX()) && (this.getPosicionX() == unaPosicion.getPosicionX())) {
            iguales = true;
        }

        return iguales;
    }

    public double calcularDistancia(Posicion unaPosicion) {
        Posicion posicionResultante = this.restar(unaPosicion);
        double distancia = (Math.pow(posicionResultante.getPosicionX(),2) + Math.pow(posicionResultante.getPosicionY(),2));
        return Math.sqrt(distancia);
    }
}
