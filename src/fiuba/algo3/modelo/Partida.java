package fiuba.algo3.modelo;


public class Partida {

    private Piloto pilotin;
    private Boolean enJuego;

    public Partida(Piloto unPiloto) {

        this.pilotin = unPiloto;
        enJuego = false;

    }

    public Piloto getPiloto() {
        return this.pilotin;
    }

    private Eventos getMyEventos() {
        return new Eventos();
    }

    public void actualizar() throws Exception{

        this.pilotin.conducir();
        this.getMyEventos().actualizar(this);

    }

    public void iniciar() throws Exception {

        /** flag de arranque **/
        this.enJuego = true;

        /** configurando mapa **/
        EditorMapa editor = new EditorMapa();
        editor.editarMapaSimple(3,3);
        // agregar el vehiculo y la llegada! editor aun no lo hace! vehiculo<=>posVehiculo :Z

        /** inicializar posicion y direccion del vehiculo en la partida **/
        Posicion posicionDeInicioDelVehiculo = new Posicion (1,2);
        Direccion direccionDeInicioDelVehiculo = new DireccionDerecha();

        /** elegir vehiculo **/
        Vehiculo miVehiculo = new Moto(posicionDeInicioDelVehiculo,direccionDeInicioDelVehiculo);
        miVehiculo.posicionarEnElMapa();   /** (!) clave **/

        /** configurando piloto **/
        this.pilotin.asignarVehiculo(miVehiculo);
        this.pilotin.arrancarVehiculo();
        //this.pilotin.getCronometro().iniciar();

        /** comienza la accion **/
        // si aca agregamos un while (enJuego) {} tenemos el game loop; por ahora esta manual.
        this.actualizar();

    }

    public void pausar() {

        this.enJuego = false;

    }

    public void reanudar() {

        this.enJuego = true;

    }

    public void finalizar() {

        this.enJuego = false;
        System.out.println("la partida finalizo");

    }

    /** faltaria una especie de metodo estaFinalizado() para realmente poder jugarlo manualmente **/
}
