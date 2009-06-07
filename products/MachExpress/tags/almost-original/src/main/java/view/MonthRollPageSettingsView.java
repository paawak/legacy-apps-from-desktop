/*
 * MonthRollPageSettingsView.java
 *
 * Created on 11 May 2004, 20:25
 */

package view;

/**
 *
 * @author  paawak
 */
import javax.swing.*;

import controller.*;

public class MonthRollPageSettingsView extends javax.swing.JPanel {
    
    /** Creates new form MonthRollPageSettingsView */
    public MonthRollPageSettingsView() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        pnlTitle = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        frmTxtCols = new javax.swing.JFormattedTextField(new java.text.DecimalFormat("0"));
        jLabel2 = new javax.swing.JLabel();
        frmTxtLines = new javax.swing.JFormattedTextField(new java.text.DecimalFormat("0"));
        btSave = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitle.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("<html><u>Page Settings For Invoice File</u></html>");
        pnlTitle.add(jLabel17, java.awt.BorderLayout.CENTER);

        add(pnlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 440, 30));

        jLabel1.setText("Max. no. of characters in a column :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        frmTxtCols.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        frmTxtCols.setText(cnt.getCols());
        frmTxtCols.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        add(frmTxtCols, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 50, -1));

        jLabel2.setText("Max. no. of lines in a page :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        frmTxtLines.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        frmTxtLines.setText(cnt.getLines());
        frmTxtLines.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        add(frmTxtLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 50, -1));

        btSave.setMnemonic('s');
        btSave.setText("Save");
        btSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSaveMouseReleased(evt);
            }
        });

        add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        btClose.setMnemonic('c');
        btClose.setText("Close");
        btClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btCloseMouseReleased(evt);
            }
        });

        add(btClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

    }//GEN-END:initComponents

    private void btCloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCloseMouseReleased
        // Add your handling code here:
        btClosePressed();
    }//GEN-LAST:event_btCloseMouseReleased

    private void btSaveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveMouseReleased
        // Add your handling code here:
        btSavePressed();
    }//GEN-LAST:event_btSaveMouseReleased
    
    private boolean isDataValid(){
        boolean flag = false;
        if(frmTxtCols.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this,"Cannot be empty","",JOptionPane.INFORMATION_MESSAGE);
            frmTxtCols.requestFocus();
        }
        else if(Integer.parseInt(frmTxtCols.getText().trim())==0){
            JOptionPane.showMessageDialog(this,"Cannot be zero","",JOptionPane.INFORMATION_MESSAGE);
            frmTxtCols.requestFocus();            
        }
        else if(frmTxtLines.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this,"Cannot be empty","",JOptionPane.INFORMATION_MESSAGE);
            frmTxtLines.requestFocus();
        }
        else if(Integer.parseInt(frmTxtLines.getText().trim())==0){
            JOptionPane.showMessageDialog(this,"Cannot be zero","",JOptionPane.INFORMATION_MESSAGE);
            frmTxtLines.requestFocus();            
        }        
        else
            flag=true;
        return flag;
    }
    
    private void btSavePressed(){
        if(isDataValid())
            if(cnt.updatePageSettings(new Object[]{frmTxtCols.getText().trim(),frmTxtLines.getText().trim()})){
                JOptionPane.showMessageDialog(this,"Data modified successfully","Saved:",JOptionPane.INFORMATION_MESSAGE);
                //clearInputs();
            }
            else
                JOptionPane.showMessageDialog(this,"Data could not be modified","Sorry:",JOptionPane.ERROR_MESSAGE);
    }
    
    private void clearInputs(){
        frmTxtCols.setText("");
        frmTxtLines.setText("");
    }
    
    private void btClosePressed(){
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btSave;
    private javax.swing.JFormattedTextField frmTxtCols;
    private javax.swing.JFormattedTextField frmTxtLines;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
    
    private SettingsController cnt = new SettingsController();
}
