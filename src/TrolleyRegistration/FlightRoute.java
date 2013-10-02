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
        private String til; 
        
        public FlightRoute(String flightRouteNr, String til){
            this.flightRouteNr = flightRouteNr; 
            this.til = til;
        }
       
        public String getFlightRouteNr(){
            return flightRouteNr; 
        }
        
        public void setFlightRouteNr(String newNumber){
            flightRouteNr = newNumber; 
        }
        
        public String getTil(){
            return til; 
        }
      
        public void setTil(String nyTilPlass){
            til = nyTilPlass; 
        }
     
        @Override
        public String toString(){
            return "Flygning " + til + "til "; 
           
        }
}
