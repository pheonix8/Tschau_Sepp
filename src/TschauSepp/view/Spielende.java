package TschauSepp.view;

import TschauSepp.Controller.SpielController;
import TschauSepp.model.Spiel;
import TschauSepp.model.Spieler;

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
 * @since 01.07.2020
 */
public class Spielende extends JDialog {

    private Spiel spiel;
    private Spieler spieler;
    private Menu menu;

    private BufferedImage bufferedImage = null;
    private BackgroundJPanel backgroundJPanel;

    private JPanel buttonPanel;

    private JLabel name;
    private JButton revanche;
    private JButton fertig;

    /**
     * Instantiates a new Spielende.
     *
     * @param spiel   the spiel
     * @param spieler the spieler
     * @param menu    the menu
     */
    public Spielende(Spiel spiel, Spieler spieler, Menu menu) {

        setTitle("Sieger");

        this.spiel = spiel;
        this.spieler = spieler;
        this.menu = menu;

        try {
            bufferedImage = ImageIO.read(new File("Hintergründe/sieger_hintergrund.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        backgroundJPanel = new BackgroundJPanel();
        buttonPanel = new JPanel();

        name = new JLabel();
        revanche = new JButton("Revanche");
        revanche.addActionListener(e -> SpielController.onClickRevanche(spiel, this));
        fertig = new JButton("Fertig");
        fertig.addActionListener(e -> SpielController.onClickBeenden(this));

        backgroundJPanel.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        add(backgroundJPanel);
        init();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * Init.
     */
    public void init() {

        backgroundJPanel.setLayout(new BorderLayout(10, 10));

        backgroundJPanel.add(name, BorderLayout.CENTER);
        name.setText(spieler.getName());
        name.setForeground(Color.yellow);
        name.setFont(new Font("Serif", Font.BOLD, 40));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.BOTTOM);

        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setHgap(50);

        Border border = BorderFactory.createEmptyBorder(100,200,100,200);

        buttonPanel.setLayout(gridLayout);
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(border);

        buttonPanel.add(revanche);
        buttonPanel.add(fertig);

        backgroundJPanel.add(buttonPanel, BorderLayout.SOUTH);


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
