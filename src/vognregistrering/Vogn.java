
package vognregistrering;


public class Vogn {
    
    private int vognNr; 
    private int egenVekt; 
    private int lastVekt = 0; 
    
    public Vogn(int vognNr, int egenVekt){
        this.vognNr = vognNr; 
        this.egenVekt = egenVekt;
        
    }
    
    public int getVognNr(){
        return vognNr; 
    }
    
    public void setVognNr(int nyttNr){
        vognNr = nyttNr; 
    }
    
    public int getEgenVekt(){
        return egenVekt; 
    }
    
    public void setEgenVekt(int nyEgenvekt){
        egenVekt = nyEgenvekt; 
    }
    
    public int getLastVekt(){
        return lastVekt; 
    }
    
    public void setLastVekt(int nyLastVekt){
        lastVekt = nyLastVekt; 
    }
    
    public int getTotalVekt(){
        return lastVekt + egenVekt; 
    }
    
    @Override
    public String toString(){
        return "Vogn " + vognNr + " Egenvekt: " + egenVekt + " Lastvekt: " + lastVekt + " Totalvekt: " + getTotalVekt(); 
    }

}
