/*
 * KeyTable.java
 *
 * Created on July 17, 2005, 11:42 AM
 */

package com.swayam.bhasha.prefs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.text.*;
import javax.swing.text.*;
import java.util.*;
import com.swayam.bhasha.utils.page.IndicPane;
import com.swayam.bhasha.utils.PropertyFileUtils;
import com.swayam.generic.utils.FontLoader;

/**
 *
 * @author  paawak
 */
public class KeyTable extends javax.swing.JDialog {
    
	private static final long serialVersionUID = -4950965396463872306L;
	
	/**
     * Creates new form KeyTable
     */
    public KeyTable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        changeLanguage();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnGrpIndicLanguage = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rdBtBangla = new javax.swing.JRadioButton();
        rdBtHindi = new javax.swing.JRadioButton();
        pnlTableHome = new javax.swing.JPanel();
        scrPnlTableHolder = new javax.swing.JScrollPane();
        pnlButtonHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIndicChar = new JFormattedTextField(
            new DefaultFormatter(){
                public Object stringToValue(String text) throws ParseException {
                    Pattern pattern = Pattern.compile(REGEX_INDIC_TEXT);

                    if (pattern != null) {
                        Matcher matcher = pattern.matcher(text);

                        if (matcher.matches()) {
                            return super.stringToValue(text);
                        }
                        throw new ParseException("Pattern did not match", 0);
                    }
                    return text;
                }

            });
            jLabel2 = new javax.swing.JLabel();
            txtEnglishChar = new JFormattedTextField(
                new DefaultFormatter(){
                    public Object stringToValue(String text) throws ParseException {
                        Pattern pattern = Pattern.compile(REGEX_ENGLISH_TEXT);

                        if (pattern != null) {
                            Matcher matcher = pattern.matcher(text);

                            if (matcher.matches()) {
                                return super.stringToValue(text);
                            }
                            throw new ParseException("Pattern did not match", 0);
                        }
                        return text;
                    }

                });

                btAdd = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                btSaveSettings = new javax.swing.JButton();
                btRestoreDefaults = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                pnlMain.setLayout(new java.awt.BorderLayout());

                pnlMain.setBackground(new java.awt.Color(255, 255, 255));
                btnGrpIndicLanguage.add(rdBtBangla);
                rdBtBangla.setSelected(true);
                rdBtBangla.setText("Bangla");
                rdBtBangla.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        rdBtBanglaMouseReleased(evt);
                    }
                });

                jPanel1.add(rdBtBangla);

                btnGrpIndicLanguage.add(rdBtHindi);
                rdBtHindi.setText("Hindi");
                rdBtHindi.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        rdBtHindiMouseReleased(evt);
                    }
                });

                jPanel1.add(rdBtHindi);

                pnlMain.add(jPanel1, java.awt.BorderLayout.NORTH);

                pnlTableHome.setLayout(new java.awt.BorderLayout());

                pnlTableHome.setBackground(new java.awt.Color(102, 204, 255));
                scrPnlTableHolder.setBackground(new java.awt.Color(153, 204, 255));
                pnlTableHome.add(scrPnlTableHolder, java.awt.BorderLayout.CENTER);

                pnlMain.add(pnlTableHome, java.awt.BorderLayout.CENTER);

                pnlButtonHome.setLayout(new java.awt.GridBagLayout());

                jLabel1.setText("Indic char(Hex):");
                jLabel1.setMaximumSize(new java.awt.Dimension(80, 20));
                jLabel1.setMinimumSize(new java.awt.Dimension(30, 20));
                jLabel1.setPreferredSize(new java.awt.Dimension(60, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.3;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
                pnlButtonHome.add(jLabel1, gridBagConstraints);

                txtIndicChar.setMargin(new java.awt.Insets(0, 0, 0, 0));
                txtIndicChar.setMaximumSize(new java.awt.Dimension(60, 20));
                txtIndicChar.setMinimumSize(new java.awt.Dimension(30, 20));
                txtIndicChar.setPreferredSize(new java.awt.Dimension(60, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.3;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
                pnlButtonHome.add(txtIndicChar, gridBagConstraints);

                jLabel2.setText("English text:");
                jLabel2.setMaximumSize(new java.awt.Dimension(60, 20));
                jLabel2.setMinimumSize(new java.awt.Dimension(30, 20));
                jLabel2.setPreferredSize(new java.awt.Dimension(60, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.weightx = 0.3;
                gridBagConstraints.weighty = 0.3;
                gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
                pnlButtonHome.add(jLabel2, gridBagConstraints);

                txtEnglishChar.setMargin(new java.awt.Insets(0, 0, 0, 0));
                txtEnglishChar.setMaximumSize(new java.awt.Dimension(60, 20));
                txtEnglishChar.setMinimumSize(new java.awt.Dimension(30, 20));
                txtEnglishChar.setPreferredSize(new java.awt.Dimension(60, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
                pnlButtonHome.add(txtEnglishChar, gridBagConstraints);

                btAdd.setText("Add");
                btAdd.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        btAddMouseReleased(evt);
                    }
                });

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 4;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.weightx = 0.2;
                gridBagConstraints.weighty = 0.2;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
                pnlButtonHome.add(btAdd, gridBagConstraints);

                btSaveSettings.setText("Save Settings");
                btSaveSettings.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        btSaveSettingsMouseReleased(evt);
                    }
                });

                jPanel2.add(btSaveSettings);

                btRestoreDefaults.setText("Restore Defaults");
                btRestoreDefaults.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        btRestoreDefaultsMouseReleased(evt);
                    }
                });

                jPanel2.add(btRestoreDefaults);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 5;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                pnlButtonHome.add(jPanel2, gridBagConstraints);

                pnlMain.add(pnlButtonHome, java.awt.BorderLayout.SOUTH);

                getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

                java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                setBounds((screenSize.width-496)/2, (screenSize.height-600)/2, 496, 600);
            }
            // </editor-fold>//GEN-END:initComponents
    
    private void btRestoreDefaultsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRestoreDefaultsMouseReleased
        int choice = JOptionPane.showConfirmDialog(this,
                "This will reset all settings to default. Are you sure you want to continue",
                "Reset to default?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            PropertyFileUtils props = new PropertyFileUtils();
            if(props.deleteUserSettingsFile(currentLocale)){
                JOptionPane.showMessageDialog(this,
                        "Settings reset to default",
                        "Operation successful",
                        JOptionPane.INFORMATION_MESSAGE);
                currentCharMap = props.getKeyMap(currentLocale, true);
                displayTable();
            }else{
                JOptionPane.showMessageDialog(this,
                        "Settings could not be reset to default",
                        "Sorry!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btRestoreDefaultsMouseReleased
        
    private void btSaveSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveSettingsMouseReleased
        int choice =
                JOptionPane.showConfirmDialog(this,
                "Are you sure you want to save the changed settings?",
                "Confirm save:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(choice == JOptionPane.YES_OPTION){
            boolean  saved = new PropertyFileUtils().writeKeyMapToUserFile(
                    tblModel.getDataAsMapWithIndicKeys(true), currentLocale);
            if(saved){
                JOptionPane.showMessageDialog(this,
                        "Changed settings saved successfully.",
                        "Saved", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,
                        "Sorry! The settings could not be saved",
                        "Error in saving", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btSaveSettingsMouseReleased
    
    private void btAddMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseReleased
        addNewKey();
    }//GEN-LAST:event_btAddMouseReleased
    
    private void rdBtHindiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdBtHindiMouseReleased
        changeLanguage();
    }//GEN-LAST:event_rdBtHindiMouseReleased
    
    private void rdBtBanglaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdBtBanglaMouseReleased
        changeLanguage();
    }//GEN-LAST:event_rdBtBanglaMouseReleased
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeyTable(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }//*/
    
    /**
     *creates the table, adds the model to it and displays it
     */
    private void displayTable(){
        //String deleteImage = "<HTML><IMG SRC='../images/delete.png'></HTML>";
        String[] tblHeaderNames = {"Indic Char", "English Char", "<HTML>Delete</HTML>"};
        tblModel = new MyTableModel(currentCharMap, tblHeaderNames);
        final JTable table = new JTable(tblModel);
        table.setRowHeight(40);
        table.setRowMargin(3);
        TableColumn indicCol = table.getColumn(tblHeaderNames[0]);
        indicCol.setMaxWidth(100);
        indicCol.setPreferredWidth(80);
        indicCol.setCellRenderer(new TableCellRenderer(){
            public Component getTableCellRendererComponent(
                    JTable table, Object text,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = new JLabel(text.toString());
                label.setToolTipText(
                        "<HTML><FONT COLOR='RED'><B>" 
                        + PropertyFileUtils.getHexCodeFromIndics(text.toString())
                        +"</B></FONT></HTML>");
                label.setOpaque(true);
                label.setBackground(Color.YELLOW);
                label.setForeground(Color.RED);
                
                Font font = (Font)IndicPane.LOCALE_TO_FONT.get(currentLocale);
            	
                //hack for bangla
            	if (currentLocale == IndicPane.BANGLA_LOCALE && !font.canDisplay('\u0985')) {
    	        	String defaultBanglaFont = FontLoader.getBanglaFonts().iterator().next();
    	        	font = new Font(defaultBanglaFont, Font.PLAIN, 14);
            	}
                
                label.setFont(font);
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
        });
        
        TableColumn englishCol = table.getColumn(tblHeaderNames[1]);
        //add custom cell renderer
        englishCol.setCellRenderer(new TableCellRenderer(){
            public Component getTableCellRendererComponent(
                    JTable table, Object text,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = new JLabel((String)text);
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLUE);
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
        });
        
        //add custom cell-editor
        JTextField txtFld = new JTextField();
        txtFld.setHorizontalAlignment(JTextField.CENTER);
        txtFld.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e) {
                selectedRow = table.getSelectedRow();
                selectedColumn = table.getSelectedColumn();
                prevCharMapFrmTable = tblModel.getDataAsMapWithIndicKeys(false);
                prevText = (String)table.getValueAt(selectedRow, selectedColumn);
            }
        });
        
        txtFld.addFocusListener(new FocusAdapter(){
            public void focusLost(FocusEvent e) {
                String englishChar = (String)table.getValueAt(selectedRow, selectedColumn);
                boolean inValidEntry = true;
                String invalidString = null;
//                String indicCharAlreadyMappedTo = null;
                if(Pattern.matches(REGEX_ENGLISH_TEXT,
                        englishChar)){
                    //check whether each comma separated value is already mapped
                    String[] englishKeys = englishChar.split(",");
                    
                    for(int i=0; i<englishKeys.length; i++){
                        if(prevCharMapFrmTable.containsKey(englishKeys[i])){
//                            indicCharAlreadyMappedTo = prevCharMapFrmTable.get(englishKeys[i]).toString();
                            invalidString = englishKeys[i];
                            inValidEntry = true;
                            break;
                        }
                        inValidEntry = false;
                    }
                }
                
                if(inValidEntry){
//                    if(indicCharAlreadyMappedTo != null){
//                        char[] indicChars = indicCharAlreadyMappedTo.toCharArray();
//                        indicCharAlreadyMappedTo = "";
//                        for(int i=0; i<indicChars.length; i++){
//                            indicCharAlreadyMappedTo += "&#" + (int)indicChars[i] + ";";
//                        }
//                    }
                    
//                    String msg = invalidString == null?
//                        "Please enter valid characters in the correct format."
//                            : "<HTML>The English char `"+invalidString+"` is already mapped to "+
//                            "<FONT FAMILY='"
//                            +((Font)Bangla.LOCALE_TO_FONT.get(currentLocale)).getFamily()
//                            +"'>"+indicCharAlreadyMappedTo+"</FONT>" +
//                            "</HTML>";
                    String msg = invalidString == null?
                        "Please enter valid characters in the correct format."
                            : "The English char `"+invalidString+"` is already mapped.";
                    
                    JOptionPane.showMessageDialog(null,
                            msg,
                            "Enter valid character", JOptionPane.ERROR_MESSAGE);
                    table.setValueAt(prevText, selectedRow, selectedColumn);
                }
            }
        });
        
        englishCol.setCellEditor(new DefaultCellEditor(txtFld));
        
        TableColumn deleteCol = table.getColumn(tblHeaderNames[2]);
        deleteCol.setMaxWidth(50);
        deleteCol.setPreferredWidth(50);
        final JCheckBox chkBox = new JCheckBox();
        chkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    int deleteOption = JOptionPane.showConfirmDialog(
                            SwingUtilities.getWindowAncestor(chkBox),
                            "Are you sure you want to delete this character?",
                            "Proceed to DELETE:", JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if(deleteOption == JOptionPane.CANCEL_OPTION ||
                            deleteOption == JOptionPane.NO_OPTION){
                        chkBox.setSelected(false);
                    } else{//delete
                        int rowToDelete = table.getSelectedRow();
                        currentCharMap.remove(table.getValueAt(rowToDelete, 0));
                        displayTable();
                    }
                }
            }
        });
        deleteCol.setCellEditor(new DefaultCellEditor(chkBox));
        scrPnlTableHolder.setViewportView(table);
    }
    
    /**
     *adds a new IndicKey and its english equivalent
     * in the property and re-displays the table
     */
    private void addNewKey(){
        //TODO: check validations and output relevant messages
        String indicChar = "";
        try{
            indicChar = Character.toString(
                    (char)Integer.decode("0x" + txtIndicChar.getText().trim()).intValue()
                    );
        }catch (NumberFormatException e){
            return ;
        }
        String englishChar = txtEnglishChar.getText();
        //is the English char already mapped to some other Indic char?
        //call the Map with English keys
        Map englishKeyMap = new PropertyFileUtils().getKeyMap(currentLocale, false);
        if(englishKeyMap.containsKey(englishChar)){
            JOptionPane.showMessageDialog(this,
                    "The English character `"+englishChar+"` is already mapped.",
                    "Char already mapped", JOptionPane.ERROR_MESSAGE);
        }
        //is the entered Indic char already mapped? append it
        else if(currentCharMap.containsKey(indicChar)){
            currentCharMap.put(indicChar,
                    currentCharMap.get(indicChar) + "," + englishChar
                    );
            displayTable();
        } else{
            currentCharMap.put(indicChar, englishChar);
            displayTable();
        }
        
        txtIndicChar.setText("");
        txtEnglishChar.setText("");
    }
    
    private void changeLanguage(){
        if(rdBtBangla.isSelected()){
            currentLocale = IndicPane.BANGLA_LOCALE;
        } else if(rdBtHindi.isSelected()){
            currentLocale = IndicPane.HINDI_LOCALE;
        }
        
        currentCharMap = new PropertyFileUtils()
        	.getKeyMap(currentLocale, true);
        displayTable();
    }
    
    /**
     *Custom table model
     */
    private class MyTableModel extends AbstractTableModel {
        final String[] columnNames;
        final Object[][] data;
        
        private MyTableModel(Map charMap, String[] columnNames){
            this.columnNames = columnNames;
            data = new Object[charMap.size()][3];
            Iterator keys = charMap.keySet().iterator();
            int i = 0;
            while(keys.hasNext()){
                data[i][0] = keys.next();
                data[i][1] = charMap.get(data[i][0]);
                data[i][2] = new Boolean(false);
                i++;
            }
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }
        
        public int getRowCount() {
            return data.length;
        }
        
        public String getColumnName(int col) {
            return columnNames[col];
        }
        
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            if (col == 1 || col == 2) {
                return true;
            } else {
                return false;
            }
        }
        
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
        
        /**
         * get the data as a Map.
         * Indic chars in col 0 are keys if true is passed.
         * Else, English chars in col 1 as keys.
         */
        private Map getDataAsMapWithIndicKeys(boolean indicKeys) {
            TreeMap map = new TreeMap();
            for(int i=0; i<data.length; i++){
                if(indicKeys){
                    map.put(data[i][0], data[i][1]);
                }else{
                    String[] englishKeys = ((String)data[i][1]).split(",");
                    for(int keyIndex=0; keyIndex<englishKeys.length; keyIndex++){
                        map.put(englishKeys[keyIndex], data[i][0]);
                    }
                }
            }
            return map;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btRestoreDefaults;
    private javax.swing.JButton btSaveSettings;
    private javax.swing.ButtonGroup btnGrpIndicLanguage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlButtonHome;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTableHome;
    private javax.swing.JRadioButton rdBtBangla;
    private javax.swing.JRadioButton rdBtHindi;
    private javax.swing.JScrollPane scrPnlTableHolder;
    private javax.swing.JFormattedTextField txtEnglishChar;
    private javax.swing.JFormattedTextField txtIndicChar;
    // End of variables declaration//GEN-END:variables
    
    /**regular expression for validating English Text entered by user*/
    private final String REGEX_ENGLISH_TEXT_SUB_CLASS = "[(\\.{0,2})(\\w)]{1,4}";
    private final String REGEX_ENGLISH_TEXT = "(" + REGEX_ENGLISH_TEXT_SUB_CLASS + "){1}" +
            "(,{1}" + REGEX_ENGLISH_TEXT_SUB_CLASS + ")*";
    /**regular expression for validating INDIC Text entered by user*/
    private final String REGEX_INDIC_TEXT = "[a-fA-F0-9]{3,4}";
    private Map currentCharMap = null;
    private int selectedRow = -1;
    private int selectedColumn = -1;
    /**stores original value of a cell data before edit on focus gained*/
    private String prevText = null;
    /**stores value of table data before edited on focus gained*/
    private Map prevCharMapFrmTable = null;
    private Locale currentLocale = null;
    private MyTableModel tblModel = null;
    
}
