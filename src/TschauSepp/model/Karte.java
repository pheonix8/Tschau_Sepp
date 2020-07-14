package TschauSepp.model;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 23.06.2020
 */
public class Karte {


    /**
     * The enum Farbe.
     */
    enum Farbe {

        Rosen, Schilten, Eichel, Schellen, Ecke, Herz, Schaufel, Kreuz;

        private static final Farbe[] farben = Farbe.values();

        /**
         * Gets farbe.
         *
         * @param i the
         * @return the farbe
         */
        public static Farbe getFarbe(int i) {
            return Farbe.farben[i];
        }

    }

    /**
     * The enum Wert.
     */
    enum Wert {

        Sechs, Sieben, Acht, Neun, Banner, Under, Ober, König, As, Zehn, Bauer, Dame;

        private static final Wert[] wert = Wert.values();

        /**
         * Gets wert.
         *
         * @param i the
         * @return the wert
         */
        public static Wert getWert(int i) {
            return Wert.wert[i];
        }

    }

    private final Farbe farbe;
    private final Wert wert;
    private final int punkte;

    /**
     * Instantiates a new Karte.
     *
     * @param farbe  the farbe
     * @param wert   the wert
     * @param punkte the punkte
     */
    public Karte(Farbe farbe, Wert wert, int punkte) {
        this.farbe = farbe;
        this.wert = wert;
        this.punkte = punkte;
    }

    /**
     * Gets farbe.
     *
     * @return the farbe
     */
    public Farbe getFarbe() {
        return farbe;
    }

    /**
     * Gets wert.
     *
     * @return the wert
     */
    public Wert getWert() {
        return wert;
    }

    /**
     * Gets punkte.
     *
     * @return the punkte
     */
    public int getPunkte() {
        return punkte;
    }

    @Override
    public String toString() {
        return farbe + "_" + wert + " : " + punkte;
    }
}
