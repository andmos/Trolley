/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.RegisterTrolley;
import GUI.TrolleyApp;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author haavamoa
 */
public class MainMenuKeyListener implements KeyListener{
private TrolleyApp trolleyApp;

    public MainMenuKeyListener(TrolleyApp trolleyApp) {
        this.trolleyApp = trolleyApp;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_1 ){ //RegisterTrolley
            RegisterTrolley regTrolley = new RegisterTrolley(trolleyApp);
        }else if (e.getKeyCode() == KeyEvent.VK_2){ //FlightList/Repport
            System.out.println("Flyliste/Rapport");
        }else if(e.getKeyCode() == KeyEvent.VK_3){ //Change flightroute
            System.out.println("Endre flyrute");
        }else if(e.getKeyCode() == KeyEvent.VK_4){ //Add flightroute
            System.out.println("Legg til flyrute");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
