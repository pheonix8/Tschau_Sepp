package TschauSepp.model;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 04.07.2020
 */
public class SaveData {

    /**
     * Createfile.
     */
    public void createfile() {
        File file = new File("SaveData/savesettings.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Savefile.
     *
     * @param nurEineRunde        the nur eine runde
     * @param maxPunkte           the max punkte
     * @param freiwilligeAufnahme the freiwillige aufnahme
     * @param aussetzen           the aussetzen
     * @param keinDoppelbauer     the kein doppelbauer
     */
    public void savefile(JCheckBox nurEineRunde, JTextField maxPunkte, JCheckBox freiwilligeAufnahme, JCheckBox aussetzen, JCheckBox keinDoppelbauer) {

        PrintStream out = null;

        try {
            System.out.println("Start writing to file");
            out = new PrintStream(new FileOutputStream("SaveData/savesettings.txt"));

            if (nurEineRunde.isSelected()) {
                out.println("true");
            } else {
                out.println(false);
            }

            out.println(maxPunkte.getText());

            if (freiwilligeAufnahme.isSelected()) {
                out.println("true");
            } else {
                out.println(false);
            }

            if (aussetzen.isSelected()) {
                out.println("true");
            } else {
                out.println(false);
            }

            if (keinDoppelbauer.isSelected()) {
                out.println("true");
            } else {
                out.println(false);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException Error:" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("PrintStream");
                out.close();
            } else {
                System.out.println("Couldn't open connenction");
            }
        }

    }

    /**
     * Readfile.
     *
     * @param nurEineRunde        the nur eine runde
     * @param maxPunkte           the max punkte
     * @param freiwilligeAufnahme the freiwillige aufnahme
     * @param aussetzen           the aussetzen
     * @param keinDoppelbauer     the kein doppelbauer
     */
    public void readfile(JCheckBox nurEineRunde, JTextField maxPunkte, JCheckBox freiwilligeAufnahme, JCheckBox aussetzen, JCheckBox keinDoppelbauer) {

        try {
            Stream<String> lines = Files.lines(Paths.get("SaveData/savesettings.txt"));

            String[] settings = lines.toArray(String[]::new);

            if (settings[0].equalsIgnoreCase("true")) {
                nurEineRunde.setSelected(true);
            } else {
                nurEineRunde.setSelected(false);
            }

            maxPunkte.setText(settings[1]);

            if (settings[2].equalsIgnoreCase("true")) {
                freiwilligeAufnahme.setSelected(true);
            } else {
                freiwilligeAufnahme.setSelected(false);
            }

            if (settings[3].equalsIgnoreCase("true")) {
                aussetzen.setSelected(true);
            } else {
                aussetzen.setSelected(false);
            }

            if (settings[4].equalsIgnoreCase("true")) {
                keinDoppelbauer.setSelected(true);
            } else {
                keinDoppelbauer.setSelected(false);
            }


        } catch (IOException ex) {
            System.out.println("Unable to open file." + ex.toString());
        }

    }

}
