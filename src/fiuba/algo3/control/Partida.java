package fiuba.algo3.control;

import ar.uba.fi.algo3.titiritero.vista.*;


import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;

/** por ahora **/
import fiuba.algo3.modelo.*;
import fiuba.algo3.vista.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


/**  ver las dependencias necesarias cuando este listo
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.EditorMapa;
import fiuba.algo3.modelo.Nivel;
**/

public class Partida {

    private ControladorJuego gameLoop;
    private Nivel  nivelAjugar;
    private Piloto pilotin;
    private ControlDeEventos controlDeEventos;
    private Panel zonaDeJuego;

    /** el primer parametro por ahora tiene nombre explicativo **/
    public Partida(VentanaPrincipal ventana, Nivel nivel , Piloto unPiloto) {

        this.gameLoop = new ControladorJuego(false);
        this.gameLoop.setIntervaloSimulacion(90);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.zonaDeJuego = new ar.uba.fi.algo3.titiritero.vista.Panel(screenSize.width - 400, screenSize.height, this.gameLoop );
        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(390, 0, screenSize.width - 400, screenSize.height);
        ventana.add(this.zonaDeJuego);

        this.gameLoop.setSuperficieDeDibujo(this.zonaDeJuego);

        this.nivelAjugar = nivel;
        this.pilotin = unPiloto;
        this.controlDeEventos = new ControlDeEventos(this);

    }

    public Piloto getPiloto() {
        return this.pilotin;
    }

    public void iniciar() {


        /** configurando mapa **/
        nivelAjugar.cargarMapa();




        /** INICIAR VEHICULO **/
        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        Estado estadoDeInicioDelVehiculo = new EstadoMoto(); /** el usuario elegi el tipo **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,estadoDeInicioDelVehiculo);

        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se posicionar el vehiculo en el mapa");}




        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();


        /** to-do lo del loop podria hacerlo una clase, o un metodo de partida **/
        /** agregar dibujables **/


        /**Se agregan las vistas de las calles **/
        ArrayList<Posicion> posicionDeLasCalles = Mapa.getMapa().getPosicionesValidas();
        Iterator<Posicion> iterador = posicionDeLasCalles.iterator();
        while (iterador.hasNext()) {
            Posicionable unaCalle = new RepresentacionDeCalle(iterador.next());
            Dibujable unaVistaCalle = new VistaCalle();
            unaVistaCalle.setPosicionable(unaCalle);
            this.gameLoop.agregarDibujable(unaVistaCalle);
        }

        /**Se agregan los aplicables**/
        ArrayList<Aplicable> aplicables = Mapa.getMapa().getAplicables();
        Iterator<Aplicable> it = aplicables.iterator();
        while (it.hasNext()) {
            Aplicable unAplicable = it.next();
            if (unAplicable instanceof ControlPolicial) {
                Posicionable policia = new RepresentacionDeCalle(unAplicable.getPosicion());
                Dibujable vistaPolicia = new VistaPolicia();
                vistaPolicia.setPosicionable(policia);
                this.gameLoop.agregarDibujable(vistaPolicia);
            } else if (unAplicable instanceof Sorpresa) {
                Posicionable sorpresa = new RepresentacionDeCalle(unAplicable.getPosicion());
                Dibujable vistaSorpresa = new VistaSorpresa();
                vistaSorpresa.setPosicionable(sorpresa);
                this.gameLoop.agregarDibujable(vistaSorpresa);
            } else if (unAplicable instanceof Piquete) {
                Posicionable piquete = new RepresentacionDeCalle(unAplicable.getPosicion());
                Dibujable vistaPiquete = new VistaPiquete();
                vistaPiquete.setPosicionable(piquete);
                this.gameLoop.agregarDibujable(vistaPiquete);
            } else if (unAplicable instanceof Pozo) {
                Posicionable pozo = new RepresentacionDeCalle(unAplicable.getPosicion());
                Dibujable vistaPozo = new VistaPozo();
                vistaPozo.setPosicionable(pozo);
                this.gameLoop.agregarDibujable(vistaPozo);
            }
        }

        Posicionable inicio = new RepresentacionDeCalle(Mapa.getMapa().getInicio());
        Dibujable vistaInicio = new VistaInicio();
        //Figura vistaInicio = new Cuadrado(50,50);
        vistaInicio.setPosicionable(inicio);
        //vistaInicio.setColor(Color.RED);
        this.gameLoop.agregarDibujable(vistaInicio);

        Posicionable llegada = new RepresentacionDeCalle(Mapa.getMapa().getLlegada());
        Dibujable vistaLlegada = new VistaLlegada();
        vistaLlegada.setPosicionable(llegada);
        this.gameLoop.agregarDibujable(vistaLlegada);

        //Figura unaVistaAuto = new Circulo(20);
        //unaVistaAuto.setPosicionable(this.pilotin.getVehiculo());
        VistaVehiculo unaVistaAuto = new VistaVehiculo(this.pilotin.getVehiculo());
        //VistaDireccionadaAuto unaVistaAuto = new VistaDireccionadaAuto(this.pilotin.getVehiculo());
        this.gameLoop.agregarDibujable(unaVistaAuto);



        //vista calles
        //vista aplicables
        //vista auto

        /** agregar objetos vivos al game loop **/

        this.gameLoop.agregarObjetoVivo(this.pilotin);
        this.gameLoop.agregarObjetoVivo(this.controlDeEventos);


        /** COMIENZA LA ACCION **/
        this.pilotin.getCronometro().iniciar();  /** iniciamos su cronometro **/
        this.gameLoop.comenzarJuego(7);
        this.pilotin.getVehiculo().setDireccion(new DireccionAbajo());
        this.gameLoop.comenzarJuego(6);
        this.pilotin.getVehiculo().setDireccion(new DireccionArriba());
        this.gameLoop.comenzarJuego(6);
        this.pilotin.getVehiculo().setDireccion(new DireccionIzquierda());
        this.gameLoop.comenzarJuego(6);

    }

    public void pausar() {

        if (this.gameLoop.estaEnEjecucion()) {

            this.pilotin.getCronometro().pausar(); /** el cronometro es un tipo independiente; A no olvidarselo **/
            this.gameLoop.detenerJuego();
        }

    }

    public void reanudar() {

        if ( !(this.gameLoop.estaEnEjecucion()) ) {

            this.pilotin.getCronometro().reanudar();  /** el cronometro es un tipo independiente; A no olvidarselo **/
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
