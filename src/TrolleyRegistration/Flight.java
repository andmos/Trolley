/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrolleyRegistration;

import java.util.ArrayList;

/**
 *
 * @author andreasmosti
 */
public class Flight {
        
        FlightRoute flightRoute; 
        ArrayList<Trolley> trolleysOnFlight = new ArrayList<Trolley>(); 
        
        public Flight(FlightRoute flightRoute){
            this.flightRoute = flightRoute; 
        }
        public void addTrolleyToFlight(Trolley newTrolley){
            if(newTrolley.getPayLoad() > 0){
                trolleysOnFlight.add(newTrolley);
            }
        }
        
        public int getTotalPayloadOnFlight(){
            int sum = 0; 
            for(Trolley t : trolleysOnFlight){
                sum += t.getPayLoad(); 
            }
            return sum; 
        }
        public void clearTrolleysOnFlight(){
            trolleysOnFlight.clear(); 
        }
       
        public String getTrolleysOnFlight(){
            String res = ""; 
            for(Trolley t : trolleysOnFlight){
                res += t.toString() + '\n'; 
            }
            return res; 
        }
        
        @Override
        public String toString(){
            return flightRoute.toString() + " Total weight on flight: " + getTotalPayloadOnFlight(); 
        }
}
