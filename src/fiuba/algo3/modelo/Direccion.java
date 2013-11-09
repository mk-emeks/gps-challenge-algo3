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

}
