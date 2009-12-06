/*
 * AccountManager.java
 *
 * Created on Dec 6, 2009 9:49:57 PM
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

package com.swayam.chat.client.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import com.swayam.chat.client.core.model.Credentials;
import com.swayam.chat.client.core.model.Group;

/**
 * 
 * @author paawak
 */
public class AccountManager {

    private final XMPPConnection con;

    public AccountManager(Credentials creds) throws XMPPException {

        con = new ConnectionManager().getConnection(creds);

    }

    // public TreeNode getContatcTreeModel() throws XMPPException {
    //
    // DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("group");
    //
    // for (Group group : getContactGroups()) {
    //
    // DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group.getName());
    //
    // for (Contact contact : group.getContacts()) {
    //
    // DefaultMutableTreeNode contactNode = new DefaultMutableTreeNode(contact
    // .getDisplayName());
    //
    // groupNode.add(contactNode);
    //
    // }
    //
    // rootNode.add(groupNode);
    //
    // }
    //
    // return rootNode;
    //
    // }

    public List<Group> getContactGroups() throws XMPPException {

        List<Group> groups = new ArrayList<Group>(1);

        Roster roster = con.getRoster();
        Collection<RosterGroup> rosterGroups = roster.getGroups();

        for (RosterGroup rosterGroup : rosterGroups) {

            String groupName = rosterGroup.getName();

            GroupImpl group = new GroupImpl(groupName);

            Collection<RosterEntry> entries = rosterGroup.getEntries();

            for (RosterEntry entry : entries) {

                String name = entry.getName();
                String user = entry.getUser();

                ContactImpl contact = new ContactImpl();
                contact.setDisplayName(name == null ? user : name);
                group.addContact(contact);

            }

            groups.add(group);

        }

        return Collections.unmodifiableList(groups);

    }

}
