
package GUI;

import GUIListeners.MainMenuKeyListener;
import GUIListeners.MainMenuMouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the main menu of the application.
 * @author haavamoa
 */
public class MainMenu {
    private TrolleyApp trolleyApp;
    public JPanel normalMenu = new JPanel();
    public JPanel adminMenu = new JPanel();
    public JPanel logoPanel = new JPanel();

    public MainMenu(TrolleyApp trolleyApp) {
        this.trolleyApp = trolleyApp;
         trolleyApp.removeAll();
        trolleyApp.revalidate();
        trolleyApp.repaint();
        trolleyApp.setLayout(new BorderLayout());
        normalMenuSetup();
        adminMenuSetup();
        setupLogoPanel();
    }
    
    /**
     * Visual options for menu-buttons.
     * @param button 
     */
    public void menuButtonSetup(JButton button){
       int buttonWidth = 200;
       int buttonHeight = 50;
       button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
       /*button.setOpaque(false);
       button.setContentAreaFilled(true);
       button.setBorderPainted(false);
       button.setFocusPainted(false);
       button.setBorder(null);*/
       button.addMouseListener(new MainMenuMouseListener(button,trolleyApp));
       button.addKeyListener(new MainMenuKeyListener(trolleyApp));
    }
    /**
     *  Setup the logo panel.
     */
    private void setupLogoPanel(){
        logoPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),140));
        logoPanel.setBackground(Color.white);
        JLabel logo = new JLabel();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/res/posten_bkup.jpg"));
        logo.setIcon(image);
        logoPanel.add(logo);
        trolleyApp.add(logoPanel,BorderLayout.NORTH); //Add to main panel.
    }
    /**
     * Setup the menu for a normal user.
     */
   private void normalMenuSetup(){
       normalMenu.setPreferredSize(new Dimension(trolleyApp.getWidth(),180));
       normalMenu.setLayout(new GridBagLayout());
       normalMenu.setBackground(Color.white);
       JButton button;
       JLabel label;
       GridBagConstraints c = new GridBagConstraints();
       c.gridx = 1;
       
       button = new JButton("Innregistrering");
       c.gridy = 0;
       menuButtonSetup(button);
       normalMenu.add(button,c);
       label = new JLabel("1. ");
       c.gridx = 0;
       normalMenu.add(label,c);
       
       c.gridx = 1;
       button = new JButton("Flyliste/Rapport");
       menuButtonSetup(button);
       c.gridy = 1;
       normalMenu.add(button,c);
       label = new JLabel("2. ");
       c.gridx = 0;
       normalMenu.add(label,c);
       
       trolleyApp.add(normalMenu,BorderLayout.CENTER); //Add to main panel.
   }
   /**
    * Setup the menu for a administration user.
    */
   private void adminMenuSetup(){  
       adminMenu.setPreferredSize(new Dimension(trolleyApp.getWidth(),100));
       adminMenu.setLayout(new GridBagLayout());
       adminMenu.setBackground(Color.white);
       GridBagConstraints c = new GridBagConstraints();
       JButton button;
       JLabel label;
       
       c.insets = new Insets(0, trolleyApp.getWidth()-400, 0, 0);
       label = new JLabel("3. ");
       adminMenu.add(label,c);
       c.insets = new Insets(0, 0, 0, 0);      
       c.ipady = 50;
       button = new JButton("Endre flyrute");
       menuButtonSetup(button);
       adminMenu.add(button,c);
       
       c.insets = new Insets(0, 20, 0, 0);
       label = new JLabel("4. ");
       adminMenu.add(label,c);
       c.insets = new Insets(0, 0, 0, 0);
       button = new JButton("Legg til flyrute");
       menuButtonSetup(button);
       adminMenu.add(button,c);
       
       trolleyApp.add(adminMenu,BorderLayout.SOUTH); //Add to main panel.
   }
    
    
    
    
}
