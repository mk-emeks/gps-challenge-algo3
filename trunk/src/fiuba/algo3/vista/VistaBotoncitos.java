package fiuba.algo3.vista;


import fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaBotoncitos {

    private JPanel panelBotonesPrincipales2;

    public VistaBotoncitos (final JFrame unMarco) {

        unMarco.getContentPane().removeAll();

        panelBotonesPrincipales2 = new JPanel();//new SuperficiePanel();
        panelBotonesPrincipales2.setBackground(Color.YELLOW);
        panelBotonesPrincipales2.setLayout(null);

        JButton botonVolver = new JButton("Volver Al Menu");
        botonVolver.setBounds(0,0,300,75);
        botonVolver.repaint();
        botonVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VistaMenuPrincipal sosUnBoton = new VistaMenuPrincipal(unMarco);

            }
        });

        panelBotonesPrincipales2.add(botonVolver);
        unMarco.add(panelBotonesPrincipales2);

        unMarco.revalidate();
        unMarco.repaint();
    }
}
