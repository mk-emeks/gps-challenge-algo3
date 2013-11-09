package fiuba.algo3.modelo;

public class Vehiculo implements Movible, Interceptable {

    /** atributos **/

    private Posicion posicion;
    private Direccion direccion;
    private EstadoVehiculo estado;

    /**Constructores**/

    public Vehiculo(Posicion unaPosicion , Direccion unaDireccion) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
    }

    public Vehiculo(Posicion unaPosicion , Direccion unaDireccion , EstadoVehiculo unEstado) {
        this.posicion = unaPosicion;
        this.direccion = unaDireccion;
        this.estado = unEstado;
    }

    /**Comportamiento**/

    public void setEstado (EstadoVehiculo unEstado) {
        this.estado = unEstado;
    }

    public EstadoVehiculo getEstado () {
        return this.estado;
    }

    /**implementacion por ser movible**/

    public void moverEn(Mapa unMapa) throws NoSePuedeMoverEnElMapaElMovibleException {

        Posicion avance = this.getDireccion().devolverComoPosicion();
        this.setPosicion(this.getPosicion().sumar(avance));

        try {
            unMapa.mover(this);

        } catch (LaPosicionNoExisteEnElMapaException excepcionPosicionNoExiste) {

            this.setPosicion(this.getPosicion().restar(avance));
            throw new NoSePuedeMoverEnElMapaElMovibleException("la direccion es invalida para la posicion actual") ;

        }

    }

    public void setDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    /**no si andara esto dle doble catch con las excepciones puestas**/
    public void ponerEn(Mapa unMapa) throws NoSePuedeAgregarEnElMapaElPosicionableException {

        try {
            unMapa.agregar(this);

        } catch (ElPosicionableYaEstaUbicadoEnElMapaException excepcionYaUbicado) {
            throw new NoSePuedeAgregarEnElMapaElPosicionableException("el posicionable ya fue puesto");
        }
        catch (LaPosicionNoExisteEnElMapaException excepcionPosicionNoExiste)
        {
            throw new NoSePuedeAgregarEnElMapaElPosicionableException("la posicion en la cual se quiere ubicar es invalida");
        }

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    /**implementacion por ser Interceptable**/




}
