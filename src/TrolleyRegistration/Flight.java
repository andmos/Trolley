
package TrolleyRegistration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author andreasmosti
 */
public class Flight {
        
        public FlightRoute flightRoute; 
        public ArrayList<Trolley> trolleysOnFlight = new ArrayList<Trolley>(); 
        public Calendar timestamp;  
        
        public Flight(FlightRoute flightRoute){
            this.flightRoute = flightRoute; 
            
        }

    public Flight() {
        
    }
        public FlightRoute getFlightRoute(){
            return flightRoute; 
        }
        
        public void setFlightRoute(FlightRoute newFlightRoute){
            flightRoute = newFlightRoute; 
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
       
        public ArrayList<Trolley> getTrolleysOnFlight(){ 
            
            return trolleysOnFlight; 
        }
        
        public void setTimeStamp(){
            timestamp = new GregorianCalendar();
        }
        
        @Override
        public String toString(){
            return flightRoute.toString() + " Total payload on flight: " + getTotalPayloadOnFlight(); 
        }
}
