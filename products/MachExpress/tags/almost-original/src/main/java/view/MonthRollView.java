/*
 * MonthRollView.java
 *
 * Created on 20 April 2004, 16:13
 */

package view;

/**
 *
 * @author  paawak
 */
import java.util.*;
import java.text.*;

import utils.general.*;
import model.*;
import controller.*;
import model.database.*;
import javax.swing.*;

public class MonthRollView extends javax.swing.JPanel implements TableListDB, DailyOrderBookDB{
    
    /** Creates new form MonthRollView */
    public MonthRollView() {
        initComponents();
        setDateFields();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        pnlTitle = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lbFromDate = new javax.swing.JLabel();
        txtFromDate = new javax.swing.JTextField();
        lbToDate = new javax.swing.JLabel();
        txtToDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArDetails = new javax.swing.JTextArea();
        btRoll = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitle.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Month Rolling  For All Clients");
        pnlTitle.add(jLabel17, java.awt.BorderLayout.CENTER);

        add(pnlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 440, 30));

        lbFromDate.setText("From :");
        add(lbFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        txtFromDate.setEditable(false);
        txtFromDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtFromDateMouseReleased(evt);
            }
        });

        add(txtFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 230, -1));

        lbToDate.setText("To :");
        add(lbToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        txtToDate.setEditable(false);
        add(txtToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 230, -1));

        txtArDetails.setEditable(false);
        txtArDetails.setFont(new java.awt.Font("Dialog", 0, 24));
        jScrollPane1.setViewportView(txtArDetails);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 880, 380));

        btRoll.setMnemonic('r');
        btRoll.setText("Roll");
        btRoll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btRollMouseReleased(evt);
            }
        });

        add(btRoll, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, -1, -1));

        btClose.setMnemonic('c');
        btClose.setText("Close");
        btClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCloseMouseReleased(evt);
            }
        });

        add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, -1, -1));

    }//GEN-END:initComponents

    private void btCloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCloseMouseReleased
        // Add your handling code here:
        closeButtonPressed();
    }//GEN-LAST:event_btCloseMouseReleased

    private void txtFromDateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFromDateMouseReleased
        // Add your handling code here:
        ShowCalendar cal = new ShowCalendar(new java.awt.Frame(), true,  txtFromDate);
        cal.show();
        gCal = cal.getSelectedDate();
        setDateFields();        
    }//GEN-LAST:event_txtFromDateMouseReleased

    private void btRollMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRollMouseReleased
        // Add your handling code here:
        rollBtPressed();        
    }//GEN-LAST:event_btRollMouseReleased

    private void closeButtonPressed() {
        this.setVisible(false);
    }    
    
    public void resetFields() {
    }    
    
    private void setDateFields() {
        gCal.set(gCal.DATE,gCal.getMinimum(gCal.DATE));
        Date dt = gCal.getTime();
        String pattern = "dd MMMMMMMM, yyyy";//to be read from property file
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        txtFromDate.setText(formatter.format(dt));
        gCal.set(gCal.DATE,gCal.getActualMaximum(gCal.DAY_OF_MONTH));
        dt = gCal.getTime();
        txtToDate.setText(formatter.format(dt));
    }
    
    private void rollBtPressed() {
        int returned = JOptionPane.showConfirmDialog(this,"Are you sure you want to proceed?","Confirm Roll Procedure",JOptionPane.YES_NO_OPTION);
        if(returned==JOptionPane.YES_OPTION){
            cntrl.roll(this, gCal.get(gCal.YEAR), gCal.get(gCal.MONTH)+1);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btRoll;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFromDate;
    private javax.swing.JLabel lbToDate;
    private javax.swing.JPanel pnlTitle;
    public javax.swing.JTextArea txtArDetails;
    private javax.swing.JTextField txtFromDate;
    private javax.swing.JTextField txtToDate;
    // End of variables declaration//GEN-END:variables

    /** holds the selected date
     *
     */
    private GregorianCalendar gCal = new GregorianCalendar();
    
    private MonthRollController cntrl = new MonthRollController();
        
}
