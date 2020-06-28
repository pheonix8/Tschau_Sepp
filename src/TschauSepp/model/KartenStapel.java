package TschauSepp.model;

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

    private Vector<Karte> kartenstapel;

    public KartenStapel() {
        kartenstapel = new Vector<Karte>();
    }

    public void generiereDeckSchweiz() {

        Karte.Farbe[] farben = Karte.Farbe.values();

        for (int i = 0; i < farben.length-4; i++) {

            Karte.Farbe farbe = farben[i];

            int j = 0;

            Karte karte = new Karte(farbe, Karte.Wert.getWert(j), 6);
            kartenstapel.add(karte);
            j++;
            Karte karte2 = new Karte(farbe, Karte.Wert.getWert(j), 7);
            kartenstapel.add(karte2);
            j++;
            Karte karte3 = new Karte(farbe, Karte.Wert.getWert(j), 8);
            kartenstapel.add(karte3);
            j++;
            Karte karte4 = new Karte(farbe, Karte.Wert.getWert(j), 9);
            kartenstapel.add(karte4);
            j++;
            Karte karte5 = new Karte(farbe, Karte.Wert.getWert(j), 10);
            kartenstapel.add(karte5);
            j++;
            Karte karte6 = new Karte(farbe, Karte.Wert.getWert(j), 20);
            kartenstapel.add(karte6);
            j++;
            Karte karte7 = new Karte(farbe, Karte.Wert.getWert(j), 3);
            kartenstapel.add(karte7);
            j++;
            Karte karte8 = new Karte(farbe, Karte.Wert.getWert(j), 4);
            kartenstapel.add(karte8);
            j++;
            Karte karte9 = new Karte(farbe, Karte.Wert.getWert(j), 11);
            kartenstapel.add(karte9);
            j = 0;

        }

    }

    public void generiereDeckFranzösisch() {

        Karte.Farbe[] farben = Karte.Farbe.values();

        for (int i = 4; i < farben.length; i++) {

            Karte.Farbe farbe = farben[i];

            Karte karte = new Karte(farbe, Karte.Wert.getWert(0), 6);
            kartenstapel.add(karte);
            Karte karte2 = new Karte(farbe, Karte.Wert.getWert(1), 7);
            kartenstapel.add(karte2);
            Karte karte3 = new Karte(farbe, Karte.Wert.getWert(2), 8);
            kartenstapel.add(karte3);
            Karte karte4 = new Karte(farbe, Karte.Wert.getWert(3), 9);
            kartenstapel.add(karte4);
            Karte karte5 = new Karte(farbe, Karte.Wert.getWert(9), 10);
            kartenstapel.add(karte5);
            Karte karte6 = new Karte(farbe, Karte.Wert.getWert(10), 20);
            kartenstapel.add(karte6);
            Karte karte7 = new Karte(farbe, Karte.Wert.getWert(11), 3);
            kartenstapel.add(karte7);
            Karte karte8 = new Karte(farbe, Karte.Wert.getWert(7), 4);
            kartenstapel.add(karte8);
            Karte karte9 = new Karte(farbe, Karte.Wert.getWert(8), 11);
            kartenstapel.add(karte9);

        }



    }

    public void kartenMischen(){
        Collections.shuffle(kartenstapel);
    }

    public void addKarte(Karte karte){
        kartenstapel.add(karte);
    }

   public void removeKarte(int index){
        kartenstapel.remove(index);
   }

   public Karte getKarte(int index){
        return kartenstapel.get(index);
   }

   public int getSize(){
        return kartenstapel.size();
   }

    @Override
    public String toString() {
        return "KartenStapel: " + "\n" + kartenstapel;
    }
}
