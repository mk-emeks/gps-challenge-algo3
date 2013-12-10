package fiuba.algo3.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.SwingConstants;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class HistorialJugadores extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int LARGO_MAX_NOMBRE = 20;
    private JPanel contentPane;
    private JTextArea historialTexto;
    private static String archivoHistorial = "historial.txt";


    public HistorialJugadores() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Historial de Jugadores");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel titulo = new JLabel("Historial De Jugadores");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 15));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(titulo, BorderLayout.NORTH);

        this.historialTexto = new JTextArea();
        historialTexto.setBackground(SystemColor.control);
        historialTexto.setFont(new Font("Monospaced", Font.PLAIN, 13));
        this.historialTexto.setEditable(false);

        this.setHistorialTexto();

        JScrollPane textoScrolls = new JScrollPane(this.historialTexto);
        contentPane.add(textoScrolls, BorderLayout.CENTER);

        JButton borrarHistorial = new JButton ("Borrar Historial");
        borrarHistorial.addMouseListener(this.getListenerBotonBorrar());
        contentPane.add(borrarHistorial, BorderLayout.SOUTH);

    }

    public static void agregarInfoPartida(String nombreJugador,
                                          int tiempoJugador) {
        try {
            FileWriter writer = new FileWriter(HistorialJugadores.archivoHistorial, true);
            writer.write(nombreJugador);

            for (int i = 0; i < (HistorialJugadores.LARGO_MAX_NOMBRE - nombreJugador.length()); i++)
                writer.write(" ");

            writer.write( "  " + Integer.toString(tiempoJugador) + "\n");

            writer.close();
        } catch (IOException e) {}
    }

    private void setHistorialTexto(){
        try {
            FileReader fr = new FileReader(HistorialJugadores.archivoHistorial);
            BufferedReader reader = new BufferedReader(fr);
            do {
                this.historialTexto.read(reader, "historial");
            } while( reader.readLine() != null);
            reader.close();
        } catch (IOException ioe) { }
    }

    private void resetHistorialTexto() {
        try {
            FileWriter writer = new FileWriter(HistorialJugadores.archivoHistorial, false);
            String jugador = "Jugador";
            writer.write(jugador);

            for (int i = 0; i < (HistorialJugadores.LARGO_MAX_NOMBRE - jugador.length()); i++)
                writer.write(" ");

            writer.write( "  Tiempos \n");

            for (int i = 0; i < HistorialJugadores.LARGO_MAX_NOMBRE; i++)
                writer.write("-");
            writer.write("  ------ \n");
            writer.close();
        } catch (IOException e) {}
    }

    private MouseListener getListenerBotonBorrar() {
        return new EscucharBotonBorrar();
    }

    public class EscucharBotonBorrar implements MouseListener {

        public void mouseClicked(MouseEvent arg0) {
            resetHistorialTexto();
            setHistorialTexto();
        }

        public void mouseEntered(MouseEvent arg0) { }
        public void mouseExited(MouseEvent arg0) { }
        public void mousePressed(MouseEvent arg0) { }
        public void mouseReleased(MouseEvent arg0) { }
    }

}