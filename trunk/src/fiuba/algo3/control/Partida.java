package fiuba.algo3.control;

import fiuba.algo3.modelo.*;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import fiuba.algo3.vista.*;

import java.util.ArrayList;
import java.util.Iterator;



public class Partida {


    private GameLoop gameLoop;
    private SuperficieDeDibujo zonaDeJuego;

    private Nivel  nivelAjugar;
    private Piloto pilotin;
    private Estado carroceria;

    private ControlDeEventos controlDeEventos;

    public void crearPiloto (String nombreDelPiloto) {

        this.pilotin = new Piloto(nombreDelPiloto);

    }

    public Piloto getPiloto() {

        return this.pilotin;

    }

    public void asignarNivel (Nivel unNivel) {

        this.nivelAjugar = unNivel;
    }

    public void asignarCarroceriaDelVehiculo ( Estado unaCarroceria) {

        this.carroceria = unaCarroceria;

    }

    /** CONSTRUCTOR **/

    /* public Partida( SuperficiePanel unaZonaDeJuego) {

        this.zonaDeJuego = unaZonaDeJuego;
        this.gameLoop = new GameLoop(90,this.zonaDeJuego);

    } */

    public void asignarZonaDeJuego(SuperficieDeDibujo unaZonaDeJuego) {

        this.zonaDeJuego = unaZonaDeJuego;

    }

    /** PRE: Se deben haber invocado los metodos crearPiloto, asignarNivel y asignarCarroceriaDelVehiculo y asignarZonaDeJuego **/
    public void iniciar() {

        this.gameLoop = new GameLoop(this.zonaDeJuego);

        this.cargarMapa();
        this.cargarVehiculoParaElPiloto();
        this.cargarGameLoop();
        this.comenzar();
    }


    /** METODOS PRIVATE **/

    private void cargarMapa() {

        nivelAjugar.cargarMapa();

    }

    private void cargarVehiculoParaElPiloto() {

        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,this.carroceria);


        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se posicionar el vehiculo en el mapa");}


        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();

    }

    private void cargarGameLoop() {

        this.agregarVistasAlGameLoop();
        this.agregarObjetosVivosAlGameLoop();

    }

    private void comenzar() {

        this.pilotin.getCronometro().iniciar();  /** iniciamos su cronometro **/
        this.gameLoop.iniciarEjecucion();

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

            ObjetoPosicionable unaCalle = new RepresentacionDeCalle(iterador.next());
            ObjetoDibujable unaVistaCalle = new VistaCalle(unaCalle);
            this.gameLoop.agregar(unaVistaCalle);
        }

    }

    private void agregarVistaInicioAlGameLoop() {

        ObjetoPosicionable inicio = new RepresentacionDeCalle(Mapa.getMapa().getInicio());
        ObjetoDibujable  vistaInicio = new VistaInicio(inicio);
        this.gameLoop.agregar(vistaInicio);

    }

    private void agregarVistaLlegadaAlGameLoop() {

        ObjetoPosicionable llegada = new RepresentacionDeCalle(Mapa.getMapa().getLlegada());
        ObjetoDibujable  vistaLlegada = new VistaLlegada(llegada);
        this.gameLoop.agregar(vistaLlegada);

    }

    private void agregarVistasDeAplicablesAlGameLoop() {

        ArrayList<Aplicable> aplicables = Mapa.getMapa().getAplicables();
        Iterator<Aplicable> it = aplicables.iterator();
        while (it.hasNext()) {
            Aplicable unAplicable = it.next();

            if (unAplicable instanceof ControlPolicial) {

                ObjetoPosicionable policia = new RepresentacionDeCalle(unAplicable.getPosicion());
                ObjetoDibujable  vistaPolicia = new VistaPolicia(policia);
                this.gameLoop.agregar(vistaPolicia);

            } else if (unAplicable instanceof Sorpresa) {

                ObjetoPosicionable sorpresa = new RepresentacionDeCalle(unAplicable.getPosicion());
                ObjetoDibujable  vistaSorpresa = new VistaSorpresa(sorpresa);
                this.gameLoop.agregar(vistaSorpresa);

            } else if (unAplicable instanceof Piquete) {

                ObjetoPosicionable piquete = new RepresentacionDeCalle(unAplicable.getPosicion());
                ObjetoDibujable  vistaPiquete = new VistaPiquete(piquete);
                this.gameLoop.agregar(vistaPiquete);

            } else if (unAplicable instanceof Pozo) {

                ObjetoPosicionable pozo = new RepresentacionDeCalle(unAplicable.getPosicion());
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

    /* public void pausar() {

        if (this.gameLoop.estaEnEjecucion()) {

            this.pilotin.getCronometro().pausar();  // el cronometro es un tipo independiente; A no olvidarselo
            this.gameLoop.detenerEjecucion();
        }

    } */

    /* public void reanudar() {

        if ( !(this.gameLoop.estaEnEjecucion()) ) {

            this.pilotin.getCronometro().reanudar();  // el cronometro es un tipo independiente; A no olvidarselo
            this.gameLoop.iniciarEjecucion();
        }

    } */

    public void finalizar() {

        this.pilotin.getCronometro().pausar();  /** el cronometro es un tipo independiente; A no olvidarselo **/
        this.gameLoop.detenerEjecucion();
        System.out.println("la partida finalizo");

    }

    /* public boolean estaFinalizada() {

        if (this.gameLoop.estaEnEjecucion()) return false;
        else return true;
    } */

}
