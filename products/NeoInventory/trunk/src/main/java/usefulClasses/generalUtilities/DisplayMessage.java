/*
 * DisplayMessage.java
 *
 * Created on March 22, 2003, 2:58 PM
 */

package usefulClasses.generalUtilities;

import javax.swing.JOptionPane;

/**
 *
 * @author  Administrator
 */
public class DisplayMessage extends javax.swing.JFrame {
    
    /** Creates a new instance of DisplayMessage */
    public DisplayMessage() {
    }
    
    public void displayMessage(String message,String title){
        
            JOptionPane.showMessageDialog(this,message,title,JOptionPane.INFORMATION_MESSAGE);

    }//end methd.    
    
}
