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

    private String name;
    private Vector<Karte> hand;
    private int punkte;

    private boolean hatTschau;
    private boolean hatSepp;
    private boolean check;

    public Spieler(String name) {
        this.name = name;
        hand = new Vector<Karte>();
        punkte = 0;

        hatTschau = false;
        hatSepp = false;
        check = true;
    }

    public void tschauSagen(Spiel spiel, JButton tschau) {
        isCheckFalse(spiel);
        if (!check && spiel.getAktuellerSpieler().getHandSize() == 2) {
            setHatTschau(true);
            tschau.setForeground(Color.green);
            System.out.println(spiel.getAktuellerSpieler().isHatTschau());
        }
    }

    public void seppSagen(Spiel spiel, JButton sepp) {
        isCheckFalse(spiel);
        if (!check && spiel.getAktuellerSpieler().getHandSize() == 1) {
            setHatSepp(true);
            sepp.setForeground(Color.green);
            System.out.println(spiel.getAktuellerSpieler().isHatSepp());
        }
    }

    public void KarteLegen(Karte karte, Spiel spiel) {

        if (karte.getFarbe() == spiel.getObersteKarte().getFarbe() || karte.getWert() == spiel.getObersteKarte().getWert()) {

            if (spiel.getAktuellerSpieler().getHandSize() == 2 && !spiel.getAktuellerSpieler().isHatTschau()) {
                spiel.getAktuellerSpieler().bestrafung(spiel);
            }

            if (spiel.getAktuellerSpieler().getHandSize() == 1 && !spiel.getAktuellerSpieler().isHatSepp()) {
                spiel.getAktuellerSpieler().bestrafung(spiel);
            }

            spiel.getAblegeStapel().addKarte(karte);
            hand.remove(karte);
            spiel.setObersteKarte(karte);

            if (hand.size() == 0) {
                spiel.rundeBeenden(this);
            } else {
                spiel.nächsterSpieler();
            }
        }
    }

    public void KarteNehmen(Spiel spiel, JButton tschau, JButton sepp) {

        check = true;
        isCheckFalse(spiel);

        if (check) {
            if (isHatTschau()) {
                setHatTschau(false);
                tschau.setForeground(Color.black);
            }

            if (isHatSepp()) {
                setHatSepp(false);
                sepp.setForeground(Color.black);
            }

            hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
            spiel.getKartenStapel().removeKarte(hand.get(hand.size() - 1));

            setChanged();
            notifyObservers();

            check = true;
            isCheckFalse(spiel);

            if (check) {
                spiel.nächsterSpieler();
            }
        }
    }

    public void bestrafung(Spiel spiel) {

        if (spiel.getAktuellerSpieler().getHandSize() == 1) {
            for (int i = 0; i < 3; i++) {
                hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
                spiel.getKartenStapel().removeKarte(hand.get(hand.size() - 1));
            }
            JOptionPane.showMessageDialog(null, spiel.getAktuellerSpieler() + " du depp musst 4 Karten aufnehmen, das nächste Mal SEPP sagen", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < 1; i++) {
                hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize() - 1));
                spiel.getKartenStapel().removeKarte(hand.get(hand.size() - 1));
            }
            JOptionPane.showMessageDialog(null, spiel.getAktuellerSpieler() + " du depp musst 3 Karten aufnehmen, das nächste Mal Tschau sagen", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        setChanged();
        notifyObservers();
        spiel.nächsterSpieler();
    }

    public String getName() {
        return name;
    }

    public void addKarte(Karte karte) {
        hand.add(karte);
    }

    public void removeKarte(Karte karte) {
        hand.remove(karte);
    }

    public void removeallKarten() {
        hand.clear();
    }

    public Karte getKarte(int index) {
        return hand.get(index);
    }

    public int getHandSize() {
        return hand.size();
    }

    public void addPunkte(int punkte) {
        this.punkte += punkte;
    }

    public int getPunkte() {
        return punkte;
    }

    public boolean isHatTschau() {
        return hatTschau;
    }

    public void setHatTschau(boolean hatTschau) {
        this.hatTschau = hatTschau;
    }

    public boolean isHatSepp() {
        return hatSepp;
    }

    public void setHatSepp(boolean hatSepp) {
        this.hatSepp = hatSepp;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public boolean isCheckFalse(Spiel spiel) {
        for (int i = 0; i < spiel.getAktuellerSpieler().getHandSize(); i++) {
            if (spiel.getObersteKarte().getFarbe() == spiel.getAktuellerSpieler().hand.get(i).getFarbe()) {
                check = false;
            } else if (spiel.getObersteKarte().getWert() == spiel.getAktuellerSpieler().hand.get(i).getWert()) {
                check = false;
            }
        }
        return check;
    }

    @Override
    public String toString() {
        return "" + name + " " + hand;
    }
}
