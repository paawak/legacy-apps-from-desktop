/*
 * LoginDialog.java
 *
 * Created on March 28, 2003, 10:58 AM
 */

package controller;

import java.sql.*;
import javax.swing.UIManager;
import javax.swing.JOptionPane;

import utils.database.DBUtil;


/**
 *
 * @author  paawak
 */
public class LoginDialog extends javax.swing.JDialog {
    
    private Database user = new Database("user");
    
    //private DBUtil user = new DBUtil(DatabaseConstants.DSN,"User");
       
    private static  String LoginID=null;
    
    private String Password ;
    
    private boolean ValidUser=false;
    
    /** Creates new form LoginDialog */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        setLookNFeel();
        initComponents();
    }
    
    public static String getLoginID(){
        return LoginID;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        lblLoginID = new javax.swing.JLabel();
        txtLoginID = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        BtOK = new javax.swing.JButton();
        BtCancel = new javax.swing.JButton();
        pswPassword = new javax.swing.JPasswordField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setTitle("User Login :");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        lblLoginID.setFont(new java.awt.Font("Dialog", 1, 10));
        lblLoginID.setText("Login ID :");
        getContentPane().add(lblLoginID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        txtLoginID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginIDFocusGained(evt);
            }
        });

        getContentPane().add(txtLoginID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 20));

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 10));
        lblPassword.setText("Password :");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        pnlButtons.setLayout(new java.awt.GridLayout(1, 1, 5, 0));

        BtOK.setMnemonic('o');
        BtOK.setText("OK");
        BtOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtOKKeyReleased(evt);
            }
        });
        BtOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BtOKMouseReleased(evt);
            }
        });

        pnlButtons.add(BtOK);

        BtCancel.setMnemonic('c');
        BtCancel.setText("Cancel");
        BtCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtCancelKeyReleased(evt);
            }
        });
        BtCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BtCancelMouseReleased(evt);
            }
        });

        pnlButtons.add(BtCancel);

        getContentPane().add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, -1));

        pswPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pswPasswordFocusGained(evt);
            }
        });
        pswPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswPasswordKeyPressed(evt);
            }
        });

        getContentPane().add(pswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-200)/2, (screenSize.height-148)/2, 200, 148);
    }//GEN-END:initComponents

    private void pswPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pswPasswordFocusGained
        // Add your handling code here:
        pswPassword.selectAll();
    }//GEN-LAST:event_pswPasswordFocusGained

    private void txtLoginIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginIDFocusGained
        // Add your handling code here:
        txtLoginID.selectAll();
    }//GEN-LAST:event_txtLoginIDFocusGained

    private void pswPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordKeyPressed
        // Add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            OK_Pressed();
    }//GEN-LAST:event_pswPasswordKeyPressed

    private void BtCancelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtCancelKeyReleased
        // Add your handling code here:
        Cancel_Pressed();
    }//GEN-LAST:event_BtCancelKeyReleased

    private void BtOKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtOKKeyReleased
        // Add your handling code here:
        OK_Pressed();
    }//GEN-LAST:event_BtOKKeyReleased

    private void BtCancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtCancelMouseReleased
        // Add your handling code here:
        Cancel_Pressed();

    }//GEN-LAST:event_BtCancelMouseReleased

    private void BtOKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtOKMouseReleased
        // Add your handling code here:
        OK_Pressed();
    }//GEN-LAST:event_BtOKMouseReleased
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
        if(!ValidUser)
            System.exit(0);
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        new LoginDialog(new javax.swing.JFrame(), true).show();
    }//*/
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancel;
    private javax.swing.JButton BtOK;
    private javax.swing.JLabel lblLoginID;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPasswordField pswPassword;
    public javax.swing.JTextField txtLoginID;
    // End of variables declaration//GEN-END:variables

    private boolean isUserValid(){
        
        boolean isValid = false;
        

        Object[] res = new Object[1];
        try{
        res = user.queryOneColumn("username",true,"");
        }catch(Exception e){}
        
        for(int i=0;i<res.length;i++){
            String userName = res[i].toString().trim();
        
            if(userName.equals(LoginID))
            {
                if(!LoginID.equals(""))
                    isValid=true;
                break;
            }//end else if
                
            
        }//end for
        
        
        return isValid;
    }
    
    private boolean isPasswordValid(){
        
        boolean isValid=false;
        
        String cond = "WHERE username = '"+LoginID+"'",passwordInDB="";
        
        try{
        passwordInDB = user.queryOneElement("password",cond).toString().trim();
        }catch(Exception e){}

        if(passwordInDB.equals(Password))
            isValid=true;
        
        return isValid;
        
    }
    
    private static void setLookNFeel() {
        
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel" );
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );//*/
            
        } catch (Exception e) { }
        
        
    }
    
    private void OK_Pressed(){
            LoginID = txtLoginID.getText().trim();
            Password = pswPassword.getText();
            
        if(!LoginID.equals(""))   {
            
        if(isUserValid()){
            
                if(isPasswordValid()){
                    ValidUser=true;
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Enter a valid password", "Sorry: could not log you on!",JOptionPane.ERROR_MESSAGE);
                    pswPassword.selectAll();
                    pswPassword.requestFocus(); 
                }              
            
        }
        else{
                JOptionPane.showMessageDialog(this,"Enter the correct LoginID", "User not recognised:",JOptionPane.ERROR_MESSAGE);
                txtLoginID.selectAll();
                txtLoginID.requestFocus(); 
            }            
              
                  }
          else{
            JOptionPane.showMessageDialog(this,"LoginID field cannot be blank", "Enter the LoginID:",JOptionPane.ERROR_MESSAGE);
           txtLoginID.requestFocus(); 
          }            
        
    }
    
    private void Cancel_Pressed(){
        this.setVisible(false);
        System.exit(0);        
    }

}
