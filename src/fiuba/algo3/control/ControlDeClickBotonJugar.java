package fiuba.algo3.control;


//import fiuba.algo3.vista.VistasMenu.BotonAnimadoVehiculo;
import fiuba.algo3.vista.*;

import java.awt.event.MouseEvent;
        import java.util.ArrayList;


public class ControlDeClickBotonJugar extends ControlDeClickBotonConJuego {


    BotonAnimadoVehiculo botonAnimadoVehiculo;
    VistaFinalizacion vistaFinalizacion;
    BoxEleccionVehiculo boxVehiculo;
    BoxEleccionMapa boxMapa;

    public ControlDeClickBotonJugar(BoxEleccionMapa unBoxMapa, BoxEleccionVehiculo unBoxVehiculo, VistaFinalizacion unaVistaFinalizacion, BotonAnimadoVehiculo botonAnimadoVehiculo, Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff){

        super(unJuego,vistasOn,vistasOff);
        this.botonAnimadoVehiculo = botonAnimadoVehiculo;
        this.vistaFinalizacion = unaVistaFinalizacion;
        this.boxMapa= unBoxMapa;
        this.boxVehiculo = unBoxVehiculo;


    }

    public ControlDeClickBotonJugar(Juego unJuego, ArrayList<VistaMenu> vistasOn, ArrayList<VistaMenu> vistasOff){

        super(unJuego,vistasOn,vistasOff);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if ((!this.boxMapa.isVisible()) && (!this.boxVehiculo.isVisible())) {


            this.juego.cargarVehiculoParaElPiloto();


            this.juego.iniciar();
            this.juego.pausar();

            this.actualizar();
            this.botonAnimadoVehiculo.comenzarAnimacion(); // el orden es importante, tiene que ser despues!

            VistaInstrucciones unaVistaInstrucciones = new VistaInstrucciones();
            this.vistaFinalizacion.comenzarVista();


        }
    }

}

