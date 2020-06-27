package TschauSepp.model;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 23.06.2020
 */
public class KarteFranzösisch {

    enum Farbe{

        Ecke, Herz, Schaufel, Kreuz;

        private static final Farbe[] farben = Farbe.values();
        public static Farbe getFarbe(int i) {
            return Farbe.farben[i];
        }

    }

    enum Wert{

        Sechs, Sieben, Acht, Neun, Zehn, Bauer, Dame, König, As;

        private static final Wert[] wert = Wert.values();
        public static Wert getWert(int i) {
            return Wert.wert[i];
        }

    }

    private final Farbe farbe;
    private final Wert wert;
    private int zahl;

    public KarteFranzösisch(Farbe farbe, Wert wert, int zahl) {
        this.farbe = farbe;
        this.wert = wert;
        this.zahl = zahl;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Wert getWert() {
        return wert;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    @Override
    public String toString() {
        return farbe + "_" + wert + " : " + zahl;
    }
}
