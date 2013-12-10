package fiuba.algo3.control;

import fiuba.algo3.masterOfPuppets.GameLoop;
import fiuba.algo3.modelo.*;

import fiuba.algo3.persistencia.RegistroUsuariosConPuntuacion;
import fiuba.algo3.persistencia.UsuarioConPuntuacion;

import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import fiuba.algo3.vista.VistasMenu.VistaCronometro;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.swing.*;
import java.io.FileInputStream;

public class Juego {

    private GameLoop gameLoop;

    private JPanel zonaDeJuego;
    private Piloto pilotin;
    private Estado carroceria;
    VistaCronometro vistaCronometro;
    private ControlDeEventos controlDeEventos;
    private ControlDeVistas controlDeVistas;
    Boolean juegoTerminado;


    public void crearPiloto (String nombreDelPiloto) {

        this.pilotin.setNombre(nombreDelPiloto);

    }

    public Piloto getPiloto() {

        return this.pilotin;

    }

    /** no se puede devolver : StackOverFlowError**/
    /*public GameLoop getGameLoop() {

        return this.getGameLoop();

    }*/

    public void asignarCarroceriaDelVehiculo ( Estado unaCarroceria) {

        this.carroceria = unaCarroceria;

    }

    public void cargarVehiculoParaElPiloto() {

        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,this.carroceria);


        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se pudo posicionar el vehiculo en el mapa");}


        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();

    }

    /** X2, este se le pasa la posicion de inicio que uno quiera, esto lo usa el cargar partida **/
    /** lo ideal seria tmb persistir la direccion del vehiculo, pero como arranca en pausa, es lo mismo **/
    public void cargarVehiculoParaElPiloto(Posicion posicionDeInicioDelVehiculo) {

        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        Vehiculo miVehiculo = new Vehiculo( posicionDeInicioDelVehiculo,direccionDeInicioDelVehiculo,this.carroceria);


        try {
            miVehiculo.posicionarEnElMapa();   /** (!) clave **/
        } catch (Exception exception) {System.out.println( "no se pudo posicionar el vehiculo en el mapa");}


        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();

    }

    public void asignarVistaAlCronometro( VistaCronometro unaVistaCronometro) {

        this.vistaCronometro = unaVistaCronometro;

    }

    /** CONSTRUCTOR **/
    public Juego() {

        /** importante crearlo antes de usarlos **/
        this.gameLoop = new GameLoop();
        this.pilotin = new Piloto();
        this.controlDeVistas = new ControlDeVistas(this.gameLoop,this.pilotin);

    }

    public void asignarZonaDeJuego(JPanel unaZonaDeJuego) {

        this.zonaDeJuego = unaZonaDeJuego;

    }


    /** PRE: Se deben haber invocado los metodos crearPiloto, asignarNivel y asignarCarroceriaDelVehiculo y asignarZonaDeJuego **/
    public void iniciar() {

        this.gameLoop.setSuperficieDeDibujo((SuperficieDeDibujo)this.zonaDeJuego);
        this.gameLoop.setIntervaloSimulacion(160);

        this.cargarGameLoop();
        this.comenzar();
        this.juegoTerminado = false;

    }

    /** METODOS PRIVATE **/

    private void cargarGameLoop() {

        this.controlDeVistas.agregarVistasAlGameLoop(); //!
        this.agregarObjetosVivosAlGameLoop();
    }

    private void comenzar() {

        this.pilotin.getCronometro().iniciar(this.vistaCronometro.getThread());  /** iniciamos su cronometro **/
        this.gameLoop.comenzarJuego();

    }

    private void agregarObjetosVivosAlGameLoop() {

        this.gameLoop.agregar(this.pilotin);

        this.gameLoop.agregar(this.controlDeVistas);

        this.controlDeEventos = new ControlDeEventos(this);
        this.gameLoop.agregar(this.controlDeEventos);

    }

    /** METODOS DE CONTROL **/

     public void pausar() {

        if (this.gameLoop.estaEnEjecucion()) {

            this.pilotin.detenerVehiculo(); //Si queremos que el juego arranque en pause es necesario
            this.pilotin.getCronometro().pausar(this.vistaCronometro.getThread());  // el cronometro es un tipo independiente; A no olvidarselo
            //this.gameLoop.pausarJuego();
            this.gameLoop.detenerJuego();
        }

    }

     public void reanudar() {

        if ( !(this.gameLoop.estaEnEjecucion()) ) {

            this.pilotin.arrancarVehiculo(); //Si queremos que el juego arranque en pause es necesario
            this.pilotin.getCronometro().reanudar(this.vistaCronometro.getThread());  // el cronometro es un tipo independiente; A no olvidarselo
            //this.gameLoop.reanuadarJuego();
            this.gameLoop.comenzarJuego();
        }

    }

    public void finalizar() {

        this.pilotin.getCronometro().pausar(this.vistaCronometro.getThread());  /** el cronometro es un tipo independiente; A no olvidarselo **/
        this.gameLoop.detenerJuego();
        this.juegoTerminado = true;


        /** cargamos el registro de usuario con puntuacion y "agregamos al nuevo competidor" **/
        RegistroUsuariosConPuntuacion registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new FileInputStream(RegistroUsuariosConPuntuacion.getNombreDelArchivo()));
            Element raiz = doc.getRootElement();
            registroUsuariosConPuntuacion = new RegistroUsuariosConPuntuacion(raiz);

        } catch (Exception e) {System.out.println("no se pudo cargar el registro de usuarios con puntuacion");}

        String nombreDelPiloto = this.getPiloto().getNombre();
        int tiempoDelPiloto = this.getPiloto().getCronometro().tiempoEnSegundos();

        registroUsuariosConPuntuacion.agregarUsuario(new UsuarioConPuntuacion(nombreDelPiloto,tiempoDelPiloto));


        System.out.println("el juego finalizo");

    }

     public boolean estaPausada() {

        if (this.gameLoop.estaEnEjecucion()) return false;
        else return true;
    }

    public boolean estaTerminada() {
        return this.juegoTerminado;
    }

    private void quitarObjetosVivosAlGameLoop() {

        this.gameLoop.remover(this.pilotin);
        this.gameLoop.remover(this.controlDeVistas);
        this.gameLoop.remover(this.controlDeEventos);
    }

    public void destruir(){
        this.quitarObjetosVivosAlGameLoop();
    }


}