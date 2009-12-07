/*
 * ContactListTreeSelectionListener.java
 *
 * Created on Dec 7, 2009 9:52:43 PM
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

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.XMPPConnection;

import com.swayam.chat.client.core.model.Contact;
import com.swayam.chat.client.core.util.AccountManager;

/**
 * 
 * @author paawak
 */
public class ContactListTreeSelectionListener implements TreeSelectionListener {

    private final AccountManager accountManager;

    private final JTree friendsListTree;

    public ContactListTreeSelectionListener(AccountManager accountManager, JTree friendsListTree) {
        this.accountManager = accountManager;
        this.friendsListTree = friendsListTree;
    }

    public void valueChanged(TreeSelectionEvent e) {

        if (e.isAddedPath()) {

            TreePath path = e.getPath();

            Object selectedObject = path.getLastPathComponent();

            if (selectedObject instanceof Contact) {

                final String user = ((Contact) selectedObject).getUserName();
                // begin new chat
                XMPPConnection con = accountManager.getConnection();
                final ChatManager chatManager = con.getChatManager();

                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        ChatWindow dialog = new ChatWindow();

                        Chat chat = chatManager.createChat(user, dialog);

                        dialog.setChat(chat);

                        dialog.addWindowListener(new WindowAdapter() {

                            public void windowClosing(WindowEvent e) {

                                friendsListTree.clearSelection();

                            }

                        });

                        dialog.setVisible(true);
                    }
                });

            }

        }
    }

}
