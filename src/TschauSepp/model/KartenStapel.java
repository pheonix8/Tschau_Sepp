package TschauSepp.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 25.06.2020
 */
public class KartenStapel {

    private Vector<KarteSchweiz> kartenstapelSchweiz;
    private Vector<KarteFranzösisch> kartenstapelFranzösisch;

    public KartenStapel() {
        kartenstapelSchweiz = new Vector<KarteSchweiz>();
        kartenstapelFranzösisch = new Vector<KarteFranzösisch>();
    }

    public void generiereDeckSchweiz() {

        KarteSchweiz.Farbe[] farben = KarteSchweiz.Farbe.values();

        for (int i = 0; i < farben.length; i++) {

            KarteSchweiz.Farbe farbe = farben[i];

            int j = 0;

            KarteSchweiz karteSchweiz = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 6);
            kartenstapelSchweiz.add(karteSchweiz);
            j++;
            KarteSchweiz karteSchweiz2 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 7);
            kartenstapelSchweiz.add(karteSchweiz2);
            j++;
            KarteSchweiz karteSchweiz3 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 8);
            kartenstapelSchweiz.add(karteSchweiz3);
            j++;
            KarteSchweiz karteSchweiz4 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 9);
            kartenstapelSchweiz.add(karteSchweiz4);
            j++;
            KarteSchweiz karteSchweiz5 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 10);
            kartenstapelSchweiz.add(karteSchweiz5);
            j++;
            KarteSchweiz karteSchweiz6 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 20);
            kartenstapelSchweiz.add(karteSchweiz6);
            j++;
            KarteSchweiz karteSchweiz7 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 3);
            kartenstapelSchweiz.add(karteSchweiz7);
            j++;
            KarteSchweiz karteSchweiz8 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 4);
            kartenstapelSchweiz.add(karteSchweiz8);
            j++;
            KarteSchweiz karteSchweiz9 = new KarteSchweiz(farbe, KarteSchweiz.Wert.getWert(j), 11);
            kartenstapelSchweiz.add(karteSchweiz9);
            j = 0;

        }

    }

    public void generiereDeckFranzösisch() {

        KarteFranzösisch.Farbe[] farben = KarteFranzösisch.Farbe.values();

        for (int i = 0; i < farben.length; i++) {

            KarteFranzösisch.Farbe farbe = farben[i];

            int j = 0;

            KarteFranzösisch karteFranzösisch = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 6);
            kartenstapelFranzösisch.add(karteFranzösisch);
            j++;
            KarteFranzösisch karteFranzösisch2 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 7);
            kartenstapelFranzösisch.add(karteFranzösisch2);
            j++;
            KarteFranzösisch karteFranzösisch3 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 8);
            kartenstapelFranzösisch.add(karteFranzösisch3);
            j++;
            KarteFranzösisch karteFranzösisch4 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 9);
            kartenstapelFranzösisch.add(karteFranzösisch4);
            j++;
            KarteFranzösisch karteFranzösisch5 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 10);
            kartenstapelFranzösisch.add(karteFranzösisch5);
            j++;
            KarteFranzösisch karteFranzösisch6 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 20);
            kartenstapelFranzösisch.add(karteFranzösisch6);
            j++;
            KarteFranzösisch karteFranzösisch7 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 3);
            kartenstapelFranzösisch.add(karteFranzösisch7);
            j++;
            KarteFranzösisch karteFranzösisch8 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 4);
            kartenstapelFranzösisch.add(karteFranzösisch8);
            j++;
            KarteFranzösisch karteFranzösisch9 = new KarteFranzösisch(farbe, KarteFranzösisch.Wert.getWert(j), 11);
            kartenstapelFranzösisch.add(karteFranzösisch9);
            j = 0;

        }

    }

    public void kartenMischenFranzösisch(){
        Collections.shuffle(kartenstapelSchweiz);
    }

    public void kartenMischenSchweiz(){
        Collections.shuffle(kartenstapelSchweiz);
    }


    @Override
    public String toString() {
        return "KartenStapel: " + "\n" + kartenstapelSchweiz + "\n" + kartenstapelFranzösisch ;
    }
}
