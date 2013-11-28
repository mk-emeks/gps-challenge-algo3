package fiuba.algo3.control;

import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.Piloto;

import javax.swing.*;
import java.awt.*;

public class Juego {

    private Piloto piloto;
    private Nivel  nivel;
    private Partida partida;
    private MenuEleccionUsuario menuEleccionUsuario;

    public void setPiloto(Piloto unPiloto) {
        this.piloto = unPiloto;
    }

    public void setNivel(Nivel unNivel) {
        this.nivel = unNivel;
    }

    public void setPartida(Partida unaPartida) {
        this.partida = unaPartida;
    }

    public Piloto getPiloto() {

        return  this.piloto;
    }

    public Nivel getNivel() {

        return this.nivel;
    }

    public Partida getPartida() {

        return this.partida;
    }

    public MenuEleccionUsuario getMenuEleccionUsuario() {

        return this.menuEleccionUsuario;
    }

    public Juego() {

        this.menuEleccionUsuario = new MenuEleccionUsuario();

    }


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

        /** cargamos menu eleccio usuario **/
        juego.getMenuEleccionUsuario().cargarMenuSeleccionUsuario(marcoPrincipal,juego);



    }


}
