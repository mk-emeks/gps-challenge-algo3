package fiuba.algo3.vista;

import fiuba.algo3.modelo.*;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaVehiculo implements ObjetoDibujable {

    private VistaDireccionada vistaDireccionada;
    private Vehiculo vehiculo;


    public VistaVehiculo (Vehiculo unVehiculo ) {

        this.vehiculo = unVehiculo;
    }

    @Override
    public void dibujar(SuperficieDeDibujo superficieDeDibujo) {

        Estado estadoAuto = new EstadoAuto();
        Estado estadoMoto = new EstadoMoto();
        Estado estado4x4 = new Estado4x4();

    /** nuevamente muy horrible, fontela lloraria**/
        if (vehiculo.getEstado().equals(estadoAuto)) {

            //System.out.println("soy auto");
            this.vistaDireccionada = new VistaDireccionadaAuto(this.vehiculo);
            this.vistaDireccionada.dibujar(superficieDeDibujo);
        }

        if (vehiculo.getEstado().equals(estadoMoto)) {

            //System.out.println("soy moto");
            this.vistaDireccionada = new VistaDireccionadaMoto(this.vehiculo);
            this.vistaDireccionada.dibujar(superficieDeDibujo);
        }

        if (vehiculo.getEstado().equals(estado4x4)) {

            //System.out.println("soy 4x4");
            this.vistaDireccionada = new VistaDireccionada4x4(this.vehiculo);
            this.vistaDireccionada.dibujar(superficieDeDibujo);
        }

        /** alf cheat (el misterioso señor null) **/
        if (vehiculo.getEstado().equals(new EstadoAlf())) {
            this.vistaDireccionada = new VistaAlf(this.vehiculo);
            this.vistaDireccionada.dibujar(superficieDeDibujo);
        }

    }
}