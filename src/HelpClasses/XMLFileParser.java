package HelpClasses;

import TrolleyRegistration.Flight;
import TrolleyRegistration.FlightReport;
import TrolleyRegistration.FlightRoute;
import TrolleyRegistration.Trolley;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.joda.time.LocalDate;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
*
* @author andreasmosti
*/
public class XMLFileParser {

    private static LocalDate currentDate = new LocalDate();
    private static String TrolleysPath = System.getProperty("user.dir") + "/src/res/DOC/Trolleys.xml";
    private static String FlightRoutePath = System.getProperty("user.dir") + "/src/res/DOC/FlightRoute.xml";
    private static String FlightReportPath = System.getProperty("user.dir") + "/src/res/DOC/Report." + currentDate.toString() + ".xml";
    private ArrayList<Trolley> trolleys = new ArrayList<Trolley>();
    private ArrayList<FlightRoute> flightRoutes = new ArrayList<FlightRoute>();
    private FileWriter fileWriter = new FileWriter();
    
    public XMLFileParser() {
        try {
            //TODO: Add the rest of the XML files.
            trolleys = getTrolleysFromXMLFile();
            flightRoutes = getFlightRoutesFromXMLFile();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Trolley> getTrolleys() {
        return trolleys;
    }

    public ArrayList<FlightRoute> getFlightRoutes() {
        return flightRoutes;
    }

    public void WriteFlightReportToXMLFile() {
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
            try {
                int id = Integer.parseInt(eElement.getAttribute("id"));
                int ownWeigth = Integer.parseInt(eElement.getAttribute("ownWeight"));
                tempTrolley.add(new Trolley(id, ownWeigth));
            } catch (NumberFormatException e) {
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
            try {
                String flightRouteNr = eElement.getAttribute("flightRouteNr");
                String destination = eElement.getAttribute("destination");
                int flightNr = Integer.parseInt(eElement.getAttribute("flightNr"));
                tempFlightRoute.add(new FlightRoute(flightNr, flightRouteNr, destination));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
        return tempFlightRoute;
    }

    public void writeFlightReportToXML(FlightReport report) {
        try {
            
              if(!fileWriter.checkIfFileExistsOrCreateNew(FlightReportPath)){
                createFlightReportToXMLFile(report);
            }
            
            // create document from existing file
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(FlightReportPath);
            Element reportElement = doc.getDocumentElement();
            
            // set data to root - element
            Attr ReportDate = doc.createAttribute("date");
            ReportDate.setValue(report.getDateStamp().toString());
            reportElement.setAttributeNode(ReportDate);
                  
            // flightroute elements
            Element flightrouteElement = doc.createElement("flightroute");
            reportElement.appendChild(flightrouteElement);
            for (int i = 0; i < report.getAllFlights().size(); i++) {
            // set attribute to Flighroute element:
                Attr idAttribute = doc.createAttribute("id");
                idAttribute.setValue(report.getAllFlights().get(i).getFlightRoute().getFlightRouteNr());
                flightrouteElement.setAttributeNode(idAttribute);

                Attr destinationAttribute = doc.createAttribute("destination");
                destinationAttribute.setValue(report.getAllFlights().get(i).getFlightRoute().getDestination());
                flightrouteElement.setAttributeNode(destinationAttribute);

                      //set ID attribute to Trolley element:
                for (int j = 0; j < report.getAllFlights().get(i).getTrolleysOnFlight().size(); j++) {
                    // trolley elements
                    Element trolleyElement = doc.createElement("trolley");
                    flightrouteElement.appendChild(trolleyElement);
                    Attr trolleyIdAttribute = doc.createAttribute("id");
                    trolleyIdAttribute.setValue(report.getAllFlights().get(i).getTrolleysOnFlight().get(j).getTrolleyId() + "");
                    trolleyElement.setAttributeNode(trolleyIdAttribute);

                    Attr trolleyTotalWeightAttribute = doc.createAttribute("payload");
                    trolleyTotalWeightAttribute.setValue(report.getAllFlights().get(i).getTrolleysOnFlight().get(j).getPayLoad()+ "");
                    trolleyElement.setAttributeNode(trolleyTotalWeightAttribute);
                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FlightReportPath));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            //Formating the XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(source, result);
            

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (SAXException ex) {
            Logger.getLogger(XMLFileParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    //This bit can be refactored, lot of DRY violations.
    public void createFlightReportToXMLFile(FlightReport report){
              try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                
                // root elements
                Element reportElement = doc.createElement("report");
                doc.appendChild(reportElement); 
                
                Attr ReportDate = doc.createAttribute("date");
                ReportDate.setValue(report.getDateStamp().toString());
                reportElement.setAttributeNode(ReportDate);
                
                
                
                Element flightrouteElement = doc.createElement("flightroute");
                reportElement.appendChild(flightrouteElement);
              for(int i = 0; i < report.getAllFlights().size(); i++){
                // set attribute to Flighroute element:
                Attr idAttribute = doc.createAttribute("id");
                idAttribute.setValue(report.getAllFlights().get(i).getFlightRoute().getFlightRouteNr());
                flightrouteElement.setAttributeNode(idAttribute);
                
                
                Attr destinationAttribute = doc.createAttribute("destination");
                destinationAttribute.setValue(report.getAllFlights().get(i).getFlightRoute().getDestination());
                flightrouteElement.setAttributeNode(destinationAttribute);
                
                
                
                Element trolleyElement = doc.createElement("trolley");
                flightrouteElement.appendChild(trolleyElement);
                
                //set ID attribute to Trolley element:
                
                Attr trolleyIdAttribute = doc.createAttribute("id");
                for(int j = 0; j < report.getAllFlights().get(i).getTrolleysOnFlight().size(); j++){
                trolleyIdAttribute.setValue(report.getAllFlights().get(i).getTrolleysOnFlight().get(j).getTrolleyId()+"");
                trolleyElement.setAttributeNode(trolleyIdAttribute);
                
                Attr trolleyTotalWeightAttribute = doc.createAttribute("payload");
                trolleyTotalWeightAttribute.setValue(report.getAllFlights().get(i).getTrolleysOnFlight().get(i).getPayLoad()+"");
                }
              }
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(FlightReportPath));
 
                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);
                
                //Formating the XML
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                
                transformer.transform(source, result);
 
                
         } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
         } catch (TransformerException tfe) {
                tfe.printStackTrace();
         }
    }
    public static void main(String[] args) {
        XMLFileParser p = new XMLFileParser();
        ArrayList traller = p.getTrolleys();
        ArrayList flights = p.getFlightRoutes();

        Trolley t1 = (Trolley) traller.get(1);
        Trolley t2 = (Trolley) traller.get(2);
        Trolley t3 = (Trolley) traller.get(3);
        Trolley t4 = (Trolley) traller.get(4);
        t1.setTotalWeight(600);
        t2.setTotalWeight(700);
        t3.setTotalWeight(800);
        t4.setTotalWeight(900);

        Flight testFlight = new Flight();
        testFlight.setFlightRoute((FlightRoute) flights.get(1));
        testFlight.addTrolleyToFlight(t1);
        testFlight.addTrolleyToFlight(t2);
        testFlight.addTrolleyToFlight(t3);
        testFlight.addTrolleyToFlight(t4);

        FlightReport report = new FlightReport();
        report.addFlightToReport(testFlight);

        p.writeFlightReportToXML(report);
    }

   
}