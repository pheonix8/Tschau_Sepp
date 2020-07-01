package TschauSepp.view;

import TschauSepp.Controller.SpielController;
import TschauSepp.model.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 *
 */
public class SpielUI extends JFrame implements Observer{

    private Spiel spiel;
    private Spieler spieler;

    private Vector<Spieler> allespieler;

    BufferedImage bufferedImage = null;

    BackgroundJPanel backgroundJPanel;

    JPanel upperPanel;

    JLabel name;
    JPanel punkteliste;
    JTextField punkte1, punkte2, punkte3, punkte4, punkte5, punkte6, punkte7;

    JPanel centerPanel;

    JPanel centerStapelPanel;
    JLabel kartenstapel;
    JLabel ablegestapel;

    JPanel centerTopPanel;
    JLabel obererSpieler1;
    JLabel obererSpieler2;

    JPanel centerLeftPanel;
    JLabel linkerSpieler1;
    JLabel linkerSpieler2;

    JPanel centerRightPanel;
    JLabel rechterSpieler1;
    JLabel rechterSpieler2;

    JPanel lowerPanel;

    JPanel kartenPanel;
    JList kartenListe;
    JScrollPane scrollPane;
    DefaultListModel<ImageIcon> defaultListModel;

    JPanel leftbuttonPanel;
    JButton setzen;
    JButton ziehen;

    JPanel rightbuttonPanel;
    JButton tschau;
    JButton sepp;

    public SpielUI(Spiel spiel, Vector<Spieler> allespieler) {

        super("Tschau Sepp");

        this.spiel = spiel;
        this.spieler = spiel.getAktuellerSpieler();
        this.allespieler = allespieler;

        try {
            bufferedImage = ImageIO.read(new File("Hintergründe/game_holz_hintergrund.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        backgroundJPanel = new BackgroundJPanel();

        upperPanel = new JPanel();
        name = new JLabel();
        
        punkteliste = new JPanel();
        punkte1 = new JTextField();
        punkte2 = new JTextField();
        punkte3 = new JTextField();
        punkte4 = new JTextField();
        punkte5 = new JTextField();
        punkte6 = new JTextField();
        punkte7 = new JTextField();
        punkte1.setEditable(false);
        punkte2.setEditable(false);
        punkte3.setEditable(false);
        punkte4.setEditable(false);
        punkte5.setEditable(false);
        punkte6.setEditable(false);
        punkte7.setEditable(false);
        
        centerPanel = new JPanel();
        
        centerStapelPanel = new JPanel();

        kartenstapel = new JLabel();
        ablegestapel = new JLabel();
        
        centerTopPanel = new JPanel();
        
        obererSpieler1 = new JLabel();
        obererSpieler2 = new JLabel();
        
        centerLeftPanel = new JPanel();
        
        linkerSpieler1 = new JLabel();
        linkerSpieler2 = new JLabel();
        
        centerRightPanel = new JPanel();
        
        rechterSpieler1 = new JLabel();
        rechterSpieler2 = new JLabel();
        
        lowerPanel = new JPanel();

        kartenPanel = new JPanel();
        defaultListModel = new DefaultListModel<>();
        kartenListe = new JList<>(defaultListModel);
        scrollPane = new JScrollPane(kartenListe);
        
        rightbuttonPanel = new JPanel();
        tschau = new JButton("Tschau");
        sepp = new JButton("Sepp");

        leftbuttonPanel = new JPanel();
        setzen = new JButton("Setzen");
        setzen.addActionListener(e -> SpielController.onClickSetzen(spieler,spieler.getKarte(kartenListe.getSelectedIndex()),spiel));
        ziehen = new JButton("Ziehen");
        spiel.getAktuellerSpieler().addObserver(this);
        spiel.addObserver(this);

        backgroundJPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        add(backgroundJPanel);
        backgroundJPanel.setLayout(new BorderLayout(20,20));
        drawUpperpanel();
        drawCenterpanel();
        drawLowerpanel();
        pack();
        setVisible(true);
        setResizable(false);

    }

    public void drawUpperpanel(){

        Collections.sort(allespieler, new Comparator<Spieler>() {
            @Override
            public int compare(Spieler o1, Spieler o2) {
                return o2.getPunkte()-o1.getPunkte();
            }
        });

        Border upperborder = BorderFactory.createEmptyBorder(15,30,0,30);

        upperPanel.setBorder(upperborder);
        upperPanel.setLayout(new BorderLayout(20,20));
        upperPanel.setOpaque(false);

        name.setText(spiel.getAktuellerSpieler().getName());
        name.setForeground(Color.yellow);
        name.setFont(new Font("Serif", Font.BOLD, 30));

        GridLayout punkteLayout = new GridLayout();
        punkteLayout.setVgap(5);
        punkteLayout.setHgap(5);

        if (allespieler.size() == 2){
            punkteLayout = new GridLayout(2,1);
        } else if (allespieler.size() == 3){
            punkteLayout = new GridLayout(3,1);
        } else if (allespieler.size() == 4){
            punkteLayout = new GridLayout(4,1);
        } else if (allespieler.size() == 5){
            punkteLayout = new GridLayout(5,1);
        } else if (allespieler.size() == 6){
            punkteLayout = new GridLayout(6,1);
        } else {
            punkteLayout = new GridLayout(7,1);
        }

        Border punkteborder = BorderFactory.createEmptyBorder(10,10,10,10);

        punkteliste.setBackground(Color.DARK_GRAY);
        punkteliste.setLayout(punkteLayout);
        punkteliste.setBorder(punkteborder);
        punkteliste.setPreferredSize(new Dimension(200,275));

        if (allespieler.size() == 2){
            punkteliste.add(punkte1);
            punkteliste.add(punkte2);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));

        } else if (allespieler.size() == 3){

            punkteliste.add(punkte1);
            punkteliste.add(punkte2);
            punkteliste.add(punkte3);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            punkte3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));

        } else if (allespieler.size() == 4){

            punkteliste.add(punkte1);
            punkteliste.add(punkte2);
            punkteliste.add(punkte3);
            punkteliste.add(punkte4);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            punkte3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            punkte4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));

        } else if (allespieler.size() == 5){

            punkteliste.add(punkte1);
            punkteliste.add(punkte2);
            punkteliste.add(punkte3);
            punkteliste.add(punkte4);
            punkteliste.add(punkte5);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            punkte3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            punkte4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            punkte5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));

        } else if (allespieler.size() == 6){

            punkteliste.add(punkte1);
            punkteliste.add(punkte2);
            punkteliste.add(punkte3);
            punkteliste.add(punkte4);
            punkteliste.add(punkte5);
            punkteliste.add(punkte6);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            punkte3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            punkte4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            punkte5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));
            punkte6.setText(allespieler.get(5).getName() + " : " + Integer.toString(allespieler.get(5).getPunkte()));

        } else {

            punkteliste.add(punkte1);
            punkteliste.add(punkte2);
            punkteliste.add(punkte3);
            punkteliste.add(punkte4);
            punkteliste.add(punkte5);
            punkteliste.add(punkte6);
            punkteliste.add(punkte7);

            punkte1.setText(allespieler.get(0).getName() + " : " + Integer.toString(allespieler.get(0).getPunkte()));
            punkte2.setText(allespieler.get(1).getName() + " : " + Integer.toString(allespieler.get(1).getPunkte()));
            punkte3.setText(allespieler.get(2).getName() + " : " + Integer.toString(allespieler.get(2).getPunkte()));
            punkte4.setText(allespieler.get(3).getName() + " : " + Integer.toString(allespieler.get(3).getPunkte()));
            punkte5.setText(allespieler.get(4).getName() + " : " + Integer.toString(allespieler.get(4).getPunkte()));
            punkte6.setText(allespieler.get(5).getName() + " : " + Integer.toString(allespieler.get(5).getPunkte()));
            punkte7.setText(allespieler.get(6).getName() + " : " + Integer.toString(allespieler.get(6).getPunkte()));

        }

        upperPanel.add(name, BorderLayout.WEST);
        upperPanel.add(punkteliste, BorderLayout.EAST);

        backgroundJPanel.add(upperPanel, BorderLayout.NORTH);

    }

    public void drawCenterpanel(){

        Border centerborder = BorderFactory.createEmptyBorder(0,544,0,544);

        centerPanel.setBorder(centerborder);
        centerPanel.setLayout(new BorderLayout(10,10));
        centerPanel.setOpaque(false);

        Border topborder = BorderFactory.createEmptyBorder(0,1,0,1);

        GridLayout grid12layout = new GridLayout(1,2);

        centerTopPanel.setBorder(topborder);
        centerTopPanel.setLayout(grid12layout);
        centerTopPanel.setOpaque(false);
        centerTopPanel.setPreferredSize(new Dimension(412,120));


        if (allespieler.size() >= 4){
            centerTopPanel.add(obererSpieler1);

            URL path2 = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon3weiter(allespieler,spieler)+"_up.png");
            ImageIcon imageIcon2 = new ImageIcon(path2);
            Image image2 = imageIcon2.getImage();
            Image newimg2 = image2.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg2);

            obererSpieler1.setIcon(imageIcon2);
            obererSpieler1.setVerticalAlignment(JLabel.CENTER);
            obererSpieler1.setHorizontalAlignment(JLabel.CENTER);

        }
        if (allespieler.size() >= 5) {
            centerTopPanel.add(obererSpieler2);

            URL path = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon4weiter(allespieler,spieler)+"_up.png");
            ImageIcon imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            obererSpieler2.setIcon(imageIcon);
            obererSpieler2.setVerticalAlignment(JLabel.CENTER);
            obererSpieler2.setHorizontalAlignment(JLabel.CENTER);

        }

        Border midborder = BorderFactory.createEmptyBorder(68,30,68,30);

        centerStapelPanel.setLayout(grid12layout);
        centerStapelPanel.setBorder(midborder);
        centerStapelPanel.setPreferredSize(new Dimension(412,410));
        centerStapelPanel.setOpaque(false);


        centerStapelPanel.add(ablegestapel);
        centerStapelPanel.add(kartenstapel);

        URL path = getClass().getResource("../img/"+spiel.getObersteKarte().getFarbe()+"-"+spiel.getObersteKarte().getWert()+".gif");
        ImageIcon ablegeIcon = new ImageIcon(path);
        Image image = ablegeIcon.getImage();
        Image newimg = image.getScaledInstance(161, 247, java.awt.Image.SCALE_SMOOTH);
        ablegeIcon = new ImageIcon(newimg);
        ablegestapel.setIcon(ablegeIcon);

        ablegestapel.setVerticalAlignment(JLabel.CENTER);
        ablegestapel.setHorizontalAlignment(JLabel.CENTER);

        URL path2 = getClass().getResource("../img/Background/Background-1.png");
        ImageIcon kartenIcon = new ImageIcon(path2);
        Image image2 = kartenIcon.getImage();
        Image newimg2 = image2.getScaledInstance(161, 247, java.awt.Image.SCALE_SMOOTH);
        kartenIcon = new ImageIcon(newimg2);
        kartenstapel.setIcon(kartenIcon);

        kartenstapel.setVerticalAlignment(JLabel.CENTER);
        kartenstapel.setHorizontalAlignment(JLabel.CENTER);

        GridLayout grid21layout = new GridLayout(2,1);

        centerLeftPanel.setLayout(grid21layout);
        centerLeftPanel.setOpaque(false);

        centerLeftPanel.add(linkerSpieler1);

        URL path3 = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon1weiter(allespieler,spieler)+".png");
        ImageIcon imageIcon = new ImageIcon(path3);
        Image image3 = imageIcon.getImage();
        Image newimg3 = image3.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg3);
        linkerSpieler1.setIcon(imageIcon);
        linkerSpieler1.setVerticalAlignment(JLabel.CENTER);
        linkerSpieler1.setHorizontalAlignment(JLabel.CENTER);

        if (allespieler.size() >= 3){
            centerLeftPanel.add(linkerSpieler2);

            URL path4 = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon2weiter(allespieler,spieler)+".png");
            ImageIcon imageIcon2 = new ImageIcon(path4);
            Image image4 = imageIcon2.getImage();
            Image newimg4 = image4.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg4);
            linkerSpieler2.setIcon(imageIcon2);
            linkerSpieler2.setVerticalAlignment(JLabel.CENTER);
            linkerSpieler2.setHorizontalAlignment(JLabel.CENTER);

        }


        centerRightPanel.setLayout(grid21layout);
        centerRightPanel.setOpaque(false);

        if (allespieler.size() >= 6){

            centerRightPanel.add(rechterSpieler1);

            URL path4 = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon5weiter(allespieler,spieler)+"_right.png");
            ImageIcon imageIcon2 = new ImageIcon(path4);
            Image image4 = imageIcon2.getImage();
            Image newimg4 = image4.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg4);
            rechterSpieler1.setIcon(imageIcon2);
            rechterSpieler1.setVerticalAlignment(JLabel.CENTER);
            rechterSpieler1.setHorizontalAlignment(JLabel.CENTER);
        }


        if (allespieler.size() >= 7){

            centerRightPanel.add(rechterSpieler2);

            URL path4 = getClass().getResource("../img/Background/Background-"+SpielController.getAnzkartenVon6weiter(allespieler,spieler)+"_right.png");
            ImageIcon imageIcon2 = new ImageIcon(path4);
            Image image4 = imageIcon2.getImage();
            Image newimg4 = image4.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg4);
            rechterSpieler2.setIcon(imageIcon2);
            rechterSpieler2.setVerticalAlignment(JLabel.CENTER);
            rechterSpieler2.setHorizontalAlignment(JLabel.CENTER);

        }

        centerPanel.add(centerTopPanel, BorderLayout.NORTH);
        centerPanel.add(centerStapelPanel, BorderLayout.CENTER);
        centerPanel.add(centerLeftPanel, BorderLayout.WEST);
        centerPanel.add(centerRightPanel,BorderLayout.EAST);

        backgroundJPanel.add(centerPanel, BorderLayout.CENTER);

    }

    public void drawLowerpanel(){

        Border lowerborder = BorderFactory.createEmptyBorder(0,450,10,450);

        lowerPanel.setBorder(lowerborder);
        lowerPanel.setLayout(new BorderLayout(10,10));
        lowerPanel.setOpaque(false);

        Border kartenborder = BorderFactory.createEmptyBorder(0,20,0,20);

        kartenPanel.setPreferredSize(new Dimension(850,200));
        kartenPanel.setBorder(kartenborder);
        kartenPanel.setOpaque(false);
        kartenPanel.add(scrollPane);

        kartenListe.setLayoutOrientation(JList.VERTICAL_WRAP);
        kartenListe.setVisibleRowCount(1);

        scrollPane.setPreferredSize(new Dimension(840,190));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ladebilder();

        lowerPanel.add(kartenPanel, BorderLayout.CENTER);

        GridLayout gridLayout = new GridLayout(2,1);
        gridLayout.setVgap(50);
        gridLayout.setHgap(5);

        leftbuttonPanel.setLayout(gridLayout);
        leftbuttonPanel.setOpaque(false);

        leftbuttonPanel.add(setzen);
        leftbuttonPanel.add(ziehen);

        rightbuttonPanel.setLayout(gridLayout);
        rightbuttonPanel.setOpaque(false);

        rightbuttonPanel.add(tschau);
        rightbuttonPanel.add(sepp);

        lowerPanel.add(leftbuttonPanel, BorderLayout.WEST);
        lowerPanel.add(rightbuttonPanel, BorderLayout.EAST);

        backgroundJPanel.add(lowerPanel, BorderLayout.SOUTH);

    }

    private void ladebilder(){

        defaultListModel.removeAllElements();

        for (int i = 0; i < spieler.getHandSize(); i++) {

            URL path2 = getClass().getResource("../img/"+spieler.getKarte(i).getFarbe()+"-"+spieler.getKarte(i).getWert()+".gif");
            ImageIcon imageIcon2 = new ImageIcon(path2);
            Image image2 = imageIcon2.getImage();
            Image newimg2 = image2.getScaledInstance(115, 170, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg2);
            defaultListModel.addElement(imageIcon2);
        }


    }

    @Override
    public void update(Observable o, Object arg) {

        spieler = spiel.getAktuellerSpieler();
        name.setText(spieler.getName());

        drawUpperpanel();
        drawCenterpanel();

        ladebilder();
        kartenListe.updateUI();

    }

    class BackgroundJPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

}
