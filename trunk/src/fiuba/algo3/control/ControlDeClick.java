package fiuba.algo3.control;

import fiuba.algo3.modelo.EstadoMoto;
import fiuba.algo3.modelo.Mapa;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlDeClick implements ActionListener {

    JFrame marcoAControlar;

    public ControlDeClick(JFrame unMarco) {
        this.marcoAControlar = unMarco;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        this.marcoAControlar.getContentPane().removeAll();

        Partida unaPartida = new Partida();
        SuperficiePanel zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setBounds(400, 0, this.marcoAControlar.getWidth() - 400, this.marcoAControlar.getHeight());
        zonaDeJuego.setBackground(Color.black);

        zonaDeJuego.setVisible(true);

        unaPartida.asignarZonaDeJuego(zonaDeJuego);
        this.marcoAControlar.getContentPane().add(zonaDeJuego);


        /** VAMOS A JUGAR**/
        Mapa.limpiar();
        Nivel nivel = new Nivel();
        unaPartida.cargarNivel(nivel);
        unaPartida.crearPiloto("pilotin");
        unaPartida.asignarCarroceriaDelVehiculo(new EstadoMoto());
        unaPartida.cargarVehiculoParaElPiloto();

        zonaDeJuego.setFocusable(true);
        zonaDeJuego.addKeyListener(new ControlDeMovimiento(unaPartida.getPiloto().getVehiculo()));

        unaPartida.iniciar();

        this.marcoAControlar.revalidate();
        this.marcoAControlar.repaint();


    }
}
