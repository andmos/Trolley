/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HelpClasses.XMLFileParser;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Trolley is a application made for Posten Norge.
 * @author haavamoa
 */
public class TrolleyApp extends JPanel {
private static int SCREEN_HEIGTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
private static int SCREEN_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();

    public TrolleyApp() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(SCREEN_HEIGTH, SCREEN_WIDTH));
        
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
