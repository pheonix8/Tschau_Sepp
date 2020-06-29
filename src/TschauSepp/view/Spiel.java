package TschauSepp.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.jar.JarEntry;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 */
public class Spiel extends JFrame {

    BufferedImage bufferedImage = null;

    BackgroundJPanel backgroundJPanel;

    JPanel upperPanel;

    JLabel name;
    JLabel obererSpieler1;
    JLabel obererSpieler2;

    JPanel punkteliste;

    JTextField punkte1;
    JTextField punkte2;
    JTextField punkte3;
    JTextField punkte4;
    JTextField punkte5;
    JTextField punkte6;
    JTextField punkte7;

    JLabel mittlererSpieler1;
    JLabel fill1;
    JLabel fill2;
    JLabel mittlererSpieler2;

    JLabel untererSpieler1;
    JLabel kartenstapel;
    JLabel ablegestapel;
    JLabel untererSpieler2;

    JPanel lowerPanel;

    JButton tschau;
    JButton sepp;

    public Spiel(){

        super("Tschau Sepp");

        try{
            bufferedImage = ImageIO.read(new File(""));
        }catch(Exception e) {
            e.printStackTrace();
        }

        backgroundJPanel = new BackgroundJPanel();
        backgroundJPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));

        add(backgroundJPanel);
        pack();
        setVisible(true);
        setResizable(false);

        }

    public static void main(String[] args) {
        Spiel spiel = new Spiel();
    }

    class BackgroundJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

}
