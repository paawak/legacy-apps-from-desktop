package controller;

import javax.swing.JApplet;
import javax.swing.JFrame;

import view.InventoryFrame;

public class InventoryApplet extends JApplet {
	
	 public void init() {
	        try {
	            java.awt.EventQueue.invokeAndWait(new Runnable() {
	                public void run() {
	                	JFrame frame = new InventoryFrame();
	                	setJMenuBar(frame.getJMenuBar());
	                    setContentPane(frame.getContentPane());
	                }
	            });
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

}
