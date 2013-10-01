
package TrolleyRegistration;


public class Trolley {
    
    private int trolleyNr; 
    private int ownWeight; 
    private int payLoad = 0; 
    
    public Trolley(int vognNr, int egenVekt){
        this.trolleyNr = vognNr; 
        this.ownWeight = egenVekt;
        
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
    
    public int getPayLoad(){
        return payLoad; 
    }
    
    public void setPayLoad(int nyLastVekt){
        payLoad = nyLastVekt; 
    }
    
    public int getTotalWeight(){
        return payLoad + ownWeight; 
    }
    
    @Override
    public String toString(){
        return "Vogn " + trolleyNr + " Egenvekt: " + ownWeight + " Lastvekt: " + payLoad + " Totalvekt: " + getTotalWeight(); 
    }

}
