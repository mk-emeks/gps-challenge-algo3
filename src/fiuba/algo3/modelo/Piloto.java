package fiuba.algo3.modelo;


public class Piloto {

    private Vehiculo vehiculo;
    private Boolean enMovimiento;
    private Cronometro cronometro;

    public Piloto() {

        cronometro = new Cronometro();
        enMovimiento = false;

    }

    public Piloto(Vehiculo unVehiculo) {

        cronometro = new Cronometro();
        this.vehiculo = unVehiculo;
        enMovimiento = false;

    }

    public void asignarVehiculo(Vehiculo unVehiculo) {

        this.vehiculo = unVehiculo;

    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void detenerVehiculo() {
        this.enMovimiento = false;
    }

    public void arrancarVehiculo() {
        this.enMovimiento = true;
    }

    public void conducir() throws Exception {

        if (enMovimiento) {

            try {

                this.vehiculo.mover();

            } catch (NoSePuedeMoverEnElMapaElMovibleException exception) {

                System.out.println(exception.getMessage());

            }

        }

    }

    public Cronometro getCronometro() {

        return this.cronometro;
    }

    /** agarrate catalina **/
    public void interactuarCon(Pozo pozo) {

        this.getVehiculo().getEstado().interactuarCon(this,pozo);
    }

    public void interactuarCon(Piquete piquete) {

        this.getVehiculo().getEstado().interactuarCon(this,piquete);

    }

    public void interactuarCon(ControlPolicial layuta) {

        this.getVehiculo().getEstado().interactuarCon(this,layuta);

    }

    public void interactuarCon(Sorpresa sorpresa) {

    }



}
