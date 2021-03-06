/*
 * BhashaDefaultView.java
 *
 * Created on February 22, 2004, 1:15 AM
 */

package com.swayam.bhasha.oldview.impl;

import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.swayam.bhasha.engine.io.writers.DocGenerationException;
import com.swayam.bhasha.engine.io.writers.impl.XHtmlGenerator;
import com.swayam.bhasha.help.Help;
import com.swayam.bhasha.oldview.BhashaView;
import com.swayam.bhasha.oldview.PageContainer;
import com.swayam.bhasha.oldview.io.GenerateOutput;
import com.swayam.bhasha.prefs.KeyTable;
import com.swayam.bhasha.prefs.UserPreferencesImpl;
import com.swayam.bhasha.utils.page.IndicPane;

public class BhashaDefaultView extends JFrame implements BhashaView {

    private static final long serialVersionUID = 7569568699722600721L;

    private final BhashaDefaultPanelView bhashaView;

    private final JTextArea rawHtmlView;

    private final JScrollPane rawHtmlViewPane;

    public BhashaDefaultView(PageContainer pageContainer, Locale[] supportedLanguages, Locale defaultLocale) {
        bhashaView = new BhashaDefaultPanelView(this, pageContainer, supportedLanguages, defaultLocale);
        setPageContainer(pageContainer);

        ImageIcon img = new ImageIcon(getClass().getResource("/images/BanglaLogo.jpg"));
        setIconImage(img.getImage());
        initComponents();

        tabbedPane.addTab("Editor View", bhashaView);

        rawHtmlViewPane = new JScrollPane();
        rawHtmlView = new JTextArea();
        rawHtmlView.setEditable(false);
        rawHtmlViewPane.setViewportView(rawHtmlView);

        tabbedPane.addTab("Raw HTML View", rawHtmlViewPane);

        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                if (tabbedPane.getSelectedComponent() == rawHtmlViewPane) {
                    try {
                        XHtmlGenerator htmlGenerator = new XHtmlGenerator(GenerateOutput.getPageModels(getPageContainer().getPageVector()));
                        String html = htmlGenerator.getHtml();
                        rawHtmlView.setText(html);
                    } catch (DocGenerationException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });

    }

    public void setPageContainer(PageContainer pageContainer) {
        bhashaView.setPageContainer(pageContainer);
    }

    public PageContainer getPageContainer() {
        return bhashaView.getPageContainer();
    }

    public JFrame getJFrame() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        mnBr = new javax.swing.JMenuBar();
        jMnFile = new javax.swing.JMenu();
        jMnNew = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMnOpen = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMnSave = new javax.swing.JMenu();
        jMnXML = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jMnHTML = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jMnJPEG = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JSeparator();
        jMnRTF = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JSeparator();
        jMnPDF = new javax.swing.JMenuItem();
        jMnHelp = new javax.swing.JMenu();
        jMnBanglaHelp = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMnAbout = new javax.swing.JMenuItem();
        jMnSettings = new javax.swing.JMenu();
        jMnLbLanguage = new javax.swing.JMenu();
        jMnBangla = new javax.swing.JMenuItem();
        jMnHindi = new javax.swing.JMenuItem();
        jMnEnglish = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMnKeyboard = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMnResetSettings = new javax.swing.JMenuItem();

        setTitle("Bhasha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        jMnFile.setMnemonic('f');
        jMnFile.setText("File");
        jMnFile.setFont(new java.awt.Font("Verdana", 1, 14));

        jMnNew.setMnemonic('n');
        jMnNew.setText("New");
        jMnNew.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMnNewKeyReleased(evt);
            }
        });
        jMnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnNewMouseReleased(evt);
            }
        });
        jMnFile.add(jMnNew);
        jMnFile.add(jSeparator1);

        jMnOpen.setMnemonic('o');
        jMnOpen.setText("Open");
        jMnOpen.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMnOpenKeyReleased(evt);
            }
        });
        jMnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnOpenMouseReleased(evt);
            }
        });
        jMnFile.add(jMnOpen);
        jMnFile.add(jSeparator2);

        jMnSave.setText("Save");

        jMnXML.setText("XML");
        jMnXML.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnXMLMouseReleased(evt);
            }
        });
        jMnSave.add(jMnXML);
        jMnSave.add(jSeparator6);

        jMnHTML.setText("HTML");
        jMnHTML.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnHTMLMouseReleased(evt);
            }
        });
        jMnSave.add(jMnHTML);
        jMnSave.add(jSeparator7);

        jMnJPEG.setText("Image(JPEG)");
        jMnJPEG.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnJPEGMouseReleased(evt);
            }
        });
        jMnSave.add(jMnJPEG);
        jMnSave.add(jSeparator8);

        jMnRTF.setText("RTF");
        jMnRTF.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnRTFMouseReleased(evt);
            }
        });
        jMnSave.add(jMnRTF);
        jMnSave.add(jSeparator9);

        jMnPDF.setText("PDF");
        jMnPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnPDFMouseReleased(evt);
            }
        });
        jMnSave.add(jMnPDF);

        jMnFile.add(jMnSave);

        mnBr.add(jMnFile);

        jMnHelp.setMnemonic('h');
        jMnHelp.setText("Help");
        jMnHelp.setFont(new java.awt.Font("Verdana", 1, 14));

        jMnBanglaHelp.setMnemonic('t');
        jMnBanglaHelp.setText("How to Type");
        jMnBanglaHelp.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMnBanglaHelpKeyReleased(evt);
            }
        });
        jMnBanglaHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnBanglaHelpMouseReleased(evt);
            }
        });
        jMnHelp.add(jMnBanglaHelp);
        jMnHelp.add(jSeparator3);

        jMnAbout.setText("About");
        jMnAbout.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMnAboutKeyReleased(evt);
            }
        });
        jMnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnAboutMouseReleased(evt);
            }
        });
        jMnHelp.add(jMnAbout);

        mnBr.add(jMnHelp);

        jMnSettings.setMnemonic('t');
        jMnSettings.setText("Settings");
        jMnSettings.setFont(new java.awt.Font("Verdana", 1, 14));

        jMnLbLanguage.setMnemonic('l');
        jMnLbLanguage.setText("Display Language");

        jMnBangla.setMnemonic('b');
        jMnBangla.setText("Bangla");
        jMnBangla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnBanglaMouseReleased(evt);
            }
        });
        jMnLbLanguage.add(jMnBangla);

        jMnHindi.setMnemonic('h');
        jMnHindi.setText("Hindi");
        jMnHindi.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnHindiMouseReleased(evt);
            }
        });
        jMnLbLanguage.add(jMnHindi);

        jMnEnglish.setMnemonic('e');
        jMnEnglish.setText("English");
        jMnEnglish.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnEnglishMouseReleased(evt);
            }
        });
        jMnLbLanguage.add(jMnEnglish);

        jMnSettings.add(jMnLbLanguage);
        jMnSettings.add(jSeparator4);

        jMnKeyboard.setText("Customise Keyboard");
        jMnKeyboard.setAutoscrolls(true);
        jMnKeyboard.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnKeyboardMouseReleased(evt);
            }
        });
        jMnSettings.add(jMnKeyboard);
        jMnSettings.add(jSeparator5);

        jMnResetSettings.setText("Reset Settings");
        jMnResetSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMnResetSettingsMouseReleased(evt);
            }
        });
        jMnSettings.add(jMnResetSettings);

        mnBr.add(jMnSettings);

        setJMenuBar(mnBr);

        setBounds(2, 2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jMnPDFMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnPDFMouseReleased
        generateOutput(GenerateOutput.PDF_FORMAT);
    }// GEN-LAST:event_jMnPDFMouseReleased

    private void jMnRTFMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnRTFMouseReleased
        generateOutput(GenerateOutput.RTF_FORMAT);
    }// GEN-LAST:event_jMnRTFMouseReleased

    private void jMnJPEGMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnJPEGMouseReleased
        generateOutput(GenerateOutput.IMAGE_JPEG_FORMAT);
    }// GEN-LAST:event_jMnJPEGMouseReleased

    private void jMnHTMLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnHTMLMouseReleased
        generateOutput(GenerateOutput.HTML_FORMAT);
    }// GEN-LAST:event_jMnHTMLMouseReleased

    private void jMnXMLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnXMLMouseReleased
        generateOutput(GenerateOutput.XML_FORMAT);
    }// GEN-LAST:event_jMnXMLMouseReleased

    private void jMnResetSettingsMouseReleased(java.awt.event.MouseEvent evt) {// GEN
        // -
        // FIRST
        // :
        // event_jMnResetSettingsMouseReleased
        if (new UserPreferencesImpl().reset()) {
            JOptionPane.showMessageDialog(this, "User settings deleted successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Could not delete settings", "Sorry", JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_jMnResetSettingsMouseReleased

    private void jMnKeyboardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-
        // FIRST
        // :
        // event_jMnKeyboardMouseReleased
        new KeyTable(this, false).setVisible(true);
        // reload the charMap in case the user has changed settings
        bhashaView.refillFontFamilyCombo();
    }// GEN-LAST:event_jMnKeyboardMouseReleased

    private void jMnAboutKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:
        // event_jMnAboutKeyReleased
        showAbout();
    }// GEN-LAST:event_jMnAboutKeyReleased

    private void jMnAboutMouseReleased(java.awt.event.MouseEvent evt) {// GEN-
        // FIRST:
        // event_jMnAboutMouseReleased
        showAbout();
    }// GEN-LAST:event_jMnAboutMouseReleased

    private void jMnBanglaHelpMouseReleased(java.awt.event.MouseEvent evt) {// GEN
        // -
        // FIRST
        // :
        // event_jMnBanglaHelpMouseReleased
        showBanglaHelp();
    }// GEN-LAST:event_jMnBanglaHelpMouseReleased

    private void jMnBanglaHelpKeyReleased(java.awt.event.KeyEvent evt) {// GEN-
        // FIRST
        // :
        // event_jMnBanglaHelpKeyReleased
        showBanglaHelp();
    }// GEN-LAST:event_jMnBanglaHelpKeyReleased

    private void jMnEnglishMouseReleased(java.awt.event.MouseEvent evt) {// GEN-
        // FIRST
        // :
        // event_jMnEnglishMouseReleased
        bhashaView.setCurrentLocale(IndicPane.ENGLISH_LOCALE);
        // setLabelsByLocale();
    }// GEN-LAST:event_jMnEnglishMouseReleased

    private void jMnHindiMouseReleased(java.awt.event.MouseEvent evt) {// GEN-
        // FIRST:
        // event_jMnHindiMouseReleased
        bhashaView.setCurrentLocale(IndicPane.HINDI_LOCALE);
        // setLabelsByLocale();
    }// GEN-LAST:event_jMnHindiMouseReleased

    private void jMnBanglaMouseReleased(java.awt.event.MouseEvent evt) {// GEN-
        // FIRST
        // :
        // event_jMnBanglaMouseReleased
        bhashaView.setCurrentLocale(IndicPane.BANGLA_LOCALE);
        // setLabelsByLocale();
    }// GEN-LAST:event_jMnBanglaMouseReleased

    private void jMnOpenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnOpenMouseReleased
        bhashaView.open();
    }// GEN-LAST:event_jMnOpenMouseReleased

    private void jMnOpenKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:
        // event_jMnOpenKeyReleased
        bhashaView.open();
    }// GEN-LAST:event_jMnOpenKeyReleased

    private void jMnNewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST
        // :
        // event_jMnNewMouseReleased
        bhashaView.newPage();
    }// GEN-LAST:event_jMnNewMouseReleased

    private void jMnNewKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:
        // event_jMnNewKeyReleased
        bhashaView.newPage();
    }// GEN-LAST:event_jMnNewKeyReleased

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {// GEN-FIRST:
        // event_exitForm
        System.exit(0);
    }// GEN-LAST:event_exitForm

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMnAbout;
    private javax.swing.JMenuItem jMnBangla;
    private javax.swing.JMenuItem jMnBanglaHelp;
    private javax.swing.JMenuItem jMnEnglish;
    private javax.swing.JMenu jMnFile;
    private javax.swing.JMenuItem jMnHTML;
    private javax.swing.JMenu jMnHelp;
    private javax.swing.JMenuItem jMnHindi;
    private javax.swing.JMenuItem jMnJPEG;
    private javax.swing.JMenuItem jMnKeyboard;
    private javax.swing.JMenu jMnLbLanguage;
    private javax.swing.JMenuItem jMnNew;
    private javax.swing.JMenuItem jMnOpen;
    private javax.swing.JMenuItem jMnPDF;
    private javax.swing.JMenuItem jMnRTF;
    private javax.swing.JMenuItem jMnResetSettings;
    private javax.swing.JMenu jMnSave;
    private javax.swing.JMenu jMnSettings;
    private javax.swing.JMenuItem jMnXML;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JMenuBar mnBr;
    private javax.swing.JTabbedPane tabbedPane;

    // End of variables declaration//GEN-END:variables

    /**
     *method to display Help Frame
     */
    private void showBanglaHelp() {
        Help help = new Help("BanglaHelp");
        help.setSize(550, 800);
        // help.setResizable(false);
        help.setVisible(true);
    }

    private void showAbout() {
        Help help = new Help("About");
        help.setSize(600, 300);
        help.setVisible(true);
    }

    private void generateOutput(final String type) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GenerateOutput generateoutput = new GenerateOutput(true, getPageContainer(), type);
                generateoutput.setVisible(true);
            }
        });
    }

}
