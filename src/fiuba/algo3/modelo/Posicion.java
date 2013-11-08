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

    public Posicion multiplicarPorEscalar(int unEscalar) {
        this.posicionX = unEscalar*this.posicionX;
        this.posicionY = unEscalar*this.posicionY;

        Posicion posicionMultiplicadaPorEscalar = new Posicion(this.posicionX, this.posicionY);

        return posicionMultiplicadaPorEscalar;
    }

    public Posicion restar(Posicion unaPosicion){

        Posicion posicionFinal = unaPosicion.multiplicarPorEscalar(-1);
        posicionFinal = this.sumar(posicionFinal);

        return posicionFinal;
    }

    /**Esto esta hecho de forma rapida, hay que verifcarlo bien**/
    @Override
    public boolean equals(Object unObjetoPosicion) {
        Posicion unaPosicion = (Posicion) unObjetoPosicion;
        boolean iguales = false;

        if ((this.getPosicionX() == unaPosicion.getPosicionX() && (this.getPosicionY() == unaPosicion.getPosicionY()))) {
            iguales = true;
        }
        return iguales;
    }





}
