package fiuba.algo3.control;

import fiuba.algo3.modelo.*;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.vista.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar menu;
    private JMenu juego, ayuda;
    private JMenuItem juegoNuevo,guardarPartida,cargarPartida,itemHistorial,salir,acercaDe;
    private AcercaDe labelAcercaDe;
    private HistorialJugadores historial;
    private SuperficiePanel zonaDeJuego;

    public VentanaPrincipal() {
        setLayout(null);
        setTitle("GPS Challenge");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearMenuBar();
        zonaDeJuego = new SuperficiePanel();
        zonaDeJuego.setLayout(null);
        zonaDeJuego.setBounds(390, 0, screenSize.width - 400, screenSize.height);
        //El boton es para que veas donde esta la zona de juego, se puede borrar
        JButton boton = new JButton("ZONA DE JUEGO");
        boton.setBounds(0, 0, screenSize.width - 400, screenSize.height);
        zonaDeJuego.add(boton);
        zonaDeJuego.setVisible(true);
        add(zonaDeJuego);
        setVisible(true);
        /**No se si esto va aca, te queria preguntar y te habias ido mirko**/
        Nivel nivel = new Nivel();
        Posicion posicion = new Posicion(500,screenSize.height/2);
        DireccionDerecha direccion = new DireccionDerecha();
        EstadoAuto estado = new EstadoAuto();
        Vehiculo vehiculo = new Vehiculo(posicion,direccion,estado);
        Piloto piloto = new Piloto(vehiculo,"pilotin");
        Partida partida = new Partida(zonaDeJuego,nivel,piloto);
    }

    public void crearMenuBar() {
        labelAcercaDe = new AcercaDe();
        historial = new HistorialJugadores();
        menu = new JMenuBar();
        setJMenuBar(menu);
        juego = new JMenu("Juego...");
        menu.add(juego);
        juegoNuevo = new JMenuItem("Nuevo");
        juego.add(juegoNuevo);
        juegoNuevo.addActionListener(this);
        guardarPartida = new JMenuItem("Guardar");
        juego.add(guardarPartida);
        guardarPartida.addActionListener(this);
        cargarPartida = new JMenuItem("Cargar");
        juego.add(cargarPartida);
        cargarPartida.addActionListener(this);
        itemHistorial = new JMenuItem("Historial de jugadores");
        itemHistorial.addActionListener(this);
        juego.add(itemHistorial);
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        juego.add(salir);
        ayuda = new JMenu("Ayuda");
        menu.add(ayuda);
        acercaDe = new JMenuItem("Acerca de...");
        ayuda.add(acercaDe);
        acercaDe.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acercaDe) {
            labelAcercaDe.setVisible(true);
        } else if ( e.getSource() == salir ) {
            System.exit(0);
        } else if (e.getSource() == itemHistorial) {
            historial.setVisible(true);
        }
    }

    public static void main(String[] argv) {
        VentanaPrincipal ventana = new VentanaPrincipal();

    }

}