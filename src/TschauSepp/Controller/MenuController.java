package TschauSepp.Controller;

import TschauSepp.model.AblegeStapel;
import TschauSepp.model.KartenStapel;
import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;
import TschauSepp.view.*;

import javax.swing.*;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 */
public class MenuController {

    public static void onClickEinstellungen(){
        Einstellungen einstellungen = new Einstellungen();
    }

    public static void onAnzSelection(JComboBox anzspieler, JTextField player3, JTextField player4, JTextField player5, JTextField player6, JTextField player7){

        if (anzspieler.getSelectedIndex() == 0){

            player3.setVisible(false);
            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 1){

            player3.setVisible(true);

            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 2){

            player3.setVisible(true);
            player4.setVisible(true);

            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 3){

            player3.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);

            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 4) {

            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);

            player7.setVisible(false);

        } else {

            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);
            player7.setVisible(true);

        }

    }

    public static void onClickStart(JComboBox anzahlspieler, JTextField player1, JTextField player2, JTextField player3, JTextField player4, JTextField player5, JTextField player6, JTextField player7, JComboBox kartendeck, Menu menu){

        Vector<Spieler> allespieler = new Vector<>();
        KartenStapel kartenStapel = new KartenStapel();
        AblegeStapel ablegeStapel = new AblegeStapel();

        if (anzahlspieler.getSelectedItem().equals("2 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
        } else if (anzahlspieler.getSelectedItem().equals("3 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
            allespieler.add(new Spieler(player3.getText()));
        } else if (anzahlspieler.getSelectedItem().equals("4 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
        } else  if (anzahlspieler.getSelectedItem().equals("5 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
        } else if (anzahlspieler.getSelectedItem().equals("6 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
            allespieler.add(new Spieler(player6.getText()));
        } else if (anzahlspieler.getSelectedItem().equals("7 Spieler")){
            allespieler.add(new Spieler(player1.getText()));
            allespieler.add(new Spieler(player2.getText()));
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
            allespieler.add(new Spieler(player6.getText()));
            allespieler.add(new Spieler(player7.getText()));
        }

        if (kartendeck.getSelectedItem().equals("Schweizer Deck")){
            kartenStapel.generiereDeckSchweiz();
            kartenStapel.generiereDeckSchweiz();
            kartenStapel.kartenMischen();
        } else if (kartendeck.getSelectedItem().equals("Französisches Deck")){
            kartenStapel.generiereDeckFranzösisch();
            kartenStapel.generiereDeckFranzösisch();
            kartenStapel.kartenMischen();
        }

        Spiel spiel = new Spiel(allespieler,kartenStapel,ablegeStapel);

        spiel.RundeStarten();

        menu.dispose();
    }


}
