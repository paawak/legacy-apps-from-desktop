/*
 * HandleError.java
 *
 * Created on January 22, 2003, 12:05 PM
 */

package usefulClasses.generalUtilities;

/**
 *
 * @author  Administrator
 */

import javax.swing.JOptionPane;

public class HandleError extends javax.swing.JFrame {
    
    /** Creates a new instance of HandleError */
    public HandleError() {
            }//end constructor

    public void displayError(String invokingMethodName,Exception exception){
        
            JOptionPane.showMessageDialog(this,"ERROR DETAILS :\n"+exception,"An ERROR has occured in "+invokingMethodName+":               ",JOptionPane.ERROR_MESSAGE);

    }//end methd.
    
    
}//end class
