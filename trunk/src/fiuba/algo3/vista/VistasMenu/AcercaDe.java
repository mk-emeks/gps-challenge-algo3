package fiuba.algo3.vista.VistasMenu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AcercaDe extends JDialog {

    private JPanel contentPane;

    public AcercaDe() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Acerca De ");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);


        JLabel titulo = new JLabel("Gps challenge");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(titulo, BorderLayout.NORTH);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(6, 0, 0, 0));

        JLabel facultad = new JLabel("Facultad de Ingenieria - Universidad de Buenos Aires");
        facultad.setFont(new Font("Tahoma", Font.BOLD, 15));
        facultad.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(facultad);

        JLabel materia = new JLabel("Algoritmos Y Programacion III (75.07)");
        materia.setFont(new Font("Tahoma", Font.BOLD, 14));
        materia.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(materia);

        infoPanel.add(new JLabel("  Autores: "));
        infoPanel.add(new JLabel("     - Ezequiel Rozenzwaig"));
        infoPanel.add(new JLabel("     - Mirko Alic"));
        infoPanel.add(new JLabel("     - Eduardo Calabrini"));

        contentPane.add(infoPanel, BorderLayout.CENTER);
        setModal(true);
        setResizable(false);
    }
}