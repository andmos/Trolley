
package TrolleyRegistration;


public class Trolley {
    
    private int trolleyNr; 
    private int ownWeight; 
    private int totalWeight; 
    
    public Trolley(int vognNr, int egenVekt){
        this.trolleyNr = vognNr; 
        this.ownWeight = egenVekt;
        this.totalWeight = ownWeight; 
        
    }
    
    public int getTrolleyNr(){
        return trolleyNr; 
    }
    
    public void setTrolleyNr(int nyttNr){
        trolleyNr = nyttNr; 
    }
    
    public int getOwnWeight(){
        return ownWeight; 
    }
    
    public void setOwnWeight(int nyEgenvekt){
        ownWeight = nyEgenvekt; 
    }
    
    public int getTotalWeight(){
        return totalWeight; 
    }
    
    public void setTotalWeight(int readWeight){
         totalWeight = readWeight; 
    }
    
    public int getPayLoad(){
        return totalWeight - ownWeight; 
    }
   
    
    @Override
    public String toString(){
        return "Vogn " + trolleyNr + " Egenvekt: " + ownWeight + " Lastvekt: " + getPayLoad() + " Totalvekt: " + getTotalWeight(); 
    }

}
