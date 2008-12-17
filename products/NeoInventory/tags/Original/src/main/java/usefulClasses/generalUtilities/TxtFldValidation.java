/*
 * TxtFldValidation.java
 *
 * Created on January 22, 2003, 8:21 PM
 */

package usefulClasses.generalUtilities;

import javax.swing.JOptionPane;
import java.util.*;
import java.awt.*;

/**
 *
 * @author  Administrator
 */
public class TxtFldValidation extends javax.swing.JFrame {
    
    /** Creates a new instance of TxtFldValidation */
    public TxtFldValidation() {
    }

   public boolean isValid = false;
    
    public double checkFloatNumber(javax.swing.JTextField txtFld){
        
         double num=0;
         if(txtFld.getText().trim().equals("")){
                txtFld.setText("0.00");
                txtFld.selectAll();
                txtFld.requestFocus();             
                
                JOptionPane.showMessageDialog(this,"This Field cannot be empty!","Error!",JOptionPane.INFORMATION_MESSAGE);    

        }//end else if
         
         else
       try{
            num=Double.parseDouble(txtFld.getText());   
            if(num<0){
                num=0;
                txtFld.setText("0.00");
                txtFld.requestFocus();
                txtFld.selectAll();
                JOptionPane.showMessageDialog(this,"This Field cannot be negative!","Error!",JOptionPane.INFORMATION_MESSAGE);                    
            }//end if
            else{   
                isValid = true;
           /* String s = adjustDecimal(""+num);
            txtFld.setText(s);
            num=Double.parseDouble(s);   */
            
            }//end else
               
        }//end try
        catch(NumberFormatException e){
            txtFld.setText("0.00");
            txtFld.requestFocus();
JOptionPane.showMessageDialog(this,"Enter a valid number!","Error!",JOptionPane.INFORMATION_MESSAGE);    
txtFld.selectAll();
        }//end catch
 return num;       
        
    }//end methd.
    
        public long checkLongNumber(javax.swing.JTextField txtFld){
            
           long num=0;
         if(txtFld.getText().trim().equals("")){
                txtFld.setText("0");
                txtFld.selectAll();
                txtFld.requestFocus();             
                JOptionPane.showMessageDialog(this,"This Field cannot be empty!","Error!",JOptionPane.INFORMATION_MESSAGE);    

        }//end else if
         
         else
       try{
            num=Long.parseLong(txtFld.getText());   
            if(num<0){
                num=0;
                txtFld.setText("0");
                txtFld.requestFocus();
                txtFld.selectAll();
                JOptionPane.showMessageDialog(this,"This Field cannot be negative!","Error!",JOptionPane.INFORMATION_MESSAGE);                    
            }//end if
            else
                isValid = true;
        }//end try
        catch(NumberFormatException e){
            txtFld.setText("0");
            txtFld.selectAll();
            txtFld.requestFocus();
JOptionPane.showMessageDialog(this,"Enter a valid number(Integer)!","Error!",JOptionPane.INFORMATION_MESSAGE);    
        }//end catch
            return num;
            
    }//end methd.


        public int checkIntNumber(javax.swing.JTextField txtFld){
            
           int num=0;
         if(txtFld.getText().trim().equals("")){
                txtFld.setText("0");
                txtFld.selectAll();
                txtFld.requestFocus();             
                JOptionPane.showMessageDialog(this,"This Field cannot be empty!","Error!",JOptionPane.INFORMATION_MESSAGE);    

        }//end else if
         
         else
       try{
            num=Integer.parseInt(txtFld.getText());   
            if(num<0){
                num=0;
                txtFld.setText("0");
                txtFld.requestFocus();
                txtFld.selectAll();
                JOptionPane.showMessageDialog(this,"This Field cannot be negative!","Error!",JOptionPane.INFORMATION_MESSAGE);                    
            }//end if
            else
                isValid = true;
        }//end try
        catch(NumberFormatException e){
            txtFld.setText("0");
            txtFld.selectAll();
            txtFld.requestFocus();
JOptionPane.showMessageDialog(this,"Enter a valid number(Integer)!","Error!",JOptionPane.INFORMATION_MESSAGE);    
        }//end catch
            return num;
            
    }//end methd.
        
        
}//end class
