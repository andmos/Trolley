
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * This class represents the main menu of the application.
 * @author haavamoa
 */
public class MainMenu {
    private TrolleyApp trolleyApp;
    public JPanel normalMenu = new JPanel();
    public JPanel adminMenu = new JPanel();
    public JPanel logoPanel = new JPanel();
    private Action goToInnreg;
    private Action goToFlightList;
    private Action goToChangeFlightRoute;
    private Action goToAddFlightRoute;

    public MainMenu(TrolleyApp trolleyApp) {
        this.trolleyApp = trolleyApp;
        trolleyApp.requestFocus();
         trolleyApp.removeAll();
        trolleyApp.revalidate();
        trolleyApp.repaint();
        trolleyApp.setLayout(new BorderLayout());
        setActions();
        setKeyBindings();
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
       button = new JButton(goToInnreg);
       button.setText("Innregistrering");
       menuButtonSetup(button);
       c.gridy = 0;
       
       normalMenu.add(button,c);
       label = new JLabel("1. ");
       c.gridx = 0;
       normalMenu.add(label,c);
       
       c.gridx = 1;
       button = new JButton(goToFlightList);
       button.setText("Flyliste / Rapport");
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
       button = new JButton(goToChangeFlightRoute);
       button.setText("Endre flyrute");
       menuButtonSetup(button);
       adminMenu.add(button,c);
       
       c.insets = new Insets(0, 20, 0, 0);
       label = new JLabel("4. ");
       adminMenu.add(label,c);
       c.insets = new Insets(0, 0, 0, 0);
       button = new JButton(goToAddFlightRoute);
       button.setText("Legg til flyrute");
       menuButtonSetup(button);
       adminMenu.add(button,c);
       
       trolleyApp.add(adminMenu,BorderLayout.SOUTH); //Add to main panel.
   }
    
    private void setKeyBindings(){
        String action = "";
        String key = "";
        //Binding 1 to a action
        action = "goToInnreg";
        key = "1";
        this.trolleyApp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), action);
        this.trolleyApp.getActionMap().put(action, goToInnreg);
        //Binding 2 to a action
        action="goToFlightList";
        key = "2";
        this.trolleyApp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), action);
        this.trolleyApp.getActionMap().put(action, goToFlightList);
        //Binding 3 to a action
        action = "goToChangeFlightRoute";
        key = "3";
        this.trolleyApp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), action);
        this.trolleyApp.getActionMap().put(action, goToChangeFlightRoute);
        //Binding 4 to a action
        action = "goToAddFlightRoute";
        key = "4";
        this.trolleyApp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), action);
        this.trolleyApp.getActionMap().put(action, goToAddFlightRoute);
        
        
        
    }
    private void setActions(){
        goToInnreg = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterTrolley(trolleyApp);
                removeActions();
            }
        };
        goToFlightList = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new FlightList();
                removeActions();
            }
        };
        goToChangeFlightRoute = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Endre flyrute kommer senere");
                removeActions();
            }
        };
        goToAddFlightRoute = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Legge til flyrute kommer senere");
                removeActions();
            }
        };
    }
    
    private void removeActions(){

        goToInnreg = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        goToFlightList = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        goToChangeFlightRoute = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        
        goToAddFlightRoute = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        setKeyBindings();
    }
    
}
