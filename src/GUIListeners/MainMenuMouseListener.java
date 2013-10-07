/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.RegisterTrolley;
import GUI.TrolleyApp;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author haavamoa
 */
public class MainMenuMouseListener implements MouseListener{
    private JButton button;
    private TrolleyApp trolleyApp;
    
    public MainMenuMouseListener(JButton button,TrolleyApp trolleyApp) {
        this.button = button;
        this.trolleyApp = trolleyApp;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(button.getText().equalsIgnoreCase("innregistrering")){
            RegisterTrolley regTrolley = new RegisterTrolley(trolleyApp);
        }
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
