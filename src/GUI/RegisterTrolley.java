
package GUI;


import GUIListeners.RegisterTrolleyItemChangedListener;
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
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
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
     * Sets up the flightroute information screen.
     */
    private void flightRouteSetup(){
        //ENDRE TIL TEXTFIELD HVIS 99
        flightRoutePanel.setLayout(new GridBagLayout());
        flightRoutePanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),120));
        flightRoutePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
   
        c.gridy = 1;
        c.gridx = 0;
        label = new JLabel("Rute nr :");
        flightRoutePanel.add(label,c);
        c.gridx = 1;
        JTextField routeNr = new JTextField(trolleyApp.xmlp.getFlightRoutes().get(0).getFlightRouteNr(),10);
        routeNr.disable();
        flightRoutePanel.add(routeNr,c);
        
        c.gridy = 2;
        c.gridx = 0;
        label = new JLabel("Destinasjon :");
        flightRoutePanel.add(label,c);
        c.gridx = 1;
        JTextField destination = new JTextField(trolleyApp.xmlp.getFlightRoutes().get(0).getDestination(),10);
        destination.disable();
        flightRoutePanel.add(destination,c);
        
        c.gridy = 0;
        c.gridx = 0;
        label = new JLabel("Fly nr :");
        flightRoutePanel.add(label,c);
        c.gridx= 1;
        JComboBox flightNr = new JComboBox(flightNrs);
        flightNr.setName("flightnr");
        flightNr.addItemListener(new RegisterTrolleyItemChangedListener(flightNr,this, routeNr, destination));
        flightNr.setMinimumSize(new Dimension(200, 20));
        flightRoutePanel.add(flightNr,c);
        trolleyApp.add(flightRoutePanel,BorderLayout.NORTH); //Add panel to main application
    }
    
    private void trolleyPanelSetup(){
        trolleyPanel.setLayout(new GridBagLayout());
        trolleyPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),150));
        trolleyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
        
        label = new JLabel("Egenvekt :");
        c.gridx = 0;
        c.gridy = 2;
        trolleyPanel.add(label,c);
        
        JTextField ownWeight = new JTextField(trolleyApp.xmlp.getTrolleys().get(0).getOwnWeight()+"",5);
        c.gridx = 1;
        c.gridy=2;
        ownWeight.disable();
        trolleyPanel.add(ownWeight,c);
        trolleyApp.add(trolleyPanel,BorderLayout.CENTER);
        
        label = new JLabel("Vogn nr :");
        c.gridx = 0;
        c.gridy = 0;
        trolleyPanel.add(label,c);
        
        c.gridx = 1;
        JComboBox trolleys = new JComboBox(trolleyIds);
        trolleys.setName("trolleys");
        trolleys.addItemListener(new RegisterTrolleyItemChangedListener(trolleys, this,ownWeight));
        trolleyPanel.add(trolleys,c);
        
        
    }
    
    private void basisPanelSetup(){
        basisPanel.setLayout(new GridBagLayout());
        basisPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(),350));
        basisPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridBagConstraints c = new GridBagConstraints();
        JLabel label;
        
        //Predefined loadweigth to use inside totalweight listener
        final JLabel loadWeigth = new JLabel("",10);
        c.gridx = 1;
        c.gridy = 2;
        basisPanel.add(loadWeigth,c);
        
        //Total weigth
        label = new JLabel("Skriv inn totalvekt :");
        c.gridx = 0;
        c.gridy=0;
        basisPanel.add(label,c);
        
        final JTextField totalWeigth = new JTextField(10);
        c.gridx = 1;
        c.gridy=0;
        totalWeigth.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println(activeTrolleyId);
                    trolleyApp.xmlp.getTrolleys().get(activeTrolleyId).setTotalWeight(Integer.parseInt(totalWeigth.getText()));
                    loadWeigth.setText(trolleyApp.xmlp.getTrolleys().get(activeTrolleyId).getPayLoad()+" kg");
                    trolleyApp.revalidate();
                    trolleyApp.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        basisPanel.add(totalWeigth,c);
        
        //Own weigth
        label = new JLabel("- egenvekt");
        c.gridx = 0;
        c.gridy = 1;
        basisPanel.add(label,c);
        
        basisPanelOwnWeigth = new JLabel(trolleyApp.xmlp.getTrolleys().get(0).getOwnWeight()+" kg");
        c.gridx = 1;
        c.gridy = 1;
        basisPanel.add(basisPanelOwnWeigth,c);
        
        //Load weigth
        label = new JLabel("LASTVEKT :");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10, 0, 0, 0);
        label.setFont(new Font("Ariel", Font.BOLD, 14));
        basisPanel.add(label,c);
        
        
        trolleyApp.add(basisPanel,BorderLayout.SOUTH);
    }
}
