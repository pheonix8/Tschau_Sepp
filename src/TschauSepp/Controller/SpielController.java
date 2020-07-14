package TschauSepp.Controller;

import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;
import TschauSepp.view.Menu;
import TschauSepp.view.RundenUbersicht;
import TschauSepp.view.Spielende;

import javax.swing.*;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 01.07.2020
 */
public class SpielController {

    /**
     * Get anzkarten von 1 weiter int.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the int
     */
    public static int getAnzkartenVon1weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 1 == allespieler.size()) {
            player = 0;
        } else {
            player = allespieler.indexOf(spieler) + 1;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * Gets anzkarten von 2 weiter.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the anzkarten von 2 weiter
     */
    public static int getAnzkartenVon2weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player = 0;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 2 >= allespieler.size()) {
            player = player + allespieler.indexOf(spieler) + 2 - allespieler.size();
        } else {
            player = allespieler.indexOf(spieler) + 2;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * Gets anzkarten von 3 weiter.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the anzkarten von 3 weiter
     */
    public static int getAnzkartenVon3weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player = 0;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 3 >= allespieler.size()) {
            player = player + allespieler.indexOf(spieler) + 3 - allespieler.size();
        } else {
            player = allespieler.indexOf(spieler) + 3;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * Gets anzkarten von 4 weiter.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the anzkarten von 4 weiter
     */
    public static int getAnzkartenVon4weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player = 0;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 4 >= allespieler.size()) {
            player = player + allespieler.indexOf(spieler) + 4 - allespieler.size();
        } else {
            player = allespieler.indexOf(spieler) + 4;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * Gets anzkarten von 5 weiter.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the anzkarten von 5 weiter
     */
    public static int getAnzkartenVon5weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player = 0;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 5 >= allespieler.size()) {
            player = player + allespieler.indexOf(spieler) + 5 - allespieler.size();
        } else {
            player = allespieler.indexOf(spieler) + 5;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * Gets anzkarten von 6 weiter.
     *
     * @param allespieler the allespieler
     * @param spieler     the spieler
     * @return the anzkarten von 6 weiter
     */
    public static int getAnzkartenVon6weiter(Vector<Spieler> allespieler, Spieler spieler) {
        int player = 0;
        int anzkarten;

        if (allespieler.indexOf(spieler) + 6 >= allespieler.size()) {
            player = player + allespieler.indexOf(spieler) + 6 - allespieler.size();
        } else {
            player = allespieler.indexOf(spieler) + 6;
        }
        anzkarten = allespieler.get(player).getHandSize();
        if (anzkarten > 7) {
            anzkarten = 7;
        }
        return anzkarten;
    }

    /**
     * On click setzen.
     *
     * @param spieler the spieler
     * @param karten  the karten
     * @param spiel   the spiel
     */
    public static void onClickSetzen(Spieler spieler, JList karten, Spiel spiel) {
        if (!karten.isSelectionEmpty()) {
            spieler.KarteLegen(spieler.getKarte(karten.getSelectedIndex()), spiel, spieler);
        }
    }

    /**
     * On click ziehen.
     *
     * @param spiel   the spiel
     * @param spieler the spieler
     * @param tschau  the tschau
     * @param sepp    the sepp
     */
    public static void onClickZiehen(Spiel spiel, Spieler spieler, JButton tschau, JButton sepp) {
        spiel.getAktuellerSpieler().KarteNehmen(spiel, spieler, tschau, sepp);
    }

    /**
     * On click weiter.
     *
     * @param spiel           the spiel
     * @param rundenUbersicht the runden ubersicht
     */
    public static void onClickWeiter(Spiel spiel, RundenUbersicht rundenUbersicht) {
        spiel.rundeStarten();
        rundenUbersicht.dispose();
    }

    /**
     * On click revanche.
     *
     * @param spiel     the spiel
     * @param spielende the spielende
     */
    public static void onClickRevanche(Spiel spiel, Spielende spielende) {
        spielende.dispose();
        spiel.spielStart();
    }

    /**
     * On click beenden.
     *
     * @param spielende the spielende
     */
    public static void onClickBeenden(Spielende spielende) {
        spielende.dispose();
        new Menu();
    }

    /**
     * On click tschau.
     *
     * @param spieler the spieler
     * @param spiel   the spiel
     * @param tschau  the tschau
     */
    public static void onClickTschau(Spieler spieler, Spiel spiel, JButton tschau) {
        spieler.tschauSagen(spiel, tschau);
    }

    /**
     * On click sepp.
     *
     * @param spieler the spieler
     * @param spiel   the spiel
     * @param sepp    the sepp
     */
    public static void onClickSepp(Spieler spieler, Spiel spiel, JButton sepp) {
        spieler.seppSagen(spiel, sepp);
    }
}

