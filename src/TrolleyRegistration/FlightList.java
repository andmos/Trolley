/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrolleyRegistration;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author andreasmosti
 */
public class FlightList {
        
        FlightRoute flightRoute; 
        ArrayList<Trolley> trolleysOnFlight = new ArrayList<Trolley>(); 
        Date timestamp; 
        
        public FlightList(FlightRoute flightRoute){
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
            return flightRoute.toString() + " Total payload on flight: " + getTotalPayloadOnFlight(); 
        }
}
