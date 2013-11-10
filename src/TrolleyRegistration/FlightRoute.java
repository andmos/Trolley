
package TrolleyRegistration;

/**
 *
 * @author andreasmosti
 */
public class FlightRoute {
       
        private int flightNr;  // entity!
        private String flightRouteNr; 
        private String destination; 
 
        
        public FlightRoute(int flightNr, String flightRouteNr, String til){
            this.flightRouteNr = flightRouteNr; 
            this.destination = til;
            this.flightNr = flightNr;
        }
       
        public int getFlightNr(){
            return flightNr; 
        }
        
        public void setFlightNr(int newFlightNr){
            flightNr = newFlightNr; 
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
            return "Flygning " + flightNr + " " + flightRouteNr + " " + "til " + destination; 
           
        }
}
