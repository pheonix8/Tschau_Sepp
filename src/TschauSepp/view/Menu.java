package TschauSepp.view;

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
public class Menu extends JFrame{

    BufferedImage bufferedImage = null;
    ImageIcon settingsicon = new ImageIcon("Hintergründe/Einstellungen_icon.png");

    BackgroundJPanel backgroundPanel;

    JPanel einstellungsPanel;

    JButton einstellungen;

    JPanel starteinstellungen;

    GridBagConstraints gbc = new GridBagConstraints();

    JComboBox deckart;
    String[] art = {
            "Schweizer Deck",
            "Französisches Deck"
    };

    JComboBox anzspieler;
    String[] anzahl = {
            "2 Spieler",
            "3 Spieler",
            "4 Spieler",
            "5 Spieler",
            "6 Spieler",
            "7 Spieler"
    };

    JTextField player1;
    JTextField player2;
    JTextField player3;
    JTextField player4;
    JTextField player5;
    JTextField player6;
    JTextField player7;

    JPanel startPanel;

    JButton start;

    public Menu(){

        super("Tschau Sepp");

        try{
            bufferedImage = ImageIO.read(new File("Hintergründe/Tschau_Sepp_Menu.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

        backgroundPanel = new BackgroundJPanel();
        einstellungsPanel = new JPanel();
        einstellungen = new JButton();
        starteinstellungen = new JPanel();
        deckart = new JComboBox(art);
        anzspieler = new JComboBox(anzahl);
        player1 = new JTextField();
        player2 = new JTextField();
        player3 = new JTextField();
        player4 = new JTextField();
        player5 = new JTextField();
        player6 = new JTextField();
        player7 = new JTextField();
        startPanel = new JPanel();
        start = new JButton("Start");

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

    public void upperPanel(){
        einstellungen.setBackground(Color.black);
        einstellungen.setIcon(settingsicon);

        Border upperBorer = BorderFactory.createEmptyBorder(15,30,15,1800);

        einstellungsPanel.setBorder(upperBorer);
        einstellungsPanel.add(einstellungen);
        einstellungsPanel.setOpaque(false);

        backgroundPanel.add(einstellungsPanel, BorderLayout.NORTH);
    }

    public void starteinstellungsPanel(){
        starteinstellungen.setLayout(new GridBagLayout());

        gbc.gridx = 2;
        gbc.gridy = 1;
        starteinstellungen.add(deckart, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        starteinstellungen.add(anzspieler, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        starteinstellungen.add(player1, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        starteinstellungen.add(player2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        starteinstellungen.add(player3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        starteinstellungen.add(player4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        starteinstellungen.add(player5, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        starteinstellungen.add(player6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        starteinstellungen.add(player7, gbc);

        starteinstellungen.setOpaque(false);
        backgroundPanel.add(starteinstellungen, BorderLayout.CENTER);
    }

    public void lowerPanel(){

        Border lowerborder = BorderFactory.createEmptyBorder(0, 750, 100, 750);

        startPanel.setLayout(new BorderLayout());

        startPanel.setBorder(lowerborder);
        startPanel.add(start, BorderLayout.CENTER);
        startPanel.setOpaque(false);

        backgroundPanel.add(startPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    class BackgroundJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}

