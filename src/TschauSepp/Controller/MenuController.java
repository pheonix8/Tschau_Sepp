package TschauSepp.Controller;

import TschauSepp.model.*;
import TschauSepp.view.Einstellungen;
import TschauSepp.view.Menu;

import javax.swing.*;
import java.util.Objects;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 */
public class MenuController {

    /**
     * On click einstellungen.
     *
     * @param saveData the save data
     */
    public static void onClickEinstellungen(SaveData saveData) {
        new Einstellungen(saveData);
    }

    /**
     * Save einstellungen.
     *
     * @param einstellungen       the einstellungen
     * @param nurEineRunde        the nur eine runde
     * @param maxPunkte           the max punkte
     * @param freiwilligeAufnahme the freiwillige aufnahme
     * @param aussetzen           the aussetzen
     * @param keinDoppelbauer     the kein doppelbauer
     * @param saveData            the save data
     */
    public static void saveEinstellungen(Einstellungen einstellungen, JCheckBox nurEineRunde, JTextField maxPunkte, JCheckBox freiwilligeAufnahme, JCheckBox aussetzen, JCheckBox keinDoppelbauer, SaveData saveData) {
        saveData.createfile();
        saveData.savefile(nurEineRunde, maxPunkte, freiwilligeAufnahme, aussetzen, keinDoppelbauer);
        einstellungen.dispose();
    }

    /**
     * On anz selection.
     *
     * @param anzspieler the anzspieler
     * @param player3    the player 3
     * @param player4    the player 4
     * @param player5    the player 5
     * @param player6    the player 6
     * @param player7    the player 7
     */
    public static void onAnzSelection(JComboBox anzspieler, JTextField player3, JTextField player4, JTextField player5, JTextField player6, JTextField player7) {

        if (anzspieler.getSelectedIndex() == 0) {

            player3.setVisible(false);
            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 1) {

            player3.setVisible(true);

            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 2) {

            player3.setVisible(true);
            player4.setVisible(true);

            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 3) {

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

    /**
     * On click start.
     *
     * @param anzahlspieler the anzahlspieler
     * @param player1       the player 1
     * @param player2       the player 2
     * @param player3       the player 3
     * @param player4       the player 4
     * @param player5       the player 5
     * @param player6       the player 6
     * @param player7       the player 7
     * @param kartendeck    the kartendeck
     * @param menu          the menu
     */
    public static void onClickStart(JComboBox anzahlspieler, JTextField player1, JTextField player2, JTextField player3, JTextField player4, JTextField player5, JTextField player6, JTextField player7, JComboBox kartendeck, Menu menu) {

        Vector<Spieler> allespieler = new Vector<>();
        KartenStapel kartenStapel = new KartenStapel();
        AblegeStapel ablegeStapel = new AblegeStapel();

        allespieler.add(new Spieler(player1.getText()));
        allespieler.add(new Spieler(player2.getText()));

        if (Objects.equals(anzahlspieler.getSelectedItem(), "3 Spieler")) {
            allespieler.add(new Spieler(player3.getText()));
        }
        if (Objects.equals(anzahlspieler.getSelectedItem(), "4 Spieler")) {
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
        }
        if (Objects.equals(anzahlspieler.getSelectedItem(), "5 Spieler")) {
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
        }
        if (Objects.equals(anzahlspieler.getSelectedItem(), "6 Spieler")) {
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
            allespieler.add(new Spieler(player6.getText()));
        }
        if (Objects.equals(anzahlspieler.getSelectedItem(), "7 Spieler")) {
            allespieler.add(new Spieler(player3.getText()));
            allespieler.add(new Spieler(player4.getText()));
            allespieler.add(new Spieler(player5.getText()));
            allespieler.add(new Spieler(player6.getText()));
            allespieler.add(new Spieler(player7.getText()));
        }

        if (Objects.equals(kartendeck.getSelectedItem(), "Schweizer Deck")) {
            kartenStapel.generiereDeckSchweiz();
            kartenStapel.generiereDeckSchweiz();
            kartenStapel.kartenMischen();
        } else if (Objects.equals(kartendeck.getSelectedItem(), "Französisches Deck")) {
            kartenStapel.generiereDeckFranzoesisch();
            kartenStapel.generiereDeckFranzoesisch();
            kartenStapel.kartenMischen();
        }

        Spiel spiel = new Spiel(allespieler, kartenStapel, ablegeStapel, menu);

        spiel.spielStart();

        menu.dispose();
    }


}
