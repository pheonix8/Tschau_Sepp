package TschauSepp.model;

import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 25.06.2020
 */
public class AblegeStapel {

    private final Vector<Karte> ablegestapel;

    /**
     * Instantiates a new Ablege stapel.
     */
    public AblegeStapel() {

        ablegestapel = new Vector<>();

    }

    /**
     * Add karte.
     *
     * @param karte the karte
     */
    public void addKarte(Karte karte) {
        ablegestapel.add(karte);
    }

    /**
     * Removeall karten.
     */
    public void removeallKarten() {
        ablegestapel.clear();
    }

    /**
     * Get karte karte.
     *
     * @param index the index
     * @return the karte
     */
    public Karte getKarte(int index) {
        return ablegestapel.get(index);
    }

    /**
     * Get size int.
     *
     * @return the int
     */
    public int getSize() {
        return ablegestapel.size();
    }

    @Override
    public String toString() {
        return "" + ablegestapel;
    }
}
