package TschauSepp.view;

import TschauSepp.Controller.SpielController;
import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 01.07.2020
 */
public class RundenUbersicht extends JDialog {

    /**
     * Instantiates a new Runden ubersicht.
     *
     * @param allespieler the allespieler
     * @param spiel       the spiel
     */
    public RundenUbersicht(Vector<Spieler> allespieler, Spiel spiel) {

        setTitle("Rundenübersicht");

        Punkteliste punkteliste = new Punkteliste(allespieler);
        JButton weiter = new JButton("weiter");
        weiter.addActionListener(e -> SpielController.onClickWeiter(spiel, this));
        add(punkteliste);

        punkteliste.addButton().add(weiter);
        punkteliste.addButton().setPreferredSize(new Dimension(500, 800));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

}