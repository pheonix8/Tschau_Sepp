package TschauSepp.model;

import TschauSepp.view.Menu;
import TschauSepp.view.RundenUbersicht;
import TschauSepp.view.SpielUI;
import TschauSepp.view.Spielende;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class Spiel extends Observable {

    private boolean nurEineRunde;
    private int maxPunktzahl;
    private boolean freiwilligeAufnahme;
    private boolean aussetzen;
    private boolean keinDoppelbauer;

    private boolean aus;
    private int auslassen;
    private boolean again;

    private boolean spieltImUhrzeigersinn;
    private Spieler aktuellerSpieler;
    private Vector<Spieler> alleSpieler;
    private KartenStapel kartenStapel;
    private AblegeStapel ablegeStapel;
    private Karte obersteKarte;

    private SpielUI spielUI;
    private Menu menu;

    /**
     * Instantiates a new Spiel.
     *
     * @param alleSpieler  the alle spieler
     * @param kartenStapel the karten stapel
     * @param ablegeStapel the ablege stapel
     * @param menu         the menu
     */
    public Spiel(Vector<Spieler> alleSpieler, KartenStapel kartenStapel, AblegeStapel ablegeStapel, Menu menu) {

        this.alleSpieler = alleSpieler;
        this.kartenStapel = kartenStapel;
        this.ablegeStapel = ablegeStapel;
        this.menu = menu;

        spieltImUhrzeigersinn = false;
        aktuellerSpieler = alleSpieler.get(0);
        aus = true;
        again = true;
    }


    /**
     * Spiel start.
     */
    public void spielStart() {

        readfile();

        if (nurEineRunde) {
            maxPunktzahl = 0;
        }

        for (int i = 0; i < alleSpieler.size(); i++) {
            alleSpieler.get(i).setPunkte(0);
        }

        for (int i = 0; i < alleSpieler.size(); i++) {
            alleSpieler.get(i).setHatTschau(false);
            alleSpieler.get(i).setHatSepp(false);
        }

        rundeStarten();

    }

    /**
     * Nächster spieler.
     */
    public void nächsterSpieler() {

        if (again) {

            if (getObersteKarte().getPunkte() != 11) {
                auslassen = 1;

                if (getObersteKarte().getPunkte() == 8) {
                    if (aus) {
                        auslassen = 2;
                        aus = false;
                    }


                }

                for (int i = 0; i < auslassen; i++) {
                    if (!spieltImUhrzeigersinn) {
                        if (alleSpieler.indexOf(aktuellerSpieler) + 1 == alleSpieler.size()) {
                            setAktuellerSpieler(alleSpieler.get(0));
                        } else {
                            setAktuellerSpieler(alleSpieler.get(alleSpieler.indexOf(aktuellerSpieler) + 1));
                        }
                    } else {
                        if (alleSpieler.indexOf(aktuellerSpieler) - 1 == -1) {
                            setAktuellerSpieler(alleSpieler.get(alleSpieler.size() - 1));
                        } else {
                            setAktuellerSpieler(alleSpieler.get(alleSpieler.indexOf(aktuellerSpieler) - 1));
                        }
                    }
                }
            }
        }

        setChanged();
        notifyObservers(aktuellerSpieler);
        if (auslassen == 1 || auslassen == 2) {
            aus = true;
        }
        again = true;
    }

    /**
     * Runde starten.
     */
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

    /**
     * Runde beenden.
     *
     * @param spieler the spieler
     */
    public void rundeBeenden(Spieler spieler) {

        for (int i = 0; i < alleSpieler.size(); i++) {

            if (!alleSpieler.get(i).equals(spieler)) {
                for (int j = 0; j < alleSpieler.get(i).getHandSize(); j++) {

                    spieler.addPunkte(alleSpieler.get(i).getKarte(j).getPunkte());

                }
            }

        }

        spielUI.dispose();

        if (spieler.getPunkte() >= maxPunktzahl) {
            spielBeenden(spieler);
        } else {
            RundenUbersicht rundenUbersicht = new RundenUbersicht(alleSpieler, this);
        }
    }

    /**
     * Spiel beenden.
     *
     * @param spieler the spieler
     */
    public void spielBeenden(Spieler spieler) {

        Spielende spielende = new Spielende(this, spieler, menu);

    }

    /**
     * Readfile.
     */
    public void readfile() {

        try {
            Stream<String> lines = Files.lines(Paths.get("SaveData/savesettings.txt"));

            String[] settings = lines.toArray(String[]::new);

            if (settings[0].equalsIgnoreCase("true")) {
                nurEineRunde = true;
            } else {
                nurEineRunde = false;
            }

            String punkte = settings[1];
            maxPunktzahl = Integer.parseInt(punkte);

            if (settings[2].equalsIgnoreCase("true")) {
                freiwilligeAufnahme = true;
            } else {
                freiwilligeAufnahme = false;
            }

            if (settings[3].equalsIgnoreCase("true")) {
                aussetzen = true;
            } else {
                aussetzen = false;
            }

            if (settings[4].equalsIgnoreCase("true")) {
                keinDoppelbauer = true;
            } else {
                keinDoppelbauer = false;
            }

        } catch (IOException ex) {
            System.out.println("Unable to open file." + ex.toString());
        }

    }

    /**
     * Gets karten stapel.
     *
     * @return the karten stapel
     */
    public KartenStapel getKartenStapel() {
        return kartenStapel;
    }

    /**
     * Gets ablege stapel.
     *
     * @return the ablege stapel
     */
    public AblegeStapel getAblegeStapel() {
        return ablegeStapel;
    }

    /**
     * Gets oberste karte.
     *
     * @return the oberste karte
     */
    public Karte getObersteKarte() {
        return obersteKarte;
    }

    /**
     * Sets oberste karte.
     *
     * @param obersteKarte the oberste karte
     */
    public void setObersteKarte(Karte obersteKarte) {
        this.obersteKarte = obersteKarte;
    }

    /**
     * Gets aktueller spieler.
     *
     * @return the aktueller spieler
     */
    public Spieler getAktuellerSpieler() {
        return aktuellerSpieler;
    }

    /**
     * Sets aktueller spieler.
     *
     * @param aktuellerSpieler the aktueller spieler
     */
    public void setAktuellerSpieler(Spieler aktuellerSpieler) {
        this.aktuellerSpieler = aktuellerSpieler;
    }

    /**
     * Sets spielt im uhrzeigersinn.
     *
     * @param spieltImUhrzeigersinn the spielt im uhrzeigersinn
     */
    public void setSpieltImUhrzeigersinn(boolean spieltImUhrzeigersinn) {
        this.spieltImUhrzeigersinn = spieltImUhrzeigersinn;
    }

    /**
     * Is spielt im uhrzeigersinn boolean.
     *
     * @return the boolean
     */
    public boolean isSpieltImUhrzeigersinn() {
        return spieltImUhrzeigersinn;
    }

    /**
     * Is aussetzen boolean.
     *
     * @return the boolean
     */
    public boolean isAussetzen() {
        return aussetzen;
    }

    /**
     * Is freiwillige aufnahme boolean.
     *
     * @return the boolean
     */
    public boolean isFreiwilligeAufnahme() {
        return freiwilligeAufnahme;
    }

    /**
     * Is again boolean.
     *
     * @return the boolean
     */
    public boolean isAgain() {
        return again;
    }

    /**
     * Sets again.
     *
     * @param again the again
     */
    public void setAgain(boolean again) {
        this.again = again;
    }
}
