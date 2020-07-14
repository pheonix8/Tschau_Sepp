package TschauSepp.view;

import TschauSepp.model.Spiel;
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

    private Vector<Spieler> allespieler;
    private Spiel spiel;

    private Punkteliste punkteliste;
    private JButton weiter;

    /**
     * Instantiates a new Uebersicht.
     *
     * @param allespieler the allespieler
     * @param spiel       the spiel
     */
    public Uebersicht(Vector<Spieler> allespieler, Spiel spiel) {

        setTitle("Übersicht");

        this.allespieler = allespieler;
        this.spiel = spiel;
        punkteliste = new Punkteliste(allespieler, spiel);
        weiter = new JButton("Weiter");
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
