package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import fiuba.algo3.modelo.Estado;
import fiuba.algo3.modelo.EstadoAuto;
import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Estado4x4;

import fiuba.algo3.modelo.Vehiculo;

public class VistaVehiculo extends Imagen {

    private VistaDireccionadaMoto vistaDireccionadaMoto;
    private Vehiculo vehiculo;

    public VistaVehiculo (Vehiculo unVehiculo ) {

        this.vehiculo = unVehiculo;

    }

    //@Override
    public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

        Estado estadoAuto = new EstadoAuto();
        Estado estadoMoto = new EstadoMoto();
        Estado estado4x4 = new Estado4x4();

        /** nuevamente muy horrible, fontela lloraria**/
        if (vehiculo.getEstado().equals(estadoAuto)) {

            //this.vistaVehiculo = new VistaDireccionadaAuto(this.vehiculo);
            //this.vistaVehiculo.dibujar(superficeDeDibujo);
            System.out.println("no deberia entrear en esta vista estado");

        }

        if (vehiculo.getEstado().equals(estadoMoto)) {

            this.vistaDireccionadaMoto = new VistaDireccionadaMoto(this.vehiculo);
            this.vistaDireccionadaMoto.dibujar(superficeDeDibujo);

        }

        if (vehiculo.getEstado().equals(estado4x4)) {

            //this.vistaVehiculo = new VistaDireccionada4x4(this.vehiculo);
            //this.vistaVehiculo.dibujar(superficeDeDibujo);
            System.out.println("no deberia entrear en esta vista estado");

        }

    }
}