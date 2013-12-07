package fiuba.algo3.control;

import fiuba.algo3.masterOfPuppets.GameLoop;
import fiuba.algo3.modelo.*;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.vista.*;

import java.util.ArrayList;
import java.util.Iterator;

public class ControlDeVistas implements ObjetoVivo {


    private ControlDeSombras controlDeSombras;
    private Piloto pilotin;
    private GameLoop gameLoop;

    public ControlDeVistas(GameLoop gameLoop, Piloto unPiloto) {


        this.gameLoop = gameLoop;
        this.pilotin = unPiloto;
        this.controlDeSombras = new ControlDeSombras(this.pilotin);

    }

    private void actualizar() {

        this.actualizarVistas();
        this.controlDeSombras.actualizar();

    }

    /** por implementar obejeto vivo **/

    public void vivir() {

        this.actualizar();

    }
    /** fin **/

    /** mouestro **/
    private void actualizarVistas() {

        /** ineficiente hacerlo siempre, habria que saber si se interactuo con alguna y entonces ahi repintar **/
        this.quitarVistaDeAplicablesTemporales();  // funciona igual sin esto, pero es correcto sacar lo que no se usa
        this.agregarVistasAlGameLoop(); /** este es el ineficiente **/



    }


    /** la unicas vista que hay que sacar **/
    private void quitarVistaDeAplicablesTemporales() {
        ArrayList<AplicableTemporal> aplicablesTemporales = Mapa.getMapa().getAplicablesTemporales();
        Iterator<AplicableTemporal> it = aplicablesTemporales.iterator();

        while (it.hasNext()) {

            Aplicable unAplicable = it.next();

            ObjetoPosicionable sorpresa = new RepresentacionDePosicionable(unAplicable.getPosicion());
            ObjetoDibujable  vistaSorpresa = new VistaSorpresa(sorpresa);
            this.gameLoop.remover(vistaSorpresa);   //titiritero pedorro

        }

    }

    /**!**/
    private void agregarVistasAlGameLoop() {

        this.agregarVistasDeCallesAlGameLoop();
        this.agregarVistaInicioAlGameLoop();
        this.agregarVistaLlegadaAlGameLoop();
        this.agregarVistasDeAplicablesTemporales();
        this.agregarVistasDeAplicablesAlGameLoop();
        this.agregarVistaAutoAlGameLoop();
        this.agregarVistasDeLasSombrasAlGameLoop();

    }

    private void agregarVistasDeAplicablesTemporales() {

        ArrayList<AplicableTemporal> aplicablesTemporales = Mapa.getMapa().getAplicablesTemporales();
        Iterator<AplicableTemporal> it = aplicablesTemporales.iterator();

        while (it.hasNext()) {

            Aplicable unAplicable = it.next();

            ObjetoPosicionable sorpresa = new RepresentacionDePosicionable(unAplicable.getPosicion());
            ObjetoDibujable  vistaSorpresa = new VistaSorpresa(sorpresa);
            gameLoop.agregar(vistaSorpresa);

        }

    }

    private void agregarVistasDeLasSombrasAlGameLoop() {

        ArrayList<Posicion> posicionDeLasSombras = Mapa.getMapa().getPosicionesValidas();
        Iterator<Posicion> iterador = posicionDeLasSombras.iterator();

        this.controlDeSombras.getNeblina().sacarTodasLasSombras(); /**!**/

        while (iterador.hasNext()) {

            ObjetoPosicionable unaSombra = new RepresentacionDePosicionable(iterador.next());
            ObjetoDibujable unaVistaSombra = new VistaSombra(unaSombra);
            gameLoop.agregar(unaVistaSombra);
            this.controlDeSombras.getNeblina().agregar((VistaSombra) unaVistaSombra);
        }

    }

    private void agregarVistasDeCallesAlGameLoop() {

        ArrayList<Posicion> posicionDeLasCalles = Mapa.getMapa().getPosicionesValidas();
        Iterator<Posicion> iterador = posicionDeLasCalles.iterator();

        while (iterador.hasNext()) {

            ObjetoPosicionable unaCalle = new RepresentacionDePosicionable(iterador.next());
            ObjetoDibujable unaVistaCalle = new VistaCalle(unaCalle);
            gameLoop.agregar(unaVistaCalle);
        }

    }

    private void agregarVistaInicioAlGameLoop() {

        ObjetoPosicionable inicio = new RepresentacionDePosicionable(Mapa.getMapa().getInicio());
        ObjetoDibujable  vistaInicio = new VistaInicio(inicio);
        gameLoop.agregar(vistaInicio);

    }

    private void agregarVistaLlegadaAlGameLoop() {

        ObjetoPosicionable llegada = new RepresentacionDePosicionable(Mapa.getMapa().getLlegada());
        ObjetoDibujable  vistaLlegada = new VistaLlegada(llegada);
        gameLoop.agregar(vistaLlegada);

    }

    private void agregarVistasDeAplicablesAlGameLoop() {

        ArrayList<Aplicable> aplicables = Mapa.getMapa().getAplicables();
        Iterator<Aplicable> it = aplicables.iterator();
        while (it.hasNext()) {
            Aplicable unAplicable = it.next();

            if (unAplicable instanceof ControlPolicial) {

                ObjetoPosicionable policia = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPolicia = new VistaPolicia(policia);
                gameLoop.agregar(vistaPolicia);

            } else if (unAplicable instanceof Pozo) {

                ObjetoPosicionable pozo = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPozo = new VistaPozo(pozo);
                gameLoop.agregar(vistaPozo);

            } else if (unAplicable instanceof Piquete) {

                ObjetoPosicionable piquete = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPiquete = new VistaPiquete(piquete);
                gameLoop.agregar(vistaPiquete);
            }
        }

    }

    private void agregarVistaAutoAlGameLoop() {

        VistaVehiculo unaVistaVehiculo = new VistaVehiculo(this.pilotin.getVehiculo());
        gameLoop.agregar(unaVistaVehiculo);
    }

}
