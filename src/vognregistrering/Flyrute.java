/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vognregistrering;

/**
 *
 * @author andreasmosti
 */
public class Flyrute {
        private String fra; 
        private String til; 
        
        public Flyrute(String fra, String til){
            this.fra = fra; 
            this.til = til;
        }
        public String getFra(){
            return fra;
        }
        public String getTil(){
            return til; 
        }
        public void setFra(String nyFraPlass){
            fra = nyFraPlass; 
        }
        public void setTil(String nyTilPlass){
            til = nyTilPlass; 
        }
     
        @Override
        public String toString(){
            return "Flygning fra " + fra + " Til " + til; 
        }
}
