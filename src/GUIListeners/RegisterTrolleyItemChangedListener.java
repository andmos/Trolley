/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.RegisterTrolley;
import TrolleyRegistration.FlightRoute;
import TrolleyRegistration.Trolley;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author haavamoa
 */
public class RegisterTrolleyItemChangedListener implements ItemListener{
    private RegisterTrolley registertrolley;
    private JTextField routeNr;
    private JTextField destination;
    private JComboBox comboBox;
    private JTextField ownWeight;
    public RegisterTrolleyItemChangedListener(JComboBox combobox,RegisterTrolley registertrolley,JTextField routeNr,JTextField destination) {
        this.comboBox = combobox;
        this.registertrolley = registertrolley;
        this.routeNr = routeNr;
        this.destination = destination;
    }
    public RegisterTrolleyItemChangedListener(JComboBox combobox,RegisterTrolley registertrolley,JTextField ownWeigth) {
        this.comboBox = combobox;
        this.registertrolley = registertrolley;
        this.ownWeight = ownWeigth;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(comboBox.getName().equals("flightnr")){ //Do something to flight panel
         if (e.getStateChange() == ItemEvent.SELECTED) {
             int flightNr = Integer.parseInt(e.getItem().toString());
             registertrolley.flightroute.setFlightNr(flightNr);
             if(flightNr!=99){
             for(FlightRoute f:registertrolley.trolleyApp.xmlp.getFlightRoutes())
                if(f.getFlightNr() ==(flightNr)){
                    routeNr.setText(f.getFlightRouteNr());
                    destination.setText(f.getDestination());
                    registertrolley.flightroute.setFlightRouteNr(f.getFlightRouteNr());
                    registertrolley.flightroute.setDestination(f.getDestination());
                    routeNr.disable();
                    destination.disable();
                }
            }else{
               routeNr.setText(null);
               destination.setText(null);
               routeNr.enable();
               destination.enable();
             }
             
    }
        }else{ //Do something to trolley panel
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int trolleyId = Integer.parseInt(e.getItem().toString());
                if(trolleyId != 99){
                    for(Trolley t:registertrolley.trolleyApp.xmlp.getTrolleys()){
                        if(t.getTrolleyId()==trolleyId){
                            ownWeight.setText(t.getOwnWeight()+" kg");
                            registertrolley.basisPanelOwnWeigth.setText(ownWeight.getText());
                            registertrolley.trolley = new Trolley(trolleyId, t.getOwnWeight());
                            ownWeight.disable();
                        }
                    }
                }else{
                    ownWeight.setText("");
                    ownWeight.enable();
                }
                
                registertrolley.activeTrolleyId = trolleyId;;
            }else{
                
            }
        }
        registertrolley.trolleyApp.revalidate();
        registertrolley.trolleyApp.repaint();
    }
}
