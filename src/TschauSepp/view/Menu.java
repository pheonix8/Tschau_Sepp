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

    public Menu(){

        super("Tschau Sepp");

        try{
            bufferedImage = ImageIO.read(new File("Hintergründe/Tschau_Sepp_Menu.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

        MyJPanel p = new MyJPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        add(p);
        pack();
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        new Menu();
    }


    class MyJPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }
}

