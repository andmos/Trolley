/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClasses;

/**
 *
 * @author andreasmosti
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileWriter {
   private static File f; 
   
   public void setFileName(String filename){
       f = new File(filename);
   }
  
   public void writeListToFile(ArrayList historyList) {
      try{
       FileOutputStream fos = new FileOutputStream(f);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       for(int i = 0; i < historyList.size(); i++) {
           oos.writeObject(historyList.get(i));
       }
       fos.close();
       oos.close();
      }catch(IOException e){
          System.out.println("Error while writing to file " + e.getMessage());
            }
        }
        
     }
