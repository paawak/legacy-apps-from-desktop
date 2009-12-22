/*
 * ErrorDialog.java
 *
 * Created on Dec 22, 2009 4:34:32 PM
 *
 * Copyright (c) 2002 - 2009 : Swayam Inc.
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.swayam.chat.client.ui.common;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * 
 * @author paawak
 */
public class ErrorDialog extends JDialog {

    private static final long serialVersionUID = -6588784647188946661L;

    public ErrorDialog(Frame owner, String title, String message, Throwable error) {
        super(owner, title, true);
        initComponents(message, error);
    }

    private void initComponents(String message, Throwable error) {

        GridBagConstraints gridBagConstraints;

        JLabel lbMessage = new JLabel(message, new ImageIcon(getClass().getResource(
                "/com/swayam/chat/client/assets/images/icons/error.gif")), SwingConstants.CENTER);
        JScrollPane txtAreaScroller = new JScrollPane();

        StringWriter writer = new StringWriter();

        error.printStackTrace(new PrintWriter(writer));

        String stackTrace = writer.toString();

        JTextArea txtStackTrace = new JTextArea(stackTrace);
        txtStackTrace.setEditable(false);
        txtStackTrace.selectAll();

        JButton btOk = new JButton("OK");

        btOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorDialog.this.setVisible(false);
            }

        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(lbMessage, gridBagConstraints);

        txtStackTrace.setColumns(20);
        txtStackTrace.setRows(5);
        txtAreaScroller.setViewportView(txtStackTrace);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(txtAreaScroller, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(btOk, gridBagConstraints);

        setResizable(false);

        pack();

    }

}
