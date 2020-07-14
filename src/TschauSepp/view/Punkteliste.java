package TschauSepp.view;

import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Collections;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 14.07.2020
 */
public class Punkteliste extends JPanel {

    private Vector<Spieler> allespieler;
    private Spiel spiel;

    private JPanel background;

    private JTextField player1;
    private JTextField player2;
    private JTextField player3;
    private JTextField player4;
    private JTextField player5;
    private JTextField player6;
    private JTextField player7;
    private JButton weiter;

    public Punkteliste(Vector<Spieler> allespieler, Spiel spiel) {

        this.allespieler = allespieler;
        this.spiel = spiel;

        background = new JPanel();
        player1 = new JTextField();
        player1.setEditable(false);
        player2 = new JTextField();
        player2.setEditable(false);
        player3 = new JTextField();
        player3.setEditable(false);
        player4 = new JTextField();
        player4.setEditable(false);
        player5 = new JTextField();
        player5.setEditable(false);
        player6 = new JTextField();
        player6.setEditable(false);
        player7 = new JTextField();
        player7.setEditable(false);

        weiter = new JButton("Weiter");

        add(background);
        init();

    }

    private void init() {

        Collections.sort(allespieler, (o1, o2) -> o2.getPunkte() - o1.getPunkte());

        GridLayout gridLayout = new GridLayout();
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        if (allespieler.size() == 2) {
            gridLayout = new GridLayout(3, 1);
        } else if (allespieler.size() == 3) {
            gridLayout = new GridLayout(4, 1);
        } else if (allespieler.size() == 4) {
            gridLayout = new GridLayout(5, 1);
        } else if (allespieler.size() == 5) {
            gridLayout = new GridLayout(6, 1);
        } else if (allespieler.size() == 6) {
            gridLayout = new GridLayout(7, 1);
        } else {
            gridLayout = new GridLayout(8, 1);
        }

        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        background.setBackground(Color.DARK_GRAY);
        background.setLayout(gridLayout);
        background.setBorder(border);

        background.add(player1);
        background.add(player2);

        player1.setText(allespieler.get(0).getName() + " : " + allespieler.get(0).getPunkte());
        player2.setText(allespieler.get(1).getName() + " : " + allespieler.get(1).getPunkte());

        if (allespieler.size() >= 3) {
            background.add(player3);
            player3.setText(allespieler.get(2).getName() + " : " + allespieler.get(2).getPunkte());
        }
        if (allespieler.size() >= 4) {
            background.add(player4);
            player4.setText(allespieler.get(3).getName() + " : " + allespieler.get(3).getPunkte());
        }
        if (allespieler.size() >= 5) {
            background.add(player5);
            player5.setText(allespieler.get(4).getName() + " : " + allespieler.get(4).getPunkte());
        }
        if (allespieler.size() >= 6) {
            background.add(player6);
            player6.setText(allespieler.get(5).getName() + " : " + allespieler.get(5).getPunkte());
        }
        if (allespieler.size() >= 7) {
            background.add(player7);
            player7.setText(allespieler.get(6).getName() + " : " + allespieler.get(6).getPunkte());
        }
    }

    public JPanel addButton() {
        return background;
    }
}
