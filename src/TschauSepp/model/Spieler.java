package TschauSepp.model;

import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 28.06.2020
 */
public class Spieler {

    private String name;
    private Vector<Karte> hand;
    private int punkte;
    private boolean hatTschau;
    private boolean hatSepp;


    public Spieler(String name) {
        this.name = name;
        hand = new Vector<Karte>();
        punkte = 0;
        hatTschau = false;
        hatSepp = false;
    }

    public String getName(){
        return name;
    }

    public void addKarte(Karte karte){
        hand.add(karte);
    }

    public void removeKarte(int index){
        hand.remove(index);
    }

    public void removeallKarten(){
        hand.clear();
    }

    public Karte getKarte(int index){
        return hand.get(index);
    }

    @Override
    public String toString() {
        return "" + name + " " + hand;
    }
}
