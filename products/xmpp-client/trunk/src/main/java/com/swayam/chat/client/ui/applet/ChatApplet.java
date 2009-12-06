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

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import org.jivesoftware.smack.XMPPException;

import com.swayam.chat.client.core.model.Credentials;
import com.swayam.chat.client.core.util.AccountManager;
import com.swayam.chat.client.ui.common.ContactListTreeCellRenderer;
import com.swayam.chat.client.ui.common.ContactListTreeModel;

/**
 * 
 * @author paawak
 */
public class ChatApplet extends JApplet {

    private static final long serialVersionUID = -2126075630790344759L;

    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
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

        JScrollPane centerScrollPane = new JScrollPane();

        JTree friendsListTree = new JTree();

        Credentials creds = new Credentials("localhost", 5222, "palash", "ray");

        try {
            AccountManager manager = new AccountManager(creds);

            friendsListTree.setModel(new ContactListTreeModel(manager.getContactGroups()));
            friendsListTree.setCellRenderer(new ContactListTreeCellRenderer());

            // FIXME:: temporary hack for expanded tree
            // friendsListTree.setSelectionRow(rootNode.getChildCount());
            // friendsListTree.expandPath(friendsListTree.getSelectionPath());
            // friendsListTree.setSelectionRow(-1);

        } catch (XMPPException e) {
            e.printStackTrace();
        }

        friendsListTree.setShowsRootHandles(true);

        friendsListTree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

        friendsListTree.setRootVisible(false);

        centerScrollPane.setViewportView(friendsListTree);

        getContentPane().add(centerScrollPane, java.awt.BorderLayout.CENTER);

    }
}
