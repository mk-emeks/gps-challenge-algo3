package fiuba.algo3.control;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.Figura;

import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

/** por ahora **/
import fiuba.algo3.modelo.*;
import fiuba.algo3.vista.RepresentacionDeCalle;
import fiuba.algo3.vista.VistaCalle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


/**  ver las dependencias necesarias cuando este listo
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.EditorMapa;
import fiuba.algo3.modelo.Nivel;
**/

public class Partida {

    private GameLoop gameLoop;
    private Nivel  nivelAjugar;
    private Piloto pilotin;
    private ControlDeEventos controlDeEventos;

    /** el primer parametro por ahora tiene nombre explicativo **/
    public Partida(SuperficieDeDibujo zonaDeJuego , Nivel nivel , Piloto unPiloto) {

        this.gameLoop = new GameLoop(zonaDeJuego); /** se podria cambiar frecuencia tmb **/
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
        EstadoMoto estadoDeInicioDelVehiculo = new EstadoMoto(); /** el usuario elegi el tipo **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,estadoDeInicioDelVehiculo);

        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se posicionar el vehiculo en el mapa");}




        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();


        /** to-do lo del loop podria hacerlo una clase, o un metodo de partida **/
        /** agregar dibujables **/

        ObjetoPosicionable inicio = new RepresentacionDeCalle(Mapa.getMapa().getInicio());
        Figura vistaInicio = new Cuadrado(50,50,inicio);
        vistaInicio.setColor(Color.RED);
        this.gameLoop.agregar(vistaInicio);

        ObjetoPosicionable llegada = new RepresentacionDeCalle(Mapa.getMapa().getLlegada());
        Figura vistaLlegada = new Cuadrado(50,50,llegada);
        vistaLlegada.setColor(Color.BLACK);
        this.gameLoop.agregar(vistaLlegada);

        ArrayList<Posicion> posicionDeLasCalles = Mapa.getMapa().getPosicionesValidas();
        Iterator<Posicion> iterador = posicionDeLasCalles.iterator();
        while (iterador.hasNext()) {
            ObjetoPosicionable unaCalle = new RepresentacionDeCalle(iterador.next());
            Figura unaVistaCalle = new Cuadrado(50,50,unaCalle);
            unaVistaCalle.setColor(Color.GREEN);
            this.gameLoop.agregar(unaVistaCalle);
        }



        /*ObjetoPosicionable unaCalle2 = new RepresentacionDeCalle(iterador.next());
        Figura unaVistaCalle2 = new Cuadrado(50,50,unaCalle2);
        unaVistaCalle2.setColor(Color.GREEN);
        this.gameLoop.agregar(unaVistaCalle2);

        ObjetoPosicionable unaCalle3 = new RepresentacionDeCalle(iterador.next());
        Figura unaVistaCalle3 = new Cuadrado(50,50,unaCalle3);
        unaVistaCalle3.setColor(Color.RED);
        this.gameLoop.agregar(unaVistaCalle3);

        ObjetoPosicionable unaCalle4 = new RepresentacionDeCalle(iterador.next());
        Figura unaVistaCalle4 = new Cuadrado(50,50,unaCalle4);
        unaVistaCalle4.setColor(Color.GREEN);
        this.gameLoop.agregar(unaVistaCalle4); */



        /*ObjetoPosicionable unaCalle = new RepresentacionDeCalle(Mapa.getMapa().getInicio());
        Figura unaVistaCalle = new Cuadrado(50,50,unaCalle);
        unaVistaCalle.setColor(Color.GRAY);
        this.gameLoop.agregar(unaVistaCalle);*/

        //ObjetoDibujable unaVistaCalle = new Cuadrado(50,50,unaCalle);


        Figura unaVistaAuto = new Circulo(20,this.pilotin.getVehiculo());
        unaVistaAuto.setColor(Color.BLUE);
        this.gameLoop.agregar(unaVistaAuto);



        //vista calles
        //vista aplicables
        //vista auto

        /** agregar objetos vivos al game loop **/

        this.gameLoop.agregar(this.pilotin);
        this.gameLoop.agregar(this.controlDeEventos);


        /** COMIENZA LA ACCION **/
        this.pilotin.getCronometro().iniciar();  /** iniciamos su cronometro **/
        this.gameLoop.iniciarEjecucion();

    }

    public void pausar() {

        if (this.gameLoop.estaEjecutando()) {

            this.pilotin.getCronometro().pausar(); /** el cronometro es un tipo independiente; A no olvidarselo **/
            this.gameLoop.detenerEjecucion();
        }

    }

    public void reanudar() {

        if ( !(this.gameLoop.estaEjecutando()) ) {

            this.pilotin.getCronometro().reanudar();  /** el cronometro es un tipo independiente; A no olvidarselo **/
            this.gameLoop.iniciarEjecucion();
        }

    }

    public void finalizar() {

        this.pilotin.getCronometro().pausar();  /** el cronometro es un tipo independiente; A no olvidarselo **/
        this.gameLoop.detenerEjecucion();
        System.out.println("la partida finalizo");

    }

    public boolean estaFinalizada() {

        if (this.gameLoop.estaEjecutando()) return false;
        else return true;
    }

}
