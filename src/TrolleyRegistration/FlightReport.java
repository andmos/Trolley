
package TrolleyRegistration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author andreasmosti
 */
public class FlightReport {
        private ArrayList<Flight> allFlights = new ArrayList<Flight>(); 
        private Date dateStamp; 
        
        public FlightReport() {
            dateStamp = new GregorianCalendar().getTime(); 
        }
        
        public ArrayList<Flight> getAllFlights(){
            return allFlights; 
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
