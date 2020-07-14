package TschauSepp.view;

import TschauSepp.Controller.SpielController;
import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 */
public class SpielUI extends JFrame implements Observer {

    private final Spiel spiel;
    private Spieler spieler;
    private final Vector<Spieler> allespieler;
    private BufferedImage bufferedImage = null;

    private final BackgroundJPanel backgroundJPanel;

    private final JPanel upperPanel;

    private final JLabel name;
    private final Punkteliste punkteliste;

    private final JPanel centerPanel;

    private final JPanel centerStapelPanel;
    private final JPanel centerTopPanel;
    private final JPanel centerLeftPanel;
    private final JPanel centerRightPanel;

    private final JLabel kartenstapel;
    private final JLabel ablegestapel;

    private final JLabel obererSpieler1;
    private final JLabel obererSpieler2;

    private final JLabel linkerSpieler1;
    private final JLabel linkerSpieler2;

    private final JLabel rechterSpieler1;
    private final JLabel rechterSpieler2;

    private final JPanel lowerPanel;
    private final JPanel kartenPanel;
    private final JPanel leftbuttonPanel;
    private final JPanel rightbuttonPanel;

    private final JList kartenListe;
    private final JScrollPane scrollPane;
    private final DefaultListModel<ImageIcon> defaultListModel;

    private final JButton setzen;
    private final JButton ziehen;

    private final JButton tschau;
    private final JButton sepp;

    /**
     * Instantiates a new Spiel ui.
     *
     * @param spiel       the spiel
     * @param allespieler the allespieler
     */
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

        punkteliste = new Punkteliste(allespieler);
        punkteliste.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Uebersicht(allespieler);
            }
        });

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
        tschau.addActionListener(e -> SpielController.onClickTschau(spieler, spiel, tschau));
        sepp = new JButton("Sepp");
        sepp.addActionListener(e -> SpielController.onClickSepp(spieler, spiel, sepp));

        leftbuttonPanel = new JPanel();
        setzen = new JButton("Setzen");
        setzen.addActionListener(e -> SpielController.onClickSetzen(spieler, kartenListe, spiel));
        ziehen = new JButton("Ziehen");
        ziehen.addActionListener(e -> SpielController.onClickZiehen(spiel, spieler, tschau, sepp));
        spiel.getAktuellerSpieler().addObserver(this);
        spiel.addObserver(this);

        backgroundJPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        add(backgroundJPanel);
        backgroundJPanel.setLayout(new BorderLayout(20, 20));
        drawUpperpanel();
        drawCenterpanel();
        drawLowerpanel();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * Draw upperpanel.
     */
    public void drawUpperpanel() {

        Border upperborder = BorderFactory.createEmptyBorder(15, 30, 0, 30);

        upperPanel.setBorder(upperborder);
        upperPanel.setLayout(new BorderLayout(20,20));
        upperPanel.setOpaque(false);

        name.setText(spiel.getAktuellerSpieler().getName());
        name.setForeground(Color.yellow);
        name.setFont(new Font("Serif", Font.BOLD, 30));

        punkteliste.addButton().setPreferredSize(new Dimension(200, 275));

        upperPanel.add(name, BorderLayout.WEST);
        upperPanel.add(punkteliste, BorderLayout.EAST);

        backgroundJPanel.add(upperPanel, BorderLayout.NORTH);

    }

    /**
     * Draw centerpanel.
     */
    public void drawCenterpanel() {

        //Todo Karten anpassen

        Border centerborder = BorderFactory.createEmptyBorder(0, 544, 0, 544);

        centerPanel.setBorder(centerborder);
        centerPanel.setLayout(new BorderLayout(10, 10));
        centerPanel.setOpaque(false);

        Border topborder = BorderFactory.createEmptyBorder(0, 1, 0, 1);

        GridLayout grid12layout = new GridLayout(1, 2);

        centerTopPanel.setBorder(topborder);
        centerTopPanel.setLayout(grid12layout);
        centerTopPanel.setOpaque(false);
        centerTopPanel.setPreferredSize(new Dimension(412,120));


        if (allespieler.size() >= 4) {
            centerTopPanel.add(obererSpieler1);

            URL pathupa = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon3weiter(allespieler, spieler) + "_up.png");
            ImageIcon imageIconupa = new ImageIcon(pathupa);
            Image imageupa = imageIconupa.getImage();
            Image newimgupa = imageupa.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
            imageIconupa = new ImageIcon(newimgupa);

            obererSpieler1.setIcon(imageIconupa);
            obererSpieler1.setVerticalAlignment(JLabel.CENTER);
            obererSpieler1.setHorizontalAlignment(JLabel.CENTER);

        }
        if (allespieler.size() >= 5) {
            centerTopPanel.add(obererSpieler2);

            URL pathupb = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon4weiter(allespieler, spieler) + "_up.png");
            ImageIcon imageIconupb = new ImageIcon(pathupb);
            Image imageupb = imageIconupb.getImage();
            Image newimgupb = imageupb.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
            imageIconupb = new ImageIcon(newimgupb);
            obererSpieler2.setIcon(imageIconupb);
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

        URL path = getClass().getResource("../img/karten/" + spiel.getObersteKarte().getFarbe() + "-" + spiel.getObersteKarte().getWert() + ".gif");
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

        GridLayout grid21layout = new GridLayout(2, 1);

        centerLeftPanel.setLayout(grid21layout);
        centerLeftPanel.setOpaque(false);

        if (allespieler.size() >= 3) {

            centerLeftPanel.add(linkerSpieler1);

            URL pathlu = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon2weiter(allespieler, spieler) + ".png");
            ImageIcon imageIconlu = new ImageIcon(pathlu);
            Image imagelu = imageIconlu.getImage();
            Image newimglu = imagelu.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIconlu = new ImageIcon(newimglu);
            linkerSpieler1.setIcon(imageIconlu);
            linkerSpieler1.setVerticalAlignment(JLabel.CENTER);
            linkerSpieler1.setHorizontalAlignment(JLabel.CENTER);
        }

        centerLeftPanel.add(linkerSpieler2);

        URL pathld = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon1weiter(allespieler, spieler) + ".png");
        ImageIcon imageIconld = new ImageIcon(pathld);
        Image imageld = imageIconld.getImage();
        Image newimgld = imageld.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
        imageIconld = new ImageIcon(newimgld);
        linkerSpieler2.setIcon(imageIconld);
        linkerSpieler2.setVerticalAlignment(JLabel.CENTER);
        linkerSpieler2.setHorizontalAlignment(JLabel.CENTER);

        centerRightPanel.setLayout(grid21layout);
        centerRightPanel.setOpaque(false);

        if (allespieler.size() >= 6) {

            centerRightPanel.add(rechterSpieler1);

            URL pathru = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon5weiter(allespieler, spieler) + "_right.png");
            ImageIcon imageIconru = new ImageIcon(pathru);
            Image imageru = imageIconru.getImage();
            Image newimgru = imageru.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIconru = new ImageIcon(newimgru);
            rechterSpieler1.setIcon(imageIconru);
            rechterSpieler1.setVerticalAlignment(JLabel.CENTER);
            rechterSpieler1.setHorizontalAlignment(JLabel.CENTER);
        }


        if (allespieler.size() >= 7) {

            centerRightPanel.add(rechterSpieler2);

            URL pathrd = getClass().getResource("../img/Background/Background-" + SpielController.getAnzkartenVon6weiter(allespieler, spieler) + "_right.png");
            ImageIcon imageIconrd = new ImageIcon(pathrd);
            Image imagerd = imageIconrd.getImage();
            Image newimgrd = imagerd.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIconrd = new ImageIcon(newimgrd);
            rechterSpieler2.setIcon(imageIconrd);
            rechterSpieler2.setVerticalAlignment(JLabel.CENTER);
            rechterSpieler2.setHorizontalAlignment(JLabel.CENTER);

        }

        centerPanel.add(centerTopPanel, BorderLayout.NORTH);
        centerPanel.add(centerStapelPanel, BorderLayout.CENTER);
        centerPanel.add(centerLeftPanel, BorderLayout.WEST);
        centerPanel.add(centerRightPanel, BorderLayout.EAST);

        backgroundJPanel.add(centerPanel, BorderLayout.CENTER);

    }

    /**
     * Draw lowerpanel.
     */
    public void drawLowerpanel() {

        //Todo Karten anpassen

        Border lowerborder = BorderFactory.createEmptyBorder(0, 450, 10, 450);

        lowerPanel.setBorder(lowerborder);
        lowerPanel.setLayout(new BorderLayout(10, 10));
        lowerPanel.setOpaque(false);

        Border kartenborder = BorderFactory.createEmptyBorder(0, 20, 0, 20);

        kartenPanel.setPreferredSize(new Dimension(850, 200));
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

            URL path2 = getClass().getResource("../img/karten/" + spieler.getKarte(i).getFarbe() + "-" + spieler.getKarte(i).getWert() + ".gif");
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

        upperPanel.removeAll();
        centerPanel.removeAll();
        lowerPanel.removeAll();

        drawUpperpanel();
        drawCenterpanel();
        drawLowerpanel();

        if (spieler.isHatTschau()) {
            tschau.setForeground(Color.green);
        } else {
            tschau.setForeground(Color.black);
        }

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
