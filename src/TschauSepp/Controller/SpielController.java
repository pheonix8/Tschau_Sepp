package TschauSepp.Controller;

import TschauSepp.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 01.07.2020
 */
public class SpielController {

    public static int getAnzkartenVon3weiter(Vector<Spieler> allespieler, Spieler spieler){
        int player = 0;
        int anzkarten = 0;

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
        int anzkarten = 0;

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

}
