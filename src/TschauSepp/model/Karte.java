package TschauSepp.model;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 23.06.2020
 */
public class Karte {


    enum Farbe{

        Rosen, Schilten, Eichel, Schellen,
        Ecke, Herz, Schaufel, Kreuz;

        private static final Farbe[] farben = Farbe.values();
        public static Farbe getFarbe(int i) {
            return Farbe.farben[i];
        }

    }

    enum Wert{

        Sechs, Sieben, Acht, Neun, Banner, Under, Ober, König, As,
        Zehn, Bauer, Dame;

        private static final Wert[] wert = Wert.values();
        public static Wert getWert(int i) {
            return Wert.wert[i];
        }

    }

    private final Farbe farbe;
    private final Wert wert;
    private final int punkte;

    public Karte(Farbe farbe, Wert wert, int punkte) {
        this.farbe = farbe;
        this.wert = wert;
        this.punkte = punkte;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Wert getWert() {
        return wert;
    }

    public int getPunkte() {
        return punkte;
    }

    @Override
    public String toString() {
        return farbe + "_" + wert + " : " + punkte;
    }
}
