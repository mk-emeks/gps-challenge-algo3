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

                this.esclarecerAlrededorConVecindad(posicionSombra);

                break;
            }
        }

    }

    /** quita la niebla de n posiciones consecutivas en una direccion, respecto de la posicion que se le pase**/
    private void esclarecerVision( Posicion posicion , Direccion unaDireccion, int cantidadDeSombrasConsecutivasAEsclarecer) {

        Posicion posicionDeLaDireccion = unaDireccion.devolverComoPosicion();
        Posicion posicionIterada = posicion.sumar(posicionDeLaDireccion);
        for (int i=0 ; i<cantidadDeSombrasConsecutivasAEsclarecer ; i++) {

            try {
                this.neblina.getVistaSombra( posicionIterada.sumar(posicionDeLaDireccion.multiplicarPorEscalar(i))).quitarNeblina();
            } catch (Exception e1) { /*System.out.println("no hay rango de vision en esta direccion");*/}

        }

    }

    private void esclarecerAlrededorSimple(Posicion unaPosicion) {

        int nSombrasConsecutivas = 1;

        try {

            this.neblina.getVistaSombra(unaPosicion).quitarNeblina();

        } catch (Exception e) {/*nunca va ser invalida, ya que entro en el if*/}

        this.esclarecerVision(unaPosicion,new DireccionArriba(),nSombrasConsecutivas);
        this.esclarecerVision(unaPosicion, new DireccionAbajo(),nSombrasConsecutivas);
        this.esclarecerVision(unaPosicion,new DireccionDerecha(),nSombrasConsecutivas);
        this.esclarecerVision(unaPosicion,new DireccionIzquierda(),nSombrasConsecutivas);

    }

    private void esclarecerAlrededorConVecindad(Posicion unaPosicion) {

    int nSombrasConsecutivas = 2;

    Direccion arriba = new DireccionArriba();
    Direccion abajo= new DireccionAbajo();
    Direccion derecha = new DireccionDerecha();
    Direccion izquierda = new DireccionIzquierda();


    // esclarece arriba y sus dos costados
    this.esclarecerVision(unaPosicion,arriba,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(arriba.devolverComoPosicion()),derecha,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(arriba.devolverComoPosicion()),izquierda,nSombrasConsecutivas);

    // esclarece abajo y sus dos costados
    this.esclarecerVision(unaPosicion,abajo,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(abajo.devolverComoPosicion()),derecha,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(abajo.devolverComoPosicion()),izquierda,nSombrasConsecutivas);

    // esclarece hacia la derecha y sus dos costados
    this.esclarecerVision(unaPosicion,derecha,2);
    this.esclarecerVision(unaPosicion.sumar(derecha.devolverComoPosicion()),arriba,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(derecha.devolverComoPosicion()),abajo,nSombrasConsecutivas);

    // esclarece hacia la izquierda y sus dos costados
    this.esclarecerVision(unaPosicion,izquierda,2);
    this.esclarecerVision(unaPosicion.sumar(izquierda.devolverComoPosicion()),arriba,nSombrasConsecutivas);
    this.esclarecerVision(unaPosicion.sumar(izquierda.devolverComoPosicion()),abajo,nSombrasConsecutivas);

    }

    private void esclareceInicio() {

        Posicion inicio = Mapa.getMapa().getInicio();
        this.esclarecerAlrededorSimple(inicio);

    }

    private void esclarecerLLegada() {

        Posicion llegada = Mapa.getMapa().getLlegada();
        this.esclarecerAlrededorSimple(llegada);

    }

    public void actualizar() {

        this.neblina.nublar();
        this.esclareceInicio();
        this.esclarecerLLegada();
        this.esclarecerVisionDelPiloto();

    }

}
