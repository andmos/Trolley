/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUIListeners.TagMouseListener;
import TrolleyRegistration.Flight;
import TrolleyRegistration.Trolley;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author haavamoa
 */
public class Tag{

    public TrolleyApp trolleyApp;
    public Flight flight;
    public Trolley trolley;
    public JPanel routePanel = new JPanel();
    public JPanel weigthDatePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JButton print;
    
    public Tag(TrolleyApp trolleyApp,Flight flight,Trolley trolley) {
        this.flight = flight;
        this.trolleyApp = trolleyApp;
        this.trolley = trolley;
        trolleyApp.setLayout(new BorderLayout());
        trolleyApp.removeAll();
        trolleyApp.revalidate();
        trolleyApp.repaint();
        routePanelSetup();
        weigthDatePanelSetup();
        buttonPanelSetup();
    }
    
    /**
     * Sets up the panel to display the information about the route.
     */
    public void routePanelSetup(){
        routePanel.setLayout(new BorderLayout());
        routePanel.setBackground(Color.white);
        routePanel.setPreferredSize(new Dimension(50, 100));
     //   routePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridBagConstraints c = new GridBagConstraints();
        
        //Route panel inside route panel.
        JPanel routeNumber = new JPanel();
        routeNumber.setBackground(Color.white);
        routeNumber.setLayout(new GridBagLayout());
        c.insets = new Insets(0, 100, 0, 0);
        c.gridx = 0;
        c.gridy = 0;
        routeNumber.add(new JLabel("Rute nummer :"),c);
        c.gridx = 0;
        c.gridy = 1;
        JLabel routeNr = new JLabel(flight.flightRoute.getFlightRouteNr());
        routeNr.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        routeNumber.add(routeNr,c);
        
        routePanel.add(routeNumber,BorderLayout.WEST);
        
        JPanel datePanel = new JPanel();
        datePanel.setBackground(Color.white);
        datePanel.setLayout(new GridBagLayout());
        c.insets = new Insets(0, 0, 0, 100);
        c.gridx = 0;
        c.gridy = 1;
        datePanel.add(new JLabel("Dato :"),c);
        //Date
        c.gridx = 0;
        c.gridy = 2;
        String dateS = new SimpleDateFormat("dd-MM-yyyy").format(flight.timestamp.getTime());
        JLabel date = new JLabel(dateS);
        date.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        datePanel.add(date,c);
        routePanel.add(datePanel,BorderLayout.EAST);
        
        
        
        trolleyApp.add(routePanel,BorderLayout.NORTH);
    }
    
    /**
     * Sets up the panel to display the weight and the date.
     */
    public void weigthDatePanelSetup(){
        weigthDatePanel.setBackground(Color.white);
        weigthDatePanel.setPreferredSize(new Dimension(trolleyApp.getWidth(), 70));
        weigthDatePanel.setLayout(new GridBagLayout());
        weigthDatePanel.setBorder(new MatteBorder(2, 0, 2, 0, Color.BLACK));
        GridBagConstraints c = new GridBagConstraints();
        
      
        
        JLabel destination= new JLabel("Destinasjon :");
        c.gridx = 0;
        c.gridy = 1;
        weigthDatePanel.add(destination,c);
        JLabel dest = new JLabel(flight.flightRoute.getDestination());
        c.gridx = 0;
        c.gridy = 2;
        dest.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
        weigthDatePanel.add(dest,c);
        
          //Load weigth
        c.insets = new Insets(60, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 3;
        weigthDatePanel.add(new JLabel("Lastvekt :"),c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        JLabel weigth = new JLabel(trolley.getPayLoad()+"kg");
        weigth.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
        weigthDatePanel.add(weigth,c);
        
        trolleyApp.add(weigthDatePanel,BorderLayout.CENTER);
    }
    
    /**
     * Sets up the panel ti display print and cancel buttons.
     */
    public void buttonPanelSetup(){
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setPreferredSize(new Dimension(trolleyApp.getWidth(), 150));
        JButton btn;
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        //Print button
        print= new JButton("Print tag");
        print.addMouseListener(new TagMouseListener(this));
        buttonPanel.add(print,c);
        
        //Cancel button
        trolleyApp.add(buttonPanel,BorderLayout.SOUTH);
    }
    }
    

