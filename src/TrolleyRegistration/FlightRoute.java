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
       
        private String til; 
        
        public FlightRoute( String til){
            
            this.til = til;
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
