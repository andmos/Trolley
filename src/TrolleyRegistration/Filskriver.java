/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TrolleyRegistration;

/**
 *
 * @author andreasmosti
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Filskriver {
   private static File f; 
   
   public void setFilnavn(String filnavn){
       f = new File(filnavn);
   }
  
   public void skrivTilFil(ArrayList historikk) {
      try{
       FileOutputStream fos = new FileOutputStream(f);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       for(int i = 0; i < historikk.size(); i++) {
           oos.writeObject(historikk.get(i));
       }
       fos.close();
       oos.close();
      }catch(IOException e){
          System.out.println("Error while writing to file " + e.getMessage());
            }
        }
        
     }
