/*
 * Print.java
 *
 * Created on April 17, 2003, 6:29 PM
 */

package usefulClasses.generalUtilities;


import java.awt.print.PrinterJob;

import java.awt.*;
import javax.swing.*;
import java.awt.print.*;


/**
 *
 * @author  Palash
 */
public class Print implements Printable{
    
    private javax.swing.JPanel Panel;
    
    /** Creates a new instance of Print */
    public Print(javax.swing.JPanel Panel) {
        
        this.Panel=Panel;
        
        initialise();
        
    }
    

    
    /** Prints the page at the specified index into the specified
     * {@link Graphics} context in the specified
     * format.  A <code>PrinterJob</code> calls the
     * <code>Printable</code> interface to request that a page be
     * rendered into the context specified by
     * <code>graphics</code>.  The format of the page to be drawn is
     * specified by <code>pageFormat</code>.  The zero based index
     * of the requested page is specified by <code>pageIndex</code>.
     * If the requested page does not exist then this method returns
     * NO_SUCH_PAGE; otherwise PAGE_EXISTS is returned.
     * The <code>Graphics</code> class or subclass implements the
     * {@link PrinterGraphics} interface to provide additional
     * information.  If the <code>Printable</code> object
     * aborts the print job then it throws a {@link PrinterException}.
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     * @return PAGE_EXISTS if the page is rendered successfully
     *         or NO_SUCH_PAGE if <code>pageIndex</code> specifies a
     * 	       non-existent page.
     * @exception java.awt.print.PrinterException
     *         thrown when the print job is terminated.
     *
     */
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
	}
	
        Panel.printAll(graphics);
        return Printable.PAGE_EXISTS; 
        
    }
    /**
     *Method to set the initialise the properties of the Page to be printed
     *
     */
    private void initialise(){
        
        PrinterJob printJob = PrinterJob.getPrinterJob();
        
        PageFormat page = printJob.defaultPage();
        
        Paper paper = new Paper();
        
        //paper.s
        page.setOrientation(page.LANDSCAPE);
        int width=(int)page.getWidth();
        int height=(int)page.getHeight();
        
        Dimension originalPanel=Panel.getSize();
        
        Panel.setSize(width, height);
        
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();  
            } catch (Exception ex) {
                ex.printStackTrace();
                
            }
    }
        Panel.setSize(originalPanel);
        
    }//end
    
}
