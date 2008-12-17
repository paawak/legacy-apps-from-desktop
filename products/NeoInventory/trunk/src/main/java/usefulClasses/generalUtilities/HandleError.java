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

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.InventoryFrame;

public class HandleError extends javax.swing.JDialog {
	
	private JLabel errorMessage;
	private JTextArea stackTrace;
    
    /** Creates a new instance of HandleError */
    public HandleError() {
    	getContentPane().setLayout(new BorderLayout());
    	errorMessage = new JLabel();
    	stackTrace = new JTextArea();
    	JScrollPane scroll = new JScrollPane();
    	scroll.setViewportView(stackTrace);
    	getContentPane().add(errorMessage, BorderLayout.NORTH);
    	getContentPane().add(scroll, BorderLayout.CENTER);
    	
    	addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                setVisible(false);
            }
        });
    	
    	setSize(600, 200);
    	
    }//end constructor

    public void displayError(String invokingMethodName,Exception e){
        setTitle("An ERROR has occured in "+invokingMethodName);
        errorMessage.setText(e.getMessage()+"\nERROR DETAILS:");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(bos));
        String trace = new String(bos.toByteArray());
        stackTrace.setText(trace);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	setVisible(true);
            }
        });
        
    }//end methd.
    
}//end class
