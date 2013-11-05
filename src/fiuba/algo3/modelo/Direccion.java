package fiuba.algo3.modelo;


public class Direccion {

    public Posicion versorDirector;

    public Direccion() {
        this.versorDirector = new Posicion();
    }

    public Posicion devolverComoPosicion() {
        return this.versorDirector;
    }

    public boolean esIgualA(Direccion unaDireccion) {
        return this.versorDirector.comparar(unaDireccion.devolverComoPosicion());
    }

}
