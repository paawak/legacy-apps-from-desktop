/*
 * ContactListPane.java
 *
 * Created on Dec 7, 2009 9:29:22 PM
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

import java.util.Collection;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.packet.Presence;

import com.swayam.chat.client.core.model.Group;
import com.swayam.chat.client.core.util.AccountManager;

/**
 * 
 * @author paawak
 */
public class ContactListPane extends JScrollPane {

    private static final long serialVersionUID = -7122899075884225557L;

    private static final long COMMAND_EXEC_TIME_FRAME_MILLIS = 2000;

    private static final String COMMAND_ID = "ContactListReloadRequest";

    private JTree friendsListTree;

    private final AccountManager acManager;

    private final RequestExecutor executor;

    private ContactListChangeListener rosterListener;

    public ContactListPane(AccountManager acManager) {
        this.acManager = acManager;
        executor = new MultipleRequestExecutor(COMMAND_EXEC_TIME_FRAME_MILLIS);
        initTree();
    }

    public void reloadContacts() {

        executor.executeCommand(new CommandImpl(COMMAND_ID) {

            @Override
            public void execute() {

                friendsListTree.setModel(new ContactListTreeModel(acManager
                        .getContactGroups(rosterListener)));

            }

        });

    }

    /**
     * Adds the contact list tree to the pane.<br>
     * Should be called only once.
     */
    private void initTree() {

        friendsListTree = new JTree(new DefaultMutableTreeNode());
        friendsListTree.setCellRenderer(new ContactListTreeCellRenderer());
        friendsListTree.setShowsRootHandles(true);
        friendsListTree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

        friendsListTree.setRootVisible(false);

        friendsListTree.addTreeSelectionListener(new ContactListTreeSelectionListener(acManager,
                friendsListTree));

        rosterListener = new ContactListChangeListener();

        List<Group> groups = acManager.getContactGroups(rosterListener);

        friendsListTree.setModel(new ContactListTreeModel(groups));

        setViewportView(friendsListTree);

    }

    private class ContactListChangeListener implements RosterListener {

        public void entriesAdded(Collection<String> addresses) {
            reloadContacts();
        }

        public void entriesDeleted(Collection<String> addresses) {
            reloadContacts();
        }

        public void entriesUpdated(Collection<String> addresses) {
            reloadContacts();
        }

        public void presenceChanged(Presence presence) {
            reloadContacts();
        }

    }

}
