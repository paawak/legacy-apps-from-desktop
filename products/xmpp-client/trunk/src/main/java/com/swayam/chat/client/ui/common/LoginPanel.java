/*
 * LoginPanel.java
 *
 * Created on Dec 7, 2009 11:40:43 PM
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.swayam.chat.client.core.model.Credentials;

/**
 * 
 * @author paawak
 */
public class LoginPanel extends JPanel {

    private static final long serialVersionUID = 4603399021683353717L;

    private final CredentialListener credListener;
    private JTextField txtUserName;
    private JPasswordField txtPassword;

    public LoginPanel(CredentialListener credListener) {
        this.credListener = credListener;
        initComponents();
    }

    private void initComponents() {

        GridBagConstraints gridBagConstraints;

        JLabel lbTitle = new JLabel();
        JLabel lbUserName = new JLabel();
        txtUserName = new JTextField();
        JLabel lbPassword = new JLabel();
        txtPassword = new JPasswordField();
        JButton btLogin = new JButton();
        btLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String userName = txtUserName.getText().trim();
                char[] password = txtPassword.getPassword();

                if (!"".equals(userName) && (userName.indexOf('@') > 0) && (password != null)) {

                    String[] array = userName.split("@");
                    String user = array[0];
                    String host = array[1];
                    Credentials creds = new Credentials(host, user, new String(password));
                    credListener.credentialsEntered(creds);

                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Please enter username/password", "Oops!", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        JLabel lbFooter = new JLabel();

        setLayout(new GridBagLayout());

        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setText("Welcome to theND, Instant Mesanger");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.7;
        add(lbTitle, gridBagConstraints);

        lbUserName.setText("Username:*");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(30, 30, 0, 0);
        add(lbUserName, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(30, 10, 0, 30);
        add(txtUserName, gridBagConstraints);

        lbPassword.setText("Password:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 30, 0, 0);
        add(lbPassword, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 10, 0, 30);
        add(txtPassword, gridBagConstraints);

        btLogin.setText("Login");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(30, 0, 30, 0);
        add(btLogin, gridBagConstraints);

        lbFooter.setText("* For example: john.smith@gmail.com");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(0, 10, 15, 10);
        add(lbFooter, gridBagConstraints);
    }
}
