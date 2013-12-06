package fiuba.algo3.control;


import fiuba.algo3.modelo.*;
import java.util.Iterator;


/** SHADOW s CONTROL: welcome to the dark side
 *  Vader: Luke, I am your father!
 *  Luke: noooooouuuu!
 */


public class ControlDeSombras {


    private Piloto piloto;  /** solo usa el vehiculo del piloto, pero quien sabe en un futuro **/
    private Neblina neblina;

    public ControlDeSombras(Piloto unPiloto) {

        this.piloto = unPiloto;
        this.neblina = new Neblina();

    }

    public Neblina getNeblina() {

        return this.neblina;
    }

    private void esclarecerVisionDelPiloto() {


        Iterator<Posicion> iterator = this.neblina.getPosicionesDeLasSombras().iterator();
        Posicion posicionVehiculo = this.piloto.getVehiculo().getPosicion();


        while (iterator.hasNext()) {

            Posicion posicionSombra = iterator.next();

            if ( posicionSombra.equals(posicionVehiculo) ) {

                try {

                this.neblina.getVistaSombra(posicionSombra).quitarNeblina();

                } catch (Exception e) {/*nunca va ser invalida, ya que entro en el if*/}

                this.esclarecerVision(posicionSombra,new DireccionArriba());
                this.esclarecerVision(posicionSombra,new DireccionAbajo());
                this.esclarecerVision(posicionSombra,new DireccionDerecha());
                this.esclarecerVision(posicionSombra,new DireccionIzquierda());

                break;
            }
        }

    }

    /** ACEPTA MODIFICACIONES **/
    /** quita la niebla de dos sombras consecutivas ( respecto de una posicion la dos que le sigan
     *  en determinada direccion **/
    private void esclarecerVision( Posicion posicion , Direccion unaDireccion) {

        Posicion posicionDeLaDireccion = unaDireccion.devolverComoPosicion();
        Posicion posicionSumada = posicion.sumar(posicionDeLaDireccion);

        try {

            this.neblina.getVistaSombra( posicionSumada ).quitarNeblina();
            this.neblina.getVistaSombra(posicionSumada.sumar(posicionDeLaDireccion)).quitarNeblina();

        } catch (Exception e) {
            //System.out.println("no hay rango de vision en esta direccion");
        }

    }

    private void esclarecerAlrededor(Posicion unaPosicion) {

        try {

            this.neblina.getVistaSombra(unaPosicion).quitarNeblina();

        } catch (Exception e) {/*nunca va ser invalida, ya que entro en el if*/}

        this.esclarecerVision(unaPosicion,new DireccionArriba());
        this.esclarecerVision(unaPosicion,new DireccionAbajo());
        this.esclarecerVision(unaPosicion,new DireccionDerecha());
        this.esclarecerVision(unaPosicion,new DireccionIzquierda());
    }

    private void esclareceInicio() {

        Posicion inicio = Mapa.getMapa().getInicio();
        this.esclarecerAlrededor(inicio);

    }

    private void esclarecerLLegada() {

        Posicion llegada = Mapa.getMapa().getLlegada();
        this.esclarecerAlrededor(llegada);

    }

    public void actualizar() {

        this.neblina.nublar();
        this.esclareceInicio();
        this.esclarecerLLegada();
        this.esclarecerVisionDelPiloto();

    }

}
