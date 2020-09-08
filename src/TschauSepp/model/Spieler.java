package TschauSepp.model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class Spieler extends Observable {

    private final String name;
    private final Vector<Karte> hand;
    private int punkte;

    private boolean hatTschau;
    private boolean hatSepp;
    private boolean check;

    /**
     * Instantiates a new Spieler.
     *
     * @param name the name
     */
    public Spieler(String name) {
        this.name = name;
        hand = new Vector<>();
        punkte = 0;

        hatTschau = false;
        hatSepp = false;
        check = true;
    }

    /**
     * Tschau sagen.
     *
     * @param spiel  the spiel
     * @param tschau the tschau
     */
    public void tschauSagen(Spiel spiel, JButton tschau) {
        isCheckFalse(spiel);
        if (!check && spiel.getAktuellerSpieler().getHandSize() == 2) {
            setHatTschau(true);
            tschau.setForeground(Color.green);
            System.out.println(spiel.getAktuellerSpieler().isHatTschau());
        }
    }

    /**
     * Sepp sagen.
     *
     * @param spiel the spiel
     * @param sepp  the sepp
     */
    public void seppSagen(Spiel spiel, JButton sepp) {
        isCheckFalse(spiel);
        if (!check && spiel.getAktuellerSpieler().getHandSize() == 1) {
            setHatSepp(true);
            sepp.setForeground(Color.green);
            System.out.println(spiel.getAktuellerSpieler().isHatSepp());
        }
    }

    /**
     * Karte legen.
     *
     * @param karte   the karte
     * @param spiel   the spiel
     * @param spieler the spieler
     */
    public void KarteLegen(Karte karte, Spiel spiel, Spieler spieler) {

        if (karte.getFarbe() == spiel.getObersteKarte().getFarbe() || karte.getWert() == spiel.getObersteKarte().getWert()) {

            if (spiel.getAktuellerSpieler().getHandSize() == 2 && !spiel.getAktuellerSpieler().isHatTschau()) {
                spiel.getAktuellerSpieler().bestrafung(spiel, spieler);
            }
            if (spiel.getAktuellerSpieler().getHandSize() == 1 && !spiel.getAktuellerSpieler().isHatSepp()) {
                spiel.getAktuellerSpieler().bestrafung(spiel, spieler);
            }

            spiel.getAblegeStapel().addKarte(karte);
            hand.remove(karte);
            spiel.setObersteKarte(karte);



            if (karte.getPunkte() == 10) {
                spiel.setSpieltImUhrzeigersinn(!spiel.isSpieltImUhrzeigersinn());
            }
            if (hand.size() == 0) {
                spiel.rundeBeenden(this);
            } else {
                spiel.setCheck(true);
                spiel.naechsterSpieler();
            }
        }
    }

    /**
     * Karte nehmen.
     *
     * @param spiel   the spiel
     * @param spieler the spieler
     * @param tschau  the tschau
     * @param sepp    the sepp
     */
    public void KarteNehmen(Spiel spiel, Spieler spieler, JButton tschau, JButton sepp) {

        check = true;
        isCheckFalse(spiel);

        if (spiel.isFreiwilligeAufnahme()) {
            check = true;
        }

        if (check) {
            if (isHatTschau()) {
                setHatTschau(false);
                tschau.setForeground(Color.black);
            }

            if (isHatSepp()) {
                setHatSepp(false);
                sepp.setForeground(Color.black);
            }

            spiel.stapelEmpty();

            spieler.hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
            spiel.getKartenStapel().removeKarte(spieler.hand.get(spieler.hand.size() - 1));

            if (!spiel.isAussetzen()) {
                check = true;
                isCheckFalse(spiel);
                if (!check) {
                    spiel.setAgain(false);
                }
            }
            spiel.setCheck(false);
            spiel.naechsterSpieler();
        }

    }

    /**
     * Bestrafung.
     *
     * @param spiel   the spiel
     * @param spieler the spieler
     */
    public void bestrafung(Spiel spiel, Spieler spieler) {

        if (spiel.getAktuellerSpieler().getHandSize() == 1) {
            spiel.stapelEmpty();
            for (int i = 0; i < 3; i++) {
                spieler.hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
                spiel.getKartenStapel().removeKarte(spieler.hand.get(spieler.hand.size() - 1));
            }
            JOptionPane.showMessageDialog(null, spiel.getAktuellerSpieler().getName() + " du depp musst Karten aufnehmen, das nächste Mal Sepp sagen", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (spiel.getAktuellerSpieler().getHandSize() == 2) {
            spiel.stapelEmpty();
            for (int i = 0; i < 2; i++) {
                spieler.hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
                spiel.getKartenStapel().removeKarte(spieler.hand.get(spieler.hand.size() - 1));
            }
            JOptionPane.showMessageDialog(null, spiel.getAktuellerSpieler().getName() + " du depp musst Karten aufnehmen, das nächste Mal Tschau sagen", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte) {
        hand.add(karte);
    }

    /**
     * Removeall karten.
     */
    public void removeallKarten() {
        hand.clear();
    }

    /**
     * Gets karte.
     *
     * @param index the index
     * @return the karte
     */
    public Karte getKarte(int index) {
        return hand.get(index);
    }

    /**
     * Gets hand size.
     *
     * @return the hand size
     */
    public int getHandSize() {
        return hand.size();
    }

    /**
     * Add punkte.
     *
     * @param punkte the punkte
     */
    public void addPunkte(int punkte) {
        this.punkte += punkte;
    }

    /**
     * Gets punkte.
     *
     * @return the punkte
     */
    public int getPunkte() {
        return punkte;
    }

    /**
     * Is hat tschau boolean.
     *
     * @return the boolean
     */
    public boolean isHatTschau() {
        return hatTschau;
    }

    /**
     * Sets hat tschau.
     *
     * @param hatTschau the hat tschau
     */
    public void setHatTschau(boolean hatTschau) {
        this.hatTschau = hatTschau;
    }

    /**
     * Is hat sepp boolean.
     *
     * @return the boolean
     */
    public boolean isHatSepp() {
        return hatSepp;
    }

    /**
     * Sets hat sepp.
     *
     * @param hatSepp the hat sepp
     */
    public void setHatSepp(boolean hatSepp) {
        this.hatSepp = hatSepp;
    }

    /**
     * Sets punkte.
     *
     * @param punkte the punkte
     */
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    /**
     * Is check false boolean.
     *
     * @param spiel the spiel
     */
    public void isCheckFalse(Spiel spiel) {
        for (int i = 0; i < spiel.getAktuellerSpieler().getHandSize(); i++) {
            if (spiel.getObersteKarte().getFarbe() == spiel.getAktuellerSpieler().hand.get(i).getFarbe()) {
                check = false;
                break;
            } else if (spiel.getObersteKarte().getWert() == spiel.getAktuellerSpieler().hand.get(i).getWert()) {
                check = false;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "" + name + " " + hand;
    }


}
