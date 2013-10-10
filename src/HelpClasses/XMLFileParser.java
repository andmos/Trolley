/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpClasses;

import TrolleyRegistration.FlightRoute;
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
/*
*
* @TODO Kaste bedre exeptions! la det komme fram hva som skjer
*/
/**
 *
 * @author haavamoa
 */
public class XMLFileParser {
private static String TrolleysPath = System.getProperty("user.dir")+"/src/res/DOC/Trolleys.xml";
private static String FlightRoutePath = System.getProperty("user.dir")+"/src/res/DOC/FlightRoute.xml"; 

private ArrayList<Trolley> trolleys = new ArrayList<Trolley>();    
private ArrayList<FlightRoute> flightRoutes = new ArrayList<FlightRoute>(); 
   
public XMLFileParser() {
        try{
            //TODO: Add the rest of the XML files.    
            trolleys = getTrolleysFromXMLFile();
            flightRoutes = getFlightRoutesFromXMLFile();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public ArrayList<Trolley> getTrolleys() {
        return trolleys;
    }
    
    
    public ArrayList<FlightRoute> getFlightRoutes(){
        return flightRoutes; 
    }
    
   public void WriteFlightReportToXMLFile(){
       
   }
    

    private ArrayList<Trolley> getTrolleysFromXMLFile() throws Exception {
        ArrayList<Trolley> tempTrolley = new ArrayList<Trolley>();
        File xmlfile = new File(TrolleysPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlfile); 
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
    
    private ArrayList<FlightRoute> getFlightRoutesFromXMLFile() throws Exception {
        ArrayList<FlightRoute> tempFlightRoute = new ArrayList<FlightRoute>();
        File xmlfile = new File(FlightRoutePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlfile); 
        NodeList nList = doc.getElementsByTagName("FlightRoute");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                try{
                String flightRouteNr = eElement.getAttribute("flightRouteNr");
                String destination = eElement.getAttribute("destination");
                int flightNr = Integer.parseInt(eElement.getAttribute("flightNr")); 
                tempFlightRoute.add(new FlightRoute(flightNr, flightRouteNr, destination));
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
                
            }
            return tempFlightRoute;        
    }
  
}
