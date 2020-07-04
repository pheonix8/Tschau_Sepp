package TschauSepp.model;

import TschauSepp.view.Menu;
import TschauSepp.view.RundenUbersicht;
import TschauSepp.view.SpielUI;
import TschauSepp.view.Spielende;

import java.util.Observable;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class Spiel extends Observable {

    private int maxPunktzahl;
    private boolean spieltImUhrzeigersinn;
    private Spieler aktuellerSpieler;
    private Vector<Spieler> alleSpieler;
    private KartenStapel kartenStapel;
    private AblegeStapel ablegeStapel;
    private Karte obersteKarte;


    private SpielUI spielUI;
    private Menu menu;

    public Spiel(Vector<Spieler> alleSpieler, KartenStapel kartenStapel, AblegeStapel ablegeStapel, Menu menu) {

        this.alleSpieler = alleSpieler;
        this.kartenStapel = kartenStapel;
        this.ablegeStapel = ablegeStapel;
        this.menu = menu;

        spieltImUhrzeigersinn = false;
        aktuellerSpieler = alleSpieler.get(0);
    }


    public void spielStart() {

        maxPunktzahl = 20;

        for (int i = 0; i < alleSpieler.size(); i++) {
            alleSpieler.get(i).setPunkte(0);
        }

        rundeStarten();

    }

    public void nächsterSpieler() {

        if (!spieltImUhrzeigersinn) {
            if (alleSpieler.indexOf(aktuellerSpieler) + 1 == alleSpieler.size()) {
                setAktuellerSpieler(alleSpieler.get(0));
            } else {
                setAktuellerSpieler(alleSpieler.get(alleSpieler.indexOf(aktuellerSpieler) + 1));
            }
        } else {
            for (int i = 0; i < alleSpieler.size(); i++) {
                if (alleSpieler.get(i).equals(aktuellerSpieler)) {
                    if (i == 0) {
                        setAktuellerSpieler(alleSpieler.get(alleSpieler.size()));
                    }
                } else {
                    setAktuellerSpieler(alleSpieler.get(i - 1));
                }
                break;
            }
        }

        setChanged();
        notifyObservers(aktuellerSpieler);

    }

    public void rundeStarten() {

        for (int i = 0; i < ablegeStapel.getSize(); i++) {

            kartenStapel.addKarte(ablegeStapel.getKarte(i));

        }

        ablegeStapel.removeallKarten();

        for (int i = 0; i < alleSpieler.size(); i++) {

            for (int j = 0; j < alleSpieler.get(i).getHandSize(); j++) {
                kartenStapel.addKarte(alleSpieler.get(i).getKarte(j));
            }

        }

        for (int i = 0; i < alleSpieler.size(); i++) {

            alleSpieler.get(i).removeallKarten();

        }

        kartenStapel.kartenMischen();

        for (int i = 0; i < alleSpieler.size(); i++) {

            for (int j = 0; j < 7; j++) {
                alleSpieler.get(i).addKarte(kartenStapel.getKarte(0));
                kartenStapel.removebyIndex(0);
            }

        }

        setObersteKarte(kartenStapel.getKarte(0));
        ablegeStapel.addKarte(kartenStapel.getKarte(0));
        kartenStapel.removebyIndex(0);

        setAktuellerSpieler(alleSpieler.get(0));

        spielUI = new SpielUI(this, alleSpieler);

    }

    public void seppSagen(Spieler spieler) {

        if (spieler.getHandSize() == 2) {
            spieler.setHatTschau(true);
        }
    }

    public void rundeBeenden(Spieler spieler) {

        for (int i = 0; i < alleSpieler.size(); i++) {

            if (!alleSpieler.get(i).equals(spieler)) {
                for (int j = 0; j < alleSpieler.get(i).getHandSize(); j++) {

                    spieler.addPunkte(alleSpieler.get(i).getKarte(j).getPunkte());

                }
            }

        }

        spielUI.dispose();

        if (spieler.getPunkte() >= maxPunktzahl){
            spielBeenden(spieler);
        } else {
            RundenUbersicht rundenUbersicht = new RundenUbersicht(alleSpieler, this);
        }
    }

    public void spielBeenden(Spieler spieler){

        Spielende spielende = new Spielende(this, spieler, menu);

    }

    public KartenStapel getKartenStapel() {
        return kartenStapel;
    }

    public AblegeStapel getAblegeStapel() {
        return ablegeStapel;
    }

    public Karte getObersteKarte() {
        return obersteKarte;
    }

    public void setObersteKarte(Karte obersteKarte) {
        this.obersteKarte = obersteKarte;
    }

    public Spieler getAktuellerSpieler() {
        return aktuellerSpieler;
    }

    public void setAktuellerSpieler(Spieler aktuellerSpieler) {
        this.aktuellerSpieler = aktuellerSpieler;
    }


}
