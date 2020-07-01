package TschauSepp.view;

import TschauSepp.model.Spieler;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 01.07.2020
 */
public class RundenUbersicht extends JDialog {

    JPanel background;

    JTextField player1;
    JTextField player2;
    JTextField player3;
    JTextField player4;
    JTextField player5;
    JTextField player6;
    JTextField player7;

    JButton weiter;

    Vector<Spieler> allespieler;

    public RundenUbersicht(Vector<Spieler> allespieler){

        setTitle("Rundenübersicht");

        this.allespieler = allespieler;

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

        background.setPreferredSize(new Dimension(500,800));
        add(background);
        init();
        pack();
        setVisible(true);
        setResizable(false);

    }

    private void init(){

        Collections.sort(allespieler, new Comparator<Spieler>() {
            @Override
            public int compare(Spieler o1, Spieler o2) {
                return o2.getPunkte()-o1.getPunkte();
            }
        });

        GridLayout gridLayout = new GridLayout();
        gridLayout.setHgap(50);
        gridLayout.setVgap(50);

        if (allespieler.size() == 2){
            gridLayout = new GridLayout(3,1);
        } else if (allespieler.size() == 3){
            gridLayout = new GridLayout(4,1);
        } else if (allespieler.size() == 4){
            gridLayout = new GridLayout(5,1);
        } else if (allespieler.size() == 5){
            gridLayout = new GridLayout(6,1);
        } else if (allespieler.size() == 6){
            gridLayout = new GridLayout(7,1);
        } else {
            gridLayout = new GridLayout(8,1);
        }

        Border border = BorderFactory.createEmptyBorder(50,10,50,10);

        background.setBackground(Color.DARK_GRAY);
        background.setLayout(gridLayout);
        background.setBorder(border);

        if (allespieler.size() == 2){
            background.add(player1);
            background.add(player2);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));

        } else if (allespieler.size() == 3){
            background.add(player1);
            background.add(player2);
            background.add(player3);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            player3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));

        } else if (allespieler.size() == 4){
            background.add(player1);
            background.add(player2);
            background.add(player3);
            background.add(player4);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            player3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            player4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));

        } else if (allespieler.size() == 5){
            background.add(player1);
            background.add(player2);
            background.add(player3);
            background.add(player4);
            background.add(player5);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            player3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            player4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            player5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));

        } else if (allespieler.size() == 6){
            background.add(player1);
            background.add(player2);
            background.add(player3);
            background.add(player4);
            background.add(player5);
            background.add(player6);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            player3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            player4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            player5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));
            player6.setText(allespieler.get(5).getName() + " : " + Integer.toString(allespieler.get(5).getPunkte()));

        } else {
            background.add(player1);
            background.add(player2);
            background.add(player3);
            background.add(player4);
            background.add(player5);
            background.add(player6);
            background.add(player7);
            background.add(weiter);

            player1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            player2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            player3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            player4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            player5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));
            player6.setText(allespieler.get(5).getName() + " : " + Integer.toString(allespieler.get(5).getPunkte()));
            player7.setText(allespieler.get(6).getName() + " : " + Integer.toString(allespieler.get(6).getPunkte()));

        }

    }

}