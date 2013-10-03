/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUIListeners.MenuButtonMouseListener;
import HelpClasses.XMLFileParser;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * Trolley is a application made for Posten Norge.
 * @author haavamoa
 */
public class TrolleyApp extends JPanel {
    //Variables to use when constructing GUI.
private static int SCREEN_HEIGTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
private static int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
final GridBagConstraints c = new GridBagConstraints();
private XMLFileParser xmlp = new XMLFileParser();
private JList trolleys;

    public TrolleyApp() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800, 600));
        menuSetup();
    }
    /**
     * Visual options for menu-buttons.
     * @param button 
     */
    public void menuButtonSetup(JButton button){
        int buttonWidth = 200;
        int buttonHeight = 20;
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setOpaque(false);
       button.setContentAreaFilled(true);
       // button.setBorderPainted(false);
       button.setFocusPainted(false);
     //   button.setBorder(null);
       button.addMouseListener(new MenuButtonMouseListener(this,button));
    }
    /**
     * The visual setup of the menu options.
     */
    private void menuSetup(){
        
        String[] buttons = {"Innregistrering","Vareregister","Fly-register","Vognr-egister","Flyliste TRAFIKK/POST","Kopi av vogn-tag","Statistikk"};
        
        c.gridx =1;
        for (int i = 0; i < buttons.length; i++) {
            JButton menuButton = new JButton(buttons[i]);
            menuButtonSetup(menuButton);
            c.gridy = i;
            add(menuButton,c);
            
        }
    }
        public void setupTrolleys(){
            JList list = new JList(xmlp.getTrolleys().toArray());
            removeAll();
            add(list);
            revalidate();
            repaint();
    }
    
    /**
     * Main method witch will start the application.
     * @param args 
     */
     public static void main(String[] args) {
        JFrame frame = new JFrame("Trolley");
        frame.setContentPane(new TrolleyApp());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
