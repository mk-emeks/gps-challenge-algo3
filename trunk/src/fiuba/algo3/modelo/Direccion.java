package fiuba.algo3.modelo;


public class Direccion {

    public Posicion versorDirector;

    public Direccion(){
        this.versorDirector = new Posicion();
    }

    public Posicion devolverComoPosicion() {
        return this.versorDirector;
    }

    @Override
    public boolean equals (Object unObjetoDireccion) {
        Direccion unaDireccion = (Direccion) unObjetoDireccion;
        boolean iguales = this.versorDirector.equals(unaDireccion.devolverComoPosicion());

        return iguales;
    }

    public void invertir() {
        this.versorDirector.setPosicionX(this.versorDirector.getPosicionX()*(-1));
        this.versorDirector.setPosicionY(this.versorDirector.getPosicionY()*(-1));
    }

}
