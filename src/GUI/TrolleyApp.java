/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HelpClasses.XMLParser;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 * Trolley is a application made for Posten Norge.
 * @author haavamoa
 */
public class TrolleyApp extends JPanel {
    //Variables to use when constructing GUI.
//private static int SCREEN_HEIGTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
//private static int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
final GridBagConstraints c = new GridBagConstraints();
private XMLParser xmlp = new XMLParser();
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
    }
    /**
     * The visual setup of the menu options.
     */
    private void menuSetup(){
        
        for (int i = 1; i <= 7; i++) {
            JLabel number = new JLabel(i+" ");
            c.gridx=0;
            c.gridy = i;
            add(number,c);
        }
        //Innregistrering
        JButton inReg = new JButton("Innregistrering");
        menuButtonSetup(inReg);
        c.gridx = 1;
        c.gridy = 1;
        add(inReg,c);
        //Vareregister
        JButton itemReg = new JButton("Vareregister");
        menuButtonSetup(itemReg);
        c.gridy = c.gridy+1;
        add(itemReg,c);
        //Fly-reigister
        JButton flightReg = new JButton("Fly-register");
        menuButtonSetup(flightReg);
        c.gridy = c.gridy+1;
        add(flightReg,c);
        //Vogn-register
        JButton trolleyReg = new JButton("Vogn-register");
        menuButtonSetup(trolleyReg);
        c.gridy = c.gridy+1;
        add(trolleyReg,c);
        //Flyliste TRAFIKK/POST
        JButton flightList = new JButton("Flyliste TRAFIKK/POST");
        menuButtonSetup(flightList);
        c.gridy = c.gridy+1;
        add(flightList,c);
        //Kopi av vogn-tag
        JButton trolleyTagCopy = new JButton("Kopi av vogn-tag");
        menuButtonSetup(trolleyTagCopy);
        c.gridy = c.gridy+1;
        add(trolleyTagCopy,c);
        //Statistikk
        JButton statistics = new JButton("Statistikk");
        menuButtonSetup(statistics);
        c.gridy = c.gridy+1;
        add(statistics,c);
        
    }
    private void trolleySetup(){
        trolleys = new JList(xmlp.trolleys.toArray());
        c.gridx = 2;
        c.gridy = 1;
        add(trolleys,c);
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
