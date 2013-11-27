package fiuba.algo3.control;

import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import fiuba.algo3.modelo.*; /** por ahora **/

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

    public void iniciar() throws Exception {


        /** configurando mapa **/
        nivelAjugar.cargarMapa();

        /** INICIAR VEHICULO **/
        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha(); /** una cualquiera, no cambia mucho **/
        EstadoMoto estadoDeInicioDelVehiculo = new EstadoMoto(); /** el usuario elegi el tipo **/
        Vehiculo miVehiculo = new Vehiculo(Mapa.getMapa().getInicio(),direccionDeInicioDelVehiculo,estadoDeInicioDelVehiculo);
        miVehiculo.posicionarEnElMapa();   /** (!) clave **/

        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();


        /** to-do lo del loop podria hacerlo una clase, o un metodo de partida **/
        /** agregar dibujables **/
        //vista calles
        //vista aplicables
        //vista auto

        /** agregar objetos vivos al game loop **/

        this.gameLoop.agregar(this.pilotin);
        this.gameLoop.agregar(this.controlDeEventos);

        /** comienza la accion **/
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
