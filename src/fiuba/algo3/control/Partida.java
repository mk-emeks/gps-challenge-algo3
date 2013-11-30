package fiuba.algo3.control;

import fiuba.algo3.masterOfPuppets.GameLoop;
import fiuba.algo3.modelo.*;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.vista.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;



public class Partida {


    private GameLoop gameLoop;
    private SuperficieDeDibujo zonaDeJuego;
    //private JPanel zonaDeJuego;

    private Piloto pilotin;
    private Estado carroceria;

    private ControlDeEventos controlDeEventos;

    /** borrar */
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }

    public void crearPiloto (String nombreDelPiloto) {

        this.pilotin = new Piloto(nombreDelPiloto);

    }

    public Piloto getPiloto() {

        return this.pilotin;

    }

    public void cargarNivel (Nivel unNivel) {

        unNivel.cargarMapa();
    }

    public void asignarCarroceriaDelVehiculo ( Estado unaCarroceria) {

        this.carroceria = unaCarroceria;

    }

    public void cargarVehiculoParaElPiloto() {

        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,this.carroceria);


        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se posicionar el vehiculo en el mapa");}


        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();

    }

    /** CONSTRUCTOR **/

    /* public Partida( SuperficiePanel unaZonaDeJuego) {

        this.zonaDeJuego = unaZonaDeJuego;
        this.gameLoop = new GameLoop(90,this.zonaDeJuego);

    } */

    //public void asignarZonaDeJuego(SuperficieDeDibujo unaZonaDeJuego) {
      public void asignarZonaDeJuego(JPanel unaZonaDeJuego) {
        //this.zonaDeJuego = unaZonaDeJuego;
          this.zonaDeJuego = (SuperficieDeDibujo)unaZonaDeJuego;

    }


    /** PRE: Se deben haber invocado los metodos crearPiloto, asignarNivel y asignarCarroceriaDelVehiculo y asignarZonaDeJuego **/
    public void iniciar() {

        this.gameLoop = new GameLoop();
        this.gameLoop.setSuperficieDeDibujo(this.zonaDeJuego);
        //this.gameLoop.setSuperficieDeDibujo((SuperficieDeDibujo)this.zonaDeJuego);
        this.gameLoop.setIntervaloSimulacion(90);

        this.cargarGameLoop();
        this.comenzar();
    }

    /** METODOS PRIVATE **/

    private void cargarGameLoop() {

        this.agregarVistasAlGameLoop();
        this.agregarObjetosVivosAlGameLoop();

    }

    private void comenzar() {

        //this.gameLoop.comenzarJuego(1);
        //this.pilotin.getCronometro().iniciar();  /** iniciamos su cronometro **/
        this.gameLoop.comenzarJuego();



    }

    /** submetodos private (son todos para cargarGameloop) **/

    private void agregarVistasAlGameLoop() {

        this.agregarVistasDeCallesAlGameLoop();
        this.agregarVistaInicioAlGameLoop();
        this.agregarVistaLlegadaAlGameLoop();
        this.agregarVistasDeAplicablesAlGameLoop();
        this.agregarVistaAutoAlGameLoop();


    }

    private void agregarVistasDeCallesAlGameLoop() {

        ArrayList<Posicion> posicionDeLasCalles = Mapa.getMapa().getPosicionesValidas();
        Iterator<Posicion> iterador = posicionDeLasCalles.iterator();

        while (iterador.hasNext()) {

            ObjetoPosicionable unaCalle = new RepresentacionDePosicionable(iterador.next());
            ObjetoDibujable unaVistaCalle = new VistaCalle(unaCalle);
            this.gameLoop.agregar(unaVistaCalle);
        }

    }

    private void agregarVistaInicioAlGameLoop() {

        ObjetoPosicionable inicio = new RepresentacionDePosicionable(Mapa.getMapa().getInicio());
        ObjetoDibujable  vistaInicio = new VistaInicio(inicio);
        this.gameLoop.agregar(vistaInicio);

    }

    private void agregarVistaLlegadaAlGameLoop() {

        ObjetoPosicionable llegada = new RepresentacionDePosicionable(Mapa.getMapa().getLlegada());
        ObjetoDibujable  vistaLlegada = new VistaLlegada(llegada);
        this.gameLoop.agregar(vistaLlegada);

    }

    private void agregarVistasDeAplicablesAlGameLoop() {

        ArrayList<Aplicable> aplicables = Mapa.getMapa().getAplicables();
        Iterator<Aplicable> it = aplicables.iterator();
        while (it.hasNext()) {
            Aplicable unAplicable = it.next();

            if (unAplicable instanceof ControlPolicial) {

                ObjetoPosicionable policia = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPolicia = new VistaPolicia(policia);
                this.gameLoop.agregar(vistaPolicia);

            } else if (unAplicable instanceof Sorpresa) {

                ObjetoPosicionable sorpresa = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaSorpresa = new VistaSorpresa(sorpresa);
                this.gameLoop.agregar(vistaSorpresa);

            } else if (unAplicable instanceof Piquete) {

                ObjetoPosicionable piquete = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPiquete = new VistaPiquete(piquete);
                this.gameLoop.agregar(vistaPiquete);

            } else if (unAplicable instanceof Pozo) {

                ObjetoPosicionable pozo = new RepresentacionDePosicionable(unAplicable.getPosicion());
                ObjetoDibujable  vistaPozo = new VistaPozo(pozo);
                this.gameLoop.agregar(vistaPozo);
            }
        }

    }

    private void agregarObjetosVivosAlGameLoop() {

        this.gameLoop.agregar(this.pilotin);

        this.controlDeEventos = new ControlDeEventos(this);
        this.gameLoop.agregar(this.controlDeEventos);

    }

    private void agregarVistaAutoAlGameLoop() {

        VistaVehiculo unaVistaVehiculo = new VistaVehiculo(this.pilotin.getVehiculo());
        this.gameLoop.agregar(unaVistaVehiculo);
    }

    /** fin submetodos private **/

    /** METODOS DE CONTROL **/

     public void pausar() {

        if (this.gameLoop.estaEnEjecucion()) {

            this.pilotin.getCronometro().pausar();  // el cronometro es un tipo independiente; A no olvidarselo
            this.gameLoop.detenerJuego();
        }

    }

     public void reanudar() {

        if ( !(this.gameLoop.estaEnEjecucion()) ) {

            this.pilotin.getCronometro().reanudar();  // el cronometro es un tipo independiente; A no olvidarselo
            this.gameLoop.comenzarJuego();
        }

    }

    public void finalizar() {

        this.pilotin.getCronometro().pausar();  /** el cronometro es un tipo independiente; A no olvidarselo **/
        this.gameLoop.detenerJuego();
        System.out.println("la partida finalizo");

    }

     public boolean estaFinalizada() {

        if (this.gameLoop.estaEnEjecucion()) return false;
        else return true;
    }

}
