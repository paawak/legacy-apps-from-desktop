/*
 * ConnectionManagerTest.java
 *
 * Created on Dec 5, 2009 5:43:10 PM
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

package com.swayam.chat.client.test.core;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.junit.Before;
import org.junit.Test;

import com.swayam.chat.client.core.model.Credentials;
import com.swayam.chat.client.core.util.ConnectionManager;

/**
 * 
 * @author paawak
 */
public class ConnectionManagerTest {

    private ConnectionManager manager;

    @Before
    public void setup() {

        manager = new ConnectionManager();

    }

    @Test
    public void test_getConnection() throws XMPPException {

        Credentials creds = new Credentials("localhost", 5222, "saikat", "basu");

        XMPPConnection con = manager.getConnection(creds);
        assertNotNull(con);

        Roster roster = con.getRoster();
        assertNotNull(roster);

        Iterator groups = roster.getGroups();

        while (groups.hasNext()) {

            RosterGroup group = (RosterGroup) groups.next();

            System.out.println("--------------------" + group.getName() + "--------------------");

            Iterator entries = group.getEntries();

            while (entries.hasNext()) {

                RosterEntry entry = (RosterEntry) entries.next();

                String name = entry.getName();
                String user = entry.getUser();
                Presence presence = roster.getPresenceResource(user);

                System.out.println("name = " + name + ", user = " + user + ", presence = "
                        + presence);

            }

        }

        // con.disconnect();

    }
}
