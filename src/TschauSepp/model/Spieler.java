package TschauSepp.model;

import java.util.Observable;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class Spieler extends Observable{

    private String name;
    private Vector<Karte> hand;
    private int punkte;

    private boolean hatTschau;
    private boolean hatSepp;
    private boolean bestrafung;



    public Spieler(String name) {
        this.name = name;
        hand = new Vector<Karte>();
        punkte = 0;

        hatTschau = false;
        hatSepp = false;

    }

    public void KarteLegen(Karte karte, Spiel spiel){

        if (karte.getFarbe() == spiel.getObersteKarte().getFarbe() || karte.getWert() == spiel.getObersteKarte().getWert()){

            spiel.getAblegeStapel().addKarte(karte);
            hand.remove(karte);
            spiel.setObersteKarte(karte);
        }

        setChanged();
        notifyObservers(hand);
        spiel.nächsterSpieler();

        if (hand.size() == 0) {
            spiel.rundeBeenden(this);
        }
    }

    public void KarteNehmen(int counter, Spiel spiel){

        if (isHatTschau()){
            setHatTschau(false);
        }

        if (isHatSepp()){
            setHatSepp(false);
        }

        hand.add(spiel.getKartenStapel().getKarte(spiel.getKartenStapel().getSize()));
        spiel.getKartenStapel().removeKarte(hand.get(hand.size()));

        setChanged();
        notifyObservers(hand);
    }

    public String getName(){
        return name;
    }

    public void addKarte(Karte karte){
        hand.add(karte);
    }

    public void removeKarte(Karte karte){
        hand.remove(karte);
    }

    public void removeallKarten(){
        hand.clear();
    }

    public Karte getKarte(int index){
        return hand.get(index);
    }

    public int getHandSize(){
        return hand.size();
    }

    public void addPunkte(int punkte){
        this.punkte += punkte;
    }

    public int getPunkte(){
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

    @Override
    public String toString() {
        return "" + name + " " + hand;
    }
}
