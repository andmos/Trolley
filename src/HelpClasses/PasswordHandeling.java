/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClasses;

import org.jasypt.util.password.*;
 
import java.util.*;
/**
 *
 * @author andreasmosti
 */
public class PasswordHandeling {
    private static final String userpass = "testpass";
    private FileWriter fileWriter = new FileWriter(); 
    private String fileName = "passord.txt"; 
    
    public PasswordHandeling(){
        fileWriter.setFileName(fileName);
    } 
    
    public String encryptPassword() {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(userpass);
        storePasswordForUser(encryptedPassword);
        return encryptedPassword;
    }
 
 
    public boolean checkPassword(String submittedPassword){
       StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
       String encryptedPassword = getPasswordFromFile();
        return passwordEncryptor.checkPassword(submittedPassword, encryptedPassword);
    }
 
    public void storePasswordForUser(String hashedPassword){
        fileWriter.writeStringToFile(hashedPassword);
    }
 
    public String getPasswordFromFile(){
      return fileWriter.readFileAsString(); 
    }
 
    public static void main(String[] args)
    {
        PasswordHandeling encrypter = new PasswordHandeling();
        encrypter.encryptPassword();
        PasswordHandeling checker = new PasswordHandeling();
        System.out.println("Passwords Matched " + (checker.checkPassword(userpass)));
    }
}
