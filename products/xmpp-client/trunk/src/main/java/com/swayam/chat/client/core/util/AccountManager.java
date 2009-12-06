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
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Mode;
import org.jivesoftware.smack.packet.Presence.Type;

import com.swayam.chat.client.core.model.Credentials;
import com.swayam.chat.client.core.model.Group;
import com.swayam.chat.client.core.model.Contact.Status;

/**
 * 
 * @author paawak
 */
public class AccountManager {

    private final XMPPConnection con;

    public AccountManager(Credentials creds) throws XMPPException {

        con = new ConnectionManager().getConnection(creds);

    }

    public List<Group> getContactGroups(RosterListener rosterListener) {

        List<Group> groups = new ArrayList<Group>(1);

        Roster roster = con.getRoster();
        Collection<RosterGroup> rosterGroups = roster.getGroups();

        roster.addRosterListener(rosterListener);

        for (RosterGroup rosterGroup : rosterGroups) {

            String groupName = rosterGroup.getName();

            GroupImpl group = new GroupImpl(groupName);

            Collection<RosterEntry> entries = rosterGroup.getEntries();

            for (RosterEntry entry : entries) {

                String name = entry.getName();
                String user = entry.getUser();

                ContactImpl contact = new ContactImpl();
                contact.setDisplayName(name == null ? user : name);

                Presence presence = roster.getPresence(user);

                Status status = Status.OFFLINE;

                Type type = presence.getType();

                Mode mode = presence.getMode();

                if (Type.available.equals(type) && (mode != null)) {

                    switch (mode) {
                    default:
                    case available:
                        status = Status.AVAILABLE;
                        break;
                    case dnd:
                        status = Status.BUSY;
                        break;
                    case away:
                        status = Status.AWAY;
                        break;
                    case xa:
                        status = Status.EXTENDED_AWAY;
                        break;

                    }
                }

                contact.setStatus(status);

                group.addContact(contact);

            }

            groups.add(group);

        }

        return Collections.unmodifiableList(groups);

    }

}
