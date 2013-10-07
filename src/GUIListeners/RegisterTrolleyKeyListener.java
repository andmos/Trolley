package GUIListeners;

import GUI.RegisterTrolley;
import TrolleyRegistration.FlightRoute;
import TrolleyRegistration.Trolley;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author havard
 */
public class RegisterTrolleyKeyListener implements KeyListener{
        private RegisterTrolley registertrolley;
        private JTextField routeNr;
        private JTextField destination;
        private String routeNrS;
        private String destinationS;

    public RegisterTrolleyKeyListener(RegisterTrolley registertrolley){
        this.registertrolley = registertrolley;
    }

    public void setRouteNr(JTextField routeNr) {
        this.routeNr = routeNr;
    }

    public void setDestination(JTextField destination) {
        this.destination = destination;
    }
        
        
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            if(routeNr.getText()!=null){
                routeNrS = routeNr.getText();
            if(destination!=null){
                destinationS = destination.getText();
            }
            if(routeNrS == null || routeNrS.equals("")){
                System.out.println("feilmelding ang rute nr");
            }
            else if(destinationS == null || destinationS.equals("")){
                System.out.println("feilmelding ang destinasjon");
            }else{
                registertrolley.trolleyApp.xmlp.getFlightRoutes().add(new FlightRoute(99, routeNrS,destinationS));
                registertrolley.trolleyApp.revalidate();
                registertrolley.trolleyApp.repaint();
            }
        }
    }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
