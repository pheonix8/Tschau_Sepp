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
public class Menu extends JFrame {

    /**
     * The Buffered image.
     */
    BufferedImage bufferedImage = null;
    /**
     * The Settingsicon.
     */
    ImageIcon settingsicon = new ImageIcon("Hintergründe/Einstellungen_icon.png");
    /**
     * The Save data.
     */
    SaveData saveData = new SaveData();

    /**
     * The Background panel.
     */
    BackgroundJPanel backgroundPanel;

    /**
     * The Einstellungs panel.
     */
    JPanel einstellungsPanel;

    /**
     * The Einstellungen.
     */
    JButton einstellungen;

    /**
     * The Starteinstellungen.
     */
    JPanel starteinstellungen;

    /**
     * The Combobox panel.
     */
    JPanel comboboxPanel;

    /**
     * The Deckart.
     */
    JComboBox deckart;
    /**
     * The Art.
     */
    String[] art = {
            "Schweizer Deck",
            "Französisches Deck"
    };

    /**
     * The Anzspieler.
     */
    JComboBox anzspieler;
    /**
     * The Anzahl.
     */
    String[] anzahl = {
            "2 Spieler",
            "3 Spieler",
            "4 Spieler",
            "5 Spieler",
            "6 Spieler",
            "7 Spieler"
    };

    /**
     * The Player panel.
     */
    JPanel playerPanel;

    /**
     * The Player 1.
     */
    JTextField player1;
    /**
     * The Player 2.
     */
    JTextField player2;
    /**
     * The Player 3.
     */
    JTextField player3;
    /**
     * The Player 4.
     */
    JTextField player4;
    /**
     * The Player 5.
     */
    JTextField player5;
    /**
     * The Player 6.
     */
    JTextField player6;
    /**
     * The Player 7.
     */
    JTextField player7;

    /**
     * The Start panel.
     */
    JPanel startPanel;

    /**
     * The Start.
     */
    JButton start;

    /**
     * Instantiates a new Menu.
     */
    public Menu() {

        super("Tschau Sepp");

        try {
            bufferedImage = ImageIO.read(new File("Hintergründe/Tschau_Sepp_Menu.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        backgroundPanel = new BackgroundJPanel();
        einstellungsPanel = new JPanel();
        einstellungen = new JButton();
        einstellungen.addActionListener(e -> MenuController.onClickEinstellungen(saveData));

        starteinstellungen = new JPanel();
        comboboxPanel = new JPanel();
        deckart = new JComboBox(art);
        anzspieler = new JComboBox(anzahl);
        anzspieler.addActionListener(e -> MenuController.onAnzSelection(anzspieler, player3, player4, player5, player6, player7));

        playerPanel = new JPanel();
        player1 = new JTextField("player1");
        player2 = new JTextField("player2");
        player3 = new JTextField("player3");
        player3.setVisible(false);
        player4 = new JTextField("player4");
        player4.setVisible(false);
        player5 = new JTextField("player5");
        player5.setVisible(false);
        player6 = new JTextField("player6");
        player6.setVisible(false);
        player7 = new JTextField("player7");
        player7.setVisible(false);
        startPanel = new JPanel();
        start = new JButton("Start");
        start.addActionListener(e -> MenuController.onClickStart(anzspieler,player1,player2,player3,player4,player5,player6,player7,deckart, this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backgroundPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        backgroundPanel.setLayout(new BorderLayout());
        add(backgroundPanel);
        upperPanel();
        starteinstellungsPanel();
        lowerPanel();
        pack();
        setVisible(true);
        setResizable(false);
    }

    /**
     * Upper panel.
     */
    public void upperPanel() {
        einstellungen.setBorderPainted(false);
        einstellungen.setFocusPainted(false);
        einstellungen.setIcon(settingsicon);

        Border upperBorer = BorderFactory.createEmptyBorder(15, 30, 15, 1800);

        einstellungsPanel.setBorder(upperBorer);
        einstellungsPanel.add(einstellungen);
        einstellungsPanel.setOpaque(false);

        backgroundPanel.add(einstellungsPanel, BorderLayout.NORTH);
    }

    /**
     * Starteinstellungs panel.
     */
    public void starteinstellungsPanel() {
        starteinstellungen.setLayout(new BorderLayout());
        starteinstellungen.setOpaque(false);

        Border border = BorderFactory.createEmptyBorder(350, 750, 200, 750);

        starteinstellungen.setBorder(border);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(2);
        gridLayout.setColumns(1);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);

        comboboxPanel.setLayout(gridLayout);

        comboboxPanel.setOpaque(false);

        comboboxPanel.add(deckart);
        comboboxPanel.add(anzspieler);

        gridLayout.setRows(4);
        gridLayout.setColumns(2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        playerPanel.setLayout(gridLayout);
        playerPanel.setOpaque(false);

        playerPanel.add(player1);
        playerPanel.add(player2);
        playerPanel.add(player3);
        playerPanel.add(player4);
        playerPanel.add(player5);
        playerPanel.add(player6);
        playerPanel.add(player7);

        starteinstellungen.add(comboboxPanel, BorderLayout.NORTH);
        starteinstellungen.add(playerPanel, BorderLayout.CENTER);
        backgroundPanel.add(starteinstellungen, BorderLayout.CENTER);
    }

    /**
     * Lower panel.
     */
    public void lowerPanel() {

        Border lowerborder = BorderFactory.createEmptyBorder(0, 750, 100, 750);

        startPanel.setLayout(new BorderLayout());

        startPanel.setBorder(lowerborder);
        startPanel.add(start, BorderLayout.CENTER);
        startPanel.setOpaque(false);

        backgroundPanel.add(startPanel, BorderLayout.SOUTH);
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

