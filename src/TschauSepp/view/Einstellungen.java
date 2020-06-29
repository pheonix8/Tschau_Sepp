package TschauSepp.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.06.2020
 */
public class Einstellungen extends JDialog {

    BufferedImage bufferedImage = null;

    BackgroundJPanel backgroundPanel;

    JPanel regelnPanel;

    JLabel nurEineRunde;
    JCheckBox getnurEineRunde;

    JLabel maxpunktzahl;
    JTextField maxpunkte;

    JLabel hilfe;
    JCheckBox gethilfe;

    JLabel sprache;
    JComboBox sprachen;
    String[] allesprachen ={
        "Deutsch",
        "Français",
        "English"

    };

    JLabel freiwilligeAufnahme;
    JCheckBox getfreiwilligeAufnahme;

    JLabel aussetzenNachAufnahme;
    JCheckBox getaussetzenNachAufnahme;

    JLabel keinDoppelbauer;
    JCheckBox getkeinDoppelbauer;

    JButton speichern;

    public Einstellungen() {

        setTitle("Einstellungen");

        try{
            bufferedImage = ImageIO.read(new File("Hintergründe/Einstellungen_Hindergrund.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

        backgroundPanel = new BackgroundJPanel();
        regelnPanel = new JPanel();
        nurEineRunde = new JLabel("Nur eine Runde");
        getnurEineRunde = new JCheckBox();
        maxpunktzahl = new JLabel("Maximale Punktzahl");
        maxpunkte = new JTextField("200");
        hilfe = new JLabel("Hilfe");
        gethilfe = new JCheckBox();
        sprache = new JLabel("Sprache");
        sprachen = new JComboBox(allesprachen);
        freiwilligeAufnahme = new JLabel("Freiwillige Aufnahme");
        getfreiwilligeAufnahme = new JCheckBox();
        aussetzenNachAufnahme = new JLabel("Aussetzen nach Aufnahme");
        getaussetzenNachAufnahme = new JCheckBox();
        keinDoppelbauer = new JLabel("Kein Doppelbauer");
        getkeinDoppelbauer = new JCheckBox();
        speichern = new JButton("Speichern");

        backgroundPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        add(backgroundPanel);
        init();
        pack();
        setVisible(true);
        setResizable(false);
    }

    public void init(){

        backgroundPanel.setLayout(new BorderLayout());

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(7);
        gridLayout.setColumns(2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        Border border = BorderFactory.createEmptyBorder(0, 100, 200, 100);
        Border regelborder = BorderFactory.createEmptyBorder(300, 0, 100, 0);

        regelnPanel.setLayout(gridLayout);
        regelnPanel.setOpaque(false);
        regelnPanel.setBorder(regelborder);

        regelnPanel.add(nurEineRunde);
        nurEineRunde.setForeground(Color.yellow);
        nurEineRunde.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(getnurEineRunde);
        getnurEineRunde.setOpaque(false);

        regelnPanel.add(maxpunktzahl);
        maxpunktzahl.setForeground(Color.yellow);
        maxpunktzahl.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(maxpunkte);

        regelnPanel.add(hilfe);
        hilfe.setForeground(Color.yellow);
        hilfe.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(gethilfe);
        gethilfe.setOpaque(false);

        regelnPanel.add(sprache);
        sprache.setForeground(Color.yellow);
        sprache.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(sprachen);

        regelnPanel.add(freiwilligeAufnahme);
        freiwilligeAufnahme.setForeground(Color.yellow);
        freiwilligeAufnahme.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(getfreiwilligeAufnahme);
        getfreiwilligeAufnahme.setOpaque(false);

        regelnPanel.add(aussetzenNachAufnahme);
        aussetzenNachAufnahme.setForeground(Color.yellow);
        aussetzenNachAufnahme.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(getaussetzenNachAufnahme);
        getaussetzenNachAufnahme.setOpaque(false);

        regelnPanel.add(keinDoppelbauer);
        keinDoppelbauer.setForeground(Color.yellow);
        keinDoppelbauer.setFont(new Font("Serif", Font.BOLD, 20));

        regelnPanel.add(getkeinDoppelbauer);
        getkeinDoppelbauer.setOpaque(false);

        backgroundPanel.add(regelnPanel, BorderLayout.CENTER);
        backgroundPanel.add(speichern, BorderLayout.SOUTH);
        backgroundPanel.setBorder(border);

    }



    class BackgroundJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

}
