/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.TrolleyApp;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author haavamoa
 */
public class MenuButtonMouseListener implements java.awt.event.MouseListener{
    private TrolleyApp trolleyApp; //The application, for controlling the GUI.
    private JButton button; //The button you have pressed.
    public MenuButtonMouseListener(TrolleyApp trolleyApp,JButton button) {
        this.trolleyApp = trolleyApp;
        this.button = button;
        
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(button.getText().equalsIgnoreCase("Vareregister")){
            trolleyApp.setupTrolleys();
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
