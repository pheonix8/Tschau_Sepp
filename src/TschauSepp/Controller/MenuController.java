package TschauSepp.Controller;

import TschauSepp.view.*;

import javax.swing.*;

/**
 * Project Tschau_Sepp
 *
 * @author Leo Oetterli
 * @version 0.1
 * @since 29.06.2020
 */
public class MenuController {

    public static void onClickEinstellungen(){
        Einstellungen einstellungen = new Einstellungen();
    }

    public static void onAnzSelection(JComboBox anzspieler, JTextField player3, JTextField player4, JTextField player5, JTextField player6, JTextField player7){

        if (anzspieler.getSelectedIndex() == 0){

            player3.setVisible(false);
            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 1){

            player3.setVisible(true);

            player4.setVisible(false);
            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 2){

            player3.setVisible(true);
            player4.setVisible(true);

            player5.setVisible(false);
            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 3){

            player3.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);

            player6.setVisible(false);
            player7.setVisible(false);

        } else if (anzspieler.getSelectedIndex() == 4) {

            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);

            player7.setVisible(false);

        } else {

            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);
            player7.setVisible(true);

        }

    }


}
