/*
 * MotorFrame.java
 *
 * Created on March 21, 2003, 12:13 PM
 */

package view;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

import controller.*;
import view.master.*;
import view.transaction.*;
import usefulClasses.generalUtilities.*;
import usefulClasses.databaseOperations.*;



/**
 *
 * @author  Administrator
 */
public class InventoryFrame extends javax.swing.JFrame {
    
    public static  InventoryPanel Panel = new InventoryPanel();
    
    /** Creates new form MotorFrame */
    public InventoryFrame() {
        initComponents();

        getContentPane().add(Panel,BorderLayout.CENTER);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        mnBarMain = new javax.swing.JMenuBar();
        jMnMasters = new javax.swing.JMenu();
        jMnEmployeeMaster = new javax.swing.JMenuItem();
        jMnItemGroupMaster = new javax.swing.JMenuItem();
        jMnItemMaster = new javax.swing.JMenuItem();
        jMnStoreMaster = new javax.swing.JMenuItem();
        jMnCurrencyMaster = new javax.swing.JMenuItem();
        jMnCashLocMaster = new javax.swing.JMenuItem();
        jMnBankMaster = new javax.swing.JMenuItem();
        jMnSupplierMaster = new javax.swing.JMenuItem();
        jMnPaymodeMaster = new javax.swing.JMenuItem();
        jMnCustomerGroupMaster = new javax.swing.JMenuItem();
        jMnCustomerMaster = new javax.swing.JMenuItem();
        jMnLocationMaster = new javax.swing.JMenuItem();
        jMnUnitMaster = new javax.swing.JMenuItem();
        jMnTaxMaster = new javax.swing.JMenuItem();
        jMnDiscountMaster = new javax.swing.JMenuItem();
        jMnUserMaster = new javax.swing.JMenuItem();
        jMnTransactions = new javax.swing.JMenu();
        jMnCustomerOrder = new javax.swing.JMenuItem();
        jMnPurchaseOrder = new javax.swing.JMenuItem();
        jMnGRN = new javax.swing.JMenuItem();
        jMnDeliveryOrder = new javax.swing.JMenuItem();
        jMnInvoice = new javax.swing.JMenuItem();
        jMnDOCumInv = new javax.swing.JMenuItem();
        jMnPurchaseReturns = new javax.swing.JMenuItem();
        jMnLoginMaster = new javax.swing.JMenu();
        jMnLogGrantAccess = new javax.swing.JMenuItem();

        getContentPane().setLayout(new java.awt.CardLayout());

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mnBarMain.setBackground(new java.awt.Color(255, 255, 204));
        jMnMasters.setBackground(new java.awt.Color(255, 255, 204));
        jMnMasters.setText("Masters");
        jMnEmployeeMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnEmployeeMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnEmployeeMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnEmployeeMaster.setText("Employee Master");
        jMnEmployeeMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnEmployeeMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnEmployeeMaster);

        jMnItemGroupMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnItemGroupMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnItemGroupMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnItemGroupMaster.setText("Item Group Master");
        jMnItemGroupMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnItemGroupMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnItemGroupMaster);

        jMnItemMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnItemMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnItemMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnItemMaster.setText("Item Master");
        jMnItemMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnItemMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnItemMaster);

        jMnStoreMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnStoreMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnStoreMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnStoreMaster.setText("Store Master");
        jMnStoreMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnStoreMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnStoreMaster);

        jMnCurrencyMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnCurrencyMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnCurrencyMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnCurrencyMaster.setText("Currency Master");
        jMnCurrencyMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnCurrencyMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnCurrencyMaster);

        jMnCashLocMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnCashLocMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnCashLocMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnCashLocMaster.setText("Cash Loc Master");
        jMnCashLocMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnCashLocMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnCashLocMaster);

        jMnBankMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnBankMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnBankMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnBankMaster.setText("Bank Master");
        jMnBankMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnBankMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnBankMaster);

        jMnSupplierMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnSupplierMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnSupplierMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnSupplierMaster.setText("Supplier Master");
        jMnSupplierMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnSupplierMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnSupplierMaster);

        jMnPaymodeMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnPaymodeMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnPaymodeMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnPaymodeMaster.setText("Paymode Master");
        jMnPaymodeMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnPaymodeMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnPaymodeMaster);

        jMnCustomerGroupMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnCustomerGroupMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnCustomerGroupMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnCustomerGroupMaster.setText("Customer Group Master");
        jMnCustomerGroupMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnCustomerGroupMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnCustomerGroupMaster);

        jMnCustomerMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnCustomerMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnCustomerMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnCustomerMaster.setText("Customer Master");
        jMnCustomerMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnCustomerMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnCustomerMaster);

        jMnLocationMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnLocationMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnLocationMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnLocationMaster.setText("Location Master");
        jMnLocationMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnLocationMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnLocationMaster);

        jMnUnitMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnUnitMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnUnitMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnUnitMaster.setText("Unit Master");
        jMnUnitMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnUnitMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnUnitMaster);

        jMnTaxMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnTaxMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnTaxMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnTaxMaster.setText("Tax Master");
        jMnTaxMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnTaxMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnTaxMaster);

        jMnDiscountMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnDiscountMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnDiscountMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnDiscountMaster.setText("Discount Master");
        jMnDiscountMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnDiscountMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnDiscountMaster);

        jMnUserMaster.setBackground(new java.awt.Color(204, 255, 204));
        jMnUserMaster.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnUserMaster.setForeground(new java.awt.Color(53, 42, 212));
        jMnUserMaster.setText("User Master");
        jMnUserMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnUserMasterMouseReleased(evt);
            }
        });

        jMnMasters.add(jMnUserMaster);

        mnBarMain.add(jMnMasters);

        jMnTransactions.setBackground(new java.awt.Color(255, 255, 204));
        jMnTransactions.setText("Transactions");
        jMnCustomerOrder.setBackground(new java.awt.Color(204, 255, 204));
        jMnCustomerOrder.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnCustomerOrder.setForeground(new java.awt.Color(53, 42, 212));
        jMnCustomerOrder.setText("Customer Order");
        jMnCustomerOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnCustomerOrderMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnCustomerOrder);

        jMnPurchaseOrder.setBackground(new java.awt.Color(204, 255, 204));
        jMnPurchaseOrder.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnPurchaseOrder.setForeground(new java.awt.Color(53, 42, 212));
        jMnPurchaseOrder.setText("Purchase Order");
        jMnPurchaseOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnPurchaseOrderMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnPurchaseOrder);

        jMnGRN.setBackground(new java.awt.Color(204, 255, 204));
        jMnGRN.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnGRN.setForeground(new java.awt.Color(53, 42, 212));
        jMnGRN.setText("Goods Reciept Note");
        jMnGRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnGRNMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnGRN);

        jMnDeliveryOrder.setBackground(new java.awt.Color(204, 255, 204));
        jMnDeliveryOrder.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnDeliveryOrder.setForeground(new java.awt.Color(53, 42, 212));
        jMnDeliveryOrder.setText("Delivery Order");
        jMnDeliveryOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnDeliveryOrderMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnDeliveryOrder);

        jMnInvoice.setBackground(new java.awt.Color(204, 255, 204));
        jMnInvoice.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnInvoice.setForeground(new java.awt.Color(53, 42, 212));
        jMnInvoice.setText("Invoice");
        jMnInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnInvoiceMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnInvoice);

        jMnDOCumInv.setBackground(new java.awt.Color(204, 255, 204));
        jMnDOCumInv.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnDOCumInv.setForeground(new java.awt.Color(53, 42, 212));
        jMnDOCumInv.setText("D.O. Cum Invoice");
        jMnDOCumInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnDOCumInvMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnDOCumInv);

        jMnPurchaseReturns.setBackground(new java.awt.Color(204, 255, 204));
        jMnPurchaseReturns.setFont(new java.awt.Font("Book Antiqua", 0, 12));
        jMnPurchaseReturns.setForeground(new java.awt.Color(53, 42, 212));
        jMnPurchaseReturns.setText("Purchase Returns");
        jMnPurchaseReturns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnPurchaseReturnsMouseReleased(evt);
            }
        });

        jMnTransactions.add(jMnPurchaseReturns);

        mnBarMain.add(jMnTransactions);

        jMnLoginMaster.setBackground(new java.awt.Color(255, 255, 204));
        jMnLoginMaster.setText("LoginMaster  ");
        jMnLogGrantAccess.setBackground(new java.awt.Color(255, 255, 204));
        jMnLogGrantAccess.setFont(new java.awt.Font("Dialog", 1, 10));
        jMnLogGrantAccess.setText("GrantAccess");
        jMnLogGrantAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnLogGrantAccessMouseReleased(evt);
            }
        });

        jMnLoginMaster.add(jMnLogGrantAccess);

        mnBarMain.add(jMnLoginMaster);

        setJMenuBar(mnBarMain);

        pack();
    }//GEN-END:initComponents

    private void jMnPurchaseReturnsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnPurchaseReturnsMouseReleased
        // Add your handling code here:
        showPurchaseReturnsPanel();
    }//GEN-LAST:event_jMnPurchaseReturnsMouseReleased

    private void jMnGRNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnGRNMouseReleased
        // Add your handling code here:
        showGRNPanel();
    }//GEN-LAST:event_jMnGRNMouseReleased

    private void jMnPurchaseOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnPurchaseOrderMouseReleased
        // Add your handling code here:
        showPurchaseOrderPanel();
    }//GEN-LAST:event_jMnPurchaseOrderMouseReleased

    private void jMnDOCumInvMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnDOCumInvMouseReleased
        // Add your handling code here:
        showDOCumInvPanel();
    }//GEN-LAST:event_jMnDOCumInvMouseReleased

    private void jMnInvoiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnInvoiceMouseReleased
        // Add your handling code here:
        showInvoicePanel();
    }//GEN-LAST:event_jMnInvoiceMouseReleased

    private void jMnDeliveryOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnDeliveryOrderMouseReleased
        // Add your handling code here:
        showDeliveryOrderPanel();
    }//GEN-LAST:event_jMnDeliveryOrderMouseReleased

    private void jMnUserMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnUserMasterMouseReleased
        // Add your handling code here:
        showUserMasterPanel();
    }//GEN-LAST:event_jMnUserMasterMouseReleased

    private void jMnDiscountMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnDiscountMasterMouseReleased
        // Add your handling code here:
        showDiscountMasterPanel();
    }//GEN-LAST:event_jMnDiscountMasterMouseReleased

    private void jMnTaxMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnTaxMasterMouseReleased
        // Add your handling code here:
        showTaxMasterPanel();
    }//GEN-LAST:event_jMnTaxMasterMouseReleased

    private void jMnUnitMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnUnitMasterMouseReleased
        // Add your handling code here:
        showUnitMasterPanel();
    }//GEN-LAST:event_jMnUnitMasterMouseReleased

    private void jMnLocationMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnLocationMasterMouseReleased
        // Add your handling code here:
        showLocationMasterPanel();
    }//GEN-LAST:event_jMnLocationMasterMouseReleased

    private void jMnCustomerMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnCustomerMasterMouseReleased
        // Add your handling code here:
        showCustomerMasterPanel();
    }//GEN-LAST:event_jMnCustomerMasterMouseReleased

    private void jMnCustomerGroupMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnCustomerGroupMasterMouseReleased
        // Add your handling code here:
        showCustomerGroupMasterPanel();
    }//GEN-LAST:event_jMnCustomerGroupMasterMouseReleased

    private void jMnPaymodeMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnPaymodeMasterMouseReleased
        // Add your handling code here:
        showPaymodeMasterPanel();
    }//GEN-LAST:event_jMnPaymodeMasterMouseReleased

    private void jMnSupplierMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnSupplierMasterMouseReleased
        // Add your handling code here:
        showSupplierMasterPanel();
    }//GEN-LAST:event_jMnSupplierMasterMouseReleased

    private void jMnBankMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnBankMasterMouseReleased
        // Add your handling code here:
        showBankMasterPanel();
    }//GEN-LAST:event_jMnBankMasterMouseReleased

    private void jMnCashLocMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnCashLocMasterMouseReleased
        // Add your handling code here:
        showCashLocMasterPanel();
    }//GEN-LAST:event_jMnCashLocMasterMouseReleased

    private void jMnCurrencyMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnCurrencyMasterMouseReleased
        // Add your handling code here:
        showCurrencyMasterPanel();
    }//GEN-LAST:event_jMnCurrencyMasterMouseReleased

    private void jMnItemMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnItemMasterMouseReleased
        // Add your handling code here:
        showItemMasterPanel();
    }//GEN-LAST:event_jMnItemMasterMouseReleased

    private void jMnItemGroupMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnItemGroupMasterMouseReleased
        // Add your handling code here:
        showItemGroupMasterPanel();
    }//GEN-LAST:event_jMnItemGroupMasterMouseReleased

    private void jMnEmployeeMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnEmployeeMasterMouseReleased
        // Add your handling code here:
        showEmployeeMasterPanel();
    }//GEN-LAST:event_jMnEmployeeMasterMouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Add your handling code here:
        /*LoginDialog login = new LoginDialog(new java.awt.Frame(),true);
        login.txtLoginID.requestFocus();
        login.show(); //*/        
    }//GEN-LAST:event_formWindowOpened

    private void jMnLogGrantAccessMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnLogGrantAccessMouseReleased
        // Add your handling code here:
        //showLoginPanel();
    }//GEN-LAST:event_jMnLogGrantAccessMouseReleased

    private void jMnStoreMasterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnStoreMasterMouseReleased
        // Add your handling code here:
        showStoreMasterPanel();
    }//GEN-LAST:event_jMnStoreMasterMouseReleased

    private void jMnCustomerOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMnCustomerOrderMouseReleased
        // Add your handling code here:
        showCOPanel();
    }//GEN-LAST:event_jMnCustomerOrderMouseReleased
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /** @param args the command line arguments
     *
     *
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMnPurchaseReturns;
    private javax.swing.JMenuBar mnBarMain;
    private javax.swing.JMenuItem jMnLocationMaster;
    private javax.swing.JMenu jMnTransactions;
    private javax.swing.JMenuItem jMnItemMaster;
    private javax.swing.JMenuItem jMnItemGroupMaster;
    private javax.swing.JMenuItem jMnLogGrantAccess;
    private javax.swing.JMenuItem jMnDiscountMaster;
    private javax.swing.JMenuItem jMnUserMaster;
    private javax.swing.JMenuItem jMnGRN;
    private javax.swing.JMenuItem jMnDOCumInv;
    private javax.swing.JMenu jMnLoginMaster;
    private javax.swing.JMenuItem jMnCashLocMaster;
    private javax.swing.JMenuItem jMnCustomerMaster;
    private javax.swing.JMenuItem jMnCustomerOrder;
    private javax.swing.JMenuItem jMnPurchaseOrder;
    private javax.swing.JMenuItem jMnUnitMaster;
    private javax.swing.JMenuItem jMnInvoice;
    private javax.swing.JMenuItem jMnBankMaster;
    private javax.swing.JMenu jMnMasters;
    private javax.swing.JMenuItem jMnTaxMaster;
    private javax.swing.JMenuItem jMnPaymodeMaster;
    private javax.swing.JMenuItem jMnDeliveryOrder;
    private javax.swing.JMenuItem jMnStoreMaster;
    private javax.swing.JMenuItem jMnCustomerGroupMaster;
    private javax.swing.JMenuItem jMnSupplierMaster;
    private javax.swing.JMenuItem jMnCurrencyMaster;
    private javax.swing.JMenuItem jMnEmployeeMaster;
    // End of variables declaration//GEN-END:variables
  
    
    private void showBankMasterPanel(){
        
        BankMasterPanel pnl = new BankMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showCashLocMasterPanel(){
        
        CashLocMasterPanel pnl = new CashLocMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showCurrencyMasterPanel(){
        
        CurrencyMasterPanel pnl = new CurrencyMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showCustomerGroupMasterPanel(){
        
        CustomerGroupMasterPanel pnl = new CustomerGroupMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showCustomerMasterPanel(){
        
        CustomerMasterPanel pnl = new CustomerMasterPanel();
        Panel.setBodyPanel(pnl); 
    }    
    
    private void showDiscountMasterPanel(){
        
        DiscountMasterPanel pnl = new DiscountMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showEmployeeMasterPanel(){
        
        EmployeeMasterPanel pnl = new EmployeeMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showItemGroupMasterPanel(){
        
        ItemGroupMasterPanel pnl = new ItemGroupMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showItemMasterPanel(){
        
        ItemMasterPanel pnl = new ItemMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showLocationMasterPanel(){
        
        LocationMasterPanel pnl = new LocationMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showPaymodeMasterPanel(){
        
        PaymodeMasterPanel pnl = new PaymodeMasterPanel();
        Panel.setBodyPanel(pnl); 
    }    
     
    private void showStoreMasterPanel(){
        
        StoreMasterPanel pnl = new StoreMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showSupplierMasterPanel(){
        
        SupplierMasterPanel pnl = new SupplierMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showTaxMasterPanel(){
        
        TaxMasterPanel pnl = new TaxMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showUnitMasterPanel(){
        
        UnitMasterPanel pnl = new UnitMasterPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showUserMasterPanel(){
        
        UserMasterPanel pnl = new UserMasterPanel();
        Panel.setBodyPanel(pnl); 
    }

    
    private void showCOPanel(){
        
        COPanel pnl = new COPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    
    private void showDOCumInvPanel(){
        
        DOCumInvPanel pnl = new DOCumInvPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showDeliveryOrderPanel(){
        
        DeliveryOrderPanel pnl = new DeliveryOrderPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showGRNPanel(){
        
        GRNPanel pnl = new GRNPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showInvoicePanel(){
        
        InvoicePanel pnl = new InvoicePanel();
        Panel.setBodyPanel(pnl); 
    }
    
    private void showPurchaseOrderPanel(){
        
        PurchaseOrderPanel pnl = new PurchaseOrderPanel();
        Panel.setBodyPanel(pnl); 
    }    
    
    private void showPurchaseReturnsPanel(){
        
        PurchaseReturnsPanel pnl = new PurchaseReturnsPanel();
        Panel.setBodyPanel(pnl); 
    }
    
    
    
}