package HelpClasses;

/**
 *
 * @author andreasmosti
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriter {

    private static File f;

    public void setFileName(String filename) {
        f = new File(filename);
    }

    public boolean checkIfFileExistsOrCreateNew(String filename) {
        File yourFile = new File(filename);
       try{ 
        if (!yourFile.exists()) {
            yourFile.createNewFile();
            return false; 
        }
             
       }catch(Exception e){
           System.out.println("Error reading or creating file: " + e.getMessage());
       }
       return true;
    }

    public void writeSimpleStringToFile(String string) {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(f));
            out.print(string);
        } catch (IOException e) {
            System.out.println("Error while writing to file " + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void writeListToFile(ArrayList historyList) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < historyList.size(); i++) {
                oos.writeObject(historyList.get(i));
            }
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Error while writing to file " + e.getMessage());
        }
    }

    public String readFileAsString() {
        try {
            StringBuilder fileData = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new FileReader(f));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
            reader.close();
            return fileData.toString();
        } catch (IOException e) {
            System.out.println("Error while reading from file " + e.getMessage());
            return "Coult not read file!";
        }

    }
}
