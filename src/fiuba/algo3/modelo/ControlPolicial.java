package fiuba.algo3.modelo;


public class ControlPolicial extends Obstaculo {

    private static final int penalizacion = 3;
    private static final double probabilidadAuto = 0.5;
    private static final double probabilidad4x4 = 0.3;
    private static final double probabilidadMoto = 0.8;

    public ControlPolicial(Posicion unaPosicion) {
        super(penalizacion,unaPosicion);
    }

    //---Implementacion de Aplicable---//

    public void actualizar(Piloto piloto) {

        Vehiculo vehiculoDelCandidatoASerAplicar = piloto.getVehiculo();

        if ( vehiculoDelCandidatoASerAplicar.getPosicion() == this.getPosicion() )
        {
            piloto.interactuarCon(this);
        }

    }

    public void aplicarA(Piloto piloto) {
        //no hace nada
    }

    public void aplicarA(Piloto piloto, EstadoAuto estadoAuto){

        this.aplicar(piloto,this.probabilidadAuto);

    }

    public void aplicarA(Piloto piloto, EstadoMoto estadoMoto) {
       this.aplicar(piloto,this.probabilidadMoto);
    }

    public void aplicarA(Piloto piloto, Estado4x4 estado4x4) {
        this.aplicar(piloto,this.probabilidad4x4);
    }

    /** ahorrando codigo **/
    protected void aplicar(Piloto piloto,double probabilidad) {
        double numeroRandom = Math.random();
        if ( numeroRandom < probabilidad ) {
            this.aplicar(piloto);
        }
    }

}
