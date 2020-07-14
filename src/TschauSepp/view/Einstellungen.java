package TschauSepp.view;

import TschauSepp.Controller.MenuController;
import TschauSepp.model.SaveData;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 27.06.2020
 */
public class Einstellungen extends JDialog {

    private BufferedImage bufferedImage = null;

    private SaveData saveData;


    private final BackgroundJPanel backgroundPanel;
    private final JPanel regelnPanel;

    private final JLabel nurEineRunde;
    private final JCheckBox getnurEineRunde;

    private final JLabel maxpunktzahl;
    private final JTextField maxpunkte;

    private JLabel hilfe;
    private JCheckBox gethilfe;

    private JLabel sprache;
    private JComboBox sprachen;

    private final JLabel freiwilligeAufnahme;
    private final JCheckBox getfreiwilligeAufnahme;

    private final JLabel aussetzenNachAufnahme;
    private final JCheckBox getaussetzenNachAufnahme;

    private final JLabel keinDoppelbauer;
    private final JCheckBox getkeinDoppelbauer;

    private final JButton speichern;

    /**
     * Instantiates a new Einstellungen.
     *
     * @param saveData the save data
     */
    public Einstellungen(SaveData saveData) {

        setTitle("Einstellungen");

        this.saveData = saveData;

        try {
            bufferedImage = ImageIO.read(new File("Hintergründe/Einstellungen_Hindergrund.png"));
        } catch (Exception e) {
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
        String[] allesprachen = {
                "Deutsch",
                "Français",
                "English"

        };
        sprachen = new JComboBox(allesprachen);
        freiwilligeAufnahme = new JLabel("Freiwillige Aufnahme");
        getfreiwilligeAufnahme = new JCheckBox();
        aussetzenNachAufnahme = new JLabel("Aussetzen");
        getaussetzenNachAufnahme = new JCheckBox();
        keinDoppelbauer = new JLabel("Kein Doppelbauer");
        getkeinDoppelbauer = new JCheckBox();
        speichern = new JButton("Speichern");
        speichern.addActionListener(e -> MenuController.saveEinstellungen(this, getnurEineRunde, maxpunkte, getfreiwilligeAufnahme, getaussetzenNachAufnahme, getkeinDoppelbauer, saveData));

        saveData.readfile(getnurEineRunde, maxpunkte, getfreiwilligeAufnahme, getaussetzenNachAufnahme, getkeinDoppelbauer);

        backgroundPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        add(backgroundPanel);
        init();
        pack();
        setVisible(true);
        setResizable(false);
    }

    /**
     * Init.
     */
    public void init() {

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


    /**
     * The type Background j panel.
     */
    class BackgroundJPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

}
