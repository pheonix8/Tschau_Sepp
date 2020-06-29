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
public class Einstellungen extends JDialog {

    BufferedImage bufferedImage = null;

    BackgroundJPanel backgroundPanel;

    public Einstellungen() {

        setTitle("Einstellungen");

        try{
            bufferedImage = ImageIO.read(new File("Hintergründe/Einstellungen_Hindergrund.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

        backgroundPanel = new BackgroundJPanel();

        backgroundPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        add(backgroundPanel);
        pack();
        setVisible(true);
        setResizable(false);
    }

    class BackgroundJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        Einstellungen einstellungen = new Einstellungen();
    }
}
