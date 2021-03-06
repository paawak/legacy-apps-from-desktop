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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

/**
 * 
 * @author paawak
 */
public class ChatWindow extends JDialog /*implements MessageListener*/{

    private static final long serialVersionUID = -1624324592341163069L;

    private Chat chat;

    private JEditorPane textEntered;
    private JEditorPane chatText;

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
        chatText = new JEditorPane();
        chatText.setEditable(false);
        centreScrPane.setViewportView(chatText);
        getContentPane().add(centreScrPane, BorderLayout.CENTER);

        JScrollPane southScrPane = new JScrollPane();
        textEntered = new JEditorPane();
        southScrPane.setViewportView(textEntered);
        getContentPane().add(southScrPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 500) / 2, (screenSize.height - 500) / 2, 500, 500);

        textEntered.requestFocusInWindow();

        textEntered.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    // send chat
                    String text = textEntered.getText();
                    Message message = new Message();
                    message.setBody(text);

                    try {
                        chat.sendMessage(message);
                        appendMessageToMainWindow("me", text);
                        textEntered.setText("");
                    } catch (XMPPException e) {
                        e.printStackTrace();
                    }

                }

            }

        });

    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void processMessage(Chat chat, Message message) {
        appendMessageToMainWindow(message.getFrom(), message.getBody());
    }

    private void appendMessageToMainWindow(String user, String message) {

        String oldText = chatText.getText();
        chatText.setText(oldText + "\n" + user + ":" + message);

    }

}
