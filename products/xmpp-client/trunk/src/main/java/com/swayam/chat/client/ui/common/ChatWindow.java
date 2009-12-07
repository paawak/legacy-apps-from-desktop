/*
 * ChatWindow.java
 *
 * Created on Dec 7, 2009 3:49:38 PM
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * 
 * @author paawak
 */
public class ChatWindow extends JDialog {

    private static final long serialVersionUID = -1624324592341163069L;

    public ChatWindow() {
        initComponents();
    }

    private void initComponents() {

        JMenuBar menuBar = new JMenuBar();
        JMenu chatMenu = new JMenu();
        chatMenu.setText("Chat");
        menuBar.add(chatMenu);
        setJMenuBar(menuBar);

        // getContentPane().setLayout(new BorderLayout());

        JScrollPane centreScrPane = new JScrollPane();
        JEditorPane chatText = new JEditorPane();
        chatText.setEditable(false);
        centreScrPane.setViewportView(chatText);
        getContentPane().add(centreScrPane, BorderLayout.CENTER);

        JScrollPane southScrPane = new JScrollPane();
        JEditorPane textEntered = new JEditorPane();
        southScrPane.setViewportView(textEntered);
        getContentPane().add(southScrPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 500) / 2, (screenSize.height - 500) / 2, 500, 500);

        textEntered.requestFocusInWindow();

    }

}
