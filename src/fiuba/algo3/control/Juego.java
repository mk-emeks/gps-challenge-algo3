package fiuba.algo3.control;

import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;

import javax.swing.*;
import java.awt.*;

public class Juego {

    private Piloto piloto;
    private Nivel  nivel;
    private Partida partida;
    private MenuPrincipal menuPrincipal;

    public Piloto getPiloto() {

        return  this.piloto;
    }

    public Nivel getNivel() {

        return this.nivel;
    }

    public Partida getPartida() {

        return this.partida;
    }

    public MenuPrincipal getMenuPrincipal() {

        return this.menuPrincipal;
    }

    public Juego() {

        this.menuPrincipal = new MenuPrincipal();

    }

    private JPanel panelBotonesPrincipales;



    public static void main(String[] argv) {

        /** Creacion Marco ppipal **/

        JFrame marcoPrincipal = new JFrame();
        marcoPrincipal.setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        marcoPrincipal.setBounds(0, 0, screenSize.width, screenSize.height);
        marcoPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        marcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoPrincipal.setLayout(null);
        marcoPrincipal.setVisible(true);

        /** Inicio de clases generales **/

        Juego juego = new Juego();

        /** ojo **/

        Partida partida = juego.getPartida();
        Piloto  piloto = juego.getPiloto();
        Nivel   nivel = juego.getNivel();

        /** cargamos menu principal **/
        juego.getMenuPrincipal().cargarMenuPrincipal(marcoPrincipal,partida,piloto,nivel);



    }


}
