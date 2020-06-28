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

    private Vector<Karte> ablegestapel;

    public AblegeStapel(){

        ablegestapel = new Vector<Karte>();

    }

    public void addKarte(Karte karte){
        ablegestapel.add(karte);
    }

    public void removeallKarten(){
        ablegestapel.clear();
    }

    public Karte getKarte(int index){
        return ablegestapel.get(index);
    }

    public int getSize(){
       return ablegestapel.size();
    }

    @Override
    public String toString() {
        return "" + ablegestapel;
    }
}
