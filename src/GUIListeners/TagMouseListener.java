/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.MainMenu;
import GUI.Tag;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author haavamoa
 */
public class TagMouseListener implements MouseListener{
    private Tag tag;
    public TagMouseListener(Tag tag) {
        this.tag = tag;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
  PrinterJob printJob = PrinterJob.getPrinterJob();
  printJob.setJobName("Utskrift av tralleseddel");
    printJob.setPrintable(new Printable() {

      @Override
      public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                   if (pageIndex > 0) {
          return(NO_SUCH_PAGE);
        } else {
          Graphics2D g2d = (Graphics2D)graphics;
          g2d.translate(pageFormat.getImageableX()-20, pageFormat.getImageableY()); //Setter y rettning litt mindre for å få det midstilt
          g2d.scale(.65, .65); //0.65 ganger i forhold til applikasjonen.
        //Pushing the size up for printing
          for(Component c:tag.weigthDatePanel.getComponents())
              if(c instanceof JLabel){
                      if(((JLabel)c).getText().equals(tag.flight.flightRoute.getDestination())){
                        c.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
                      }else if(((JLabel)c).getText().equals(tag.flight.flightRoute.getFlightNr())){
                          c.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
                  }
              }  
          // Turn off double buffering
          tag.print.hide();
          tag.trolleyApp.paint(g2d);
          tag.print.show();
          // Turn double buffering back on
          return(PAGE_EXISTS);
      }
      }
  });
    if (printJob.printDialog()){
      try {
        printJob.print();
        new MainMenu(tag.trolleyApp);
      } catch(PrinterException pe) {
        System.out.println("Error printing: " + pe);
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
    
    
}
