package TschauSepp.view;

import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 04.07.2020
 */
public class Uebersicht extends JDialog {

    /**
     * Instantiates a new Uebersicht.
     *
     * @param allespieler the allespieler
     */
    public Uebersicht(Vector<Spieler> allespieler) {

        setTitle("Übersicht");

        Punkteliste punkteliste = new Punkteliste(allespieler);
        JButton weiter = new JButton("Weiter");
        weiter.addActionListener(e -> dispose());

        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
            }
        });

        add(punkteliste);

        punkteliste.addButton().add(weiter);
        punkteliste.addButton().setPreferredSize(new Dimension(500, 800));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}
