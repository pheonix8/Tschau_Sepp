package TschauSepp.Controller;

import TschauSepp.model.AblegeStapel;
import TschauSepp.model.Karte;
import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;
import TschauSepp.view.SpielUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 01.07.2020
 */
public class SpielController {

    public static int getAnzkartenVon1weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 1 > allespieler.size()){

            player = 0;

        } else {

            player = allespieler.indexOf(spieler) + 1;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }

    public static int getAnzkartenVon2weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 2 > allespieler.size()){

            player = player + allespieler.indexOf(spieler) + 2 - allespieler.size() - 1;

        } else {

            player = allespieler.indexOf(spieler) + 2;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }

    public static int getAnzkartenVon3weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 3 > allespieler.size()){

            player = player + allespieler.indexOf(spieler) + 3 - allespieler.size() - 1;

        } else {

            player = allespieler.indexOf(spieler) + 3;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }

    public static int getAnzkartenVon4weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 4 > allespieler.size()){

            player = player + allespieler.indexOf(spieler) + 4 - allespieler.size() - 1;

        } else {

            player = allespieler.indexOf(spieler) + 4;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }

    public static int getAnzkartenVon5weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 5 > allespieler.size()){

            player = player + allespieler.indexOf(spieler) + 5 - allespieler.size() - 1;

        } else {

            player = allespieler.indexOf(spieler) + 5;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }

    public static int getAnzkartenVon6weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten;

        if(allespieler.indexOf(spieler) + 6 > allespieler.size()){

            player = player + allespieler.indexOf(spieler) + 6 - allespieler.size() - 1;

        } else {

            player = allespieler.indexOf(spieler) + 6;

        }


        anzkarten = allespieler.get(player).getHandSize();

        if (anzkarten > 7 ){

            anzkarten = 7;

        }

        return anzkarten;

    }


    public static void onClickSetzen(Spieler spieler, Karte karte, Spiel spiel){

        spieler.KarteLegen(karte,spiel );

    }

}

