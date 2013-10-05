
package TrolleyRegistration;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author andreasmosti
 */
public class FlightReport {
        private ArrayList<Flight> allFlights = new ArrayList<Flight>(); 
        private Date dateStamp; 
        
        public FlightReport() {
            dateStamp = new Date(); 
           
        }
        public void addFlightToReport(Flight newFlight){
            allFlights.add(newFlight);
        }
        public void clearFlightReportList(){
            allFlights.clear();
        }
        public Date getDateStamp(){
            return dateStamp; 
        }
        
}
