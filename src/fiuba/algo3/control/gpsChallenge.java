package fiuba.algo3.control;


import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.MouseClickController;
import ar.uba.fi.algo3.titiritero.vista.Panel;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;
import fiuba.algo3.modelo.Mapa;

import java.awt.*;


public class gpsChallenge {



    public static void main(String[] argv) {

        /** creamos el control de juego **/
        ControladorJuego controlDeJuego = new ControladorJuego(false);
        controlDeJuego.setIntervaloSimulacion(90);

        /** Configuracion Ventana **/

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Ventana ventana = new Ventana(0,0, controlDeJuego); // el 0,0 sino no anda el cerrar ?
        ventana.setLayout(null);
        ventana.setBounds(0, 0, screenSize.width, screenSize.height);
        ventana.setVisible(true);

        /** agregamos observador de mouse **/
        ventana.addMouseListener(new MouseClickController(controlDeJuego));

        /** vamos a jugar **/
        Mapa.limpiar();
        Nivel nivel = new Nivel();
        Piloto piloto = new Piloto("pilotin");
        Partida partida = new Partida(ventana,controlDeJuego,nivel,piloto);

        partida.iniciar();


    }




}
