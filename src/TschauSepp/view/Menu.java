package TschauSepp.view;

import javax.imageio.ImageIO;
import javax.swing.*;
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

    JButton einstellungen;

    JPanel starteinstellungen;

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

    JPanel playerpanel;

    JTextField player1;
    JTextField player2;
    JTextField player3;
    JTextField player4;
    JTextField player5;
    JTextField player6;
    JTextField player7;

    JButton start;

    public Menu(){

        super("Tschau Sepp");

        try{
            bufferedImage = ImageIO.read(new File("Hintergründe/Tschau_Sepp_Menu.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

        backgroundPanel = new BackgroundJPanel();
        einstellungen = new JButton();
        starteinstellungen = new JPanel();
        deckart = new JComboBox(art);
        anzspieler = new JComboBox(anzahl);
        playerpanel = new JPanel();
        player1 = new JTextField();
        player2 = new JTextField();
        player3 = new JTextField();
        player4 = new JTextField();
        player5 = new JTextField();
        player6 = new JTextField();
        player7 = new JTextField();
        start = new JButton("Start");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        backgroundPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        init();
        add(backgroundPanel);
        pack();
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public void init(){

        backgroundPanel.setLayout(new BorderLayout());

        einstellungen.setBackground(Color.black);
        einstellungen.setIcon(settingsicon);

        backgroundPanel.add(einstellungen, BorderLayout.NORTH);

        starteinstellungen.setLayout(new BorderLayout());

        starteinstellungen.add(deckart, BorderLayout.NORTH);
        starteinstellungen.add(anzspieler, BorderLayout.CENTER);

        playerpanel.setLayout(new GridLayout(4,2));
        playerpanel.add(player1);
        playerpanel.add(player2);
        playerpanel.add(player3);
        playerpanel.add(player4);
        playerpanel.add(player5);
        playerpanel.add(player6);
        playerpanel.add(player7);

        starteinstellungen.add(playerpanel, BorderLayout.SOUTH);

        backgroundPanel.add(starteinstellungen, BorderLayout.CENTER);

        backgroundPanel.add(start, BorderLayout.SOUTH);
    }


    class BackgroundJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}

