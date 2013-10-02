/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrolleyRegistration;

/**
 *
 * @author andreasmosti
 */
public class FlightRoute {
       
        private String flightRouteNr; 
        private String destination; 
        
        public FlightRoute(String flightRouteNr, String til){
            this.flightRouteNr = flightRouteNr; 
            this.destination = til;
        }
       
        public String getFlightRouteNr(){
            return flightRouteNr; 
        }
        
        public void setFlightRouteNr(String newNumber){
            flightRouteNr = newNumber; 
        }
        
        public String getDestination(){
            return destination; 
        }
      
        public void setDestination(String nyTilPlass){
            destination = nyTilPlass; 
        }
     
        @Override
        public String toString(){
            return "Flygning " + destination + "til "; 
           
        }
}
