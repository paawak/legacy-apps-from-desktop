

package controller;

import view.*;

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;

import usefulClasses.generalUtilities.*;


/**
 *
 * @author  Palash
 */
public class Inventory {

    /** Creates a new instance of Motor */
    public Inventory() {
    }

    
    public static void main(String[] args) {
    
        InventoryFrame frame = new InventoryFrame();
        
        ReadPropertyFile readProp = new ReadPropertyFile("controller/InvProps/InventoryView");
        
        Boolean FullScreen = Boolean.valueOf(readProp.getVal("Frame.FullScreenOption"));
        centerWindow(frame,FullScreen);        
        frame.show();
    }
    
    /** @param args the command line arguments
     *
     */
    public static void centerWindow(javax.swing.JFrame frame, Boolean FullScreen) {
        
    int Height;
    int Width;
              
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        if(FullScreen.booleanValue()){
        Height=(int)screenDim.getHeight()-60;
        Width=(int)screenDim.getWidth();                
        }
        else{
        ReadPropertyFile readProp = new ReadPropertyFile("controller/InvProps/InventoryView");            
        Height=Integer.parseInt(readProp.getVal("Frame.Height"));
        Width=Integer.parseInt(readProp.getVal("Frame.Width"));    
        }
                
        
        Window win = new Window(frame);
        frame.setSize(Width, Height);
        win.setSize(Width, Height);
        // If larger than screen, reduce window width or height
        if (screenDim.width < win.getSize().width) {
            win.setSize(screenDim.width, win.getSize().height);
        }
        if (screenDim.height < win.getSize().height) {
            win.setSize(win.getSize().width, screenDim.height);
        }
        int x = (screenDim.width - win.getSize().width) / 2;
        int y = (screenDim.height - win.getSize().height) / 2;
        frame.setBounds(x, y, Width,Height);

        
    }    
    
    public static void exit(){
     System.exit(0);   
    }
    
}
