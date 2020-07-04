package TschauSepp.view;

import TschauSepp.model.Spiel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 04.07.2020
 */
public class Farbwahl extends JDialog {

    /**
     * The Buffered image.
     */
    BufferedImage bufferedImage = null;

    /**
     * The Background j panel.
     */
    BackgroundJPanel backgroundJPanel;

    /**
     * The Spiel.
     */
    Spiel spiel;

    /**
     * The Farbe 1.
     */
    JButton farbe1;
    /**
     * The Farbe 2.
     */
    JButton farbe2;
    /**
     * The Farbe 3.
     */
    JButton farbe3;
    /**
     * The Farbe 4.
     */
    JButton farbe4;

    /**
     * Instantiates a new Farbwahl.
     *
     * @param spiel the spiel
     */
    public Farbwahl(Spiel spiel) {

        try {
            bufferedImage = ImageIO.read(new File("Hintergründe/Farbauswahl_hintergrund.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.spiel = spiel;

        backgroundJPanel = new BackgroundJPanel();
        farbe1 = new JButton();
        farbe2 = new JButton();
        farbe3 = new JButton();
        farbe4 = new JButton();

        backgroundJPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        add(backgroundJPanel);
        pack();
        init();
        setVisible(true);
        setResizable(false);

    }

    /**
     * Init.
     */
    public void init() {

        GridLayout gridLayout = new GridLayout(1, 4);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        Border border = BorderFactory.createEmptyBorder(14, 10, 14, 10);

        backgroundJPanel.setBorder(border);
        backgroundJPanel.setLayout(gridLayout);

        imageIcons();

        backgroundJPanel.add(farbe1);
        backgroundJPanel.add(farbe2);
        backgroundJPanel.add(farbe3);
        backgroundJPanel.add(farbe4);

    }

    /**
     * Image icons.
     */
    public void imageIcons() {

        String farbe = "" + spiel.getObersteKarte().getFarbe();

        if (farbe.equalsIgnoreCase("Schilten") || farbe.equalsIgnoreCase("Schellen") || farbe.equalsIgnoreCase("Rosen") || farbe.equalsIgnoreCase("Eichel")) {

            URL path1 = getClass().getResource("../img/Background/Schellen.png");
            ImageIcon imageIcon1 = new ImageIcon(path1);
            Image image1 = imageIcon1.getImage();
            Image newimg1 = image1.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon1 = new ImageIcon(newimg1);
            farbe1.setIcon(imageIcon1);

            URL path2 = getClass().getResource("../img/Background/Schilten.png");
            ImageIcon imageIcon2 = new ImageIcon(path2);
            Image image2 = imageIcon2.getImage();
            Image newimg2 = image2.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg2);
            farbe2.setIcon(imageIcon2);

            URL path3 = getClass().getResource("../img/Background/Rosen.png");
            ImageIcon imageIcon3 = new ImageIcon(path3);
            Image image3 = imageIcon3.getImage();
            Image newimg3 = image3.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon3 = new ImageIcon(newimg3);
            farbe3.setIcon(imageIcon3);

            URL path4 = getClass().getResource("../img/Background/Eichel.png");
            ImageIcon imageIcon4 = new ImageIcon(path4);
            Image image4 = imageIcon4.getImage();
            Image newimg4 = image4.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon4 = new ImageIcon(newimg4);
            farbe4.setIcon(imageIcon4);

        } else {

            URL path1 = getClass().getResource("../img/Background/Herz.png");
            ImageIcon imageIcon1 = new ImageIcon(path1);
            Image image1 = imageIcon1.getImage();
            Image newimg1 = image1.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon1 = new ImageIcon(newimg1);
            farbe1.setIcon(imageIcon1);

            URL path2 = getClass().getResource("../img/Background/Ecke.png");
            ImageIcon imageIcon2 = new ImageIcon(path2);
            Image image2 = imageIcon2.getImage();
            Image newimg2 = image2.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon2 = new ImageIcon(newimg2);
            farbe2.setIcon(imageIcon2);

            URL path3 = getClass().getResource("../img/Background/Kreuz.png");
            ImageIcon imageIcon3 = new ImageIcon(path3);
            Image image3 = imageIcon3.getImage();
            Image newimg3 = image3.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon3 = new ImageIcon(newimg3);
            farbe3.setIcon(imageIcon3);

            URL path4 = getClass().getResource("../img/Background/Schaufel.png");
            ImageIcon imageIcon4 = new ImageIcon(path4);
            Image image4 = imageIcon4.getImage();
            Image newimg4 = image4.getScaledInstance(120, 200, java.awt.Image.SCALE_SMOOTH);
            imageIcon4 = new ImageIcon(newimg4);
            farbe4.setIcon(imageIcon4);
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
