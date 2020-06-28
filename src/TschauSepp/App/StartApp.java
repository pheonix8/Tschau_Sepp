package TschauSepp.App;

import TschauSepp.model.*;

import java.util.Collections;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class StartApp {
    public static void main(String[] args) {
        KartenStapel kartenStapel = new KartenStapel();
        AblegeStapel ablegeStapel = new AblegeStapel();
        Spieler spieler = new Spieler("Leo");

        kartenStapel.generiereDeckFranzösisch();

        System.out.println(kartenStapel);

        kartenStapel.kartenMischen();

        System.out.println(kartenStapel);

        for (int i = 0; i < 4; i++) {
            spieler.addKarte(kartenStapel.getKarte(i));
            kartenStapel.removeKarte(i);
        }

        System.out.println(kartenStapel);
        System.out.println(spieler);

        ablegeStapel.addKarte(spieler.getKarte(0));
        spieler.removeKarte(0);

        System.out.println(spieler);

        ablegeStapel.addKarte(spieler.getKarte(0));
        spieler.removeKarte(0);

        System.out.println(spieler);

        ablegeStapel.addKarte(spieler.getKarte(0));
        spieler.removeKarte(0);

        System.out.println(spieler);

        ablegeStapel.addKarte(spieler.getKarte(0));
        spieler.removeKarte(0);

        System.out.println(spieler);
        System.out.println(ablegeStapel);

        for (int i = 0; i < ablegeStapel.getSize(); i++) {

            kartenStapel.addKarte(ablegeStapel.getKarte(i));

        }

        ablegeStapel.removeallKarten();

        System.out.println(kartenStapel);
        System.out.println(ablegeStapel);

    }
}
