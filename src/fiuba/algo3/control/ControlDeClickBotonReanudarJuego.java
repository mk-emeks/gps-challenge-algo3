package fiuba.algo3.control;


import fiuba.algo3.persistencia.Partida;
import fiuba.algo3.vista.BotonAnimadoVehiculo;
import fiuba.algo3.vista.VistaFinalizacion;
import fiuba.algo3.vista.VistaInstrucciones;
import fiuba.algo3.vista.VistaMenu;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.ArrayList;


public class ControlDeClickBotonReanudarJuego extends ControlDeClickBotonConJuego {

    BotonAnimadoVehiculo botonAnimadoVehiculo;
    VistaFinalizacion vistaFinalizacion;

    public ControlDeClickBotonReanudarJuego(VistaFinalizacion unaVistaFinalizacion, BotonAnimadoVehiculo botonAnimadoVehiculo, Juego unJuego, ArrayList<VistaMenu> vistasOn, java.util.ArrayList<VistaMenu> vistasOff) {

        super(unJuego,vistasOn,vistasOff);
        this.vistaFinalizacion = unaVistaFinalizacion;
        this.botonAnimadoVehiculo = botonAnimadoVehiculo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        /** cargamos la partida e iniciamos el juego **/
        Partida partidaARecuperar = new Partida();

        try {

            SAXBuilder builder = new SAXBuilder();
            String usuario = this.juego.getPiloto().getNombre();
            Document doc = builder.build(new FileInputStream(usuario+Partida.getTerminacionArchivo()));
            Element raiz = doc.getRootElement();
            partidaARecuperar = new Partida(raiz);


            partidaARecuperar.cargarPartidaGuardada(this.juego);

            /** el resto de lo que hace boton jugar **/
            this.botonAnimadoVehiculo.comenzarAnimacion(); // el orden es importante, tiene que ser despues!

            this.juego.iniciar();
            this.juego.pausar();

            this.actualizar();

            VistaInstrucciones unaVistaInstrucciones = new VistaInstrucciones();
            this.vistaFinalizacion.comenzarVista();

        } catch (Exception execpcion) {System.out.println("no se pudo cargar la partida guardad");}

    }

}

