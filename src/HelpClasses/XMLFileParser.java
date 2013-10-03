/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClasses;

import TrolleyRegistration.Trolley;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *
 * @author haavamoa
 */
public class XMLFileParser {
private static String TrolleysPath = System.getProperty("user.dir")+"/DOC/Trolleys.xml";
private static String FlightRoutePath = System.getProperty("user.dir")+"/DOC/FlightRoute.xml"; 

public ArrayList<Trolley> trolleys = new ArrayList<Trolley>();    

    public XMLFileParser() {
        try{
            //TODO: Add the rest of the XML files.    
            trolleys = getTrolleysFromeFile();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    /**
     * get parsed Trolleys from XML file.
     * @return 
     */
    public ArrayList<Trolley> getTrolleys() {
        return trolleys;
    }
/**
 * Sets the Trolleys
 * @param trolleys 
 */
    public void writeTrolleysToXMLFile(ArrayList<Trolley> trolleys) {
        //TODO: Write to XML if you change them.
        this.trolleys = trolleys;
    }
    
    /**
     * Method to parse existing trolleys from XML file.
     * @return Trolleys from XL file.
     * @throws Exception Catches if a attribute has been incorectly formated.
     */
    private ArrayList<Trolley> getTrolleysFromeFile() throws Exception {
        ArrayList<Trolley> tempTrolley = new ArrayList<Trolley>();
        File fxmlfile = new File(TrolleysPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fxmlfile);
        NodeList nList = doc.getElementsByTagName("Trolley");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                try{
                int id = Integer.parseInt(eElement.getAttribute("id"));
                int ownWeigth = Integer.parseInt(eElement.getAttribute("ownWeight"));
                tempTrolley.add(new Trolley(id, ownWeigth));
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
                
            }
            return tempTrolley;        
    }
    
    
    public static void main(String[] args) {
        XMLFileParser xmlP = new XMLFileParser();
        for(Trolley t:xmlP.getTrolleys())
            System.out.println("Trolley id:"+t.getTrolleyNr()+"\n own weigth: "+t.getOwnWeight());
        
    }
    
}
