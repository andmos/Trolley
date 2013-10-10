/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HelpClasses.XMLFileParser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 * Trolley is a application made for Posten Norge.
 * @author haavamoa
 */
public class TrolleyApp extends JPanel {
    //Variables to use when constructing GUI.
private static int SCREEN_HEIGTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
private static int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
public XMLFileParser xmlp = new XMLFileParser();
private JList trolleys;

private int width;
private int height;

    public TrolleyApp(int width,int heigth) {
        this.width = width;
        this.height = heigth;
        setPreferredSize(new Dimension(width, heigth));
        MainMenu mainMenu = new MainMenu(this);
    }
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    /**
     * Main method witch will start the application.
     * @param args 
     */
     public static void main(String[] args) {
        JFrame frame = new JFrame("Trolley");
        frame.setContentPane(new TrolleyApp(800,600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
}
