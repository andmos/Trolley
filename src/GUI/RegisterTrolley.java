
package GUI;


import GUIListeners.RegisterTrolleyItemChangedListener;
import GUIListeners.RegisterTrolleyKeyListener;
import TrolleyRegistration.Flight;
import TrolleyRegistration.FlightRoute;
import TrolleyRegistration.Trolley;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import sun.rmi.transport.proxy.CGIHandler;

/**
 * This class represents the window where you register Trolleys.
 * @author haavamoa
 */
public class RegisterTrolley {
    public TrolleyApp trolleyApp;
    public JPanel flightRoutePanel = new JPanel();
    public JPanel trolleyPanel = new JPanel();
    public JPanel basisPanel = new JPanel();
    public Integer[] flightNrs;
    public Integer[] trolleyIds;
    public JLabel basisPanelOwnWeigth;
    public int activeTrolleyId;
    public Flight flight;
    public FlightRoute flightroute;
    public Trolley trolley;
    
    public RegisterTrolley(TrolleyApp trolleyApp) {
        this.trolleyApp = trolleyApp;
        trolleyApp.removeAll();
        trolleyApp.revalidate();
        trolleyApp.repaint();
        trolleyApp.setLayout(new BorderLayout());
        trolleyApp.setFocusable(true);
        //Get the fligts from xml
        ArrayList<FlightRoute> flights = trolleyApp.xmlp.getFlightRoutes();
        flightNrs = new Integer[flights.size()+1];
        for (int i = 0; i < flights.size(); i++) {
            flightNrs[i] = flights.get(i).getFlightNr();
        }
            
        ArrayList<Trolley> trolleys = trolleyApp.xmlp.getTrolleys();
        trolleyIds = new Integer[trolleys.size()+1];
        for (int i = 0; i < trolleys.size(); i++) {
            trolleyIds[i] = trolleys.get(i).getTrolleyId();
        }
        trolleyIds[trolleys.size()] = 99; //Always add trolleysid 99 for user input
        flightNrs[flights.size()] = 99; //Always add flight nr 99 for user input
        
        flightRouteSetup();
        trolleyPanelSetup();
        basisPanelSetup();
        
    }
    /**
     * Sets up the flight route information screen.
     */
    private void flightRouteSetup(){
        flightRoutePanel.setLayout(new GridBagLayout());
        flightRoutePanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),120));
        flightRoutePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        flightRoutePanel.setBackground(Color.white);
        
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
   
        c.gridx=0;
        c.gridy=0;
        JLabel logo = new JLabel();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/res/plane.png"));
        logo.setIcon(image);
        flightRoutePanel.add(logo,c);
        
        c.gridy = 2;
        c.gridx = 0;
        label = new JLabel("Rute nr :");
        flightRoutePanel.add(label,c);
        c.gridx = 1;
        String tempRouteNr = "";
        JTextField routeNr = new JTextField(tempRouteNr,10);
        routeNr.setName("routeNr");
        RegisterTrolleyKeyListener keylistener = new RegisterTrolleyKeyListener(this);
        keylistener.setRouteNr(routeNr);
        routeNr.addKeyListener(keylistener);
        routeNr.disable();
        flightRoutePanel.add(routeNr,c);
        
        c.gridy = 3;
        c.gridx = 0;
        label = new JLabel("Destinasjon :");
        flightRoutePanel.add(label,c);
        c.gridx = 1;
        String tempDestination = trolleyApp.xmlp.getFlightRoutes().get(0).getDestination();
        JTextField destination = new JTextField(tempDestination,10);
        destination.setName("destination");
        keylistener.setDestination(destination);
        destination.addKeyListener(keylistener);
        destination.disable();
        flightRoutePanel.add(destination,c);
        
        c.gridy = 1;
        c.gridx = 0;
        label = new JLabel("Fly nr :");
        flightRoutePanel.add(label,c);
        c.gridx= 1;
        JComboBox flightNr = new JComboBox(flightNrs);
        flightNr.setFocusable(true);
        flightNr.requestFocus();
        flightNr.setName("flightnr");
        flightNr.addItemListener(new RegisterTrolleyItemChangedListener(flightNr,this, routeNr, destination));
        flightNr.setMinimumSize(new Dimension(200, 20));
        flightRoutePanel.add(flightNr,c);
        trolleyApp.add(flightRoutePanel,BorderLayout.NORTH); //Add panel to main application
        
        //Add the temporary flight route and flightroute
        flightroute = new FlightRoute(flightNrs[0], tempRouteNr , tempDestination);
        flight = new Flight(flightroute);

        
    }
    
    private void trolleyPanelSetup(){
        trolleyPanel.setLayout(new GridBagLayout());
        trolleyPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),150));
        trolleyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        trolleyPanel.setBackground(Color.white);
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
        
        c.gridx =0;
        c.gridy=0;
        JLabel logo = new JLabel();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/res/trolley.png"));
        logo.setIcon(image);
        trolleyPanel.add(logo,c);
        
        label = new JLabel("Egenvekt :");
        c.gridx = 0;
        c.gridy = 3;
        trolleyPanel.add(label,c);
        int tempOwnWeigth = trolleyApp.xmlp.getTrolleys().get(0).getOwnWeight();
        JTextField ownWeight = new JTextField(tempOwnWeigth+" kg",5);
        c.gridx = 1;
        c.gridy=3;
        ownWeight.disable();
        trolleyPanel.add(ownWeight,c);
        trolleyApp.add(trolleyPanel,BorderLayout.CENTER);
        
        label = new JLabel("Vogn nr :");
        c.gridx = 0;
        c.gridy = 1;
        trolleyPanel.add(label,c);
        
        activeTrolleyId = trolleyApp.xmlp.getTrolleys().get(0).getTrolleyId();
        c.gridx = 1;
        JComboBox trolleys = new JComboBox(trolleyIds);
        trolleys.setName("trolleys");
        trolleys.addItemListener(new RegisterTrolleyItemChangedListener(trolleys, this,ownWeight));
        trolleyPanel.add(trolleys,c);
        
        trolley = new Trolley(activeTrolleyId, tempOwnWeigth);
        
    }
    
    private void basisPanelSetup(){
        basisPanel.setLayout(new GridBagLayout());
        basisPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),350));
        basisPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        basisPanel.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
        
        c.gridx =0;
        c.gridy=0;
        JLabel logo = new JLabel();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/res/weight.png"));
        logo.setIcon(image);
        basisPanel.add(logo,c);
        //Predefined OK Button to use in totalweigth listener
        final JButton okBtn = new JButton("Fortsett");
        //Predefined loadweigth to use inside totalweight listener
        final JLabel loadWeigth = new JLabel("",10);
        loadWeigth.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(9, 0, 0, 0);
        basisPanel.add(loadWeigth,c);
        
        //Total weigth icon
        c.gridx =2;
        c.gridy=3;
        logo = new JLabel();
        image = new ImageIcon(this.getClass().getResource("/res/notOK.png"));
        logo.setIcon(image);
        basisPanel.add(logo,c);
        
        //Total weigth
        label = new JLabel("Skriv inn totalvekt :");
        c.gridx = 0;
        c.gridy=1;
        basisPanel.add(label,c);
        
        final JTextField totalWeigth = new JTextField(3);
        c.gridx = 1;
        c.gridy=1;
        totalWeigth.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    for (Trolley t:trolleyApp.xmlp.getTrolleys()){
                        if(trolley.getTrolleyId()==t.getTrolleyId()){
                        trolley.setTotalWeight(Integer.parseInt(totalWeigth.getText()));
                        loadWeigth.setText(trolley.getPayLoad()+" kg");
                    }
                    }
                    
                }else{
                }
                trolleyApp.revalidate();
                trolleyApp.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        basisPanel.add(totalWeigth,c);
        
        //Own weigth
        label = new JLabel("- egenvekt");
        c.gridx = 0;
        c.gridy = 2;
        basisPanel.add(label,c);
        
        basisPanelOwnWeigth = new JLabel(trolley.getOwnWeight()+" kg");
        c.gridx = 1;
        c.gridy = 2;
        basisPanel.add(basisPanelOwnWeigth,c);
        
        //Load weigth
        label = new JLabel("LASTVEKT :");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 0, 0, 0);
        label.setFont(new Font("Ariel", Font.BOLD, 14));
        label.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        basisPanel.add(label,c);
        
        JButton btn;
        
        //BACK button
        btn = new JButton("Tilbake");
        btn.setForeground(Color.red);
        c.gridx = 0;
        c.gridy=3;
        c.insets = new Insets(100, 0, 0, 120);
        btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                new MainMenu(trolleyApp);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        basisPanel.add(btn,c);
        
        //OK button
        okBtn.setForeground(Color.green);
        okBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                    flight.addTrolleyToFlight(trolley);
                    if(trolley.getPayLoad()<=0){
                        JOptionPane.showMessageDialog(null, "Du må fylle inn totalvekt.");
                    }else{
                        flight.setTimeStamp();
                        Object[] valgene = {"Ja","Nei"};
                   int valg = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "Vil du printe tag?", //Object message,
                               "Ta et valg", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               valgene, //Object[] options,
                               "Ja");//Object initialValue
                   if(valg==0){ //Vise tag
                       new Tag(trolleyApp,flight,trolley);
                   }else{ //Ikke vise tag
                       new MainMenu(trolleyApp);
                   }
                    }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        c.gridx = 1;
        c.gridy=3;
        c.insets = new Insets(100, 120, 0, 0);
        basisPanel.add(okBtn,c);
        trolleyApp.add(basisPanel,BorderLayout.SOUTH);
    }
}
