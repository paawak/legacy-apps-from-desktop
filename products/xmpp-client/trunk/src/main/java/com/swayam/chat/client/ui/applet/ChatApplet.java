/*
 * ChatApplet.java
 *
 * Created on Dec 6, 2009 9:19:01 PM
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

package com.swayam.chat.client.ui.applet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import com.swayam.chat.client.core.model.Contact;
import com.swayam.chat.client.core.model.Credentials;
import com.swayam.chat.client.core.model.Group;
import com.swayam.chat.client.core.util.AccountManager;
import com.swayam.chat.client.ui.common.ChatWindow;
import com.swayam.chat.client.ui.common.ContactListTreeCellRenderer;
import com.swayam.chat.client.ui.common.ContactListTreeModel;

/**
 * 
 * @author paawak
 */
public class ChatApplet extends JApplet {

    private static final long serialVersionUID = -2126075630790344759L;

    private JTree friendsListTree;

    private AccountManager manager;

    private MyRosterListener rosterListener;

    public void init() {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {

        JMenuBar mainMenuBar = new JMenuBar();
        JMenu buddiesMenu = new JMenu();
        buddiesMenu.setText("Buddies");
        JMenuItem addBuddyItem = new JMenuItem();
        addBuddyItem.setText("Add Buddy");
        buddiesMenu.add(addBuddyItem);
        mainMenuBar.add(buddiesMenu);

        setJMenuBar(mainMenuBar);

        // getContentPane().setLayout(new BorderLayout());

        JScrollPane centerScrollPane = new JScrollPane();

        friendsListTree = new JTree(new DefaultMutableTreeNode());
        friendsListTree.setCellRenderer(new ContactListTreeCellRenderer());
        friendsListTree.setShowsRootHandles(true);
        friendsListTree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

        friendsListTree.setRootVisible(false);

        friendsListTree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {

                if (e.isAddedPath()) {

                    TreePath path = e.getPath();

                    Object selectedObject = path.getLastPathComponent();

                    if (selectedObject instanceof Contact) {

                        final String user = ((Contact) selectedObject).getUserName();
                        // begin new chat
                        XMPPConnection con = manager.getConnection();
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

        });

        // Credentials creds = new Credentials("paawak", "ssdsddaas");
        Credentials creds = new Credentials("localhost", "palash", "ray");

        try {
            manager = new AccountManager(creds);

            rosterListener = new MyRosterListener();

            List<Group> groups = manager.getContactGroups(rosterListener);

            friendsListTree.setModel(new ContactListTreeModel(groups));

        } catch (XMPPException e) {
            e.printStackTrace();
        }

        centerScrollPane.setViewportView(friendsListTree);

        getContentPane().add(centerScrollPane, BorderLayout.CENTER);

    }

    private class MyRosterListener implements RosterListener {

        public void entriesAdded(Collection<String> addresses) {
            reloadTree();
        }

        public void entriesDeleted(Collection<String> addresses) {
            reloadTree();
        }

        public void entriesUpdated(Collection<String> addresses) {
            reloadTree();
        }

        public void presenceChanged(Presence presence) {
            reloadTree();
        }

        private void reloadTree() {

            friendsListTree.setModel(new ContactListTreeModel(manager
                    .getContactGroups(rosterListener)));

        }

    }

}
