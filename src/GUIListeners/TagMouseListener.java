/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIListeners;

import GUI.Tag;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

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
    printJob.setPrintable(tag);
    printJob.printDialog();
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
